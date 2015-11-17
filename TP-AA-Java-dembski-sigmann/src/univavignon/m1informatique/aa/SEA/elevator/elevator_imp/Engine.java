package univavignon.m1informatique.aa.SEA.elevator.elevator_imp;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class Engine {

	/**
	 * 
	 */
	final double constSpeed = 1.0; // vitesse du moteur constante en m/s
	/**
	 * 
	 */
	final double constSpeedTransient = 0.2; // vitesse de transition du moteur constante en m/s
	/**
	 * 
	 */
	public double speed;
	/**
	 * 
	 */
	public Direction direction;
	/**
	 * 
	 */
	public boolean engineOn;
	/**
	 * Getter of speed
	 */
	public double getSpeed() {
	 	 return speed; 
	}
	/**
	 * Setter of speed
	 */
	public void setSpeed(double speed) { 
		 this.speed = speed; 
	}
	/**
	 * Getter of direction
	 */
	public Direction getDirection() {
	 	 return direction; 
	}
	/**
	 * Setter of direction
	 */
	public void setDirection(Direction direction) { 
		 this.direction = direction; 
	}
	/**
	 * Getter of engineOn
	 */
	public boolean getEngineOn() {
	 	 return engineOn; 
	}
	/**
	 * Setter of engineOn
	 */
	public void setEngineOn(boolean engineOn) { 
		 this.engineOn = engineOn; 
	}
	/**
	 * 
	 * @param direction 
	 */
	public void on(Direction direction) { 
		this.engineOn = true;
		this.direction = direction;
		this.speed = constSpeed;
	 }
	/**
	 * 
	 */
	public void off() { 
		this.engineOn = false;
		this.direction = Direction.None;
		this.speed = 0;
	 }
	/**
	 * 
	 * @param speed 
	 */
	public void changeSpeed(double speed) { 
		this.speed = speed;
	 } 

}
