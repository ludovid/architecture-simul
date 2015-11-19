package univavignon.m1informatique.aa.SEA.flow.api;

import java.io.File;

import univavignon.m1informatique.aa.SEA.sequencer.api.Event;

public interface IFlow extends Event {

	/**
	 * 
	 * @param file 
	 */
	public void compute(File file);

	/**
	 * 
	 * @return 
	 */
	public int getMaxLevel(); 

}
