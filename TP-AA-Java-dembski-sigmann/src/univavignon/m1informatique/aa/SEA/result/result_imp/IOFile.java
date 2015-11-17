package univavignon.m1informatique.aa.SEA.result.result_imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class IOFile
{

	// Type des données récupéré: lvlDepart | lvlArrivé | tCall | tArriveElevator | DépartElev | ArrivéeEtage
	/**
	 * 
	 * @return 
	 */
	public static SimulationData read(String file)
	{
		// Arrayliste stockera les différentes données
		int nbData = 6;
		ArrayList data[];
		data = new ArrayList[nbData];
		for(int i=0;i<nbData;i++)	data[i] = new ArrayList();
		
		// Récupération des données dans le fichier texte
		try{
			Scanner scanner = new Scanner(new FileInputStream(file), "UTF-8");
			for(int i=0;scanner.hasNextLong();i++)
				data[i%nbData].add(scanner.nextLong());
		}catch (IOException ioe) { System.out.println("Erreur --" + ioe.toString());}
		
		// Convertion de l'ArrayList en structur de retour
		return new SimulationData(toLongTab(data[2]), toLongTab(data[3]), toLongTab(data[3]), toLongTab(data[4]));
	}

	/**
	 * 
	 * @param data 
	 */
	public static void write(String data)
	{
		//Récupération de la date pour le nom de fichier
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy_HH-mm" );
		String fileName = new String ("result_"+formatter.format(new Date())+".txt"); 
		
		try{
			FileWriter fw = new FileWriter (new File (fileName));
		    fw.write(data); 
		    fw.close();
		}catch (IOException exception){System.out.println ("Erreur lors de l'ecriture: " + exception.getMessage());}
	} 
	
	private static long[] toLongTab(ArrayList l)
	{
		int s = l.size();
		long[] t = new long[s];
		for(int i=0;i<s;i++)	t[i]=(long)l.get(i);
		return t;
	}

}
