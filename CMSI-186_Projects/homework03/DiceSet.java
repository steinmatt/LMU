/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-02-13  Matt Stein    Update 1: Constructor, sum, roll, getValue, rollIndividual.
 *  @version 1.0.2  2018-02-20  Matt Stein    Wrote toString methods and isIdentical methods.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count ;
   private int sides ;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet ( int sideCount, int sidesCount ) throws IllegalArgumentException {
      if ( sideCount < 1 ) {
        throw new IllegalArgumentException("Check your parameters again. Somethings wrong. You at mus choose at least one die with at least 4 sides or more.");
      }
      count = sideCount;
      sides = sidesCount;
      ds = new Die[ count ];
      for (int i = 0; i < count - 1; i++ ) {
        ds[i] = new Die(sides);
      }

   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      int sumOfDie = 0;
      for (int i = 0; i < count - 1; i++ ) {
        sumOfDie += ds[i].getValue();
      }
      return sumOfDie;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for (int i = 0; i < count - 1; i++ ) {
       ds[i].roll();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      if (dieIndex >= ds.length){
        throw new IllegalArgumentException ("Inputted index is out of range. Die not found. Please input number in range.");
      }
      Die d = ds[dieIndex];
      d.roll();
      return d.getValue();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to get value from
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      Die d = ds[dieIndex];
      return d.getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String outputString = "";
      for (int i = 0; i < count - 1; i++ ) {
        outputString += ds[i].toString();
      }
      return outputString;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet dSet ) {
     return dSet.toString();
   }

  /**
   * Method to test to see if inputted Dice Set is equal to current Dice Set.
   * Two dice sets are considered if both sets contain the same number of dice
   * with the same numbers of sides and the same value for each die. Consequently,
   * the sum of the entire array of die is also equal.
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet dSet ) {
      if ( (dSet.count == count) && (dSet.sides == sides) && (dSet.sum() == sum() ) )  {
        for (int i = 0; i < count - 2; i++ ) {
          if (dSet.ds[i].getValue() != ds[i].getValue() ){
            return false;
          }
          else {
            return true;
          }
        }
      }
      return false;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet testSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
      testSet.roll();
      System.out.println("Test Set = " + testSet.toString());
      DiceSet compareSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
      for (int i = 0; i < compareSet.count - 1 ; i++ ) {
        compareSet.ds[i].setValue(testSet.ds[i].getValue());
      }
      System.out.println("Compare Set = " + compareSet.toString());
      System.out.println("The two dice set are identifcal: " + testSet.isIdentical(compareSet));
      System.out.println("We now roll all the dice in the first test set.");
      testSet.roll();
      System.out.println("Test Set = " + testSet.toString());
      System.out.println("Now these two dice set are identical:" + testSet.isIdentical(compareSet));

   }

}
