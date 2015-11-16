package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

import java.util.List;

public class ProcessExecutor {

	/**
	 * 
	 */
	private static List<Process> processes;
	public static long t;

	/**
	 * Getter of processes
	 */
	public List<Process> getProcesses() {
	 	 return processes; 
	}

	/**
	 * 
	 */
	public void initialize() { 
		// TODO Auto-generated method
		processes = new java.util.ArrayList<Process> ();
	 }

	/**
	 * 
	 */
	public void sequence() { 
		// TODO Auto-generated method
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(true) {
					for (Process p : processes) {
						p.active(t);
						new Thread().sleep(t);
					}
				}
			}
		};
		r.run();
	 }

	/**
	 * 
	 * @param process 
	 */
	public static void addProcessToList(Process process) { 
		// TODO Auto-generated method
		processes.add(process);
	 }

	/**
	 * Getter of t
	 */
	public long getT() {
	 	 return t; 
	}

}
