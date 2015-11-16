package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

public class ProcessFactory {

	/**
	 * 
	 */
	public static long t;

	/**
	 * Getter of t
	 */
	public long getT() {
	 	 return t; 
	}

	/**
	 * 
	 * @param process 
	 */
	public static void createProcess(Process process) { 
		// TODO Auto-generated method
		process.setPeriod(t);
		
	 }

	/**
	 * 
	 */
	public static void addProcessToPE() { 
		// TODO Auto-generated method
		Process p = new Process();
		createProcess(p);
	 }
}
