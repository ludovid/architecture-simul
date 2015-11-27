package univavignon.m1informatique.aa.SEA.result.impl;

public class DataConverter
{

	/**
	 * Prend deux tableaux de points dans les temps et retourn la durée entre les deux dans un tableau
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
