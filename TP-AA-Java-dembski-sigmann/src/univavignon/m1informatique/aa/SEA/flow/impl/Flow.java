package univavignon.m1informatique.aa.SEA.flow.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import univavignon.m1informatique.aa.SEA.elevatorUI.api.ElevatorUIRequestFactory;
import univavignon.m1informatique.aa.SEA.flow.api.IFlow;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;
import univavignon.m1informatique.aa.SEA.sequencer.api.Event;
import univavignon.m1informatique.aa.SEA.sequencer.api.Sequenceur;

public class Flow implements IFlow {

	// liste pour stocker les utilisateurs et leurs informations
	private ArrayList<IUser> users = new ArrayList<IUser>();

	// instanciation
	private ElevatorUIRequestFactory Elevatorui;
	
	// pour g�rer les chiffres al�atoires
	private final Random generator;
	
	// les deux donn�es transmises par le SEA UI, le temps et le temps d'origine
	private final long simuContraction;
	private final long simuOrigine;
	
	// nombre de levels
	private int nbLevels;
	
	// d�claration du Sequencer
	private Sequenceur seq;
	
	
	// constructeur
	public Flow(final String flowFile, long time, long time2) {
		/*
		 *  initialisation du Sequencer
		 *  avec param�tres temporels origine et dur�e
		 */
		seq = new Sequenceur (time, time2);
		this.simuContraction=time;
		this.simuOrigine=time2;
		
		// liste utilisateurs et g�n�rateur de chiffres
		this.users = new ArrayList<IUser>();
		this.generator = new Random();
	}
	
/*
 * Fonction pour cr�er un fichier, on lui transmet des informations basiques
 * (un nom, nombre d'utilisateurs, de levels, le temps, etc
 * et il y a g�n�ration de chiffres al�atoires pour les utilisateurs
 * 
 */
	public void create (String fichier, int nbUsers, int nbLevels, long start, long time)
	{
		this.nbLevels=nbLevels;
		//int id=0;
		String Concatenation=null;
		long CallTime;
		int levelStart;
		int levelEnd;
		File Configuration = new File(fichier);
		// au cas o� il y a d�j� un fichier avec ce nom, on le supprime
		Configuration.delete();
		
		try 
		{
			// normalement si le fichier n'existe pas, il est cr�e � la racine du projet
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration));
	
			
			
			
			// cr�ation des utilisateurs
			for (int i=0; i<nbUsers; i++)
			{
	
				// l'heure � laquelle il a appel�
				CallTime  = generator.nextLong() % time;
				// le level de depart
				levelStart = generator.nextInt(nbLevels);
				// le level d'arriv�e
				levelEnd = generator.nextInt(nbLevels);
				
				// v�rification
				// si l'appel est �gal � z�ro, on relance
				 while (CallTime <=0)
				 {
					 CallTime  = generator.nextLong() % time;
				 }
				 
				 // si l'�tage de d�part et d'arriv�e sont identiques
				 // ou si l'�tage de d�part est inf�rieur ou �gal � z�ro
				 // ou si l'�tage d'arriv�e est inf�rieur ou �gal � z�ro
				 while (levelStart == levelEnd || levelStart<=0 || levelEnd <=0)
				 {
					 levelStart = generator.nextInt(nbLevels);
					 levelEnd = generator.nextInt(nbLevels);
				 }
				 
			Concatenation = Long.toString(CallTime) + " " + Integer.toString(levelStart) + " " 
					+ Integer.toString(levelEnd);
			writer.write(Concatenation);
			writer.newLine();
			
		
		  }
			writer.close();
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
	}
	
	
	/*
	 * Fonction pour charger un fichier de configuration
	 * 
	 */
	public void compute(File file) throws FileNotFoundException{
		// on cr�e un scanner
		try(Scanner scanner = new Scanner(file)) {
		// on pr�pare les variables pour stocker les valeurs
		//String str = null;
		 int heureAppel, etageDepart, etageArrivee;
		 while (scanner.hasNextLine()) {
			 try {
			 /*
			  *  les fichiers sont de la forme :
			  *  HeureAppel + EtageDepart + EtageArrivee 
			  */
		     heureAppel = scanner.nextInt();
		     etageDepart = scanner.nextInt();
		     etageArrivee = scanner.nextInt();
		     
		     // ajout de l'utilisateur dans la liste
		     users.add(new User(heureAppel, etageDepart, etageArrivee)); 
		 	// ajout de l'utilisateur dans le sequencer
		     Event e = null;
		     seq.addEvent(e,heureAppel);
			 }
			 catch (NoSuchElementException e){
				 System.out.println("Il n'y a plus d'�l�ments");
			 }
		 }
	}
	}

	/*
	 * permet de concevoir un fichier contenant l'ensemble des informations 
	 * de la simulation
	 */
	
	public File generateFlowCompleted (String file)
	{
		File FlowCompleted = new File(file);
		FlowCompleted.delete();
		String Concatenation=null;
		
		try 
		{
			// normalement si le fichier n'existe pas, il est cr�e � la racine du projet
			BufferedWriter writer = new BufferedWriter(new FileWriter(FlowCompleted));
			
			for(IUser elem: users)
		       {
				/*
				 * on stocke les diff�rents informations qui nous int�resse
				 * ID + TempsAppel + TempsD�part + TempsArriv�e + LevelD�part + LevelFin
				 */
				Concatenation= Integer.toString(elem.getID()) + " " + Long.toString(elem.getCallTime()) + " " 
				 + Long.toString(elem.getStartTime()) + " " + Long.toString(elem.getEndTime()) + " " 
				+ Integer.toString(elem.getStartLevel()) + " " + Integer.toString(elem.getDestinationLevel());
	
				// on �crit dans le fichier
				writer.write(Concatenation);
				// on passe � la ligne
				writer.newLine();
				
		       }
			// quand tous les users sont pass�s, on ferme l'�criture
			writer.close();
			
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
		
		return FlowCompleted;
	}
	

	/*
	 * Fonction pour d�clencher des modifications sur l'utilisateur
	 */
	@Override
	public void trigger(long t) {
		IUser u;
		for (int i=0; i<users.size(); i++)
		{
			// on r�cup�re un utilisateur
			u=users.get(i);
			// si l'utilisateur n'a pas notifi� qu'il a appel�
			// et que le temps d'appel est inf�rieur ou �gal au temps actuel
			if (!u.callOrNot() && u.getCallTime() <= t)
			{
				// on envoie une requ�te pour aller chercher l'utilisateur
				Elevatorui.createCall(u.getStartLevel(),  u.getDirection(), u);
				u.callOrNot(true);
			}
			
			// si le temps de d�part de l'utilisateur n'est pas d�fini
			// et si il a appel�
			//et si l'�tat de l'ascenseur permet d'y rentrer
			// et si l'ascenseur est bien � l'�tage de l'utilisateur
			else if(u.getStartTime()==-1 && u.callOrNot() 
					/*&& cs.notifyState()==State.Transient /*&&
					Elevatorui.getLevel()==u.getStartLevel()*/)
			{
				// on envoie une requ�te pour emmener l'utilisateur � l'�tage d�sir�
				Elevatorui.createMove(u.getDestinationLevel(), u);
				// on r�cup�re le moment o� l'utilisateur est entr�
				u.notifyMove(t);
			}
			
			// si le temps d'arriv�e de l'utilisateur n'est pas d�fini
			// et si il a appel�
			// et que son temps de d�part n'est pas nul (qu'il est dans l'ascenseur donc)
			// et si il est � l'�tage d�sir�
			// et si les portes sont ouvertes
			else if(u.getEndTime()==-1 && u.callOrNot() && u.getStartTime()!=1 
					/*&&Elevatorui.getState()== State.Transient
					&& Elevatorui.getLevel() == u.getDestinationLevel()*/ )
			{
				// on indique � quel moment l'utilisateur est arriv�
				u.setEnd(t);
			}
		}
	}

	// permet de lancer la stimulation
	public void start() {
		seq.start();
	}

	// permet de r�cup�rer le nombre de levels
	public int getMaxLevel() {
	return nbLevels;
	}
}
