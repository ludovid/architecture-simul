package univavignon.m1informatique.aa.SEA.elevator.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class Engine {

	public double constSpeed;
	
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
	 * Constructeur
	 */
	public Engine(double speed) {
	 	  this.speed = 0;
	 	  this.direction = Direction.None;
	 	  this.engineOn = false;
	 	  this.constSpeed = speed;
	}
	
	public double getConstSpeed() {
		return constSpeed;
	}
	
	public void setConstSpeed(double constSpeed) {
		this.constSpeed = constSpeed;
	}
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
		this.changeSpeed(this.constSpeed);
	 }
	/**
	 * 
	 */
	public void off() { 
		this.engineOn = false;
		this.direction = Direction.None;
		this.changeSpeed(0);
	 }
	/**
	 * 
	 * @param speed 
	 */
	public void changeSpeed(double constSpeed) { 
		this.speed = constSpeed;
	 } 

}
