package univavignon.m1informatique.aa.SEA.sequencer.api;

public class Sequenceur
{
	//Singleton
	private static Sequenceur s = null;
	public Sequenceur(long Contraction, long Origine){pe = new ProcessExecutor(Contraction, Origine);}
	//ProcessExecutor
	private ProcessExecutor pe = null;

	public static Sequenceur create(long Contraction, long Origine)
	{
		if(s == null)s = new Sequenceur(Contraction, Origine);
		return s;
	}
	
	public static Sequenceur create()	//On donne la possibilité de ne pas modifier le r�f�rentiel de temps.
	{
		if(s == null)	s = new Sequenceur(0, 0);
		return s;
	}
	
	public void addEvent(Event e, long t)
	{
		pe.addEvent(e, t);
	}

	public void start()
	{
		pe.initialise();
		pe.sequance();
	} 
	
	/**
	 * Getter of processExecutor
	 */
	public ProcessExecutor getProcessExecutor() {
	 	 return pe; 
	}

	/**
	 * Setter of processExecutor
	 */
	public void setProcessExecutor(ProcessExecutor pe) { 
		 this.pe = pe; 
	}
	

}
