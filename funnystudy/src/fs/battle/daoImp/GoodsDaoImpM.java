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
//import fs.battle.dao.GoodsDaoByManager;
//import fs.battle.model.Goods;
//
//public class GoodsDaoImpM implements GoodsDaoByManager{
//
//	@Override
//	public void daoAddGoods(Connection conn,String name,String remark, int type, int buffName, int buffPower)throws SQLException
//	{
//		//Connection conn = MySQLConnection.getMySQLConnection();
//		PreparedStatement ps = null;
//		
//			String sql = "insert goods(goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower)" +
//					" values(?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setString(2, remark);
//			ps.setInt(3, type);
//			ps.setInt(4, buffName);
//			ps.setInt(5, buffPower);
//			
//			ps.executeUpdate();
//		 
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
//	public void daoUpdateGoods(Connection conn,int id, String name,String remark ,int type, int buffName,
//			int buffPower)throws SQLException
//	{ 
//		//Connection conn = MySQLConnection.getMySQLConnection();
//		PreparedStatement ps = null;
//				
//			String sql = "update goods set goods_name=?,goods_remark=?,goods_type=?,goods_buffName=?,goods_buffPower=? " +
//					"where goods_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setString(2, remark);
//			ps.setInt(3, type);
//			ps.setInt(4, buffName); 
//			ps.setInt(5, buffPower); 
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
//	public Goods daoSelectGoods(Connection conn,int id) throws SQLException 
//	{ 
//		//Connection conn = MySQLConnection.getMySQLConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		
//		String sql = "select goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower " +
//				" from goods where goods_id = ? ";
//		ps = conn.prepareStatement(sql);
//		ps.setInt(1, id);
//		rs = ps.executeQuery();
//		rs.next();
//
//		Goods goods = new Goods();
//			 
//		goods.setName	(rs.getString	("goods_name"));
//		goods.setRemark	(rs.getString	("goods_remark"));
//		goods.setType	(rs.getInt	("goods_type"));
//		goods.setBuffName	(rs.getInt	("goods_buffName"));
//		goods.setBuffPower	(rs.getInt	("goods_buffPower"));
//									
//		if(rs != null)
//		{
//			try 
//			{
//				rs.close();
//			} 
//			catch (SQLException e)
//			{
//				System.out.println("发生数据库异常啦！");
//				e.printStackTrace();
//			}
//		}
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
//		return goods;
//		//return null;
//	}
//
//	@Override
//	public List<Goods> daoSelectAllGoods(Connection conn)throws SQLException 
//	{ 
//		//Connection conn = MySQLConnection.getMySQLConnection();
//		Statement stat = null;
//		ResultSet rs = null;
//
//			stat = conn.createStatement();
//			String sql = "select goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower " +
//					" from goods ";
//			rs = stat.executeQuery(sql);
//			List<Goods> goodsList = new ArrayList<Goods>();
//			while(rs.next())
//			{
//				Goods goods = new Goods();
//				 
//				goods.setName	(rs.getString	("goods_name"));
//				goods.setRemark	(rs.getString	("goods_remark"));
//				goods.setType	(rs.getInt	("goods_type"));
//				goods.setBuffName	(rs.getInt	("goods_buffName"));
//				goods.setBuffPower	(rs.getInt	("goods_buffPower"));
//				
//				goodsList.add(goods);
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
//			return goodsList;
//		//return null;
//	}
//}
