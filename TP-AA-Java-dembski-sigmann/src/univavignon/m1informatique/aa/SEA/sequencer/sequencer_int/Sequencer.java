package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

import univavignon.m1informatique.aa.SEA.sequencer.sequencer_imp.DummySequencer;

public class Sequencer {

	/**
	 * 
	 */
	public DummySequencer dummySequencer;
	/**
	 * 
	 */
	public ProcessExecutor processExecutor;

	/**
	 * Getter of dummySequencer
	 */
	public DummySequencer getDummySequencer() {
	 	 return dummySequencer; 
	}

	/**
	 * Setter of dummySequencer
	 */
	public void setDummySequencer(DummySequencer dummySequencer) { 
		 this.dummySequencer = dummySequencer; 
	}

	/**
	 * 
	 */
	public void create() { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 */
	public void addProcess() { 
		// TODO Auto-generated method
	 }

	/**
	 * 
	 */
	public void start() { 
		// TODO Auto-generated method
	 }

	/**
	 * Getter of processExecutor
	 */
	public ProcessExecutor getProcessExecutor() {
	 	 return processExecutor; 
	}

	/**
	 * Setter of processExecutor
	 */
	public void setProcessExecutor(ProcessExecutor processExecutor) { 
		 this.processExecutor = processExecutor; 
	} 

}
