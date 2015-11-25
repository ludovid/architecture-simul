package univavignon.m1informatique.aa.SEA.elevator.api;
import java.io.File;

import univavignon.m1informatique.aa.SEA.elevator.impl.ElevatorShaft;

public class ElevatorCommandFactory {

	/**
	 * 
	 * @return 
	 */
	public static IElevatorCommand getElevatorCommand(File setting) { 
	
		// mettre les param du fichier pour construire les objets de shaft
		ElevatorShaft ES = new ElevatorShaft(2, 5, 3, 10, 1); 
		
		
		return null;
	 } 

}
