package univavignon.m1informatique.aa.SEA.elevator.api;

import java.io.File;

public interface ElevatorFactory {

	/**
	 * 
	 * @param setting 
	 * @return 
	 */
	public boolean BuildElevator(File setting); 

}
