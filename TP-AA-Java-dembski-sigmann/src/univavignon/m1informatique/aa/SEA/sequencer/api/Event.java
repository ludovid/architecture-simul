package univavignon.m1informatique.aa.SEA.sequencer.api;

/**
 * On fera hériter tous nos events de cette interface
 * @author Ludovic
 *
 */
public interface Event
{
	/**
	 * le déclenchement de l'event
	 * @param t
	 */
	public void trigger(long t); 
}
