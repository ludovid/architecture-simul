package univavignon.m1informatique.aa.SEA.simulationUI;

import java.io.File;

public class FileControleur
{

	/**
	 * 
	 * @param fileName 
	 */
	public static boolean fileExist(String fileName)
	{ 
		File f = new File(fileName); 
		return f.exists();
	}

}
