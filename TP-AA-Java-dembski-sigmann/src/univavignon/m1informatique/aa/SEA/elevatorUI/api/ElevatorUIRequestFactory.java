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
	public static IElevatorUI ElevatorUI;

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
	
	/*
	 * méthodes appelées par flow lorsqu'il y a une requête à envoyer
	 */
	
	// méthode appel
	public static void createCall(int level, Direction direction, IUser user) 
	 { 
		ElevatorUIRequest Call=null;
		Call.level=level;
		Call.direction=direction;
		Call.user=user;
		ElevatorUI.stopRequest(level, direction, Call);  
	 }
	
	// méthode déplacement
	public static void createMove(int level, IUser user) 
  	{
		ElevatorUIRequest Move=null;
		Move.level=level;
		Move.direction=null;
		Move.user=user;
		ElevatorUI.stopRequest(level, null, Move); 
	} 

}