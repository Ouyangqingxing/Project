package fs.study.daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SentenceDaoImp
{
	public String daoSelectSentence(Connection conn)throws Exception
	{
		Statement stat = null;
		ResultSet rs = null;
		stat = conn.createStatement();
		
		String sql = "SELECT * FROM  sentence WHERE sentence_id >= " +
				"((SELECT MAX(sentence_id) FROM sentence)-(SELECT MIN(sentence_id) FROM sentence)) * RAND()" +
				" + (SELECT MIN(sentence_id) FROM sentence) LIMIT 1"	;
		rs = stat.executeQuery(sql);
		String sentence = null;
		if(rs.next())
		{
			sentence = rs.getString	("sentence_content");
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
		return sentence;
	}
}
