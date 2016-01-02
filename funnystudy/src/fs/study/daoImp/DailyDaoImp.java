package fs.study.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.Date; 
 
import fs.study.dao.DailyDao;
import fs.study.model.Daily;

public class DailyDaoImp implements DailyDao
{
	public void daoAddDaily(Connection conn)throws SQLException 
	{
		PreparedStatement ps = null;
		
		String sql = "insert daily(daily_date,daily_power,daily_camp1,daily_camp2,daily_camp3)" +
				" values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		String today = dateString.substring(0, 10);
		ps.setString(1, today);
		 
		ps.setInt(2, 0); 
		ps.setInt(3, 0); 
		ps.setInt(4, 0); 
		ps.setInt(5, 0); 
	   
		ps.executeUpdate();
	
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
	
	
	@Override
	public void daoUpdatePower(Connection conn) throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "update daily set daily_power = daily_power + 1 where daily_date=?";
		ps = conn.prepareStatement(sql);
		
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = df.format(date);
//		String today = dateString.substring(0, 10);
//		
//		ps.setString(1, today); 
		ps.setString(1, "123");
		
		ps.executeUpdate();

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

	
	@Override
	public Daily daoSelectDailyById(Connection conn, int id)
			throws SQLException 
	{ 
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select daily_date,daily_power,daily_camp1,daily_camp2,daily_camp3 " +
					" from daily where daily_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			 
			Daily daily = new Daily();
			
			daily.setId		(id);
			daily.setDate		(rs.getString	("daily_date"));
			daily.setPower	(rs.getInt	("daily_power"));
			daily.setCamp1	(rs.getInt	("daily_camp1")); 
			daily.setCamp2	(rs.getInt	("daily_camp2")); 
			daily.setCamp3	(rs.getInt	("daily_camp3")); 
			
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
			return daily;
	}

	@Override
	public Daily daoSelectDailyByDate(Connection conn, String date)
			throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select daily_id,daily_power,daily_camp1,daily_camp2,daily_camp3 " +
					" from daily where daily_date = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			 
			Daily daily = new Daily();
			
			daily.setId		(rs.getInt	("daily_id"));
			daily.setDate	(date);
			daily.setPower	(rs.getInt	("daily_power"));
			daily.setCamp1	(rs.getInt	("daily_camp1")); 
			daily.setCamp2	(rs.getInt	("daily_camp2")); 
			daily.setCamp3	(rs.getInt	("daily_camp3")); 
			
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
			return daily;
	}

//	@Override
//	public List<Daily> daoSelectDaily(Connection conn) throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//	
//			stat = conn.createStatement();
//			String sql = "select daily_id,daily_date,daily_power,daily_camp1,daily_camp2,daily_camp3 " +
//					" from daily  ";
//			rs = stat.executeQuery(sql);
//			List<Daily> dailyList = new ArrayList<Daily>();
//			while(rs.next())
//			{
//				Daily daily = new Daily();
//				
//				daily.setId		(rs.getInt	("daily_id"));
//				daily.setDate	(rs.getString	("daily_date"));
//				daily.setPower	(rs.getInt	("daily_power"));
//				daily.setCamp1	(rs.getInt	("daily_camp1")); 
//				daily.setCamp2	(rs.getInt	("daily_camp2")); 
//				daily.setCamp3	(rs.getInt	("daily_camp3")); 
//				
//				dailyList.add(daily);
//			}
//			
//			if(rs != null)
//			{
//				try 
//				{
//					rs.close();
//				} 
//				catch (SQLException e)
//				{
//					System.out.println("发生数据库异常啦！");
//					e.printStackTrace();
//				}
//			}
//			if(stat != null)
//			{
//				try
//				{
//					stat.close();
//				}
//				catch (SQLException e)
//				{
//					System.out.println("发生数据库异常啦！");
//					e.printStackTrace();
//				}
//			}
//			return dailyList;
//	}
//	@Override
//	public void daoUpdateCamp(Connection conn, int choose) throws SQLException 
//	{
//		PreparedStatement ps = null;
//		
//		String sql = null;
//		if(choose == 1)
//		{
//			sql = "update daily set daily_camp1 = daily_camp1 + 1 where daily_date=?";
//		}
//		if(choose == 2)
//		{
//			sql = "update daily set daily_camp2 = daily_camp2 + 1 where daily_date=?";
//		}		
//		if(choose == 3)
//		{
//			sql = "update daily set daily_camp3 = daily_camp3 + 1 where daily_date=?";
//		}
//		 
//		ps = conn.prepareStatement(sql);
//		
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = df.format(date);
//		String today = dateString.substring(0, 10);
//		
//		ps.setString(1, today); 
//		
//		ps.executeUpdate();
//
//		if(ps != null)
//		{
//			try 
//			{
//				ps.close();
//			} 
//			catch (SQLException e) 
//			{
//				System.out.println("发生数据库异常啦！");
//				e.printStackTrace();
//			}
//		}
//	}
}
