package univavignon.m1informatique.aa.SEA.controlSystem.controlSystem_imp;

import univavignon.m1informatique.aa.SEA.elevator.elevator_int.ElevatorCommandFactory;
import univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_int.IElevatorUIRequest;

public class ControlSystemExecutor {

	public ControlSystemExecutor() {
		
	}
	/**
	 * 
	 */
	public IElevatorUIRequest IElevatorUIRequest;
	/**
	 * 
	 */
	public ElevatorCommandFactory elevatorCommandFactory;
	/**
	 * 
	 */
	public RequestListFactory requestListFactory;
	/**
	 * Getter of iElevatorUIRequest
	 */
	public IElevatorUIRequest getIElevatorUIRequest() {
	 	 return IElevatorUIRequest; 
	}
	/**
	 * Setter of iElevatorUIRequest
	 */
	public void setIElevatorUIRequest(IElevatorUIRequest IElevatorUIRequest) { 
		 this.IElevatorUIRequest = IElevatorUIRequest; 
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
	/**
	 * Getter of requestListFactory
	 */
	public RequestListFactory getRequestListFactory() {
	 	 return requestListFactory; 
	}
	/**
	 * Setter of requestListFactory
	 */
	public void setRequestListFactory(RequestListFactory requestListFactory) { 
		 this.requestListFactory = requestListFactory; 
	}
	/**
	 * 
	 */
	public void initialize() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void start() { 
		// TODO Auto-generated method
	 } 

}
