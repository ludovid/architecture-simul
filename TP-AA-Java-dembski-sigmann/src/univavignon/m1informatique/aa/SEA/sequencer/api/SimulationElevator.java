package univavignon.m1informatique.aa.SEA.sequencer.api;

public class SimulationElevator
{
	// Singleton
	private long origine, contraction, timeOrigine;
	private SimulationTimeConverteur convertTime;
	private static SimulationElevator s = null;
	
	public long getContraction() {
		return contraction;
	}

	public void setContraction(long contraction) {
		this.contraction = contraction;
	}

	public SimulationElevator(long contraction, long origine)
	{
		this.origine = (origine==-1)?	System.currentTimeMillis():	origine;
		this.setContraction(contraction);
		this.timeOrigine = -1;
		this.convertTime = SimulationTimeConverteur.create(this);
	}
	
	public static SimulationElevator create()
	{
		if(s==null)	s = new SimulationElevator( 0, -1);
		return s;
	}
	public static SimulationElevator create(long contraction, long origine)
	{
		if(s==null)	s = new SimulationElevator(contraction, origine);
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
