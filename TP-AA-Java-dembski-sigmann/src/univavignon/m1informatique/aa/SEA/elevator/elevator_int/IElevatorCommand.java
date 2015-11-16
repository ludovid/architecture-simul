package univavignon.m1informatique.aa.SEA.elevator.elevator_int;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

public interface IElevatorCommand {

	/**
	 * 
	 * @param direction 
	 */
	public void move(Direction direction);

	/**
	 * 
	 * @param level 
	 */
	public void stopAtLevel(int level); 

}
