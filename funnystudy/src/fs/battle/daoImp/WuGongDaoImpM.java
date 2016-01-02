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
//import fs.battle.dao.WuGongDaoByManager;
//import fs.battle.model.WuGong;
//
//public class WuGongDaoImpM implements WuGongDaoByManager
//{
//	@Override
//	public void daoAddWuGong(Connection conn,int type, String name, String remark,
//			int buffName, int buffPower, int buffRound, int hits,int specialNumber) throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "insert wugong(wugong_type,wugong_name,wugong_remark,wugong_buffName,wugong_buffPower,wugong_buffRound,wugong_hits,wugong_specialNumber)" +
//					" values(?,?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, type);
//			ps.setString(2, name);
//			ps.setString(3, remark);
//			ps.setInt(4, buffName);
//			ps.setInt(5, buffPower);
//			ps.setInt(6, buffRound);
//			ps.setInt(7,hits);
//			ps.setInt(8,specialNumber);
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
//	public void daoUpdateWuGong(Connection conn,int id, int type, String name, String remark,
//			int buffName, int buffPower, int buffRound, int hits,int specialNumber) throws SQLException
//	{
//		PreparedStatement ps = null;
//	
//			String sql = "update wugong set wugong_type=?,wugong_name=?,wugong_remark=?,wugong_buffName=?,wugong_buffPower=?,wugong_buffRound=?,wugong_hits=?,wugong_specialNumber=? " +
//					"where wugong_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, type);
//			ps.setString(2, name);
//			ps.setString(3, remark);
//			ps.setInt(4, buffName); 
//			ps.setInt(5, buffPower); 
//			ps.setInt(6, buffRound); 
//			ps.setInt(7, hits); 
//			ps.setInt(8, specialNumber);  
//			ps.setInt(9, id); 
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
//	public List<WuGong> daoSelectAllWuGong(Connection conn) throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//	
//			stat = conn.createStatement();
//			String sql = "select wugong_id,wugong_type,wugong_name,wugong_remark,wugong_buffName,wugong_buffPower,wugong_buffRound,wugong_hits,wugong_specialNumber  " +
//					" from wugong";
//			rs = stat.executeQuery(sql);
//			List<WuGong> wugongList = new ArrayList<WuGong>();
//			while(rs.next())
//			{
//				WuGong wugong = new WuGong();
//				 
//				wugong.setId	(rs.getInt	("wugong_id"));
//				wugong.setType	(rs.getInt	("wugong_type"));
//				wugong.setName	(rs.getString	("wugong_name"));
//				wugong.setRemark	(rs.getString	("wugong_remark"));
//				wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//				wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//				wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//				wugong.setHits	(rs.getInt	("wugong_hits"));
//				wugong.setSpecialNumber	(rs.getInt	("wugong_specialNumber"));
//				
//				wugongList.add(wugong);
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
//			return wugongList;
//	}
//
//	@Override
//	public WuGong daoSelectWuGong(Connection conn,int id) throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select wugong_type,wugong_name,wugong_remark,wugong_buffName,wugong_buffPower,wugong_buffRound,wugong_hits,wugong_specialNumber  " +
//					" from wugong where wugong_id =?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			WuGong wugong = new WuGong();
//			 
//			wugong.setId	(id);
//			wugong.setType	(rs.getInt	("wugong_type"));
//			wugong.setName	(rs.getString	("wugong_name"));
//			wugong.setRemark	(rs.getString	("wugong_remark"));
//			wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//			wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//			wugong.setBuffName	(rs.getInt	("wugong_buffName"));
//			wugong.setHits	(rs.getInt	("wugong_hits"));
//			wugong.setSpecialNumber	(rs.getInt	("wugong_specialNumber"));
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
//			return wugong;
//	}
//
//}
