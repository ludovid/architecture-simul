package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.impl.ElevatorUI;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;

public class ElevatorUIFactoryImplementation {
	
static ElevatorUI eUI = null;
	
	public static IElevatorUI createElevatorUI(final IControlSystem cs){
		if(eUI == null)
			eUI = new ElevatorUI(cs); 
		return eUI;
		
		
	}

}
