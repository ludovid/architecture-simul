package univavignon.m1informatique.aa.SEA.elevatorUI.impl;

import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public class DummyElevatorUI implements IElevatorUIRequest {

	/**
	 * 
	 */
	public IUser iUser;

	/**
	 * Getter of iUser
	 */
	public IUser getIUser() {
	 	 return iUser; 
	}

	/**
	 * Setter of iUser
	 */
	public void setIUser(IUser iUser) { 
		 this.iUser = iUser; 
	}

	/**
	 * 
	 * @param t 
	 */
	public void notify(long t) { 
		// TODO Auto-generated method
		System.out.println("notify dummy_elevator_ui from iuser "+iUser+" "+t);
	 } 

}
