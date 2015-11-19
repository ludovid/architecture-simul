package univavignon.m1informatique.aa.SEA.elevator.api;

import univavignon.m1informatique.aa.SEA.commontype.State;

public interface IElevatorNotifier {

	/**
	 * 
	 * @param level 
	 */
	 void notifyLevel(int level);

	/**
	 * 
	 * @param state 
	 */
	void notifyState(State state);

}
