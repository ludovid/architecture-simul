package univavignon.m1informatique.aa.SEA.elevatorUI.api;

import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;
import univavignon.m1informatique.aa.SEA.elevatorUI.impl.ElevatorUIFactoryImplementation;


public final class ElevatorUIFactory {

	/**
	 * 
	 * @return
	 */
	public static IElevatorUI createElevatorUI(IControlSystem moveOptimizer){
		return ElevatorUIFactoryImplementation.createElevatorUI(moveOptimizer);
	}
}

