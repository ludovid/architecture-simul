package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

public class Timer
{
	SimulationTimeConverteur convertTime;
	SimulationElevator se;
	
	public Timer(SimulationElevator se)
	{
		this.se = se;
		this.convertTime = SimulationTimeConverteur.create(se);
	}
	
	public void Wait(long realTimeMilli)
	{
		long tempsAttente = convertTime.realTimeToSimulationTime(realTimeMilli);
		try{
		    Thread.sleep(tempsAttente);}
		catch(InterruptedException ex){
		    Thread.currentThread().interrupt();}
	}
}
