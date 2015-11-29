package univavignon.m1informatique.aa.SEA.flow.api;

import java.io.File;
import java.io.FileNotFoundException;

import univavignon.m1informatique.aa.SEA.sequencer.api.Event;

public interface IFlow extends Event {

	/**
	 * 
	 * @param file 
	 * @throws FileNotFoundException 
	 */
	public void compute(File file) throws FileNotFoundException;

	/**
	 * 
	 * @return 
	 */
	public int getMaxLevel(); 

}
