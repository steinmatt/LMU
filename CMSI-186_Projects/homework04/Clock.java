/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private static double currentTime;
   private static double currentHours;
   private static double currentMins;
   private static double currentSecs;
   public static double timeSlice;




  /**
   *  Constructor goes here
   *
   * Made to work with the ClockSolver class
   */
   public Clock(){
     currentTime = 0;
     currentHours = 0;
     currentMins = 0;
     currentSecs = 0;
     timeSlice = (double) 60;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
      currentTime = currentTime + timeSlice;
      for (double i = 0; i <= timeSlice; i++){
        currentSecs += 1;
        if (currentSecs == 60) {
          currentMins += 1;
          if (currentMins == 60) {
            currentHours += 1;
            currentMins = 0;
          }
          currentSecs = 0;
        }
      }
      return currentTime;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
      if ((Double.parseDouble(argValue) > MAXIMUM_DEGREE_VALUE) || (Double.parseDouble(argValue) < 0))  {
        throw new NumberFormatException("Error! The angle between hands cannot be greater than or equal to 360!");
      }
      else {
        return Double.parseDouble(argValue);
      }

   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
     if ( (Double.parseDouble(argValue) > (double) 0 ) && (Double.parseDouble(argValue) < (double) 1800 )) {
       return Double.parseDouble(argValue);
     }
     else {
       throw new NumberFormatException("Error! The angle between hands cannot be greater than or equal to 360!");
     }
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      double hourHandAngle = (currentHours*3600.0 + currentMins*60.0 + currentSecs) * HOUR_HAND_DEGREES_PER_SECOND;
      System.out.println(hourHandAngle);
      return hourHandAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public static double getMinuteHandAngle() {
      return (double) (currentMins*60 + currentSecs) * MINUTE_HAND_DEGREES_PER_SECOND;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
      return Math.abs(getHourHandAngle() - getMinuteHandAngle());
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public boolean timeElapsed() {
      return currentHours == 12;

   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      return currentHours + " hours, " + currentMins + " minutes, " + currentSecs + " seconds.";
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );

      // Testing validateAngleArg()
      System.out.println( "  Testing validateAngleArg()....");
      System.out.println( "      sending '  0 degrees', expecting double value   0.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("0"));
      System.out.println( "      sending '  30 degrees', expecting double value   30.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("30"));
      System.out.println( "      sending '  60 degrees', expecting double value   60.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("60"));
      System.out.println( "      sending '  90 degrees', expecting double value   90.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("90"));
      System.out.println( "      sending '  120 degrees', expecting double value   120.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("120"));
      System.out.println( "      sending '  150 degrees', expecting double value   150.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("150"));
      System.out.println( "      sending '  180 degrees', expecting double value   180.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("180"));
      System.out.println( "      sending '  270 degrees', expecting double value   270.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("270"));
      System.out.println( "      sending '  360 degrees', expecting double value   360.0" );
      System.out.println(" Angle is " + clock.validateAngleArg("360"));
      System.out.println( "      sending '  -10 degrees', expecting INVALID_ARGUMENT_VALUE");
      System.out.println(" Angle is " + clock.validateAngleArg("-10"));
      System.out.println( "      sending 'ABC degrees', expecting INVALID_ARGUMENT_VALUE");
      System.out.println(" Angle is " + clock.validateAngleArg("ABC"));

      // Testing validateTimeSliceArg()
      System.out.println( "  Testing validateTimeSliceArg()....");
      System.out.println( "      sending '  0.0 seconds', expecting double value   0.0" );
      clock.validateTimeSliceArg("0");
      System.out.println( "      sending '  10.0 seconds', expecting double value   30.0" );
      clock.validateTimeSliceArg("10");
      System.out.println( "      sending '  30.0 seconds', expecting double value   60.0" );
      clock.validateTimeSliceArg("30");
      System.out.println( "      sending '  ABC seconds', expecting INVALID_ARGUMENT_VALUE");
      clock.validateTimeSliceArg("ABC");
      System.out.println( "      sending '  90.0 seconds', expecting double value   120.0" );
      clock.validateTimeSliceArg("90");
      System.out.println( "      sending '  500.0 seconds', expecting double value   150.0" );
      clock.validateTimeSliceArg("500");
      System.out.println( "      sending '  1000.0 seconds', expecting double value   180.0" );
      clock.validateTimeSliceArg("1000");
      System.out.println( "      sending '  1800.0 seconds', expecting double value   270.0" );
      clock.validateTimeSliceArg("1800");
      System.out.println( "      sending '  1805.0 seconds', expecting INVALID_ARGUMENT_VALUE" );
      clock.validateTimeSliceArg("1805");

      // Testing toString()
      System.out.println( "  Testing toString()....");
      System.out.println(clock.toString());

      // Testing tick()
      System.out.println( "  Testing tick().... time slice is 10.0 seconds");
      System.out.println( "      expecting string with 0.0 for hours and minutes, and 10.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours and minutes, and 20.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours and minutes, and 30.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours and seconds, and 1.0 minutes values" );
      clock.tick();
      clock.tick();
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours and seconds, and 2.0 minutes values" );
      clock.tick();
      clock.tick();
      clock.tick();
      clock.tick();
      clock.tick();
      clock.tick();

      System.out.println( "   Continue testing tick(), time slice is 100.0 seconds....");
      System.out.println( "      expecting string with 0.0 for hours, 3.0 minutes, and 40.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours, 5.0 minutes, and 20.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours, 7.0 minutes, and 0.0000 seconds values" );
      clock.tick();
      System.out.println( "      expecting string with 0.0 for hours, 25.0 minutes, and 20.0000 seconds values" );
      for (int i = 0; i < 11; i++){
        clock.tick();
      }

      System.out.println( "  Continue testing tick(), time slice is 1507.0 seconds....");
      System.out.println( "      expecting string with 0.0 for hours, 50.0 minutes, and 27.0000 seconds values" );
      System.out.println( "      expecting string with 4.0 for hours, 36.0 minutes, and 30.0000 seconds values" );

      System.out.println( "  Continue testing tick(), time slice is 1789.0 seconds....");
      System.out.println( "      expecting string with 5.0 for hours, 6.0 minutes, and 19.0000 seconds values" );
      System.out.println( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.0000 seconds values" );

      System.out.println( "  Continue testing tick(), time slice is 0.123 seconds....");
      System.out.println( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.1230 seconds values" );
      System.out.println( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.3690 seconds values" );
      System.out.println( "      expecting string with 6.0 for hours, 5.0 minutes, and 58.1070 seconds values" );

      // Test getHourHandAngle()
      System.out.println( "  Testing getHourHandAngle() for current time 06:05:57.1070....");
      System.out.println( "      expecting double angle value of approximately 183.131" );

      // Test getMinuteHandAngle()
      System.out.println( "  Testing getMinuteHandAngle() for current time 06:05:57.1070....");
      System.out.println( "      expecting double angle value of approximately 35.811" );

      // Test getHandAngle()
      System.out.println( "  Testing getHandAngle() for current time 06:05:57.1070....");
      System.out.println( "      expecting double angle value of approximately 147.321 degrees" );




      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
