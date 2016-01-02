//package fs.battle.daoImp;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import fs.battle.dao.BackPackDaoByUser;
//import fs.battle.model.BackPack;
//
//public class BackPackDaoImpU implements BackPackDaoByUser
//{
//	@Override
//	public void daoAddBackPack(Connection conn,int playerId, int goodsId, int goodsType,
//			int goodsNumber, int goodsState)throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		 
//			String sql = "insert backpack(player_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState )" +
//					" values(?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, playerId);
//			ps.setInt(2, goodsId);
//			ps.setInt(3, goodsType);
//			ps.setInt(4, goodsNumber);
//			ps.setInt(5, goodsState); 
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
//	public void daoDeleteBackPack(Connection conn,String[] backpackIds)throws SQLException
//	{
//		PreparedStatement ps = null;
//			String sql = "delete from backpack where backpack_id = ?";
//			ps = conn.prepareStatement(sql);
//			for (String idString : backpackIds) 
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
//	@Override
//	public void daoUpdateBackPackGoodsNumber(Connection conn,int goodsId,int playerId, int useOrget)throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		String sql = null;
//
//			if(useOrget == 5)
//			{
//				sql = "update backpack set backpack_GoodsNumber=backpack_GoodsNumber-1 " +
//					"where goods_id=? and player_id=? ";
//			}
//			else if(useOrget == 9)
//			{
//				sql = "update backpack set backpack_GoodsNumber=backpack_GoodsNumber+1 " +
//						"where goods_id=? and player_id=? ";
//			}
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, goodsId);  
//			ps.setInt(2, playerId);  
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
//	public void daoUpdateBackPackGoodsState(Connection conn,int id, int state)throws SQLException
//	{
//		PreparedStatement ps = null;
//		String sql = null;
//
//			sql = "update backpack set backpack_GoodsState=? " +
//				"where backpack_id=?";
//			
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, state);  
//			ps.setInt(2, id); 
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
//	public List<BackPack> daoSelectBackPackGoods(Connection conn,int playerId)throws SQLException
//	{
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//		
//				String sql = "select backpack_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState  " +
//						" from backpack where player_id = ? ";
//				ps = conn.prepareStatement(sql);
//				ps.setInt(1, playerId);
//				rs = ps.executeQuery();
//				
//				List<BackPack> backpackList = new ArrayList<BackPack>();
//				while(rs.next())
//				{
//					BackPack backpack = new BackPack();
//					 
//					backpack.setPlayerId	(playerId);
//					backpack.setGoodsId	(rs.getInt	("goods_id"));
//					backpack.setGoodsType	(rs.getInt	("backpack_GoodsType"));
//					backpack.setGoodsNumber	(rs.getInt	("backpack_GoodsNumber"));
//					backpack.setGoodsState	(rs.getInt	("backpack_GoodsState"));
//					backpack.setId	(rs.getInt	("backpack_id"));
//					 
//					backpackList.add(backpack);
//				}
//				
//				if(rs != null)
//				{
//					try 
//					{
//						rs.close();
//					} 
//					catch (SQLException e)
//					{
//						System.out.println("发生数据库异常啦！");
//						e.printStackTrace();
//					}
//				}
//				if(ps != null)
//				{
//					try
//					{
//						ps.close();
//					}
//					catch (SQLException e)
//					{
//						System.out.println("发生数据库异常啦！");
//						e.printStackTrace();
//					}
//				}
//				return backpackList;
//	}
//
//	@Override
//	public BackPack daoSelectBackPack(Connection conn, int playerId, int goodsId)
//			throws SQLException 
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select backpack_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState  " +
//					" from backpack where player_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, playerId);
//			rs = ps.executeQuery();
//			
//			if(rs.next())
//			{
//				BackPack backpack = new BackPack();
//				 
//				backpack.setPlayerId	(playerId);
//				backpack.setGoodsId	(rs.getInt	("goods_id"));
//				backpack.setGoodsType	(rs.getInt	("backpack_GoodsType"));
//				backpack.setGoodsNumber	(rs.getInt	("backpack_GoodsNumber"));
//				backpack.setGoodsState	(rs.getInt	("backpack_GoodsState"));
//				backpack.setId	(rs.getInt	("backpack_id"));
//				return backpack;
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
//		return null;
//	}
//
//
//	
//	@Override
//	public int daoSelectBackPackId(Connection conn, int playerId, int goodsId)
//			throws SQLException 
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select backpack_id  " +
//					" from backpack where player_id = ? and goods_id = ?  ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, playerId);
//			ps.setInt(2, goodsId);
//			rs = ps.executeQuery();
//			
//			if(rs.next())
//			{		
//				return rs.getInt	("backpack_id");
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
//		return 0;
//	}
//}
