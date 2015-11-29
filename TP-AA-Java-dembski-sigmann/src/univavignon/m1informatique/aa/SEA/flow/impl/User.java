package univavignon.m1informatique.aa.SEA.flow.impl;

import univavignon.m1informatique.aa.SEA.flow.api.IUser;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class User implements IUser {
	
	private static int cc = 0; //nombre d'user instanci�s
	private int id; // un identifiant chiffr� par user
	
	// les differentes dates-cles de l'utilisateur
		private long call; // appel de l'utilisateur
		private long start; // utilisateur entre dans l'ascenseur
		private long end; // utilisateur est � destination

		private int levelStart; // niveau de depart
		private int levelEnd; // niveau de fin

		boolean ICall; // savoir si l'utilisateur a appel� ou non

		private Direction direction; // la direction souhait�e

		/* Constructeur d'un utilisateur
		 * On initialise que ce que l'on connait de base
		 * Le reste devra �tre modifi� durant la simulation
		 */
		public User(long call, int levelStart, int levelEnd)
		{
			cc++;
			id=cc;
			this.call=call;
			start=-1;
			end=-1;
			this.levelStart=levelStart;
			this.levelEnd=levelEnd;
			// de base, l'elevator monte
			if (levelStart<levelEnd)
			direction=Direction.Up;
			// si l'�tage de d�but est sup�rieur � l'�tage d'arriv�e, on descend
			else
				direction=Direction.Down;
		}

		/*
		 * Fonctions pour r�cup�rer des informations
		 */

		// temps appel
		public long getCallTime(){
			return call;
		}

		// temps d�part
		public long getStartTime(){
			return start;
		}

		// temps arriv�e
		public long getEndTime(){
			return end;
		}

		// level d�part
		public int getStartLevel(){
			return levelStart;
		}

		// level arriv�e
		public int getDestinationLevel(){
			return levelEnd;
		}

		// utilisateur a appel�
		public boolean callOrNot(){
			return ICall;
		}

		// direction choisie
		public Direction getDirection(){
			return direction;
		}
		
		public int getID(){
			return id;
		}


		/*
		 * Fonctions pour modifier des informations
		 */

		// temps appel
		public void notifyCall(long t) {
			this.call=t;
			
		}
		
		
		// temps d�part
		public void notifyMove(long t) {
			this.start=t;
			
		}
	
		// temps d'arriv�e
		public void setEnd(long end){
			this.end=end;
		}

		// level d�part
		public void setlevelStart(int levelStart){
			this.levelStart=levelStart;
		}
		
		// level arriv�e
		public void setlevelEnd(int levelEnd){
			this.levelEnd=levelEnd;
		}
		
		// l'utilisateur entre dans l'elevator ou non
		public void callOrNot(boolean ICall){
			this.ICall= ICall;
		}
		
		//modification de la direction choisie par l'utilisateur
		public void setDirection(Direction direction){
			this.direction=direction;
		}


		

		
}
