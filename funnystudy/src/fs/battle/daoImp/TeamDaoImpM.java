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
//import fs.battle.dao.TeamDaoByManager;
//import fs.battle.model.Team;
//
//public class TeamDaoImpM implements TeamDaoByManager
//{
//	@Override
//	public boolean daoCheckTeamName(Connection conn,String teamName)
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try
//		{ 
//			String sql = "select team_remark " +
//					" from team where team_name = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, teamName);
//			rs = ps.executeQuery();
//			rs.next();
//			
//			rs.getString("team_remark");
//		} 
//		catch (SQLException e) 
//		{ 
//			return false; 
//		} 
//		finally
//		{
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
//		}
//		return true;
//	}
//	
// 
//	
//	@Override
//	public void daoAddTeam(Connection conn,int leaderId,int campId, String name, String remark)throws SQLException 
//	{ 
//		PreparedStatement ps = null;
//	
//			String sql = "insert team(camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign)" +
//					" values(?,?,?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, campId);
//			ps.setInt(2, leaderId);
//			ps.setInt(3, 0);
//			ps.setString(4, name);
//			ps.setString(5, remark);
//			ps.setInt(6, 0);
//			ps.setInt(7, 1);
//			ps.setInt(8, 1);
//			ps.setInt(9, 0);
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
//	
//	@Override
//	public void daoUpdateTeam(Connection conn,int id, int campId, int leaderId,
//			int viceLeaderId, String name, String remark, int exp, int level,
//			int population, int sign) throws SQLException 
//	{
//		PreparedStatement ps = null;
//			String sql = "update team set camp_id=?,team_leaderId=?,team_viceLeaderId=?,team_name=?,team_remark=?,team_exp=?,team_level=?,team_population=?,team_sign=? " +
//					"where team_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, campId);
//			ps.setInt(2, leaderId);
//			ps.setInt(3, viceLeaderId);
//			ps.setString(4, name); 
//			ps.setString(5, remark); 
//			ps.setInt(6, exp); 
//			ps.setInt(7, level); 
//			ps.setInt(8, population); 
//			ps.setInt(9, sign); 
//			ps.setInt(10, id); 
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
//	
//	@Override
//	public Team daoSelectTeaminfo(Connection conn,int id) throws SQLException 
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign " +
//					" from team where team_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			Team team = new Team();
//			 
//			team.setId	(id);
//			team.setCampId	(rs.getInt	("camp_id"));
//			team.setLeaderId	(rs.getInt	("team_leaderId"));
//			team.setViceLeaderId	(rs.getInt	("team_viceLeaderId"));
//			team.setName	(rs.getString	("team_name"));
//			team.setRemark	(rs.getString	("team_remark"));
//			team.setExp	(rs.getInt	("team_exp"));
//			team.setLevel	(rs.getInt	("team_level"));
//			team.setPopulation	(rs.getInt	("team_population"));
//			team.setSign	(rs.getInt	("team_sign"));		
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
//			return team;
//	}
//
//	@Override
//	public List<Team> daoSelectAllTeamInfo(Connection conn)throws SQLException 
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//	
//			stat = conn.createStatement();
//			String sql = "select team_id,camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign  " +
//					" from team";
//			rs = stat.executeQuery(sql);
//			List<Team> teamList = new ArrayList<Team>();
//			while(rs.next())
//			{
//				Team team = new Team();
//				 
//				team.setId	(rs.getInt	("team_id"));
//				team.setCampId	(rs.getInt	("camp_id"));
//				team.setLeaderId	(rs.getInt	("team_leaderId"));
//				team.setViceLeaderId	(rs.getInt	("team_viceLeaderId"));
//				team.setName	(rs.getString	("team_name"));
//				team.setRemark	(rs.getString	("team_remark"));
//				team.setExp	(rs.getInt	("team_exp"));
//				team.setLevel	(rs.getInt	("team_level"));
//				team.setPopulation	(rs.getInt	("team_population"));
//				team.setSign	(rs.getInt	("team_sign"));
//				
//				teamList.add(team);
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
//			return teamList;
//	}
//}
