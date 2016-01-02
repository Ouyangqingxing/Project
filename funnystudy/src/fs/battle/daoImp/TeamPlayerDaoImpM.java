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
//import fs.battle.dao.TeamPlayerDaoByManager;
//import fs.battle.model.TeamPlayer;
//
//public class TeamPlayerDaoImpM implements TeamPlayerDaoByManager
//{
//	@Override
//	public void daoAddTeamPlayer(Connection conn , int teamId, int playerId)throws SQLException
//	{
//		PreparedStatement ps = null;
//	
//			String sql = "insert teamplayer(team_id,player_id,teamplayer_contribution,teamplayer_job)" +
//					" values(?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, teamId);
//			ps.setInt(2, playerId);
//			ps.setInt(3, 0);
//			ps.setInt(4, 1); 
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
//	public void daoDeleteTeamPlayer(Connection conn ,String[] playerId)throws SQLException
//	{
//		PreparedStatement ps = null;
//	
//			String sql = "delete from teamplayer where teamplayer_id = ?";
//			ps = conn.prepareStatement(sql);
//			for (String idString : playerId) 
//			{
//				ps.setInt(1, Integer.parseInt(idString));
//				ps.executeUpdate();
//			}
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
//	public void daoUpdateTeamPlayer(Connection conn ,int id, int teamId, int playerId,
//			int contribution, int job) throws SQLException
//	{
//		PreparedStatement ps = null;
//	
//			String sql = "update teamplayer set team_id=?,player_id=?,teamplayer_contribution=?,teamplayer_job=?   " +
//					"where teamplayer_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, teamId);
//			ps.setInt(2, playerId);
//			ps.setInt(3, contribution);
//			ps.setInt(4, job); 
//			ps.setInt(5, id); 
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
//	
//	@Override
//	public TeamPlayer daoSelectTeamPlayerById(Connection conn ,int id)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select team_id,player_id,teamplayer_contribution,teamplayer_job " +
//					" from teamplayer where teamplayer_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			TeamPlayer teamplayer = new TeamPlayer();
//			 
//			teamplayer.setId	(id);
//			teamplayer.setTeamId	(rs.getInt	("team_id"));
//			teamplayer.setPlayerId	(rs.getInt	("player_id"));
//			teamplayer.setContribution	(rs.getInt	("teamplayer_contribution"));
//			teamplayer.setJob	(rs.getInt	("teamplayer_job"));			
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
//			return teamplayer;
//	}
//
//	@Override
//	public TeamPlayer daoSelectTeamPlayerByTeamId(Connection conn ,int teamId)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select teamplayer_id,player_id,teamplayer_contribution,teamplayer_job " +
//					" from teamplayer where team_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, teamId);
//			rs = ps.executeQuery();
//			rs.next();
//
//			TeamPlayer teamplayer = new TeamPlayer();
//			 
//			teamplayer.setId	(rs.getInt	("teamplayer_id"));
//			teamplayer.setTeamId	(teamId);
//			teamplayer.setPlayerId	(rs.getInt	("player_id"));
//			teamplayer.setContribution	(rs.getInt	("teamplayer_contribution"));
//			teamplayer.setJob	(rs.getInt	("teamplayer_job"));
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
//			return teamplayer;
//	}
//
//	@Override
//	public TeamPlayer daoSelectTeamPlayerByPlayerId(Connection conn ,int playerId)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select teamplayer_id,team_id,teamplayer_contribution,teamplayer_job " +
//					" from teamplayer where player_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, playerId);
//			rs = ps.executeQuery();
//			rs.next();
//
//			TeamPlayer teamplayer = new TeamPlayer();
//			 
//			teamplayer.setId	(rs.getInt	("teamplayer_id"));
//			teamplayer.setTeamId	(rs.getInt	("team_id"));
//			teamplayer.setPlayerId	(playerId);
//			teamplayer.setContribution	(rs.getInt	("teamplayer_contribution"));
//			teamplayer.setJob	(rs.getInt	("teamplayer_job"));
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
//			return teamplayer;
//	}
//
//	@Override
//	public List<TeamPlayer> daoSelectTeamPlayer(Connection conn )throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//
//			stat = conn.createStatement();
//			String sql = "select teamplayer_id,team_id,player_id,teamplayer_contribution,teamplayer_job " +
//					" from teamplayer ";
//			rs = stat.executeQuery(sql);
//			List<TeamPlayer> teamplayerList = new ArrayList<TeamPlayer>();
//			while(rs.next())
//			{
//				TeamPlayer teamplayer = new TeamPlayer();
//				 
//				teamplayer.setId	(rs.getInt	("teamplayer_id"));
//				teamplayer.setTeamId	(rs.getInt	("team_id"));
//				teamplayer.setPlayerId	(rs.getInt	("player_id"));
//				teamplayer.setContribution	(rs.getInt	("teamplayer_contribution"));
//				teamplayer.setJob	(rs.getInt	("teamplayer_job"));
//				
//				teamplayerList.add(teamplayer);
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
//			return teamplayerList;
//	}
//
//}
