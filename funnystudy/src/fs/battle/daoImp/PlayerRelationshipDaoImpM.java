//package fs.battle.daoImp;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//import fs.battle.dao.PlayerRelationshipDaoByManager;
//import fs.battle.model.PlayerRelationship;
//
//public class PlayerRelationshipDaoImpM implements PlayerRelationshipDaoByManager
//{
//	@Override
//	public void daoAddPR(Connection conn,int playerId, int bePlayerId, int relationship)throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "insert playerrelationship(playerrelationship_playerId,playerrelationship_beplayerId,playerrelationship_relationship,playerrelationship_time)" +
//					" values(?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, playerId);
//			ps.setInt(2, bePlayerId);
//			ps.setInt(3, relationship);
//			
//			Date date = new Date();
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			String dateString = df.format(date);
//			ps.setString(4, dateString); 
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
//	public void daoDeletePR(Connection conn,String[] id) throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "delete from playerrelationship where playerrelationship_id = ?";
//			ps = conn.prepareStatement(sql);
//			for (String idString : id) 
//			{
//				ps.setInt(1, Integer.parseInt(idString));
//				ps.executeUpdate();
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
//	}
//
//	
//	@Override
//	public void daoUpdatePR(Connection conn,int id, int playerId, int bePlayerId,
//			int relationship, String time)throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "update playerrelationship set playerrelationship_playerId=?,playerrelationship_beplayerId=?,playerrelationship_relationship=?,playerrelationship_time=?   " +
//					"where playerrelationship_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, playerId);
//			ps.setInt(2, bePlayerId);
//			ps.setInt(3, relationship);
//			ps.setString(4, time); 
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
//	@Override
//	public PlayerRelationship daoSelectPRId(Connection conn,int id) throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select playerrelationship_playerId,playerrelationship_beplayerId,playerrelationship_relationship,playerrelationship_time " +
//					" from playerrelationship where playerrelationship_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			PlayerRelationship playerrelationship = new PlayerRelationship();
//			 
//			playerrelationship.setId	(id);
//			playerrelationship.setPlayerId	(rs.getInt	("playerrelationship_playerId")); 
//			playerrelationship.setBeplayerId	(rs.getInt	("playerrelationship_beplayerId")); 
//			playerrelationship.setRelationship	(rs.getInt	("playerrelationship_relationship")); 
//			playerrelationship.setTime	(rs.getString	("playerrelationship_time")); 
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
//			return playerrelationship;
//	}
//
//	@Override
//	public List<PlayerRelationship> daoSelectPRplyerId(Connection conn,int playerId)throws SQLException 
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select playerrelationship_id,playerrelationship_beplayerId,playerrelationship_relationship,playerrelationship_time " +
//					" from playerrelationship where playerrelationship_playerId = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, playerId);
//			rs = ps.executeQuery();
//			List<PlayerRelationship> playerrelationshipList = new ArrayList<PlayerRelationship>();
//			
//			while(rs.next())
//			{
//				PlayerRelationship playerrelationship = new PlayerRelationship();
//				 
//				playerrelationship.setId	(rs.getInt	("playerrelationship_id"));
//				playerrelationship.setPlayerId	(playerId); 
//				playerrelationship.setBeplayerId	(rs.getInt	("playerrelationship_beplayerId")); 
//				playerrelationship.setRelationship	(rs.getInt	("playerrelationship_relationship")); 
//				playerrelationship.setTime	(rs.getString	("playerrelationship_time")); 
//				
//				playerrelationshipList.add(playerrelationship);
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
//			return playerrelationshipList;
//	}
//	
//	@Override
//	public List<PlayerRelationship> daoSelectPRR(Connection conn,int Relationship)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
// 
//			String sql = "select playerrelationship_id,playerrelationship_playerId,playerrelationship_beplayerId,playerrelationship_time " +
//					" from playerrelationship where playerrelationship_relationship = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, Relationship);
//			rs = ps.executeQuery();
//			List<PlayerRelationship> playerrelationshipList = new ArrayList<PlayerRelationship>();
//			
//			while(rs.next())
//			{
//				PlayerRelationship playerrelationship = new PlayerRelationship();
//				 
//				playerrelationship.setId	(rs.getInt	("playerrelationship_id"));
//				playerrelationship.setPlayerId	(rs.getInt	("playerrelationship_playerId")); 
//				playerrelationship.setBeplayerId	(rs.getInt	("playerrelationship_beplayerId")); 
//				playerrelationship.setRelationship	(Relationship); 
//				playerrelationship.setTime	(rs.getString	("playerrelationship_time")); 
//				
//				playerrelationshipList.add(playerrelationship);
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
//			return playerrelationshipList;
//	}
//}
