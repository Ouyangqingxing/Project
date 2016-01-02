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
//import fs.battle.dao.PlayerRelationshipDaoByUser;
//import fs.battle.model.PlayerRelationship;
//
//public class PlayerRelationshipDaoImpU implements PlayerRelationshipDaoByUser
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
//	@Override
//	public void daoUpdatePR(Connection conn, int playerId,int beplayerId,int relationship)
//			throws SQLException {
//		PreparedStatement ps = null;
//		
//		String sql = "update playerrelationship set playerrelationship_relationship=? " +
//				"where playerrelationship_playerId=? and playerrelationship_beplayerId=?";
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, relationship); 
//		ps.setInt(2, playerId); 
//		ps.setInt(3, beplayerId);
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
//	
//	@Override
//	public void daoDeletePR(Connection conn,String[] id)throws SQLException 
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
//	public List<PlayerRelationship> daoSelectPR(Connection conn,int playerId) throws SQLException
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
//		return playerrelationshipList;
//	}
//
//	@Override
//	public int daoSelect(Connection conn, int playerId, int beplayerId)
//			throws Exception 
//	{ 
//		int result = 0 ;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
// 
//			String sql = "select playerrelationship_relationship " +
//					" from playerrelationship where playerrelationship_playerId = ? and playerrelationship_beplayerId = ?   ";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, playerId);
//			ps.setInt(2, beplayerId);
//			rs = ps.executeQuery(); 
//				 
//			if(rs.next())
//			{
//				result = rs.getInt	("playerrelationship_relationship"); 
//			}	 
//			
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
//		return result;
//	}
//
//}
