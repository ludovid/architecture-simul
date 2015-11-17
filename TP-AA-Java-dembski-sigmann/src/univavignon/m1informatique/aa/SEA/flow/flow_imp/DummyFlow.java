package univavignon.m1informatique.aa.SEA.flow.flow_imp;

import univavignon.m1informatique.aa.SEA.flow.flow_int.IUser;

public class DummyFlow implements IUser {

	/**
	 * 
	 * @param t 
	 */
	public void notifyCall(long t) { 
		// TODO Auto-generated method
		System.out.println("notify call "+t);
	 }

	/**
	 * 
	 * @param t 
	 */
	public void notifyMove(long t) { 
		// TODO Auto-generated method
		System.out.println("notify move "+t);
	 } 

}
