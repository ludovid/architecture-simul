package univavignon.m1informatique.aa.SEA.result.impl;

public class SimulationData
{
	public long callStart[];
	public long callGoal[];
	public long travelStart[];
	public long travelGoal[];

	public SimulationData(long[] cs, long[] cg, long[] ts, long[] tg)
	{
		callStart = cs;
		callGoal = cg;
		travelStart = ts;
		travelGoal = tg;
	}
}
