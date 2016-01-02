package fs.common.util;

import java.util.Calendar;

/**幸运数的计算
 * @author Jason_★  
 */
public class LuckNumber 
{
	/**获得今日幸运数，对应不同的加成可能。LuckNumber = （日数+星期数）取余，换0为10
	 * @return 今日幸运数
	 */
	public static int getLuckNumber()
	{
		int luckNumber=0;								//今日幸运数
		Calendar today = Calendar.getInstance();
		int day =today.get( Calendar.DAY_OF_MONTH);		//日
		int week = today.get(Calendar.DAY_OF_WEEK) - 1; //星期
		 
		luckNumber = ( day + week ) % 10 ;
		if(luckNumber == 0 ) 
		{
			luckNumber = 10;
		} 
		
		return luckNumber;
	}
}
