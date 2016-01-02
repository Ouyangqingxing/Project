package fs.study.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import fs.study.dao.StudyInfoDao;
import fs.study.model.StudyInfo;

public class StudyInfoDaoImp implements StudyInfoDao
{

	@Override
	public void daoAddStudyInfo(Connection conn, int userId, String content)
			throws SQLException 
	{ 
		PreparedStatement ps = null;
		
		String sql = "insert studyInfo(user_id,studyInfo_time,studyInfo_content)" +
				" values(?,?,?)";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, userId);
		
		Date d=new Date();  
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");       
		String today =  df.format(d);//今天的日期 
		ps.setString(2, today);
		
		ps.setString(3, content+" ("+today+")"); 
		
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
	public void daoDeleteStudyInfo(Connection conn, String[] studyInfoId)
			throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "delete from studyInfo where studyInfo_id = ?";
		ps = conn.prepareStatement(sql);
		for (String idString : studyInfoId) 
		{
			ps.setInt(1, Integer.parseInt(idString));
			ps.executeUpdate();
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

	@Override
	public List<StudyInfo> daoSelectStudyInfoByUesrId(Connection conn,
			int userId) throws SQLException 
	{ 
		Statement stat = null;
		ResultSet rs = null;
	
			stat = conn.createStatement();
			String sql = "select studyInfo_id,studyInfo_time,studyInfo_content " +
					" from studyInfo";
			rs = stat.executeQuery(sql);
			List<StudyInfo> studyInfoList = new ArrayList<StudyInfo>();
			while(rs.next())
			{
				StudyInfo studyInfo = new StudyInfo();
				
				studyInfo.setUserId	(userId);
				studyInfo.setId		(rs.getInt	("studyInfo_id"));
				studyInfo.setTime	(rs.getString	("studyInfo_time"));
				studyInfo.setContent(rs.getString	("studyInfo_content")); 
				
				studyInfoList.add(studyInfo);
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
			return studyInfoList;
	}

	@Override
	public StudyInfo daoSelectStudyInfoById(Connection conn, int id)
			throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select user_id,studyInfo_time,studyInfo_content " +
					" from studyInfo where studyInfo_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			 
			StudyInfo studyInfo = new StudyInfo();
			
			studyInfo.setId		(id);
			studyInfo.setUserId		(rs.getInt	("user_id"));
			studyInfo.setTime	(rs.getString	("studyInfo_time"));
			studyInfo.setContent	(rs.getString	("studyInfo_content")); 

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
			return studyInfo;
	}

	@Override
	public StudyInfo daoSelectStudyInfoByUserIdandTime(Connection conn,
			int userId, String time) throws SQLException 
	{ 
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select studyInfo_id,studyInfo_content " +
					" from studyInfo where user_id=? and studyInfo_time=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2,time);
			rs = ps.executeQuery();
			rs.next();
			 
			StudyInfo studyInfo = new StudyInfo();
			
			studyInfo.setId			(rs.getInt	("studyInfo_id"));
			studyInfo.setUserId		(userId);
			studyInfo.setTime		(time);
			studyInfo.setContent	(rs.getString	("studyInfo_content")); 

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
			return studyInfo;
	}

}
