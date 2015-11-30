package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.commontype.State;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevator.impl.Elevator;
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
		this.cs = controlsystem;
	}
	
	/**
	 * 
	 */
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

	/**
	 * 
	 *  stopRequest crée une requête pour le controlsystem à partir d'un étage, d'une direction.
	 */
	
	@Override
	public void stopRequest(int level, Direction direction) {
		 // Depend de comment il creer la request 
		//soit à partir d'une request directement soit à partir des info mais sur les interface c'est comme ça 
		cs.stopRequest(level,direction, null);
		
	} 

	
	public static void createCall(int level, Direction direction, IUser user) 
	 { 
		// VOIR COMMENT EST ENREGISTRE LES REQUEST DANS COMMAND SYSTEM 
		//CHANGER recRequest par le nom de la méthode
		//un call aura une direction et un move non ...		 
		  cs.stopRequest(level, direction, null); 
		  // faire un notify
	 }

	/**
	 * 
	 * @param level 
	 * @param user 
	 */
	public static void createMove(int level, IUser user) 
 	{
	
		// VOIR COMMENT EST ENREGISTRE LES REQUEST DANS COMMAND SYSTEM 
		//ET CHANGER recRequest par le nom de la méthode
				  cs.stopRequest(level, user.getDirection(), null);  

	} 

	// ta demande est complètement dafuk car on a meme pas de commontype elevatorState
	public State getState() 		
		{
			return null;    
			//return cs.notifyState();
			
		}

	public int getLevel() 				// la pareil faut voir si ils ont un getLevel
		{                
			//return cs.notifyLevel();
		return 0;
		}
}

