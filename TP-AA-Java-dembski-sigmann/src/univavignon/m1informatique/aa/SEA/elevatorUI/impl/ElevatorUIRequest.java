package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public class ElevatorUIRequest implements IElevatorUIRequest 
{
	// une requête d'IElevatorUI est défini par :
	public Direction direction;	
	public int level;
	public IUser user;

	// constructeur
	public ElevatorUIRequest(Direction direction, int level, IUser user)
	{
		this.direction = direction;
		this.level = level;
		this.user=user;
	}
	

	/*
	 * Pour récupérer des informations
	 */
	public Direction getDirection() 
	{
		return direction;
	}

	public int getLevel() 
	{
		return level;
	}


	// appelé par controlsystem pour indiquer que la requête a été traitée
	public void notifyStop(long t)  
	{
		// si l'utilisateur concerné n'est pas encore dans l'ascenseur 
		if (user.getStartTime() ==-1) 
			// on met à jour la valeur
		user.notifyCall(t);
		else
			// sinon la requête met à jour la date à laquelle l'utilisateur est arrivé
			user.notifyMove(t);
	}

	
}
