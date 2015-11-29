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

//Je comprend pas trop le notifyStop je retourne le temps notifyStop, car il est appelée par le controlsystem pour signaler que
//l'ascenseur est arrivé à un des étages demandés.
// en gros un signal pour dire que la requète est traité
// Son argument long t est la date de l'arrivé de l'assenceur on doit remonter cette info à flow donc je retourne juste la date ?.

	public void notifyStop(long t)  
	{
		System.out.println("L'arrêt est à " + t);
	}

	
}
