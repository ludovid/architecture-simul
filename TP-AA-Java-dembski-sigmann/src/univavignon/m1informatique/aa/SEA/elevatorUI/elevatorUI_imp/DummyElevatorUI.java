package univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_imp;

import univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_int.IElevatorUIRequest;
import univavignon.m1informatique.aa.SEA.flow.flow_int.IUser;

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
	 } 

}