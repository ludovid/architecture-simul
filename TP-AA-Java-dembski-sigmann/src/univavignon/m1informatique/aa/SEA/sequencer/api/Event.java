package univavignon.m1informatique.aa.SEA.sequencer.api;

/**
 * On fera h�riter tous nos events de cette interface
 * @author Ludovic
 *
 */
public interface Event
{
	/**
	 * le d�clenchement de l'event
	 * @param t
	 */
	public void trigger(long t); 
}
