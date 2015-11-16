package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

public class Process {

	/**
	 * 
	 */
	private long period;
	/**
	 * 
	 */
	private IEvent iEvent;

	/**
	 * Getter of period
	 */
	public long getPeriod() {
	 	 return period; 
	}

	/**
	 * Setter of period
	 */
	public void setPeriod(long period) { 
		 this.period = period; 
	}

	/**
	 * 
	 * @param t 
	 */
	public void active(long t) { 
		// TODO Auto-generated method
		java.util.Timer timer = new java.util.Timer();
		timer.schedule(new java.util.TimerTask() {
		    @Override
		    public void run() {
		       iEvent.trigger();
		    }
		}, t);
	 }

	/**
	 * Getter of iEvent
	 */
	public IEvent getIEvent() {
	 	 return iEvent; 
	}

	/**
	 * Setter of iEvent
	 */
	public void setIEvent(IEvent iEvent) { 
		 this.iEvent = iEvent; 
	}

}
