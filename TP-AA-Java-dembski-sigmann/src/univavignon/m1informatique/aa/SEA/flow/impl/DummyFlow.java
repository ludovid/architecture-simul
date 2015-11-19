package univavignon.m1informatique.aa.SEA.flow.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUI;
import univavignon.m1informatique.aa.SEA.flow.api.IFlow;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

/**
 * Approved by teacher
 * @author uapv1102294
 *
 */
public class DummyFlow implements IFlow {

	/** **/
	private ArrayList<IUser> users = new ArrayList<> ();

	/** **/
	private final IElevatorUI ui;

	/** **/
	private final Random generator;

	/**
	 * 
	 * @param ui
	 */
	public DummyFlow(final File flowFile, final IElevatorUI ui) {
		this.ui = ui;
		this.users = new ArrayList<IUser>();
		this.generator = new Random();
	}

	/*
	 * (non-Javadoc)
	 * @see univavignon.m1informatique.aa.SEA.flow.api.IFlow#compute(java.io.File)
	 */
	@Override
	public void compute(File file) {
		// OWO SHIT
	}

	/*
	 * (non-Javadoc)
	 * @see univavignon.m1informatique.aa.SEA.flow.api.IFlow#getMaxLevel()
	 */
	@Override
	public int getMaxLevel() {
		return 7;
	}

	/*
	 * (non-Javadoc)
	 * @see univavignon.m1informatique.aa.SEA.sequencer.api.Event#trigger(long)
	 */
	@Override
	public void trigger(long t) {
		// Add random request.
		final int start = generator.nextInt(getMaxLevel());
		int destination;
		while ((destination = generator.nextInt(getMaxLevel())) == start) {};
		users.add(new User(start, destination, System.currentTimeMillis() + 1000));
		// Check current users.
		for (final IUser user : users) {
			if (user.getStartTime() >= t) {
				final Direction direction = null;
				ui.stopRequest(user.getStartLevel(), direction);
			}
		}
	}

}
