package univavignon.m1informatique.aa.SEA.sequencer.sequencer_int;

public class SimulationElevator
{
	// Singleton
	public long origine, expention, contraction, timeOrigine;
	private SimulationTimeConverteur convertTime;
	private static SimulationElevator s = null;
	
	private SimulationElevator(long expention, long contraction, long origine)
	{
		this.origine = (origine==-1)?	System.currentTimeMillis():	origine;
		this.expention = expention;
		this.contraction = contraction;
		this.timeOrigine = -1;
		this.convertTime = SimulationTimeConverteur.create(this);
	}
	
	public static SimulationElevator create()
	{
		if(s==null)	s = new SimulationElevator(0, 0, -1);
		return s;
	}
	public static SimulationElevator create(long expention, long contraction, long origine)
	{
		if(s==null)	s = new SimulationElevator(expention, contraction, origine);
		return s;
	}
	
	public void start()	//Doit normalement se faire dans ProcessExecutor.initialise()
	{
		if(timeOrigine!=-1)	return;
		this.timeOrigine = System.currentTimeMillis();
	}
	
	public long Time()	//Retourn le temps courant de la simuation: O + (t-t0) * Ex
	{
		return origine+convertTime.simulationTimeToRealTime(System.currentTimeMillis()-timeOrigine);
	}

	/*		O: temps d'origne de la simulation
	 * 		t: temps courant
	 *		t0:temps d'origine r�el
	 */
}
