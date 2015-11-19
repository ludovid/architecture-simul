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
		long distortion = (se.expention-se.contraction);
		if(distortion==0)	return simulationTime;
		return (distortion>0)?	simulationTime/distortion:	simulationTime*(-distortion);
	}

	public long realTimeToSimulationTime(long realTime)
	{
		long distortion = (se.expention-se.contraction);
		if(distortion==0)	return realTime;
		return (distortion>0)?	realTime*distortion:	realTime/(-distortion);
	} 

}
