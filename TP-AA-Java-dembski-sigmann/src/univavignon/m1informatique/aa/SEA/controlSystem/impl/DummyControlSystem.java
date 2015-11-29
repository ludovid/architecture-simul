package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.elevator.api.ElevatorCommandFactory;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;

public class DummyControlSystem implements IControlSystem {

	/** **/
	private final IElevatorCommand command;

	/**
	 * 
	 * @param command
	 */
	public DummyControlSystem(final IElevatorCommand command) {
		this.command = command;
	}
	
	/*
	 * (non-Javadoc)
	 * @see univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem#stopRequest(int, univavignon.m1informatique.aa.SEA.commontype.Direction)
	 */
	@Override
	public void stopRequest(int level, Direction direction,
			IElevatorUIRequest uiRequest) {
		// TODO Auto-generated method stub
		
	} 

}
