package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;

public class ElevatorUIFactoryImplementation {
	
static ElevatorUI eUI = null;
	
	// constructeur d'un ElevatorUI 
	public static IElevatorUI createElevatorUI(final IControlSystem cs){
		if(eUI == null)
			eUI = new ElevatorUI(cs); 
		return eUI;
		
		
	}

}
