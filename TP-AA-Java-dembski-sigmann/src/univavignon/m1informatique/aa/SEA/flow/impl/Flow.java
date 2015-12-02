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
	
	// pour gérer les chiffres aléatoires
	private final Random generator;
	
	// les deux données transmises par le SEA UI, le temps et le temps d'origine
	private final long simuContraction;
	private final long simuOrigine;
	
	// nombre de levels
	private int nbLevels;
	
	// déclaration du Sequencer
	private Sequenceur seq;
	
	
	// constructeur
	public Flow(final String flowFile, long time, long time2) {
		/*
		 *  initialisation du Sequencer
		 *  avec paramètres temporels origine et durée
		 */
		seq = new Sequenceur (time, time2);
		this.simuContraction=time;
		this.simuOrigine=time2;
		
		// liste utilisateurs et générateur de chiffres
		this.users = new ArrayList<IUser>();
		this.generator = new Random();
	}
	
/*
 * Fonction pour créer un fichier, on lui transmet des informations basiques
 * (un nom, nombre d'utilisateurs, de levels, le temps, etc
 * et il y a génération de chiffres aléatoires pour les utilisateurs
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
		// au cas où il y a déjà un fichier avec ce nom, on le supprime
		Configuration.delete();
		
		try 
		{
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration));
	
			
			
			
			// création des utilisateurs
			for (int i=0; i<nbUsers; i++)
			{
	
				// l'heure à laquelle il a appelé
				CallTime  = generator.nextLong() % time;
				// le level de depart
				levelStart = generator.nextInt(nbLevels);
				// le level d'arrivée
				levelEnd = generator.nextInt(nbLevels);
				
				// vérification
				// si l'appel est égal à zéro, on relance
				 while (CallTime <=0)
				 {
					 CallTime  = generator.nextLong() % time;
				 }
				 
				 // si l'étage de départ et d'arrivée sont identiques
				 // ou si l'étage de départ est inférieur ou égal à zéro
				 // ou si l'étage d'arrivée est inférieur ou égal à zéro
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
		// on crée un scanner
		try(Scanner scanner = new Scanner(file)) {
		// on prépare les variables pour stocker les valeurs
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
				 System.out.println("Il n'y a plus d'éléments");
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
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
			BufferedWriter writer = new BufferedWriter(new FileWriter(FlowCompleted));
			
			for(IUser elem: users)
		       {
				/*
				 * on stocke les différents informations qui nous intéresse
				 * ID + TempsAppel + TempsDépart + TempsArrivée + LevelDépart + LevelFin
				 */
				Concatenation= Integer.toString(elem.getID()) + " " + Long.toString(elem.getCallTime()) + " " 
				 + Long.toString(elem.getStartTime()) + " " + Long.toString(elem.getEndTime()) + " " 
				+ Integer.toString(elem.getStartLevel()) + " " + Integer.toString(elem.getDestinationLevel());
	
				// on écrit dans le fichier
				writer.write(Concatenation);
				// on passe à la ligne
				writer.newLine();
				
		       }
			// quand tous les users sont passés, on ferme l'écriture
			writer.close();
			
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
		
		return FlowCompleted;
	}
	

	/*
	 * Fonction pour déclencher des modifications sur l'utilisateur
	 */
	@Override
	public void trigger(long t) {
		IUser u;
		for (int i=0; i<users.size(); i++)
		{
			// on récupère un utilisateur
			u=users.get(i);
			// si l'utilisateur n'a pas notifié qu'il a appelé
			// et que le temps d'appel est inférieur ou égal au temps actuel
			if (!u.callOrNot() && u.getCallTime() <= t)
			{
				// on envoie une requête pour aller chercher l'utilisateur
				Elevatorui.createCall(u.getStartLevel(),  u.getDirection(), u);
				u.callOrNot(true);
			}
			
			// si le temps de départ de l'utilisateur n'est pas défini
			// et si il a appelé
			//et si l'état de l'ascenseur permet d'y rentrer
			// et si l'ascenseur est bien à l'étage de l'utilisateur
			else if(u.getStartTime()==-1 && u.callOrNot() 
					/*&& cs.notifyState()==State.Transient /*&&
					Elevatorui.getLevel()==u.getStartLevel()*/)
			{
				// on envoie une requête pour emmener l'utilisateur à l'étage désiré
				Elevatorui.createMove(u.getDestinationLevel(), u);
				// on récupère le moment où l'utilisateur est entré
				u.notifyMove(t);
			}
			
			// si le temps d'arrivée de l'utilisateur n'est pas défini
			// et si il a appelé
			// et que son temps de départ n'est pas nul (qu'il est dans l'ascenseur donc)
			// et si il est à l'étage désiré
			// et si les portes sont ouvertes
			else if(u.getEndTime()==-1 && u.callOrNot() && u.getStartTime()!=1 
					/*&&Elevatorui.getState()== State.Transient
					&& Elevatorui.getLevel() == u.getDestinationLevel()*/ )
			{
				// on indique à quel moment l'utilisateur est arrivé
				u.setEnd(t);
			}
		}
	}

	// permet de lancer la stimulation
	public void start() {
		seq.start();
	}

	// permet de récupérer le nombre de levels
	public int getMaxLevel() {
	return nbLevels;
	}
}
