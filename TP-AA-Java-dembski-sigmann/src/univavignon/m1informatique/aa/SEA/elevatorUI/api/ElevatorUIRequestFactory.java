package univavignon.m1informatique.aa.SEA.elevatorUI.api;

import univavignon.m1informatique.aa.SEA.elevator.impl.Elevator;
import univavignon.m1informatique.aa.SEA.elevatorUI.impl.DummyElevatorUI;
import univavignon.m1informatique.aa.SEA.elevatorUI.impl.ElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class ElevatorUIRequestFactory 
{

	/**
	 * 
	 */
	public IElevatorUI ElevatorUI;

	/**
	 * Getter of ElevatorUI
	 */
	public IElevatorUI getElevatorUI() 
	{
	 	 return ElevatorUI; 
	}

	/**
	 * Setter of ElevatorUI
	 */
	public void setElevatorUI(IElevatorUI ElevatorUI)
	{ 
		 this.ElevatorUI = ElevatorUI; 
	}
	/**
	 * 
	 * @param level 
	 * @param direction 
	 * @param user 
	 */
	

}