package univavignon.m1informatique.aa.SEA.flow.api;

import univavignon.m1informatique.aa.SEA.flow.impl.Flow;

public class FlowFactory {

	/**
	 * 
	 * @param flowFile 
	 * @return 
	 */
	public static IFlow buildFlow(final String flowFile, long time, long time2) { 
		return new Flow(flowFile, time, time2);
	 } 

}
