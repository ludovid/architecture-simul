package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import java.util.Collections;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.commontype.State;
import univavignon.m1informatique.aa.SEA.elevator.api.ElevatorCommandFactory;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorNotifier;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;

public class Optimizer implements IElevatorNotifier {
	
	public IElevatorCommand command;
	public IElevatorUIRequest r;
	public State state;
	public Direction direction;
	public static int currentLevel = 0;
	
	/**
	 *  @Description: Fait le lien avec l'elevator
	 */
	public Optimizer() {
		command = ElevatorCommandFactory.getElevatorCommand();
	}
	
	@Override
	/**
	 * @name: notifyLevel @param le niveau actuel de l'elevator
	 * 
	 * 	La fonction prend l'étage actuel de l'elevator en param
	 * 	et le compare avec l'étage de la 1ere requête, si l'étage
	 * 	de la requête se trouve juste au dessus (resp. en dessous),
	 *  la fonction stopAtNextLevel de l'elevator est alors appelée
	 *  pour que celui-ci s'arrête au prochain étage.
	 *  
	 *  currentList:
	 *  Liste des utilisateurs qui vont dans la même direction. Lorsque
	 *  celle-ci a été entièrement parcouru, currentList devient nextList
	 *  
	 *  nextList:
	 *  Liste des utilisateurs qui vont dans le sens opposé à currentList.
	 *  Lorsqu'elle est assigné à currentList, elle récupère les requêtes de otherList.
	 *  
	 *  otherList:
	 *  Liste des utlisateurs qui vont dans la même direction que currentList, mais
	 *  qui se trouve en dessous du niveau actuel de l'elevator. Lorsqu'elle est assignée
	 *  à nextList, elle est réinitialisé.
	 *  
	 * 
	 */
	public void notifyLevel(int level) {
		/** Si **/
		if(RequestList.currentList.size() == 1)
			command.move(RequestList.currentList.get(0).getDirection());
		
		currentLevel = level;
		direction = RequestList.currentList.get(0).getDirection();
		
		int nextLevel = RequestList.currentList.get(0).getDirection()
						== Direction.Up ? level + 1 : level - 1;
		if(!RequestList.currentList.isEmpty()) {
			if(state == State.Move) {
				if(RequestList.currentList.get(0).getLevel() == nextLevel) {
					command.stopAtNextLevel(nextLevel);
				}
			}
			if(state == State.Pause) {
				/** Si l'elevator a les portes ouverte, on notifie UIElevator
				 *  qu'une de ses requête a été traité et on remove la requête.
				 *  On fait ensuite bouger l'elevator dans la direction de la dernière
				 *  requête traité.
				 */
				if(RequestList.currentList.get(0).getLevel() == level) {
					RequestList.currentList.get(0).uiRequest.notify();
					RequestList.currentList.remove(0);
				}
			}
		}
		/** La liste principale est vide. On transfert la liste secondaire
		 * 	(celle qui contient les requête qui vont dans le sens opposé)
		 *  dans la liste principale et on transfert la troisième liste ( celle
		 *  qui contient les requête qui allaient dans le même sens, mais qui se trouvaient
		 *  en dessous de l'elevator ) dans la liste secondaire.
		 * **/
		else {
			RequestList.currentList = RequestList.nextList;
			/** On trie la nouvelle currentList **/
			Collections.sort(RequestList.currentList);
			
			RequestList.nextList = RequestList.otherList;
			RequestList.otherList.clear();
			
			/**
			 * Si la direction était montante, on fait descendre l'ascenceur
			 * sinon, on le fait monter.
			 */
			if(direction == Direction.Up)
				command.move(Direction.Down);
			else
				command.move(Direction.Up);
		}
	}

	@Override
	public void notifyState(State currentState) {
		state = currentState;
	}
	
}
