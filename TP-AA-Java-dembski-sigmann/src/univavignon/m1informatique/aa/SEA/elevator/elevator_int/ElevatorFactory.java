package univavignon.m1informatique.aa.SEA.elevator.elevator_int;

import java.io.File;

import univavignon.m1informatique.aa.SEA.elevator.elevator_imp.ElevatorShaft;

public class ElevatorFactory {

	/**
	 * 
	 * @param setting 
	 * @return 
	 */
	public static boolean BuildElevator(File setting) {
		ElevatorShaft ES = new ElevatorShaft(2, 5, 3, 10, 1); // mettre les param du fichier pour construire les objets de shaft
		return false;
		
	}

};
