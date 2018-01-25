/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Matthew Stein
 *  Date          :  2018-01-18
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-12-25  B.J. Johnson  Updated for Spring 2018
 *  @version 1.0.2  2018-01-18  Matt Stein    Started writing code; finished dateEquals.
 *  @version 1.0.3  2018-01-23  Matt Stein    Created compareNums, compareDate, isValidDate, & started toMonthString
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  /**
   * A listing of the months of the year, assigning numbers; Year starts with January like normal.
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;


  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   */
   private static int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /**
   * The constructor for the class
   */
   // super() - look into this
   public CalendarStuff () {
      System.out.println( "Constructor called..." );  // replace this with the actual code
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
      if ( year % 400 == 0 ) {    // every 400th year is a leap year. (i.e. 1600, 2000)
        return true;
      }
      else if (year % 100 == 0) { // every 100th year is NOT a leap year (i.e. 1700, 1800)
        return false;
      }
      else if (year % 4 == 0){   // every 4th year is a leap year (i.e. 2004, 2008)
        return true;
      }
      else {
        return false;
      }
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
      CalendarStuff.daysInMonths[1] = 28;
      if ( true == CalendarStuff.isLeapYear(year) ) {
        CalendarStuff.daysInMonths[1] = 29;
      }
      return CalendarStuff.daysInMonths[(int) month - 1];
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     if  ( (year1 == year2) && (month1 == month2) && (day1 == day2) ) {
      return true ;
    }
     else {
      return false ;
    }
   }

  /**
    * A method to compare the ordering of two numbers
    * @param   num1   long  first number feeded in, 1st date/month/year
    * @param   num2   long  second number feeded in, 2nd date/month/year
    * @return         int   -1/0/+1 if first date is before/same/after second
    *                 // NOTE: If Date 1 is before Date 2, return -1; vice versa applies.
    */

  public static int compareNums (long num1, long num2) {
    if (num1 < num2) {
      return -1 ;
    }
    else if (num1 > num2) {
      return 1 ;
    }
    else {
      return 0 ;
    }

  }
  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is before/equal to/after the second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {



     if ( true == CalendarStuff.dateEquals(month1, day1, year1, month2, day2, year2) ){
       return 0 ;
     }
     else if ( 0 != CalendarStuff.compareNums(year1, year2) ){
       return CalendarStuff.compareNums(year1,year2) ;
     }
     else {
       if ( 0 != CalendarStuff.compareNums(month1,month2) ){
         return CalendarStuff.compareNums(month1,month2) ;
       }
       else {
         return CalendarStuff.compareNums(day1, day2) ;
       }
     }
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) {
      if ( ( (int) month == month) && ( (int) day == day) && ( (int) year == year) ) {
        if ( (day > 0) && ( day <= CalendarStuff.daysInMonth(month, year) ) && (month > 0) && (month <= 12) ) {
          return true ;
        }
        else {
          return false ;
        }
      }
      else {
        return false ;
      }


      /** try {
        * }
        * catch(ArrayIndexOutOfBoundsException e) {
        }
        */
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
      String monthString = "temp";
      switch( month - 1 ) {
         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
         case JANUARY:   monthString = "January" ;
                  return monthString;
         case FEBRUARY:  monthString = "February" ;
                  return monthString;
         case MARCH:     monthString = "March" ;
                  return monthString;
         case APRIL:     monthString = "April";
                  return monthString;
         case MAY:       monthString = "May";
                  return monthString;
         case JUNE:      monthString = "June";
                  return monthString;
         case JULY:      monthString = "July";
                  return monthString;
         case AUGUST:    monthString = "August";
                  return monthString;
         case SEPTEMBER: monthString = "September";
                  return monthString;
         case OCTOBER:   monthString = "October";
                  return monthString;
         case NOVEMBER:  monthString = "November";
                  return monthString;
         case DECEMBER:  monthString = "December";
                  return monthString;
      }
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      String dayString = "temp";
      switch( day - 1 ) {
         default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
         case SUNDAY   :      dayString = "Sunday";
                       return dayString;
         case MONDAY   :      dayString = "Monday";
                       return dayString;
         case TUESDAY  :      dayString = "Tuesday";
                       return dayString;
         case WEDNESDAY:      dayString = "Wednesday";
                       return dayString;
         case THURSDAY :      dayString = "Thursday";
                       return dayString;
         case FRIDAY   :      dayString = "Friday";
                       return dayString;
         case SATURDAY :      dayString = "Saturday";
                       return dayString;
      }
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      int dayCount = 0;
      int earlyDay = 0;
      int earlyMonth = 0;
      int earlyYear = 0;
      int lateDay = 0;
      int lateMonth = 0;
      int lateYear = 0;
      // return failure if this is not a valid date
      if (0 == CalendarStuff.compareDate( month1, day1, year1, month2, day2, year2 ) ){
        return dayCount;
      }
      else if ( 1 == CalendarStuff.compareDate(month1, day1, year1, month2, day2, year2 )) {
        earlyDay = (int) day2;
        earlyMonth = (int) month2;
        earlyYear = (int) year2;
        lateDay = (int) day1;
        lateMonth = (int) month1;
        lateYear = (int) year1;
      }
      else if ( -1 == CalendarStuff.compareDate(month1, day1, year1, month2, day2, year2 )) {
        earlyDay = (int) day1;
        earlyMonth = (int) month1;
        earlyYear = (int) year1;
        lateDay = (int) day2;
        lateMonth = (int) month2;
        lateYear = (int) year2;
      }

      while (earlyYear != lateYear) {
        while (earlyMonth <= 12 ) {
          while (earlyDay <= CalendarStuff.daysInMonth(earlyMonth, earlyYear)) {
            dayCount += 1 ;
            earlyDay += 1 ;
          }
          earlyDay = 1;
          earlyMonth += 1;
        }
        earlyDay = 1;
        earlyMonth = 1;
        earlyYear += 1;
      }

      while (earlyMonth != lateMonth) {
        while (earlyDay <= CalendarStuff.daysInMonth(earlyMonth, earlyYear)) {
          dayCount += 1 ;
          earlyDay += 1 ;
        }
        earlyDay = 1;
        earlyMonth += 1;
      }

      while (earlyDay < lateDay) {
        dayCount += 1;
        earlyDay += 1;
      }
      return dayCount;
    }
}
