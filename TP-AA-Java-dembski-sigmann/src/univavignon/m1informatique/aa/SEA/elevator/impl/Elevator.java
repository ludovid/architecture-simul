package univavignon.m1informatique.aa.SEA.elevator.impl;

import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorNotifier;
import univavignon.m1informatique.aa.SEA.commontype.State;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class Elevator implements IElevatorNotifier, IElevatorCommand {

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
	public void move(Direction direction) { 
		this.direction = direction;
		this.state = State.Move;
		System.out.println("elevator move "+direction);
	 }
	
	/**
	 * 
	 * @param level 
	 */
	public void stopAtLevel(int level) { 
		// TODO Auto-generated method
		System.out.println("elevator stop at level "+level);
	 }
	
	@Override
	public void notifyLevel(int level) {
		// TODO Auto-generated method stub
		System.out.println("elevator notify level "+level);
		
	}
	
	@Override
	public void notifyState(State state) {
		// TODO Auto-generated method stub
		System.out.println("elevator notify state "+state);
		
	} 

}
