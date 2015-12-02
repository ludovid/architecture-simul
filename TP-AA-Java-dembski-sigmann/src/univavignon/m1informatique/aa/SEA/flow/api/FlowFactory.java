
package univavignon.m1informatique.aa.SEA.flow.api;

import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.flow.impl.Flow;

public class FlowFactory {

	/**
	 * 
	 * @param flowFile 
	 * @return 
	 */
	public static IFlow buildFlow(final String flowFile, IElevatorCommand ie,  long time, long time2) { 
		return new Flow(flowFile, ie, time, time2);
	 } 

}
