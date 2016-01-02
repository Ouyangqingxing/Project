package fs.common.util;

import java.util.Random;

/**一些算法中的数学计算
 * @author Jason_★  
 */
public class MathMethod 
{
	/**计算升级所需经验
	 * @param i 当前等级
	 * @return 所需经验
	 */
	public static int getNeedExp(int i) 
	{
		//所需经验实例 1级 2级 3级。。升级所需经验分别是  100 200 300 500 800 1300 2100 3400 5500 8900    
		if (i == 1 || i == 2)
		{
			return i*100;
		}
		else
		{
			return getNeedExp(i - 1) + getNeedExp(i - 2);
		}
	}
	
	/**获得随机3个数，3个数之和等于参数
	 * @param totle 3个数之和
	 * @return 这3个数
	 */
	public static int[] getRandomThreeNumber(int totle)
	{
		Random r1 = new Random();
		int[] arr = new int[3];
		
		arr[0] = r1.nextInt(totle+1)  ; 
			
		if(arr[0]==(totle))
		{
			arr[1]=0;
			arr[2]=0;
		}
		else
		{
			arr[1]=r1.nextInt(totle+1-arr[0]) ;
			arr[2]=totle-arr[0]-arr[1];
		} 
		
		return arr;
	}
	
}
