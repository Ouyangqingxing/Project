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
//import fs.battle.dao.WeaponDaoByManager;
//import fs.battle.model.Weapon;
//
//public class WeaponDaoImpM implements WeaponDaoByManager
//{
//
//	@Override
//	public void daoAddWeapon(Connection conn,int type, String name, String remark,
//			int buffName, int buffPower,int specialNumber)throws SQLException 
//	{ 
//		PreparedStatement ps = null;
//		
//			String sql = "insert Weapon(weapon_type,weapon_holderId,weapon_name,weapon_remark,weapon_buffName,weapon_buffPower,weapon_specialNumber)" +
//					" values(?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, type);
//			ps.setInt(2, 0);
//			ps.setString(3, name);
//			ps.setString(4, remark);
//			ps.setInt(5, buffName);
//			ps.setInt(6, buffPower);
//			ps.setInt(7, specialNumber);
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
//	public void daoUpdateWeapon(Connection conn,int id, int type,int holderId, String name, String remark,
//			int buffName, int buffPower,int specialNumber)throws SQLException 
//	{
//		PreparedStatement ps = null;
//	
//			String sql = "update weapon set weapon_type=?,weapon_holderId=?,weapon_name=?,weapon_remark=?,weapon_buffName=?,weapon_buffPower=?,weapon_specialNumber=?   " +
//					"where weapon_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, type);
//			ps.setInt(2, holderId);
//			ps.setString(3, name);
//			ps.setString(4, remark); 
//			ps.setInt(5, buffName); 
//			ps.setInt(6, buffPower); 
//			ps.setInt(7, specialNumber); 
//			ps.setInt(8, id);
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
//	public List<Weapon> daoSelectAllWeapon(Connection conn) throws SQLException 
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//
//			stat = conn.createStatement();
//			String sql = "select weapon_id,weapon_type,weapon_holderId,weapon_name,weapon_remark,weapon_buffName,weapon_buffPower,weapon_specialNumber  " +
//					" from weapon";
//			rs = stat.executeQuery(sql);
//			List<Weapon> weaponList = new ArrayList<Weapon>();
//			while(rs.next())
//			{
//				Weapon weapon = new Weapon();
//				 
//				weapon.setId	(rs.getInt	("weapon_id"));
//				weapon.setType	(rs.getInt	("weapon_type"));
//				weapon.setHolderId	(rs.getInt	("weapon_holderId"));
//				weapon.setName	(rs.getString	("weapon_name"));
//				weapon.setRemark	(rs.getString	("weapon_remark"));
//				weapon.setBuffName	(rs.getInt	("weapon_buffName"));
//				weapon.setBuffPower	(rs.getInt	("weapon_buffPower"));
//				weapon.setSpecialNumber	(rs.getInt	("weapon_specialNumber"));
//				
//				weaponList.add(weapon);
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
//			return weaponList;
//	}
//
//	@Override
//	public Weapon daoSelectWeapon(Connection conn,int id) throws SQLException 
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//			String sql = "select weapon_id,weapon_type,weapon_holderId,weapon_name,weapon_remark,weapon_buffName,weapon_buffPower,weapon_specialNumber  " +
//					" from weapon where weapon_id=?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//			
//			Weapon weapon = new Weapon();
//			 
//			weapon.setId	(id);
//			weapon.setType	(rs.getInt	("weapon_type"));
//			weapon.setHolderId	(rs.getInt	("weapon_holderId"));
//			weapon.setName	(rs.getString	("weapon_name"));
//			weapon.setRemark	(rs.getString	("weapon_remark"));
//			weapon.setBuffName	(rs.getInt	("weapon_buffName"));
//			weapon.setBuffPower	(rs.getInt	("weapon_buffPower"));
//			weapon.setSpecialNumber	(rs.getInt	("weapon_specialNumber"));
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
//		return weapon;
//	}
//
//}
