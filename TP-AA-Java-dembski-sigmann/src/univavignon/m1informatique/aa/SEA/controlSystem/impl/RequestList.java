package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import java.util.ArrayList;

import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;

public class RequestList {
	
	/**
	 * currentList:	requêtes qui vont dans la même direction
	 * nextList:	requêtes qui vont dans le sens opposé.
	 * otherList:	requêtes qui vont dans la même direction mais se trouvant
	 * 				en dessous du niveau actuel de elevator.
	 */
	public static ArrayList<CSRequest> currentList;
	public static ArrayList<CSRequest> nextList;
	public static ArrayList<CSRequest> otherList;
	public static IElevatorCommand command;
	
	/**
	 * @name: addRequest @param: la requête transformé d'UIRequest
	 * 
	 * Cette fonction permet d'ajouter une requête dans une des 3 listes.
	 * currentList est la liste principale. Si elle est vide, la requête est
	 * ajouté à celle-ci. Sinon, si la direction de la requête est la même que
	 * la 1ere requête de currentList et que l'étage demandé est inférieur
	 * (resp. supérieur) à l'étage de la 1ere requête et supérieur
	 * a l'étage actuel de l'elevator, alors elle est ajouté en tête (resp. à la suite)
	 * de currentList.
	 * 
	 * Si la direction de la requête n'est pas la même que celle de la 1ere requete
	 * de currentList, alors elle est ajouté à nextList.
	 * 
	 * Si la direction est la même, mais que l'étage demandé se trouve en dessous de
	 * l'étage actuel de l'elevator, alors la requête est ajouté à otherList.
	 */
	public static void addRequest(CSRequest request) {
		/** C'est la 1ere requête, donc on fait bouger l'elevator
		 *  dans la direction de la requête.
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
