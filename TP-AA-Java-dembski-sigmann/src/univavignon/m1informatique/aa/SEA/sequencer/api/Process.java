package univavignon.m1informatique.aa.SEA.sequencer.api;

/**
 * unit� qui prend un event et qui le traite
 * @author Ludovic
 *
 */
public class Process
{
	private Event event;
	private long timeRepetition, lastTrigger;
	/**
	 * cc the number of Process instantiations
	 */
	static int cc = 0;
	/**
	 * ccc the ID of this Process object
	 */
	int ccc;	
	
	public Process(Event e, long t)
	{
		event = e; 
		timeRepetition = t;
		lastTrigger = 0;
		cc++;
		ccc=cc;
	}
	
	/**
	 * active pendant time ms
	 * @param time
	 */
	public void active(long time)
	{
		System.out.println("Call Active "+ccc+", time : "+time);
		if((time-lastTrigger)>timeRepetition)
		{
			event.trigger(time);
			System.out.println("Event");
			lastTrigger=time;
			return;
		}
	} 
}
