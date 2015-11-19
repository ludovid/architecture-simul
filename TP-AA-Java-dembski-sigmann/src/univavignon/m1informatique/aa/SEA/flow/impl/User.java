package univavignon.m1informatique.aa.SEA.flow.impl;

import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public class User implements IUser {
	
	private static int cc = 0; //nombre d'user instanciés
	private int id;
	
	private final int start;
	
	private final int destination;

	/** **/
	private final long startTime;

	public User(final int start, final int destination, final long startTime) {
		this.start = start;
		this.startTime = startTime;
		this.destination = destination;
		cc++;
		id=cc;
	}

	@Override
	public void notifyCall(long t) {
		// TODO Auto-generated method stub
		System.out.println("call from user "+id+" "+t);
	}

	@Override
	public void notifyMove(long t) {
		// TODO Auto-generated method stub
		System.out.println("move for user "+id+" "+t);
	}

	@Override
	public int getStartLevel() {
		return start;
	}

	@Override
	public int getDestinationLevel() {
		return destination;
	}

	@Override
	public long getStartTime() {
		return startTime;
	}

}
