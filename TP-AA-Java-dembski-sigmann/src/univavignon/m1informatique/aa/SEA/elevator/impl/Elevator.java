package univavignon.m1informatique.aa.SEA.elevator.impl;

import univavignon.m1informatique.aa.SEA.commontype.State;
import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IElevatorNotifier;


public class Elevator {

	/**
	 * 
	 */
	public State state;
	/**
	 * 
	 */
	public int position;
	/**
	 * 
	 */
	public Direction direction;
	/**
	 * 
	 */
	public long openDoorWait;
	/**
	 * 
	 */
	public IElevatorNotifier IEN;
	
	/**
	 * Constructeur
	 */
	public Elevator(long odw) {
	 	 this.state = State.Pause;
	 	 this.position = 0;
	 	 this.direction = Direction.None;
	 	 this.openDoorWait = odw;
	}
	/**
	 * Getter of state
	 */
	public State getState() {
	 	 return state; 
	}
	/**
	 * Setter of state
	 */
	public void setState(State state) { 
		 this.state = state; 
	}
	/**
	 * Getter of position
	 */
	public int getPosition() {
	 	 return position; 
	}
	/**
	 * Setter of position
	 */
	public void setPosition(int position) { 
		 this.position = position; 
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
	 * Getter of openDoorWait
	 */
	public long getOpenDoorWait() {
	 	 return openDoorWait; 
	}
	/**
	 * Setter of openDoorWait
	 */
	public void setOpenDoorWait(long openDoorWait) { 
		 this.openDoorWait = openDoorWait; 
	}
	
	public IElevatorNotifier getIEN() {
		return IEN;
	}
	
	public void setIEN(IElevatorNotifier iEN) {
		this.IEN = iEN;
	}
	/**
	 * 
	 */
	public void openDoor() { 
		this.state = State.Transient;
		System.out.println("elevator open door");
	 }
	/**
	 * 
	 */
	public void closeDoor() { 
		this.state = State.Pause;
		System.out.println("elevator close door");
	 }
	/**
	 * 
	 * @param direction 
	 */
	public void moveElevator(Direction direction) { 
		this.direction = direction;
		this.state = State.Move;
	 }
}
