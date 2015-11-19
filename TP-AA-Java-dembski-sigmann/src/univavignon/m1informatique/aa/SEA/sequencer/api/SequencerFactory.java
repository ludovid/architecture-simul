package univavignon.m1informatique.aa.SEA.sequencer.api;

import univavignon.m1informatique.aa.SEA.sequencer.impl.DummySequencer;

/**
 * 
 * @author uapv1102294
 *
 */
public final class SequencerFactory {

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static DummySequencer createSequencer(final long a, final long b, final long c) {
		return new DummySequencer(a, b, c);
	}

}
