/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Takes in two dates and outputs the absolute days between the two dates.
 *  Author        :  Matt Stein
 *  Date          :  2018-01-24
 *  Description   :  This file takes in an input of two dates and calcuates the absolute amount of days
 *                   between the two dates. The program uses supporting files from CalendarStuff.java
 *                   to account for Leap Year, ensure a valid date entry, and do appropriate calculations.
 *                   File used for Homework 01 assignment in CMSI 186 at Loyola Marymount University.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-24  Matt Stein    Initial writing and implementation of program
 *  @version 1.0.1  2017-12-24  Matt Stein    Minor edits for presentability. 
 */

public class CountTheDays {
  public static void main( String args[] ) {
     if( args.length == 0 ) {
        System.out.println( "\n  Run me again, with some command line arguments....\n" );
        System.exit( 0 );
     }

     int month1 = Integer.parseInt(args[0]);
     int day1   = Integer.parseInt(args[1]);
     int year1  = Integer.parseInt(args[2]);
     int month2 = Integer.parseInt(args[3]);
     int day2   = Integer.parseInt(args[4]);
     int year2  = Integer.parseInt(args[5]);

     if ( (true == CalendarStuff.isValidDate(month1, day1, year1)) && (true == CalendarStuff.isValidDate(month2, day2, year2)) ) {
       System.out.printf("\n  There are %d" + " absolute days between the two entered dates. \n", CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2) );
     }
     else {
       System.out.println( "\n  Run me again, with some correct dates this time....\n" );
       System.exit( 0 );
     }
  }

}
