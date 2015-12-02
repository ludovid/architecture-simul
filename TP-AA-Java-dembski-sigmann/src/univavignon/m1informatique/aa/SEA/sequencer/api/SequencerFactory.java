package univavignon.m1informatique.aa.SEA.sequencer.api;

import univavignon.m1informatique.aa.SEA.sequencer.impl.DummySequencer;

/**
 * cr�e un s�quenceur
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
	public static DummySequencer createSequencer(final long b, final long c) {
		return new DummySequencer(b, c);
	}

}
