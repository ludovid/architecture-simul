package univavignon.m1informatique.aa.SEA.simulationUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IHM
{
	/**
	 * 
	 * @param outString Message qui sera affiché
	 * @param retour Retourn un fichier valide
	 */
	public static String displayFileRequestInteract(String outString)
	{
		try (Scanner sc = new Scanner(System.in)) {
			String r;
			boolean b;
			do{
				System.out.println(outString);
				r = sc.nextLine();
				b = FileControleur.fileExist(r);
				if(b==false)	System.out.println("Fichier inexistant.");
			}while(b==false);
			return r;
		}
	}
	
	/**
	 * 
	 * @param outString Message à afficher avant demande
	 * @param retour Retourn la réponse de l'utilisateur
	 */
	public static boolean displayBooleanInteract(String outString)
	{
		try(Scanner sc = new Scanner(System.in)) {
			String r;
			do{
				System.out.println(outString+"\ny: accepter | n: refuser");
				r = sc.nextLine();
				if(!(r.equals("y")||r.equals("n")))	System.out.println("Réponse incorrecte.");
			}while(!(r.equals("y")||r.equals("n")));
			return r.equals("y");
		}
	}
	
	/**
	 * 
	 * @param outString Message à afficher avant demande
	 * @return long corespondant au texte saisie
	 */
	public static long displayNumberInteract(String outString)
	{
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(outString);
			return Long.parseLong(sc.nextLine());
		}
	}
	
	/**
	 * 
	 * @param outString Message à afficher avant demande
	 * @param min Valeur minimum possible
	 * @param max Valeur maximum possible
	 * @return long compris entre min et max
	 */
	public static long displaySecurNumberInteract(String outString, long min, long max)
	{
		long r;
		try (Scanner sc = new Scanner(System.in)) {
			do{
				System.out.println(outString);
				System.out.println("Minimum: "+Long.toString(min)+", Maximum: "+Long.toString(max));
				r = Long.parseLong(sc.nextLine());
			}while(r<min||r>max);
			return r;
		}
	}
	
	/**
	 * 
	 * @param outString Message à afficher avant séléction
	 * @return 
	 */
	public static long displaySelectTimeInteract(String outString)
	{
		String annee, mois, jour, heure, minute, seconde;
		System.out.println(outString);
		
		// Si veut entrer sa propre heure pour la simulation
		if(!displayBooleanInteract("Voulez-vous utiliser l'heure courente pour la simulation?"))
		{
			annee = Long.toString(displaySecurNumberInteract("Entrez l'année de départ.", 1970, 9999));
			mois = Long.toString(displaySecurNumberInteract("Entrez le mois de départ.", 1, 12));
			jour = Long.toString(displaySecurNumberInteract("Entrez le jour de départ.", 1, 31));
			heure = Long.toString(displaySecurNumberInteract("Entrez l'heure de départ.", 0, 23));
			minute = Long.toString(displaySecurNumberInteract("Entrez la minute de départ.", 0, 59));
			seconde = Long.toString(displaySecurNumberInteract("Entrez la seconde de départ.", 0, 59));
			
			// Convertie le texte en milliseconde
			long tmp=0;
			try{
				SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
				Date d = f.parse(jour+"-"+mois+"-"+annee+"-"+heure+"-"+minute+"-"+seconde);
				tmp = d.getTime();
			}catch (java.text.ParseException e){e.printStackTrace();}
			return tmp;
		}
		//Sinon tilise l'heure courante de simulation
		return System.currentTimeMillis();
	}
}
