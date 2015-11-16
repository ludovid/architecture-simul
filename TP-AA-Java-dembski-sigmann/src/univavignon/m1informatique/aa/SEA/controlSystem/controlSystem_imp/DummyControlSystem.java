package univavignon.m1informatique.aa.SEA.controlSystem.controlSystem_imp;

import univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_int.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.elevator.elevator_int.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.elevator.elevator_int.ElevatorCommandFactory;

public class DummyControlSystem {

	/**
	 * 
	 */
	public IElevatorUIRequest iElevatorUIRequest;
	/**
	 * 
	 */
	public IElevatorCommand iElevatorCommand;
	/**
	 * 
	 */
	public ElevatorCommandFactory elevatorCommandFactory;
	/**
	 * Getter of iElevatorUIRequest
	 */
	public IElevatorUIRequest getIElevatorUIRequest() {
	 	 return iElevatorUIRequest; 
	}
	/**
	 * Setter of iElevatorUIRequest
	 */
	public void setIElevatorUIRequest(IElevatorUIRequest iElevatorUIRequest) { 
		 this.iElevatorUIRequest = iElevatorUIRequest; 
	}
	/**
	 * Getter of iElevatorCommand
	 */
	public IElevatorCommand getIElevatorCommand() {
	 	 return iElevatorCommand; 
	}
	/**
	 * Setter of iElevatorCommand
	 */
	public void setIElevatorCommand(IElevatorCommand iElevatorCommand) { 
		 this.iElevatorCommand = iElevatorCommand; 
	}
	/**
	 * Getter of elevatorCommandFactory
	 */
	public ElevatorCommandFactory getElevatorCommandFactory() {
	 	 return elevatorCommandFactory; 
	}
	/**
	 * Setter of elevatorCommandFactory
	 */
	public void setElevatorCommandFactory(ElevatorCommandFactory elevatorCommandFactory) { 
		 this.elevatorCommandFactory = elevatorCommandFactory; 
	} 

}
