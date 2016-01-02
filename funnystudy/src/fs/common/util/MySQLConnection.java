package fs.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.util.Calendar;

/**用于和mysql数据库连接
 * @author Jason_★  
 */
public class MySQLConnection 
{
	private static Connection mySQLConnection;
	public static Connection getMySQLConnection()
	{
		Calendar today = Calendar.getInstance();
		int hour =today.get( Calendar.HOUR_OF_DAY);		//日
	     
		if(hour > 8 && hour <23)//早上8点到晚上11点期间可以进行访问
		{
			if(mySQLConnection != null)
			{
				return mySQLConnection;
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/funnystudy","root","123456");
					mySQLConnection = conn;
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				return mySQLConnection;
			}
		}
		return null;
	}
}
