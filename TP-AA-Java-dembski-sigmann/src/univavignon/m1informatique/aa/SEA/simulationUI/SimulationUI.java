package univavignon.m1informatique.aa.SEA.simulationUI;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;

import univavignon.m1informatique.aa.SEA.elevator.api.ElevatorFactory;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.flow.api.FlowFactory;
import univavignon.m1informatique.aa.SEA.flow.api.IFlow;

public class SimulationUI
{
	
	/**
	 * 	Configure l'ensemble du système et interagie avec l'utilisateur
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[]args) throws ParserConfigurationException
	{		
		// Récupération des informations pour la créaton de la simulation
		System.out.println("Bienvenue au système de simulation d'ascenceur.\n");
		//Pour Elevator et flow
		String fileElevator = IHM.displayFileRequestInteract("Entrer le nom du fichier de configuration de l'elevator.");
		String fileFlow = IHM.displayFileRequestInteract("Entrer le nom du fichier de configuration du flow d'utilisateurs.");
		//Pour Simulator
		long simuContraction = IHM.displayNumberInteract("Choisir contraction/extention:\nNombre positif pour une extention, négatif pour une contraction");
		long simuOrigine = IHM.displaySelectTimeInteract("Entrer l'origine de la simulation: ");
		
		// Création des composants de la simulation
		IElevatorCommand tmpUI = ElevatorFactory.buildElevator(new File(fileElevator));
		IFlow flowCommand = FlowFactory.buildFlow(fileFlow, tmpUI, simuContraction, simuOrigine);
		
		// Lancement de la simulation
		boolean b = IHM.displayBooleanInteract("Commancer la simulation ?");
		if(b==true)	flowCommand.start();
		
		System.out.println("Fin du système de simulation d'ascenceur.");
		
	}

}
