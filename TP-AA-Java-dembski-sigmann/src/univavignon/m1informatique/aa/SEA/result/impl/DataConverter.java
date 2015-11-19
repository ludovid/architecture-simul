package univavignon.m1informatique.aa.SEA.result.impl;

public class DataConverter {

	/**
	 * 
	 * @param start 
	 * @param goal 
	 * @return r
	 */
	public static long[] toDuration(long[] start, long[] goal)
	{
		long[] r = new long[start.length];
		for(int i = start.length;i>=0;i--)
			r[i] = goal[i]-start[i];
		return r;
	} 

}
