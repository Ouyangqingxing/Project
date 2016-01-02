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
//import fs.battle.dao.CampDaoByManager;
//import fs.battle.model.Camp;
//
//public class CampDaoImpM implements CampDaoByManager{
//
//	@Override
//	public void daoAddCamp(Connection conn,String name, String remark) throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "insert camp(camp_name,camp_population,camp_remark,camp_teamNumber)" +
//					" values(?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setInt(2, 0);
//			ps.setString(3, remark);
//			ps.setInt(4, 0);
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
//	public void daoUpdateCamp(Connection conn,int id, String name, int population, String remark,int teamNumber)throws SQLException 
//	{
//		PreparedStatement ps = null;
//
//			String sql = "update camp set camp_name=?,camp_population=?,camp_remark=?,camp_teamNumber=? " +
//					"where camp_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setInt(2, population);
//			ps.setString(3, remark);
//			ps.setInt(4, teamNumber); 
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
//	@Override
//	public Camp daoSelectCampById(Connection conn,int id)throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//			String sql = "select camp_name,camp_population,camp_remark,camp_teamNumber " +
//					" from camp where camp_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			Camp camp = new Camp();
//			
//			camp.setId(id);
//			camp.setName(rs.getString	("camp_name"));	
//			camp.setPopulation(rs.getInt	("camp_population"));	
//			camp.setRemark(rs.getString	("camp_remark"));	
//			camp.setTeamNumber(rs.getInt	("camp_teamNumber"));	
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
//			return camp;
//	}
//
//	@Override
//	public List<Camp> daoSelectAllCamp(Connection conn)throws SQLException 
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//			stat = conn.createStatement();
//			String sql = "select camp_id,camp_name,camp_population,camp_remark,camp_teamNumber  " +
//					" from camp";
//			rs = stat.executeQuery(sql);
//			List<Camp> campList = new ArrayList<Camp>();
//			while(rs.next())
//			{
//				Camp camp = new Camp();
//				
//				camp.setId			(rs.getInt		("camp_id"));
//				camp.setName		(rs.getString	("camp_name"));
//				camp.setPopulation	(rs.getInt	("camp_population"));
//				camp.setRemark		(rs.getString	("camp_remark"));
//				camp.setTeamNumber	(rs.getInt	("camp_teamNumber"));
//				 
//				campList.add(camp);
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
//		return campList;
//	}
//}
