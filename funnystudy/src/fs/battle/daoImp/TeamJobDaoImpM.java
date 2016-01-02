//package fs.battle.daoImp;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import fs.battle.dao.TeamJobDaoByManager;
//import fs.battle.model.TeamJob;
//
//public class TeamJobDaoImpM implements TeamJobDaoByManager
//{
//	@Override
//	public void daoAddTeamJob(Connection conn,int team_id, String oneName, String twoName,
//			String threeName, String fourName, String fiveName) throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "insert teamjob(team_id,teamjob_oneName,teamjob_twoName,teamjob_threeName,teamjob_fourName,teamjob_fiveName)" +
//					" values(?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, team_id);
//			ps.setString(2, oneName);
//			ps.setString(3, twoName);
//			ps.setString(4, threeName);
//			ps.setString(5, fourName);
//			ps.setString(6,fiveName); 
//			
//			ps.executeUpdate();
//		
//			if(ps != null)
//			{
//				try
//				{
//					ps.close();
//				}
//				catch (SQLException e)
//				{
//					System.out.println("发生数据库异常啦！");
//					e.printStackTrace();
//				}
//			}
//	}
//
//	@Override
//	public void daoUpdateTeamJob(Connection conn,int id, String oneName, String twoName,
//			String threeName, String fourName, String fiveName)throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "update teamjob set teamjob_oneName=?,teamjob_twoName=?,teamjob_threeName=?,teamjob_fourName=?,teamjob_fiveName=? " +
//					"where teamjob_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, oneName);
//			ps.setString(2, twoName);
//			ps.setString(3, threeName);
//			ps.setString(4, fourName); 
//			ps.setString(5, fiveName); 
//			ps.setInt(6, id);  
//			
//			ps.executeUpdate();
//		
//			if(ps != null)
//			{
//				try 
//				{
//					ps.close();
//				} 
//				catch (SQLException e) 
//				{
//					System.out.println("发生数据库异常啦！");
//					e.printStackTrace();
//				}
//			}
//	}
//
//	@Override
//	public TeamJob daoSelectTeamJobById(Connection conn,int id) throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select team_id,teamjob_oneName,teamjob_twoName,teamjob_threeName,teamjob_fourName,teamjob_fiveName " +
//					" from teamjob where teamjob_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			TeamJob teamjob = new TeamJob();
//			 
//			teamjob.setId	(id); 
//			teamjob.setTeamId	(rs.getInt	("team_id"));
//			teamjob.setOneName	(rs.getString	("teamjob_oneName"));
//			teamjob.setTwoName	(rs.getString	("teamjob_twoName"));
//			teamjob.setThreeName	(rs.getString	("teamjob_threeName"));
//			teamjob.setFourName	(rs.getString	("teamjob_fourName"));
//			teamjob.setFiveName	(rs.getString	("teamjob_fiveName"));
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
//			if(ps != null)
//			{
//				try
//				{
//					ps.close();
//				}
//				catch (SQLException e)
//				{
//					System.out.println("发生数据库异常啦！");
//					e.printStackTrace();
//				}
//			}
//			return teamjob;
//	}
//
//	@Override
//	public List<TeamJob> daoSelectAllTeamJob(Connection conn) throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//	
//			stat = conn.createStatement();
//			String sql = "select teamjob_id,team_id,teamjob_oneName,teamjob_twoName,teamjob_threeName,teamjob_fourName,teamjob_fiveName " +
//					" from teamjob ";
//			rs = stat.executeQuery(sql);
//			List<TeamJob> teamjobList = new ArrayList<TeamJob>();
//			while(rs.next())
//			{
//				TeamJob teamjob = new TeamJob();
//				 
//				teamjob.setId	(rs.getInt	("teamjob_id"));
//				teamjob.setTeamId	(rs.getInt	("team_id"));
//				teamjob.setOneName	(rs.getString	("teamjob_oneName"));
//				teamjob.setTwoName	(rs.getString	("teamjob_twoName"));
//				teamjob.setThreeName	(rs.getString	("teamjob_threeName"));
//				teamjob.setFourName	(rs.getString	("teamjob_fourName"));
//				teamjob.setFiveName	(rs.getString	("teamjob_fiveName"));
//				
//				teamjobList.add(teamjob);
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
//			return teamjobList;
//	}
//}
