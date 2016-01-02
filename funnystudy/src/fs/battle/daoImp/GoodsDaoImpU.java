//package fs.battle.daoImp;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//
//import fs.battle.dao.GoodsDaoByUser;
//import fs.battle.model.Goods;
//
//public class GoodsDaoImpU implements GoodsDaoByUser
//{
//	@Override
//	public Goods daoSelectGoods(Connection conn,int id)throws SQLException 
//	{
//		//Connection conn = MySQLConnection.getMySQLConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower " +
//					" from goods where goods_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			Goods goods = new Goods();
//			 
//			goods.setName	(rs.getString	("goods_name"));
//			goods.setRemark	(rs.getString	("goods_remark"));
//			goods.setType	(rs.getInt	("goods_type"));
//			goods.setBuffName	(rs.getInt	("goods_buffName"));
//			goods.setBuffPower	(rs.getInt	("goods_buffPower"));
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
//			return goods;
//	}
//}
