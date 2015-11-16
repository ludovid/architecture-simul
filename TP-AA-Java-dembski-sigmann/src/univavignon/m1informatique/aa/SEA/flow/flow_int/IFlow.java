package univavignon.m1informatique.aa.SEA.flow.flow_int;

import java.io.File;

public interface IFlow {

	/**
	 * 
	 * @param file 
	 */
	public void setting(File file);

	/**
	 * 
	 */
	public void start();

	/**
	 * 
	 * @param file 
	 */
	public void compute(File file);

	/**
	 * 
	 * @return 
	 */
	public IUser addUser();

	/**
	 * 
	 * @return 
	 */
	public int getMaxLevel(); 

}
