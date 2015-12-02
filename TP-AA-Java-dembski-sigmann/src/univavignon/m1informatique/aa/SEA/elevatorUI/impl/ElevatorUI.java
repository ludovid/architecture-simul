package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public class ElevatorUI implements IElevatorUI
{

	// un elevatorUI possède un control system correspondant
	public static IControlSystem cs;
	
	// constructeur
	public ElevatorUI(IControlSystem controlsystem) {
		super();
		cs = controlsystem;
	}
	

	public IUser iUser;

	/**
	 * Getter of iUser
	 */
	public IUser getIUser() 
	{
	 	 return iUser; 
	}

	/**
	 * Setter of iUser
	 */
	public void setIUser(IUser iUser) 
	{ 
		 this.iUser = iUser; 
	}

	/* 
	 *  //stopRequest crée une requête pour le controlsystem à partir d'un étage, d'une direction
	 *  et d'une requête de type IElevatorUIRequest
	 */
	@Override
	public void stopRequest(int level, Direction direction,
			IElevatorUIRequest uiRequest) {
		cs.stopRequest(level, direction, uiRequest);
		
	}

	
	

}

