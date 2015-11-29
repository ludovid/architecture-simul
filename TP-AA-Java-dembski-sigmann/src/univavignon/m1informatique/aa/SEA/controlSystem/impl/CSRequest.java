package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;

public class CSRequest implements Comparable<CSRequest> { 
	private int level;
	private Direction direction;
	public IElevatorUIRequest uiRequest;
	
	public CSRequest(int level, Direction direction, IElevatorUIRequest uiRequest) {
		this.level = level;
		this.direction = direction;
		this.uiRequest = uiRequest;
	}
	
	public int getLevel() {
		return level;
	}
	public Direction getDirection() {
		return direction;
	}

	@Override
	/**
	 * Permert de trier la liste une fois le changement de liste
	 * effectué. On vérifier d'abord la direction des requêtes dans la liste,
	 * si la direction est montante, on trie selon un ordre ascendant,
	 * sinon, on trie selon un ordre descendant
	 */
	public int compareTo(CSRequest c) {
		if(c.getDirection() == Direction.Up) {
			return this.getLevel() - c.getLevel();
		}
		if(c.getDirection() == Direction.Down) {
			return c.getLevel() - this.getLevel();
		}
		return 0;
	}

}
