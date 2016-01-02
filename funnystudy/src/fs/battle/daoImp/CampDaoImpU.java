package fs.battle.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  

import fs.battle.dao.CampDaoByUser; 

/**CampDaoByUser的实现类
 * @author Jason_★ 
 */
public class CampDaoImpU implements CampDaoByUser
{
	@Override
	public void daoUpdateCampPopulation(Connection conn,int id)throws SQLException
	{
		PreparedStatement ps = null;
			String sql = "update camp set camp_population=camp_population+1 " +
					"where camp_id=?";
			ps = conn.prepareStatement(sql);
			 
			ps.setInt(1, id); 
			ps.executeUpdate();
		
			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	}

	@Override
	public int daoSelectCampPopulation(Connection conn,int id) throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
	
			String sql = "select camp_population " +
					" from camp where camp_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			int population = rs.getInt	("camp_population");
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}			
			return population;
	}
	
//	@Override
//	public void daoUpdateCampTeamNumber(Connection conn,int id,int check) throws SQLException
//	{ 
//		PreparedStatement ps = null;
//
//			String sql = null;
//			if(check == 9)//9表有 增加
//			{
//				sql = "update camp set camp_teamNumber=camp_teamNumber+1 " +
//						"where camp_id=?";
//			}
//			else if(check == 5)//5表无 减小
//			{
//				sql = "update camp set camp_teamNumber=camp_teamNumber-1 " +
//						"where camp_id=?";
//			}
//			else
//			{	
//				System.out.println("【来自CampDaoImpU的提示】输入的参数有误！");
//			} 
//			ps = conn.prepareStatement(sql); 
//			ps.setInt(1, id);  
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

//	@Override
//	public Camp daoSelectCampById(Connection conn,int id)throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
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
//			return campList;
//	}


//	@Override
//	public int daoSelectCampTeamNumber(Connection conn,int id)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//			String sql = "select camp_teamNumber " +
//					" from camp where camp_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
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
//			return rs.getInt	("camp_teamNumber");
//	}
}
