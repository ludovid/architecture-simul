package univavignon.m1informatique.aa.SEA.sequencer.api;

public class SimulationTimeConverteur
{
	// Singleton
	private SimulationElevator se;
	private static SimulationTimeConverteur s = null;
	private SimulationTimeConverteur(SimulationElevator se){this.se=se;}
	public static SimulationTimeConverteur create(SimulationElevator se)
	{
		if(s==null)	s = new SimulationTimeConverteur(se);
		return s;
	}
	
	public long simulationTimeToRealTime(long simulationTime)
	{
		if(se.contraction==0)	return simulationTime;
		return (se.contraction>0)?	simulationTime/se.contraction:	simulationTime*(-se.contraction);
	}

	public long realTimeToSimulationTime(long realTime)
	{
		if(se.contraction==0)	return realTime;
		return (se.contraction>0)?	realTime*se.contraction:	realTime/(-se.contraction);
	} 

}
