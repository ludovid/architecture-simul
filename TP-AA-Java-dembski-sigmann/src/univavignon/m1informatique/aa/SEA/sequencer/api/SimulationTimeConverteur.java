package univavignon.m1informatique.aa.SEA.sequencer.api;

/**
 * Classe gérant le temps de la simulation
 * @author Ludovic
 *
 */
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
		if(se.getContraction()==0)	return simulationTime;
		if (se.getContraction()>0)
		{
			return simulationTime/se.getContraction();
		}
		else
		{
			return simulationTime*(-se.getContraction());
		}
	}

	public long realTimeToSimulationTime(long realTime)
	{
		if(se.getContraction()==0)	return realTime;
		if (se.getContraction()>0)
		{
			return realTime*se.getContraction();
		}
		else
		{
			return realTime/(-se.getContraction());
		}
	} 

}
