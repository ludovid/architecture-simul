package univavignon.m1informatique.aa.SEA.elevatorUI.api;

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
	public void setElevatorUI(IElevatorUI ElevatorUI1)
	{ 
		 ElevatorUI = ElevatorUI1; 
	}
	
	/*
	 * méthodes appelées par flow lorsqu'il y a une requête à envoyer
	 */
	
	// méthode appel
	public static void createCall(int level, Direction direction, IUser user) 
	 { 
		ElevatorUIRequest Call=new ElevatorUIRequest(direction,level,user);
		ElevatorUI.stopRequest(level, direction, Call);  
	 }
	
	// méthode déplacement
	public static void createMove(int level, IUser user) 
  	{
		ElevatorUIRequest Move=new ElevatorUIRequest(null, level,user);
		ElevatorUI.stopRequest(level, null, Move); 
	} 

}