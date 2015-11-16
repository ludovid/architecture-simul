package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

import univavignon.m1informatique.aa.SEA.sequencer.sequencer_imp.DummySequencer;

public class Sequenceur
{
	public DummySequencer dummySequencer;
	
	//Singleton
	private static Sequenceur s = null;
	private Sequenceur(long Extention, long Contraction, long Origine){pe = new ProcessExecutor(Extention, Contraction, Origine);}
	//ProcessExecutor
	private ProcessExecutor pe = null;

	public static Sequenceur create(long Extention, long Contraction, long Origine)
	{
		if(s == null)s = new Sequenceur(Extention, Contraction, Origine);
		return s;
	}
	
	public static Sequenceur create()	//On donne la possibilité de ne pas modifier le r�f�rentiel de temps.
	{
		if(s == null)	s = new Sequenceur(0, 0, 0);
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

}
