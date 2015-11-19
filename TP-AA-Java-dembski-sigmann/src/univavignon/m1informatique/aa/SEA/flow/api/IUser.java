package univavignon.m1informatique.aa.SEA.flow.api;

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
	int getStartLevel();

	/**
	 * 
	 * @return
	 */
	int getDestinationLevel();

	/**
	 * 
	 * @return
	 */
	long getStartTime();

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

}
