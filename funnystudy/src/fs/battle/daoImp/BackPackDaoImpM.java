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
//import fs.battle.dao.BackPackDaoByManager;
//import fs.battle.model.BackPack;
//
//public class BackPackDaoImpM implements BackPackDaoByManager
//{
//	@Override
//	public void daoAddBackPack(Connection conn,int playerId, int goodsId, int goodsType,
//			int goodsNumber, int goodsState)throws SQLException
//	{  
//		PreparedStatement ps = null;
//			String sql = "insert backpack(player_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState )" +
//					" values(?,?,?,?,?)";
////			conn.setAutoCommit(false);
//			
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
//	public void daoUpdateBackPack(Connection conn,int id, int playerId, int goodsId,
//			int goodsType, int goodsNumber, int goodsState) throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "update backpack set player_id=?,goods_id=?,backpack_GoodsType=?,backpack_GoodsNumber=?,backpack_GoodsState=? " +
//					"where backpack_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, playerId);
//			ps.setInt(2, goodsId);
//			ps.setInt(3, goodsType);
//			ps.setInt(4, goodsNumber); 
//			ps.setInt(5, goodsState); 
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
//	
//	@Override
//	public BackPack daoSelectBackPackById(Connection conn,int id) throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select player_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState  " +
//					" from backpack where backpack_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			BackPack backpack = new BackPack();
//			 
//			backpack.setPlayerId	(rs.getInt	("player_id"));
//			backpack.setGoodsId	(rs.getInt	("goods_id"));
//			backpack.setGoodsType	(rs.getInt	("backpack_GoodsType"));
//			backpack.setGoodsNumber	(rs.getInt	("backpack_GoodsNumber"));
//			backpack.setGoodsState	(rs.getInt	("backpack_GoodsState"));
//			backpack.setId	(id);
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
//		return backpack;
//	}
//
//	@Override
//	public List<BackPack> daoSelectBackPackByPlayerId(Connection conn,int playerId) throws SQLException
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
//			List<BackPack> backpackList = new ArrayList<BackPack>();
//			while(rs.next())
//			{
//				BackPack backpack = new BackPack();
//				 
//				backpack.setPlayerId	(playerId);
//				backpack.setGoodsId	(rs.getInt	("goods_id"));
//				backpack.setGoodsType	(rs.getInt	("backpack_GoodsType"));
//				backpack.setGoodsNumber	(rs.getInt	("backpack_GoodsNumber"));
//				backpack.setGoodsState	(rs.getInt	("backpack_GoodsState"));
//				backpack.setId	(rs.getInt	("backpack_id"));
//				 
//				backpackList.add(backpack);
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
//		return backpackList;
//	}
//
//	@Override
//	public List<BackPack> daoSelectBackPackByGoodsId(Connection conn,int goodsId) throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select backpack_id,player_id,goods_id,backpack_GoodsType,backpack_GoodsNumber,backpack_GoodsState  " +
//					" from backpack where goods_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, goodsId);
//			rs = ps.executeQuery();
//			
//			List<BackPack> backpackList = new ArrayList<BackPack>();
//			while(rs.next())
//			{
//				BackPack backpack = new BackPack();
//			 
//				backpack.setGoodsId	( goodsId );
//				backpack.setPlayerId	(rs.getInt	("player_id"));
//				backpack.setGoodsType	(rs.getInt	("backpack_GoodsType"));
//				backpack.setGoodsNumber	(rs.getInt	("backpack_GoodsNumber"));
//				backpack.setGoodsState	(rs.getInt	("backpack_GoodsState"));
//				backpack.setId	(rs.getInt	("backpack_id"));
//				 
//				backpackList.add(backpack);
//			}
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
//		return backpackList;
//	}
//
//}
