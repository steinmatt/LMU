/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Game Interface that uses the Die and Dice Set classes to roll and accummulate die.
 *  Author        :  Matt Stein
 *  Date          :  2017-02-22
 *  Description   :
 *
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-21  Matt Stein    Creation and completed file. 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.IOException;

 public class HighRoll {
   public static void main( String args[] ) {
      if( args.length == 0 ) {
         System.out.println( "\n  Run me again, with some command line arguments." );
         System.out.println( "\n  The first input should represent the amount of die, while the second represents the side per die!");
         System.exit( 0 );
      }

      // Create Variables to rpresent the amount of die in the set
      // and the amount of sides each die has

      int dieAmount = Integer.parseInt(args[0]);
      int dieSides  = Integer.parseInt(args[1]);

      // initially create the user's dice set
      DiceSet userSet = new DiceSet(dieAmount, dieSides);

      // roll the user's dice set so each die starts with a current value
      userSet.roll();

      // initialize the high score at 0
      int highScore = 0;

      // begin running the program.
      System.out.printf( "\n  Congratulations! You have created your set of die.");
      System.out.println("\n  Currently, your set of die reads as the following: \n      " + userSet.toString());


     BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

     // create a boolean to cancel loop if program is quit
     boolean failSafe;
     failSafe = true;

     /* While Program Loop:
     *       The following loop prompts the user to do one of 6 options, then conducts each option.
     *
     *       The user can either roll all the dice in the set, roll a single die, calculate the sum or score
     *       of their dice set, save their score as the high score if it constitutes as the high score, or
     *       display the high score. They also can leave the program.
     */
     while(failSafe == true ) {
        System.out.println( "\n  Now you can do any of the following options: \n");
        System.out.println( "\n      Option 1) ROLL ALL THE DICE. ");
        System.out.println( "\n      Option 2) ROLL A SINGLE DIE. ");
        System.out.println( "\n      Option 3) CALCULATE THE SCORE FOR THIS SET. ");
        System.out.println( "\n      Option 4) SAVE THIS SCORE AS THE HIGH SCORE. ");
        System.out.println( "\n      Option 5) DISPLAY THE HIGH SCORE. ");
        System.out.println( "\n      Option 6) EXIT THE PROGRAM. \n");
        System.out.println( "\n Please enter the option you wish to do by entering the number of the option. (i.e. enter '3' for option 3.)");
        String inputLine = null;
        try {
           inputLine = input.readLine();
           if( 0 == inputLine.length() ) {
              System.out.println("Please enter a number!");
           }
           else if( 1 == Character.getNumericValue(inputLine.charAt(0)) ) {
              userSet.roll();
              System.out.println("Your die set is now: \n     " + userSet.toString());
           }
           else if( 2 == Character.getNumericValue(inputLine.charAt(0)) ) {
              System.out.println("Please enter which die you would like to roll:");
              inputLine = input.readLine();
              if (0 == inputLine.length()){
                System.out.println("\n \n Please enter a number!");
              }
              userSet.rollIndividual(Character.getNumericValue(inputLine.charAt(0)));
              System.out.println("Your die set is now:     " + userSet.toString());
           }
           else if( 3 == Character.getNumericValue(inputLine.charAt(0)) ) {
              System.out.println("\n \n The High Score for your set of die is:  " + userSet.sum());
           }
           else if( 4 == Character.getNumericValue(inputLine.charAt(0)) ) {
              if (highScore > userSet.sum()) {
                System.out.println("\n\n\n\n\n But this isn't the high score... try again!");
              }
              else {
                highScore = userSet.sum();
                System.out.println("\n \n The overall High Score is now:    " + highScore);
              }
           }
           else if( 5 == Character.getNumericValue(inputLine.charAt(0)) ) {
              System.out.println("\n \n The overall High Score is:    " + highScore);
           }
           else if( 6 == Character.getNumericValue(inputLine.charAt(0)) ) {
              failSafe = false;
           }


        }
        catch( IOException ioe ) {
           System.out.println( "Caught IOException" );
        }
     }
     System.out.println("\n\n\n\n\n Thanks for playing! We'll see you next time!");
     System.exit(0);
    }
 }
