package univavignon.m1informatique.aa.SEA.sequencer.impl;

import univavignon.m1informatique.aa.SEA.sequencer.api.Event;
import univavignon.m1informatique.aa.SEA.sequencer.api.Sequenceur;

public class DummySequencer { 

	private Sequenceur seq;
	
	public DummySequencer (long long1, long long2, long long3)
	{
		seq = Sequenceur.create(long1,long2,long3);
	}
	
	public void start () 
	{
		seq.start ();
	}
	
	public void addEvent(Event e, long t)
	{
		seq.addEvent(e, t);
	}
	
	
	
}