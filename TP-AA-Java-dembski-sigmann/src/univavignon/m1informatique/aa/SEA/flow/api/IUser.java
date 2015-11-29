package univavignon.m1informatique.aa.SEA.flow.api;

import univavignon.m1informatique.aa.SEA.commontype.Direction;

/**
 * 
 * @author uapv1102294
 *
 */
public interface IUser {

	/**
	 * 
	 * @return
	 */
	

	/**
	 * 
	 * @return
	 */
	

	/**
	 * 
	 * @return
	 */
	long getStartTime();

	
	public Direction getDirection();
	
	/**
	 * 
	 * @param t 
	 */
	public void notifyCall(long t);

	/**
	 * 
	 * @param t 
	 */
	public void notifyMove(long t);

	public long getCallTime();
	public boolean callOrNot();
	public void callOrNot(boolean ICall);
	public long getEndTime();
	public int getStartLevel();
	public int getDestinationLevel();
	public void setEnd(long end);
	public int getID();
}
