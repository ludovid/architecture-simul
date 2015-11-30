package univavignon.m1informatique.aa.SEA.flow.api;

import univavignon.m1informatique.aa.SEA.commontype.Direction;


public interface IUser {

	
	
	/*
	 * Fonctions permettant la communication entre Elevator UI et Flow
	 */
	
	// pour récupérer le temps lorsque l'ascenseur arrive à l'étage appelé
	public void notifyCall(long t);

	// pour récupérer le temps lorsque l'ascenseur arrive à l'étage désiré
	public void notifyMove(long t);

	
	/*
	 * Fonctions pour le Flow permettant de connaitre et de modifier certaines informations des utilisateurs
	 */
	long getStartTime();
	public Direction getDirection();
	public long getCallTime();
	public boolean callOrNot();
	public void callOrNot(boolean ICall);
	public long getEndTime();
	public int getStartLevel();
	public int getDestinationLevel();
	public void setEnd(long end);
	public int getID();
}
