package univavignon.m1informatique.aa.SEA.elevator.elevator_imp;

import univavignon.m1informatique.aa.SEA.sequencer.sequencer_int.IEvent;
import univavignon.m1informatique.aa.SEA.elevator.elevator_int.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.elevator.elevator_int.ElevatorNotifier;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class DummyElevator implements IEvent, IElevatorCommand {

	/**
	 * 
	 */
	public ElevatorNotifier elevatorNotifier;

	/**
	 * Getter of elevatorNotifier
	 */
	public ElevatorNotifier getElevatorNotifier() {
	 	 return elevatorNotifier; 
	}

	/**
	 * Setter of elevatorNotifier
	 */
	public void setElevatorNotifier(ElevatorNotifier elevatorNotifier) { 
		 this.elevatorNotifier = elevatorNotifier; 
	}

	/**
	 * 
	 */
	public void trigger() { 
		System.out.println("git");
	 }

	/**
	 * 
	 * @param direction 
	 */
	public void move(Direction direction) { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 * @param level 
	 */
	public void stopAtLevel(int level) { 
		// TODO Auto-generated method
	 }
	
	

}
