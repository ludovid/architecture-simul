package univavignon.m1informatique.aa.SEA.flow.api;

import java.io.File;
import java.io.FileNotFoundException;

import univavignon.m1informatique.aa.SEA.sequencer.api.Event;

public interface IFlow extends Event {

	// permet de créer un fichier avec des chiffres randoms
	public void create (String fichier, int nbUsers, int nbLevels, long start, long time);
	// permet de lire un fichier
	public void compute(File file) throws FileNotFoundException;
	// renvoie le nombre maximal de levels
	public int getMaxLevel();
	public void start(); 

}
