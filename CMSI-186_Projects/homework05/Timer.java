/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Provides a clock for the SoccerSim class.
 *  Author        :  Matt Stein
 *  Date          :  2018-03-15
 *  Description   :  This timer class tracks the current time of in the SoccerSim class and
 *                   continues to create ticks for the program to operate on.
 *  Notes         :  This class does not have a main program. It is made to run with the SoccerSim class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-15  Matt Stein    Initial Code Writing and Method Selection
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class Timer {

  public double currentTime ;
  public double currentHours;
  public double currentMins;
  public double currentSecs;
  public double timeSlice = 1.0;

  public double tick() {
     currentTime = currentTime + timeSlice;
     currentSecs = currentTime % 60;
     currentMins = (int) (currentTime / 60) % 60;
     currentHours = (int) currentTime / 3600 % 1;
     //for (double i = 0; i < timeSlice; i++){
    //   currentSecs += 1;
    //   if (currentSecs == 60) {
    //     currentMins += 1;
    //     if (currentMins == 60) {
    //       currentHours += 1;
    //       currentMins = 0;
    //     }
    //     currentSecs = 0;
    //   }
     //}
     return currentTime;
  }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs possible last input
   *  @return double-precision value of the argument or NumberFormatException
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */

  public double validateTimeSliceArg( String argValue ) throws NumberFormatException{
    if ( Double.parseDouble(argValue) > 0.0 ) {
      return Double.parseDouble(argValue);
    }
    else {
      throw new NumberFormatException("Error! The time slice is invalid. Please choose a number greater than 0!");
    }
  }

  /**
   *  Method to return a String representation of this timer
   *  @return String value of the current time.
   */
   public String toString() {
      return currentHours + ":" + currentMins + ":" + currentSecs + ".    (hrs:mins:secs)";
   }

}
