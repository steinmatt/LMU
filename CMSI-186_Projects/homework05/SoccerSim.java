/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Detects collisions between an arbitrary number of balls on a soccer field.
 *  Author        :  Matt Stein
 *  Date          :  2018-03-20
 *  Description   :  This simulation class uses the Ball class to simulate an inputted number of balls being
 *                   kicked on a soccer field in inputted directions with inputted speeds, from an intitial
 *                   given position.  Friction is applied to each ball where each ball loses 1% of it's velocity
 *                   per second. The Timer class is also used to track the current time in the simulation.
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-03-15  Matt Stein    Initial Code Writing and Method Selection
 *  @version 1.1.0  2018-03-25  Matt Stein    Finalized Simulation Code w/ Methods and Testing
 *  @version 1.1.1  2018-03-27  Matt Stein    Created Method Descriptions for Java Docs
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class SoccerSim {
  public static final double FIELD_LENGTH = 1000.0;
  public static final double FIELD_HEIGHT = 1000.0;
  public static final double POLE_XPOSITION = 175.0;
  public static final double POLE_YPOSITION = -7.0;
  public static boolean collisionCondition = false;
  private static int firstBall;
  private static int secondBall;
  private static int argReducer = 0;
  private static Ball[] ballSet = null;

  /**
   * Validates after each iteration the need for further Simulation
   * Simulation stops if all balls have come to a rest or are no longer on the field.
   *
   * @param  bs An array of ball objects
   * @return true/false if simulation is to continue/stop
   */

  public static boolean validateSimulationStatus(Ball[] bs){
    for (Ball b: bs) {
      if ( (b.validateBallPresence() == true) && ((b.xVelocity > 0.1) || (b.yVelocity > 0.1)))  {
        return true;
      }
    }
    return false;
  }

  /**
   * Moves a Ball along the soccer Field.
   * NOTE: Movement will only occur if ball is on the field.
   *
   * @param  b A ball object
   * @return a string representation of the ball's new position and velocity
   */

  public static String moveBall(Ball b){
     if (b.validateBallPresence() == true) {
       b.xPosition += b.xVelocity*0.001;
       b.yPosition += b.yVelocity*0.001;
     }
     return b.toString();
  }

  /**
   * Updates the Ball's Velocity to account for Frictional Forces
   * NOTE: Only occurs once per second. Friction forces are equivalent to 1% decrease in speed.
   *
   * @param  bs An array of ball objects
   * @return String affirmation that each Ball's velocity has been updated.
   */

  public static String updateBallVelocity(Ball[] bs){
    for (Ball b: bs) {
      if (b.validateBallPresence() == true) {
        b.xVelocity = b.xVelocity - b.xVelocity*0.01;
        b.yVelocity = b.yVelocity - b.yVelocity*0.01;
      }
    }
    return "Each present Ball's velocity has been updated.";
  }

  /**
   * Checks to see if collision between two balls have occurred.
   * Method uses each ball's radius to detect if their is a possible collision
   * between balls. Collision occurs if the difference between both Ball's positions
   * are less than two times the radius.
   *
   * @param  bs An array of ball objects
   * @return true/false if collision has occured/didn't occur.
   */

 public static boolean checkCollision(Ball[] bs){
   for (int i = 0; i < bs.length; i++){
     for (int j = 0; j < bs.length; j++){
      if ( (i != j) && (Math.abs(bs[i].xPosition - bs[j].xPosition) < bs[i].radius*2) && ( Math.abs(bs[i].yPosition - bs[j].yPosition) < bs[i].radius*2) ) {
        firstBall = i;
        secondBall = j;
        return true;
      }
     }
     if ( ( ( Math.abs(bs[i].xPosition - POLE_XPOSITION) < bs[i].radius*2) && (Math.abs(bs[i].yPosition - POLE_YPOSITION) < bs[i].radius*2)) ){
       firstBall = i;
       secondBall = -1;
      return true;
     }
   }
   return false;
 }


 /**
  * Main Simulation Program.
  * Usage: java Soccer Sim <xPosition> <yPosition> <xVelocity> <yVelocity> [timeSlice]
  * NOTE: Program operates on instaneous increments. As a result, each ball moves and each collision
  * is tracked at near instaneous speeds.
  * NOTE: Time Slice is used to denote the frequency of simulation updates given to the user.
  *
  * @param  bs An array of ball objects
  * @return true/false if simulation is to continue/stop
  */

  public static void main( String args[] ) {
    Timer timer = new Timer();
    if( (0 == args.length) || (args.length < 4) ){
       System.out.println( "   Sorry you must create at least one ball. \n" +
                           "   Usage: java SoccerSim <xPosition> <yPosition> <xVelocity> <yVelocity> [timeSlice]\n" +
                           "   Please try again..........." );
       System.exit( 1 );
    }
    else if (1 == args.length % 4) {
      timer.timeSlice = timer.validateTimeSliceArg(args[args.length-1]);
      args[args.length-1] = null;
      argReducer = 1;

    }
    else if (0 != args.length % 4){
      System.out.println( " Sorry, something went wrong. Please check your input sequence. \n" +
                          "   Usage: java SoccerSim <xPosition> <yPosition> <xVelocity> <yVelocity> [timeSlice]\n" +
                          "   Please try again..........." );
    }

    ballSet = new Ball[(int) Math.floor( args.length/4)];
    int j = 0;
      for (int i = 0; i < args.length - argReducer; i+=4 ) {
        ballSet[j] = new Ball(Double.parseDouble(args[i]), Double.parseDouble(args[i+1]), Double.parseDouble(args[i+2]), Double.parseDouble(args[i+3]));
        j += 1;
      }


    System.out.println("Simulation Beginning:                                 \n" +
                       "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                       "Initial Conditions: \n" +
                       "~~~~~~~~~~~~~~ \n" +
                       "Current Time:               " + timer.toString());
    for (int i = 0; i < ballSet.length; i++) {
      System.out.println(i + ":                   " + ballSet[i].toString() + ".\n");
    }

    Double t = 0.0;
    while (true == validateSimulationStatus(ballSet)) {
        t += 0.01;
        if (0.01 > t % 1.0) {
          updateBallVelocity(ballSet);
        }
        if (0.01 > t % timer.timeSlice) {
          timer.tick();
          System.out.println("Simulation Update:                   NO COLLISION OCCURRED    \n" +
                             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                             "Current Conditions: \n" +
                             "~~~~~~~~~~~~~~ \n" +
                             "Current Time:               " + timer.toString() );
          for (int i = 0; i < ballSet.length; i++){
            System.out.println(i + ":                 " + ballSet[i].toString() + ".\n");
          }
        }
        for (int i = 0; i < ballSet.length; i++ ){
          moveBall(ballSet[i]);
        }
        if ( true == checkCollision(ballSet) ){
          timer.tick();
          if (secondBall == -1) {
            System.out.println("Simulation End:                    COLLISION OCCURRED    \n" +
                               "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                               "Current Time:                 " + timer.toString() +
                               "\nCONTACT:     Between Ball "  + firstBall + " & the Pole at: Position:   <" + ballSet[firstBall].xPosition + ", " + ballSet[firstBall].yPosition + ">.");

          }
          else {
            System.out.println("Simulation End:                    COLLISION OCCURRED    \n" +
                               "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                               "Current Time:                 " + timer.toString() +
                               "\nCONTACT:     Between Ball "  + firstBall + " & Ball " + secondBall + " at: Position:   <" + ballSet[firstBall].xPosition + ", " + ballSet[firstBall].yPosition + ">.");

          }

          System.exit(1);
        }
    }

    System.out.println("Simulation End:                   NO COLLISION OCCURRED    \n" +
                       "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                       "Elapsed Time:               " + timer.toString() );
  }
}
