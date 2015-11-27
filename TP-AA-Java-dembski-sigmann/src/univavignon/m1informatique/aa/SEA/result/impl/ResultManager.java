package univavignon.m1informatique.aa.SEA.result.impl;

public class ResultManager
{
	/**
	 * Permet de calculer les donn�es de la simulation
	 * @param file Fichier texte dans lequel lire les donn�es utiles
	 */
	public static void executResult(String file)
	{
		// R�cup�ration des donn�e contenu dans le fichier
		SimulationData sd = IOFile.read(file);
		
		// Calcule de donn�es
		long[] dCall = DataConverter.toDuration(sd.callStart, sd.callGoal);
		float moyenneCall = MathOperation.avarage(dCall);
		float ecartCall = MathOperation.standardDeviation(dCall);
		
		long[] dTravel= DataConverter.toDuration(sd.travelStart, sd.travelGoal);
		float moyenneTravel = MathOperation.avarage(dTravel);
		float ecartTravel = MathOperation.standardDeviation(dTravel);
		
		long[] dGlobalUserTravel = DataConverter.toDuration(sd.callStart, sd.travelGoal);
		float moyenneGlobalUserTravel = MathOperation.avarage(dGlobalUserTravel);
		float ecartGlobalUserTravel = MathOperation.standardDeviation(dGlobalUserTravel);
		
		// Ecriture des donn�es calcul�
		String toWrite="Temps moyen d'arriver de l'ascenseur apr�s appel: "+Float.toString(moyenneCall);
		toWrite+="Ecart type du temps d'arriver de l'ascenseur apr�s appel: "+Float.toString(ecartCall);
		toWrite+="Temps moyendu trajet de l'ascenseur: "+Float.toString(moyenneTravel);
		toWrite+="Ecart type du tempe de trajet de l'ascenseur: "+Float.toString(ecartTravel);
		toWrite+="Temps moyendu trajet total de l'utilisateur (en milliseconde) : "+Float.toString(moyenneGlobalUserTravel);
		toWrite+="Ecart type du tempe de trajet total de l'utilisateur: "+Float.toString(ecartGlobalUserTravel);
		IOFile.write(toWrite);
	}
}
