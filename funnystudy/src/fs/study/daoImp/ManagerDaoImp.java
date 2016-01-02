package fs.study.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImp 
{
	public boolean daoCheckPassword(Connection conn, String name,
			String password)
	{  
		String sql = "select manager_name,manager_password from manager where manager_name=? and manager_password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try 
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next())//如果有结果返回true
			{
				return true;
			} 
		}
		catch (SQLException e) 
		{
			System.out.println("发生数据库异常啦！");
			e.printStackTrace();
		} 
		finally 
		{
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			
			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
		}
		return false;//默认错误
	}
}
