package univavignon.m1informatique.aa.SEA.sequencer.api;

import java.util.*;

public class ProcessExecutor
{
	private ArrayList<Process> listProcess = new ArrayList<>();
	private long timeMini;
	private Timer timer;
	private boolean isInit;
	private SimulationElevator simuElev;
	
	public ProcessExecutor(long Extention, long Contraction, long Origine)
	{
		timeMini = -1;
		isInit = false;
		simuElev = SimulationElevator.create(Extention, Contraction, Origine);
		timer = new Timer(simuElev);
	}
	
	public void addEvent(Event e, long t)
	{
		if(t < timeMini || timeMini == -1)	timeMini = t;
		listProcess.add(new Process(e, t));
	}
	
	public void initialise()
	{
		isInit=true;
		simuElev.start();
		Process tmp;
		for(int i=0;i<listProcess.size();i++)
		{
			tmp = (Process)listProcess.get(i);
			tmp.active(simuElev.Time());
		}
	}

	public void sequance()
	{ 
		if(isInit=false) initialise();
		Process tmp;
		while(true)
		{
			for(int i=0;i<listProcess.size();i++)
			{
				timer.Wait(timeMini);
				tmp = (Process)listProcess.get(i);
				tmp.active(simuElev.Time());
			}
		}
	} 

}
