package fs.study.daoImp;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class NoticeDaoImp 
{
	public void daoAddNotice(Connection conn,String content)throws Exception
	{}
	
	public void daoDeleteNotice(Connection conn,String[] actionId)throws Exception
	{}
	
	public String daoSelectNotice(Connection conn)throws Exception
	{
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		
		String sql = "SELECT * FROM  notice WHERE notice_id >= " +
				"((SELECT MAX(notice_id) FROM notice)-(SELECT MIN(notice_id) FROM notice)) * RAND()" +
				" + (SELECT MIN(notice_id) FROM notice) LIMIT 1"	;
		rs = stat.executeQuery(sql);
		String notice = null;
		if(rs.next())
		{
			notice = rs.getString	("notice_content");
		} 
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
		if(stat != null)
		{
			try
			{
				stat.close();
			}
			catch (SQLException e)
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}
		return notice;
	}
}
