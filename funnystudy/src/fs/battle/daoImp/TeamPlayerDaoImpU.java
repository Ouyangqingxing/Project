//package fs.battle.daoImp;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//
//import fs.battle.dao.TeamPlayerDaoByUser;
//import fs.battle.model.TeamPlayer;
//
//public class TeamPlayerDaoImpU implements TeamPlayerDaoByUser
//{
//	@Override
//	public void daoAddTeamPlayer(Connection conn,int teamId, int playerId,boolean check)throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "insert teamplayer(team_id,player_id,teamplayer_contribution,teamplayer_job)" +
//					" values(?,?,?,?)";
//			ps = conn.prepareStatement(sql);  
//			ps.setInt(1, teamId);
//			ps.setInt(2, playerId);
//			ps.setInt(3, 0);
//			
//			if(check)//如果是创建者 那么等级为帮主-5
//			{
//				ps.setInt(4, 5); 
//			}
//			else
//			{
//				ps.setInt(4, 1); 
//			}
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
//	public void daoDeleteTeamPlayer(Connection conn,String[] playerId)throws SQLException
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
//	public void daoUpdateTeamPlayerCTB(Connection conn,int teamPlayerId, int contribution) throws SQLException
//	{
//		PreparedStatement ps = null;
//		int oldContribution = daoSelectTeamPlayerById(conn, teamPlayerId).getContribution();
//			String sql = "update teamplayer set teamplayer_contribution=?  " +
//					"where teamplayer_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, (oldContribution+contribution) );
//			ps.setInt(2, teamPlayerId); 
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
//	public void daoUpdateTeamPlayerJOB(Connection conn,int teamPlayerId, int job) throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "update teamplayer set teamplayer_job=?   " +
//					"where teamplayer_id=?";
//			ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, job); 
//			ps.setInt(2, teamPlayerId); 
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
//	public TeamPlayer daoSelectTeamPlayerByPlayerId(Connection conn,int playerId)throws SQLException
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
//
//	@Override
//	public TeamPlayer daoSelectTeamPlayerById(Connection conn, int id)
//			throws SQLException 
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select player_id,team_id,teamplayer_contribution,teamplayer_job " +
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
//}
