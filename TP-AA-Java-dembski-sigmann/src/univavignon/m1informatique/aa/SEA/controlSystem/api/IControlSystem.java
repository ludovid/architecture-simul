package univavignon.m1informatique.aa.SEA.controlSystem.api;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

/**
 * 
 * @author uapv1102294
 *
 */
public interface IControlSystem {

	/**
	 * 
	 * @param level
	 * @param direction
	 */
	void stopRequest(int level, Direction direction);

}
