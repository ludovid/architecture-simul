package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public class ElevatorUIRequest implements IElevatorUIRequest 
{
	// une requ�te d'IElevatorUI est d�fini par :
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
	 * Pour r�cup�rer des informations
	 */
	public Direction getDirection() 
	{
		return direction;
	}

	public int getLevel() 
	{
		return level;
	}


	// appel� par controlsystem pour indiquer que la requ�te a �t� trait�e
	public void notifyStop(long t)  
	{
		// si l'utilisateur concern� n'est pas encore dans l'ascenseur 
		if (user.getStartTime() ==-1) 
			// on met � jour la valeur
		user.notifyCall(t);
		else
			// sinon la requ�te met � jour la date � laquelle l'utilisateur est arriv�
			user.notifyMove(t);
	}

	
}
