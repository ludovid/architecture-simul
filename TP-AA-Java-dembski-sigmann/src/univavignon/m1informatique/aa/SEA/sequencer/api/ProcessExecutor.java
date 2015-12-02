package univavignon.m1informatique.aa.SEA.sequencer.api;

import java.util.*;

/**
 * ProcessExecutor contiendra tous les process 
 * @author Ludovic
 *
 */
public class ProcessExecutor
{
	private ArrayList<Process> listProcess = new ArrayList<>();
	private long timeMini;
	
	public long getTimeMini() {
		return timeMini;
	}

	public void setTimeMini(long timeMini) {
		this.timeMini = timeMini;
	}

	private Timer timer;
	private boolean isInit;
	private SimulationElevator simuElev;
	
	public ProcessExecutor(long Contraction, long Origine)
	{
		timeMini = -1;
		setInit(false);
		simuElev = SimulationElevator.create(Contraction, Origine);
		timer = new Timer(simuElev);
	}
	
	public void addEvent(Event e, long t)
	{
		if(t < timeMini || timeMini == -1)	timeMini = t;
		listProcess.add(new Process(e, t));
	}
	
	public void initialise()
	{
		setInit(true);
		simuElev.start();
		Process tmp;
		for(int i=0;i<listProcess.size();i++)
		{
			tmp = listProcess.get(i);
			tmp.active(simuElev.Time());
		}
	}

	public void sequence()
	{ 
		if(setInit(false)) initialise();
		Process tmp;
		while(true)
		{
			for(int i=0;i<listProcess.size();i++)
			{
				tmp = listProcess.get(i);
				timer.Wait(timeMini);
				tmp.active(simuElev.Time());
			}
		}
	}

	public boolean isInit() {
		return isInit;
	}

	public boolean setInit(boolean isInit) {
		this.isInit = isInit;
		return isInit;
	} 

}
