package univavignon.m1informatique.aa.SEA.result.impl;

public class MathOperation
{ 
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static float standardDeviation(long[] data)
	{
		float res=0, moy = 0;
        for(int i = 0;i<data.length;i++)
            res+=data[i]*data[i];
        for(int i = 0;i<data.length;i++)
            moy+=data[i];
        moy=moy/data.length;
        res-=(moy*moy);
		return (float)Math.sqrt(res);
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static float avarage(long[] data)
	{
		float res=0;
        for(int i = 0;i<data.length;i++)
            res+=data[i];
        return res/data.length;
	}
}
