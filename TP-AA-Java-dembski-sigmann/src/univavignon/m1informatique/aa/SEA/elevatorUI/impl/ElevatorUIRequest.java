package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;

public class ElevatorUIRequest implements IElevatorUIRequest 
{
	
	private Direction direction;	
	private int level;

	public ElevatorUIRequest(Direction direction, int level)
	{
		this.direction = direction;
		this.level = level;
	}
	

	public Direction getDirection() 
	{
		return direction;
	}

	public int getLevel() 
	{
		return level;
	}

//Je comprend pas trop le notifyStop je retourne le temps notifyStop, car il est appel�e par le controlsystem pour signaler que
//l'ascenseur est arriv� � un des �tages demand�s.
// en gros un signal pour dire que la requ�te est trait�
// Son argument long t est la date de l'arriv� de l'assenceur on doit remonter cette info � flow donc je retourne juste la date ?.

	public void notifyStop(long t)  
	{
		System.out.println("L'arr�t est � " + t);
	}

	
}
