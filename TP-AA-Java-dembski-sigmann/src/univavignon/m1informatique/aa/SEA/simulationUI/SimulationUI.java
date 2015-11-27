package univavignon.m1informatique.aa.SEA.simulationUI;

import java.io.File;

import univavignon.m1informatique.aa.SEA.elevator.api.ElevatorFactory;
import univavignon.m1informatique.aa.SEA.flow.api.FlowFactory;
import univavignon.m1informatique.aa.SEA.flow.api.IFlowCommand;

public class SimulationUI
{
	
	/**
	 * 	Configure l'ensemble du système et interagie avec l'utilisateur
	 */
	public static void main(String[]args)
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
		ElevatorFactory.buildElevator(new File(fileElevator));
		IFlowCommand flowCommand = FlowFactory.buildFlow(fileFlow, simuContraction, simuOrigine);
		
		// Lancement de la simulation
		boolean b = IHM.displayBooleanInteract("Commancer la simulation ?");
		if(b==true)	flowCommand.start();
		
		System.out.println("Fin du système de simulation d'ascenceur.");
		
	}

}
