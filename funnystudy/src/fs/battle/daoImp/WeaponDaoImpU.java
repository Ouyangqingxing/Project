package fs.battle.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import fs.battle.dao.WeaponDaoByUser;
import fs.battle.model.Weapon; 

/**WeaponDaoByUser的实现类
 * @author Jason_★ 
 */
public class WeaponDaoImpU implements WeaponDaoByUser
{ 
	@Override
	public void daoUpdataWeaponHolder(Connection conn,int id,int newHolderId)throws SQLException 
	{
		PreparedStatement ps = null;
	
			String sql = "update weapon set weapon_holderId=?   " +
					"where weapon_id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newHolderId);
			ps.setInt(2, id);
			
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
	public Weapon daoSelectWeapon(Connection conn,int id) throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
	
			String sql = "select weapon_id,weapon_type,weapon_holderId,weapon_name,weapon_remark,weapon_buffName,weapon_buffPower,weapon_specialNumber  " +
					" from weapon where weapon_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			
			Weapon weapon = new Weapon();
			 
			weapon.setId	(id);
			weapon.setType	(rs.getInt	("weapon_type"));
			weapon.setHolderId	(rs.getInt	("weapon_holderId"));
			weapon.setName	(rs.getString	("weapon_name"));
			weapon.setRemark	(rs.getString	("weapon_remark"));
			weapon.setBuffName	(rs.getInt	("weapon_buffName"));
			weapon.setBuffPower	(rs.getInt	("weapon_buffPower"));
			weapon.setSpecialNumber	(rs.getInt	("weapon_specialNumber"));
					
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
			return weapon;
	}
 	
	
	@Override
	public List<Weapon> daoSelectAllWeapon(Connection conn) throws SQLException 
	{
		Statement stat = null;
		ResultSet rs = null;

			stat = conn.createStatement();
			String sql = "select weapon_id,weapon_type,weapon_holderId,weapon_name,weapon_remark,weapon_buffName,weapon_buffPower,weapon_specialNumber  " +
					" from weapon";
			rs = stat.executeQuery(sql);
			List<Weapon> weaponList = new ArrayList<Weapon>();
			while(rs.next())
			{
				Weapon weapon = new Weapon();
				 
				weapon.setId	(rs.getInt	("weapon_id"));
				weapon.setType	(rs.getInt	("weapon_type"));
				weapon.setHolderId	(rs.getInt	("weapon_holderId"));
				weapon.setName	(rs.getString	("weapon_name"));
				weapon.setRemark	(rs.getString	("weapon_remark"));
				weapon.setBuffName	(rs.getInt	("weapon_buffName"));
				weapon.setBuffPower	(rs.getInt	("weapon_buffPower"));
				weapon.setSpecialNumber	(rs.getInt	("weapon_specialNumber"));
				
				weaponList.add(weapon);
			}	

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
			if(stat != null)
			{
				try
				{
					stat.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return weaponList;
	}
}
