package univavignon.m1informatique.aa.SEA.result.api;

import univavignon.m1informatique.aa.SEA.result.impl.ResultManager;

public class result_int
{

		/**
		 * 
		 * @param fileReadResult Nom du fichier de résultat pour enssuite lancer les calcules
		 */
		public static void calculer(String fileReadResult)
		{
			ResultManager.executResult(fileReadResult);
		}
}
