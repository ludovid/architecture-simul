package univavignon.m1informatique.aa.SEA.elevatorUI.api;

import univavignon.m1informatique.aa.SEA.elevatorUI.impl.DummyElevatorUI;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;
import univavignon.m1informatique.aa.SEA.commontype.Direction;

public class ElevatorUIRequestFactory {

	/**
	 * 
	 */
	public DummyElevatorUI dummyElevatorUI;

	/**
	 * Getter of dummyElevatorUI
	 */
	public DummyElevatorUI getDummyElevatorUI() {
	 	 return dummyElevatorUI; 
	}

	/**
	 * Setter of dummyElevatorUI
	 */
	public void setDummyElevatorUI(DummyElevatorUI dummyElevatorUI) { 
		 this.dummyElevatorUI = dummyElevatorUI; 
	}
	/**
	 * 
	 * @param level 
	 * @param direction 
	 * @param user 
	 */
	public static void createCall(int level, Direction direction, IUser user) { 
		// TODO Auto-generated method
		/**
		 * user.notifyCall(t);
		 */
	 }

	/**
	 * 
	 * @param level 
	 * @param user 
	 */
	public static void createMove(int level, IUser user) { 
		// TODO Auto-generated method
	 } 

}
