package univavignon.m1informatique.aa.SEA.UI_imp;

import univavignon.m1informatique.aa.SEA.flow.flow_int.IFlowCommand;
import univavignon.m1informatique.aa.SEA.flow.flow_int.FlowFactory;
import univavignon.m1informatique.aa.SEA.sequencer.sequencer_imp.DummySequencer;

public class DummyUI implements IFlowCommand {

	/**
	 * 
	 */
	public FlowFactory flowFactory;

	/**
	 * Getter of flowFactory
	 */
	public FlowFactory getFlowFactory() {
	 	 return flowFactory; 
	}

	/**
	 * Setter of flowFactory
	 */
	public void setFlowFactory(FlowFactory flowFactory) { 
		 this.flowFactory = flowFactory; 
	}

	/**
	 * 
	 */
	public void start() { 
		// TODO Auto-generated method
		
	 } 
	
	public static void main(String[]args) {
		
		DummySequencer ds = new DummySequencer(0,0,-1);
		System.out.println(ds);
	}

}
