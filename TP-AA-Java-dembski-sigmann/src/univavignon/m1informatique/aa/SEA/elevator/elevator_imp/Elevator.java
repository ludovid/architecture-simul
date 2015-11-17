package univavignon.m1informatique.aa.SEA.elevator.elevator_imp;

import univavignon.m1informatique.aa.SEA.elevator.elevator_int.ElevatorNotifier;
import univavignon.m1informatique.aa.SEA.elevator.elevator_int.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.commontype.State;
import univavignon.m1informatique.aa.SEA.commontype.Direction;


public class Elevator extends ElevatorNotifier implements IElevatorCommand {

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
	 * @throws InterruptedException 
	 * 
	 */
	public void openDoor() throws InterruptedException { 
		this.state = State.Transient;
		wait(openDoorWait);
	 }
	/**
	 * 
	 */
	public void closeDoor() { 
		this.state = State.Pause;
	 }
	/**
	 * 
	 * @param direction 
	 */
	public void move(Direction direction) { 
		this.direction = direction;
		this.state = State.Move;
	 }
	/**
	 * 
	 * @param level 
	 */
	public void stopAtLevel(int level) { 
		// TODO Auto-generated method
	 } 

}
