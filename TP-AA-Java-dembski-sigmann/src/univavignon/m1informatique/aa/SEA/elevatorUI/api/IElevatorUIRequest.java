package univavignon.m1informatique.aa.SEA.elevatorUI.api;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

public interface IElevatorUIRequest 
{

	Direction getDirection();
	void notifyStop(long t);
	int getLevel();
	
}