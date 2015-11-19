package univavignon.m1informatique.aa.SEA.flow.api;

import java.io.File;

import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;
import univavignon.m1informatique.aa.SEA.flow.impl.DummyFlow;

public class FlowFactory {

	/**
	 * 
	 * @param flowFile 
	 * @return 
	 */
	public static IFlow buildFlow(final File flowFile, final IElevatorUI elevatorUI) { 
		return new DummyFlow(flowFile, elevatorUI);
	 } 

}
