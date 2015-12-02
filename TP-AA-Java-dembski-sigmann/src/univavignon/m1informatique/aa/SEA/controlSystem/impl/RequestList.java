package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import java.util.ArrayList;

import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;

public class RequestList {
	
	/**
	 * currentList:	requ�tes qui vont dans la m�me direction
	 * nextList:	requ�tes qui vont dans le sens oppos�.
	 * otherList:	requ�tes qui vont dans la m�me direction mais se trouvant
	 * 				en dessous du niveau actuel de elevator.
	 */
	public static ArrayList<CSRequest> currentList;
	public static ArrayList<CSRequest> nextList;
	public static ArrayList<CSRequest> otherList;
	public static IElevatorCommand command;
	
	/**
	 * @name: addRequest @param: la requ�te transform� d'UIRequest
	 * 
	 * Cette fonction permet d'ajouter une requ�te dans une des 3 listes.
	 * currentList est la liste principale. Si elle est vide, la requ�te est
	 * ajout� � celle-ci. Sinon, si la direction de la requ�te est la m�me que
	 * la 1ere requ�te de currentList et que l'�tage demand� est inf�rieur
	 * (resp. sup�rieur) � l'�tage de la 1ere requ�te et sup�rieur
	 * a l'�tage actuel de l'elevator, alors elle est ajout� en t�te (resp. � la suite)
	 * de currentList.
	 * 
	 * Si la direction de la requ�te n'est pas la m�me que celle de la 1ere requete
	 * de currentList, alors elle est ajout� � nextList.
	 * 
	 * Si la direction est la m�me, mais que l'�tage demand� se trouve en dessous de
	 * l'�tage actuel de l'elevator, alors la requ�te est ajout� � otherList.
	 */
	public static void addRequest(CSRequest request) {
		/** C'est la 1ere requ�te, donc on fait bouger l'elevator
		 *  dans la direction de la requ�te.
		 */
		if(currentList.isEmpty()) {
			currentList.add(request);
			command.move(RequestList.currentList.get(0).getDirection());
		}
		if(currentList.size() == 1)
			command.move(RequestList.currentList.get(0).getDirection());
		else if(request.getDirection() == currentList.get(0).getDirection()) {
			if(request.getLevel() < currentList.get(0).getLevel()
			   && request.getLevel() > Optimizer.currentLevel ){
				currentList.add(0, request);	
			}
			if(request.getLevel() >= currentList.get(0).getLevel()
			   && request.getLevel() > Optimizer.currentLevel) {
				currentList.add(request);
			}
			if(request.getLevel() < Optimizer.currentLevel) {
				otherList.add(request);
			}
		}
		else
			nextList.add(request);
	 }
}
