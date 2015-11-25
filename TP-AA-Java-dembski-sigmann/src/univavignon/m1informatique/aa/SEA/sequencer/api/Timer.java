package univavignon.m1informatique.aa.SEA.sequencer.api;

import java.util.Date;

public class Timer
{
	SimulationTimeConverteur convertTime;
	SimulationElevator se;
	
	public Timer(SimulationElevator se)
	{
		this.se = se;
		this.convertTime = SimulationTimeConverteur.create(se);
	}
	
	public void Wait (long t) 
	{
		long start = new Date().getTime();
		while(new Date().getTime() - start < t){}
	}
	
}
