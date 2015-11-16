package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

public class Process
{
	private Event event;
	private long timeRepetition, lastTrigger;
	private boolean firstUse;
	static int cc = 0;
	int ccc;
	
	public Process(Event e, long t)
	{
		event = e; 
		timeRepetition = t;
		lastTrigger = 0;
		firstUse = true;
		cc++;
		ccc=cc;
	}
	
	public void active(long time)
	{
		System.out.println("Call Active "+ccc+", time : "+time);
		if((time-lastTrigger)>timeRepetition)
		{
			event.trigger();
			System.out.println("Event");
			lastTrigger=time;
			return;
		}
	} 
}
