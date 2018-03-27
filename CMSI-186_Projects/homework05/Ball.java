/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a ball that can be kicked for the SoccerSim class .
 *  Author        :  Matt Stein
 *  Date          :  2018-03-15
 *  Description   :  This ball class tells the speed of the ball, the direction that the ball is traveling,
 *                   and the position of the ball at any given time instant. The ball also reports whether
 *                   or not the ball is currently moving.
 *  Notes         :  This class does not have a main function. It is made entirely to be used with the
 *                   SoccerSim class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-03-15  Matt Stein    Initial Code Writing and Method Selection
 *  @version 1.1.0  2018-03-20  Matt Stein    Final Code completion 
 *  @version 1.1.1  2018-03-27  Matt Stein    Added method descriptions 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 public class Ball {

   /**
    * private instance data
    */
    public double radius = 4.45/12;
    public double mass = 1.0;
    public double xPosition;
    public double yPosition;
    public double xVelocity;
    public double yVelocity;


    // public constructor:
   /**
    * constructor
    * @param xPos double value containing the initial x Position of ball
    * @param yPos double value containing the initial y Position of ball
    * @param xVel double value containing the initial x Velocity of ball
    * @param yVel double value containing the initial x Velocity of ball
    * @throws       IllegalArgumentException
    * Note: parameters must be checked for validity; invalid value must throw "IllegalArgumentException"
    */

    public Ball ( double xPos, double yPos, double xVel, double yVel ) throws IllegalArgumentException {
        xPosition = xPos;
        yPosition = yPos;
        xVelocity = xVel;
        yVelocity = yVel;
    }

    /**
     * To String representation of current Ball class
     *
     * @return Position: <xPosition, yPosition> with Velocity: <xVelocity, yVelocity>.
     */

    public String toString() {
       return "Position: <" + xPosition + ", " + yPosition + ">    with  Velocity: <" + xVelocity + ", " + yVelocity + ">";
    }

    /**
     * Validates ball presence on soccer field
     * NOTE: Uses field dimensions set up in SoccerSim
     *
     * @return true/false if ball is present/not present.
     */
    public boolean validateBallPresence() {
      if ( (xPosition > SoccerSim.FIELD_LENGTH/2) || (xPosition < -1*SoccerSim.FIELD_LENGTH/2) ||  (yPosition > SoccerSim.FIELD_HEIGHT/2) || (yPosition < -1*SoccerSim.FIELD_HEIGHT/2) ){
        return false;
      }
      else {
        return true;
      }
    }

}
