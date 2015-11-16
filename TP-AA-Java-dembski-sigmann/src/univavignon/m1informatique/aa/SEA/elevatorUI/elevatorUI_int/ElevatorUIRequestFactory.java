package univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_int;

import univavignon.m1informatique.aa.SEA.elevatorUI.elevatorUI_imp.DummyElevatorUI;
import univavignon.m1informatique.aa.SEA.flow.flow_int.IUser;
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
