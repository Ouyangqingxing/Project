package fs.battle.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

import fs.battle.dao.WuGongDaoByUser;
import fs.battle.model.WuGong;

/**WuGongDaoByUser的实现类
 * @author Jason_★ 
 */
public class WuGongDaoImpU implements WuGongDaoByUser
{
	@Override
	public WuGong daoSelectWuGong(Connection conn,int id) throws SQLException
	{ 
			PreparedStatement ps = null;
			ResultSet rs = null;
	
			String sql = "select wugong_type,wugong_name,wugong_remark,wugong_buffName,wugong_buffPower,wugong_buffRound,wugong_hits,wugong_specialNumber  " +
					" from wugong where wugong_id =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();

			WuGong wugong = new WuGong();
			 
			wugong.setId	(id);
			wugong.setType	(rs.getInt	("wugong_type"));
			wugong.setName	(rs.getString	("wugong_name"));
			wugong.setRemark	(rs.getString	("wugong_remark"));
			wugong.setBuffName	(rs.getInt	("wugong_buffName"));
			wugong.setBuffPower	(rs.getInt	("wugong_buffPower"));
			wugong.setBuffRound	(rs.getInt	("wugong_buffRound"));
			wugong.setHits	(rs.getInt	("wugong_hits"));
			wugong.setSpecialNumber	(rs.getInt	("wugong_specialNumber"));
					
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
			return wugong;
	} 

	@Override
	public int daoSelectWuGongNumber(Connection conn) throws SQLException
	{
		Statement stat = null;
		ResultSet rs = null;
		int totalItem = 0;
		try 
		{ 
			stat = conn.createStatement();
			String sql = "select count(wugong_id) as totalItem from wugong";
			rs = stat.executeQuery(sql);
			rs.next();
			totalItem = rs.getInt("totalItem");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return totalItem;
	}
}
