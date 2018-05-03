/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  To find the least amount of coins in inputted denominations to total an inputted amount.
 * @author    :  Matt Stein
 * @author    :  B.J. Johnson totally ripped off from the original
 * Date       :  2017-04-19
 * Description:  Program takes in a given set of coin denominations,seperated by commas, and finds the best possible combination
 *               of these coin denominations - the second input in array - to total inputted about of money.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2018-04-24  Matt Stein    Initial writing and release. Created initial program entry point.
                                     Checked for neg. coin denominations & neg. money totals, wrote usage errors
                                     and created initial Tuble Table.
 *  1.1.0  2018-04-26  Matt Stein    Wrote main method to collect input methods, check inputs for validity,
 *                                   feed inputs into makeChangeWithDynamicProgramming method.
 *  1.2.0  2018-04-27  Matt Stein    Finish program. Checked validity with tester.
 *  1.3.0  2018-04-30  Matt Stein    Wrote java docs.
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class DynamicChangeMaker{
  private static final String usageMessage = "\n Please be sure that you are entering positive integers. " +
                                             "\n NOTE: Coin denominations are to be seperated by commas. " +
                                             "\n Usage: java DynamicChangeMaker <coin_denominations> <total_money>";
  private static final String BAD_DATA = "BAD DATA";
  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  public static String[] coinDenominations;
  public static int[] validCoins;
  public static Tuple coins;
  public static Tuple[][] theTable;
  private static int[] data;
  private static Tuple temp;

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   * Method that utilizes Dynamic Programming to find the least number of coins, from a given set
   * of coin values, that add up to the total target.
   *
   * @param denominations  int array containing an unordered set of coin values
   * @param target         int containing the target goal to add up to
   *
   * @return the Tuple containing amount of each coin (same order as denominations) to reach target
   *         in most optimal way
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

  public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int target){
    // NOTE: Don't forget to reset Data to 0 after creating the respective Tuple for each Table location.
    coins = new Tuple(denominations); // success //
    theTable = new Tuple[coins.length()][target + 1];
    data = new int[coins.length()];

    for (int i = 0; i < coins.length(); i++) {
      data[i] = 0;
    }

    for (int i = 0; i < coins.length(); i++) {
      for (int j = 0; j <= target; j++) {

        if (j == 0) {
          theTable[i][j] = new Tuple(data);
        }
        else if (j < coins.getElement(i)) {
          temp = Tuple.IMPOSSIBLE;
          if ( ( i > 0 ) && ( theTable[i-1][j].isImpossible() ) ){
            temp = temp;
          }
          else if ( ( i > 0 ) && ( ( temp.isImpossible() == true ) && ( theTable[i-1][j].isImpossible() == false ) ) ) {
            temp = theTable[i-1][j];
          }
          else if ( ( i > 0 ) && ( theTable[i-1][j].total() <= temp.total() ) ) {
            temp = theTable[i-1][j];
          }

          theTable[i][j] = temp;
        }
        else {
          data[i] = 1;
          temp = new Tuple(data);
          data[i] = 0;  // Reset Data to 0 for next iteration

          if ( theTable[i][j - coins.getElement(i)].isImpossible() == true ){
            temp = Tuple.IMPOSSIBLE;
          }
          else{
            temp = temp.add( theTable[i][j - coins.getElement(i)] );
          }

          if ( ( i > 0 ) && ( theTable[i-1][j].isImpossible() ) ){
            temp = temp;
          }
          else if ( ( i > 0 ) && ( ( temp.isImpossible() == true ) && ( theTable[i-1][j].isImpossible() == false ) ) ) {
            temp = theTable[i-1][j];
          }
          else if ( ( i > 0 ) && ( theTable[i-1][j].total() <= temp.total() ) ) {
            temp = theTable[i-1][j];
          }

          theTable[i][j] = temp;

        }
      }
    }
    return theTable[coins.length()-1][target];
  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   * Basic main program to accept input data, reject bad data, reform and send arguments to
   * makeChangeWithDynamicProgramming method, and return an output for the user to see.
   *
   * @param args[]  string array consisting of the coin deonminations in args[0], seperated by
   *                commas, and the target in args[1]
   *
   * @return either BAD DATA, if the inputted data does not follow standards, IMPOSSIBLE, if
   *         the target cannot be achieved, or the most optimal coin denominations
   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

  public static void main(String args[]) throws IllegalArgumentException{
    if (args.length > 2) {
      System.out.println(BAD_DATA + " \n because there are too many arguments inputted.");
      throw new IllegalArgumentException(usageMessage);
    }
    else if (args.length < 2){
      System.out.println(BAD_DATA + "\n because there are not enough input arguments.");
      throw new IllegalArgumentException(usageMessage);
    }
    else if (Integer.parseInt(args[1]) < 0) {
      System.out.println(BAD_DATA + "\n because you cannot have a total coin amount that is negative.");
      throw new IllegalArgumentException(usageMessage);
    }
    else if (Integer.parseInt(args[1]) == 0) {
      System.out.println(BAD_DATA + "\n because you cannot have a total coin amount of 0.");
      throw new IllegalArgumentException(usageMessage);
    }

    coinDenominations = args[0].split(",");
    validCoins = new int[coinDenominations.length];

    for (int i = 0; i < coinDenominations.length; i++){
      if (Integer.parseInt(coinDenominations[i]) < 0){
        System.out.println(BAD_DATA + "\n because input arguments contain a negative number");
        throw new IllegalArgumentException(usageMessage);
      }
      else if (Integer.parseInt(coinDenominations[i]) == 0){
        System.out.println(BAD_DATA + "\n because input arguments contain a zero. \n No such coin denomination as 0.");
        throw new IllegalArgumentException(usageMessage);
      }

      validCoins[i] = Integer.parseInt(coinDenominations[i]);
    }


    Tuple result = makeChangeWithDynamicProgramming( validCoins, Integer.parseInt(args[1]) ) ;

    if (result.isImpossible() == true) {
      System.out.println("IMPOSSIBLE! \n Because you cannot make " + args[1] + " cents with the coins given.");
    }
    else{
      System.out.println(args[1] + " cents can be made with " + Integer.toString( result.total() ) + " inputted coins in the most optimal way as follows: " );
      for (int i = 0; i < validCoins.length; i++) {
        System.out.println(  result.getElement(i)  + " x " + Integer.toString(validCoins[i]) + " cents");
      }
    }


  }

}
