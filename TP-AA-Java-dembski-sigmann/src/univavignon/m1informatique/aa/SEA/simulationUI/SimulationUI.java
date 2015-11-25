package univavignon.m1informatique.aa.SEA.simulationUI;

import java.io.File;

import univavignon.m1informatique.aa.SEA.controlSystem.api.ControlSystemFactory;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.ElevatorUIFactory;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;
import univavignon.m1informatique.aa.SEA.flow.api.FlowFactory;
import univavignon.m1informatique.aa.SEA.flow.api.IFlow;
import univavignon.m1informatique.aa.SEA.flow.api.IFlowCommand;
import univavignon.m1informatique.aa.SEA.sequencer.api.SequencerFactory;
import univavignon.m1informatique.aa.SEA.sequencer.impl.DummySequencer;

public class SimulationUI implements IFlowCommand {

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
		//IFlowCommand ifc = flowFactory.buildFlow(new File("flowSetting"));
		//ifc.start();
	 }
	
	public static void main(String[]args) {
		final File flowFile = null; // TODO : Retrieve from arguments.
		final DummySequencer s = SequencerFactory.createSequencer(0,-1);		
		final IElevatorCommand command = null;
		final IControlSystem cs = ControlSystemFactory.createControlSystem(command);
		final IElevatorUI elevatorUI = ElevatorUIFactory.createElevatorUI(cs);
		final IFlow flow = FlowFactory.buildFlow(flowFile, elevatorUI);	
		System.out.println(flow);
		
		/*
		Sequenceur seq = new Sequenceur (0, 0, 0);
		seq.addEvent(callEvent, 1000);
		seq.addEvent(moveEvent, 1000);
		seq.start();
		*/
	}

}
