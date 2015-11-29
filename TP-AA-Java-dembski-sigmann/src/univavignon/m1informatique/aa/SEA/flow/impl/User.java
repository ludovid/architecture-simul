package univavignon.m1informatique.aa.SEA.flow.impl;

import univavignon.m1informatique.aa.SEA.flow.api.IUser;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class User implements IUser {
	
	private static int cc = 0; //nombre d'user instanciés
	private int id; // un identifiant chiffré par user
	
	// les differentes dates-cles de l'utilisateur
		private long call; // appel de l'utilisateur
		private long start; // utilisateur entre dans l'ascenseur
		private long end; // utilisateur est à destination

		private int levelStart; // niveau de depart
		private int levelEnd; // niveau de fin

		boolean ICall; // savoir si l'utilisateur a appelé ou non

		private Direction direction; // la direction souhaitée

		/* Constructeur d'un utilisateur
		 * On initialise que ce que l'on connait de base
		 * Le reste devra être modifié durant la simulation
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
			// si l'étage de début est supérieur à l'étage d'arrivée, on descend
			else
				direction=Direction.Down;
		}

		/*
		 * Fonctions pour récupérer des informations
		 */

		// temps appel
		public long getCallTime(){
			return call;
		}

		// temps départ
		public long getStartTime(){
			return start;
		}

		// temps arrivée
		public long getEndTime(){
			return end;
		}

		// level départ
		public int getStartLevel(){
			return levelStart;
		}

		// level arrivée
		public int getDestinationLevel(){
			return levelEnd;
		}

		// utilisateur a appelé
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
		
		
		// temps départ
		public void notifyMove(long t) {
			this.start=t;
			
		}
	
		// temps d'arrivée
		public void setEnd(long end){
			this.end=end;
		}

		// level départ
		public void setlevelStart(int levelStart){
			this.levelStart=levelStart;
		}
		
		// level arrivée
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
