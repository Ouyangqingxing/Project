package fs.battle.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;  

import fs.battle.dao.PlayerDaoByManager;
import fs.battle.model.Player;
import fs.common.util.ListAndString;

/**PlayerDaoByManager的实现类
 * @author Jason_★ 
 */ 
public class PlayerDaoImpM implements PlayerDaoByManager
{
	@Override
	public void daoUpdatePlayerState(Connection conn,int playerId, int state) throws SQLException
	{
		PreparedStatement ps = null;

			String sql = "update player set player_state=? where player_id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, state);
			ps.setInt(2, playerId); 
			
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
	public List<Player> getPlayerList(Connection conn, int eachPage,
			int currentPage)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Player> playerList = new ArrayList<Player>();
		try 
		{ 
			String sql = "select player_id,player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_pk,player_power,player_ranking from player order by player_lv desc limit ?,? ";				
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, (currentPage-1)*eachPage);
			ps.setInt(2, eachPage); 
			
			rs = ps.executeQuery();
			
			 
			while(rs.next())
			{
				Player player = new Player();
				
				player.setId		(rs.getInt	("player_id"));
				player.setName		(rs.getString	("player_name"));
				player.setSex		(rs.getInt	("player_sex"));
				player.setRemark	(rs.getString	("player_remark"));
				player.setHp		(rs.getInt	("player_hp"));
				player.setAtk		(rs.getInt	("player_atk"));
				player.setDef		(rs.getInt	("player_def"));
				player.setSpd		(rs.getInt	("player_spd"));
				player.setRp		(rs.getInt	("player_rp"));
				player.setCritical	(rs.getInt	("player_critical"));
				player.setDodge		(rs.getInt	("player_dodge"));
				player.setLv		(rs.getInt	("player_lv"));
				player.setExp		(rs.getInt	("player_exp"));
				
				player.setWugong	(ListAndString.StringToList( rs.getString	("player_wugong")));
				player.setEquipment	(ListAndString.StringToList( rs.getString	("player_equipment")));
				player.setBackpack	(ListAndString.StringToList( rs.getString	("player_backpack")));
				
				player.setCampId		(rs.getInt	("player_campId"));
				player.setTeamId		(rs.getInt	("player_teamId"));
				player.setCoreCheck		(rs.getInt	("player_coreCheck"));
				player.setState		(rs.getInt	("player_state"));
				player.setBuff		(rs.getInt	("player_buff"));
				player.setLastFightChance		(rs.getInt	("player_lastFightChance"));
				player.setXiuwei(rs.getInt	("player_xiuwei"));
				player.setPoints(rs.getInt	("player_points"));
				player.setRanking(rs.getInt	("player_ranking"));
				player.setPk(rs.getInt	("player_pk"));
				player.setPower(rs.getInt	("player_power"));
				
				playerList.add(player);
			}
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
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return playerList;
	}
	
	@Override
	public int getTotalItem(Connection conn) 
	{ 
		Statement stat = null;
		ResultSet rs = null;
		int totalItem = 0;
		try 
		{ 
			stat = conn.createStatement();
			String sql = "select count(player_id) as totalItem from player";
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
	
//	@Override
//	public boolean daoCheckUserName(Connection conn,String name)
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try
//		{ 
//			String sql = "select player_remark " +
//					" from player where player_name = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, name);
//			rs = ps.executeQuery();
//			rs.next();
//			
//			rs.getString("player_remark");
//		} 
//		catch (SQLException e) 
//		{ 
//			return false; 
//		} 
//		finally
//		{
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
//		}
//		return true;
//	}
//	
//	@Override
//	public int daoAddPlayer(Connection conn,String name,String remark,int hp,int atk,int def,int spd,int rp,int critical,int dodge ,int lv,String wugong,String weapon,int campId,int coreCheck) throws SQLException
//	{ 
//		Random r1 = new Random();
//		 campId =r1.nextInt(3)+1 ;
//		
//		PreparedStatement ps = null;
//		name = "★" + name + "★";
//
//			String sql = "insert player(player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points)" +
//					" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setInt(2, 1);
//			ps.setString(3, remark);
//			
//			ps.setInt(4,100);
//			ps.setInt(5,20);
//			ps.setInt(6,10);
//			ps.setInt(7,1);
//			ps.setInt(8,0);//rp0
//			ps.setInt(9,0);
//			ps.setInt(10,10);
//			ps.setInt(11,1);
//			ps.setInt(12,0);
//			
//			List<Integer> l1 = new ArrayList<Integer>();
//			l1.add(0);
//			String s1 = ListAndString.ListToString(l1);
//			
//			ps.setString(13,s1);
//			ps.setString(14,s1);
//			ps.setString(15,s1);
//			ps.setInt(16,campId);//
//			ps.setInt(17,0);
//			ps.setInt(18,0);
//			ps.setInt(19,1);
//			ps.setInt(20,0);
//			ps.setInt(21,10);
//			ps.setInt(22,0);
//			ps.setInt(23,0);
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
//			return campId;
//	}
//	
//	@Override
//	public void daoUpdatePlayerAllInfo(Connection conn,int id, String name, int sex,
//			String remark, int hp, int atk, int def, int spd, int rp,
//			double critical, int dodge, int exp, int coreCheck, int buff,
//			int lastfightchance) throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "update player set player_name=?,player_sex=?,player_remark=?,player_hp=?,player_atk=?,player_def=?,player_spd=?,player_rp=?, player_critical=?,player_dodge=?,player_exp=?, player_coreCheck=?,player_buff=?,player_lastfightchance=? " +
//					" where player_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, name);
//			ps.setInt(2, sex); 
//			ps.setString(3, remark);
//			ps.setInt(4, hp);
//			ps.setInt(5, atk);
//			ps.setInt(6, def);
//			ps.setInt(7, spd);
//			ps.setInt(8, rp);
//			ps.setDouble(9, critical);
//			ps.setInt(10, dodge);
//			ps.setInt(11, exp);
//			ps.setInt(12, coreCheck);
//			ps.setInt(13, buff);
//			ps.setInt(14, lastfightchance);
//			ps.setInt(15, id);
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
//	public List<Player> daoSelectAllPlayerInfo(Connection conn)throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//	
//			stat = conn.createStatement();
//			String sql = "select player_id,player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points " +
//					" from player";
//			rs = stat.executeQuery(sql);
//			List<Player> playerList = new ArrayList<Player>();
//			while(rs.next())
//			{
//				Player player = new Player();
//				
//				player.setId		(rs.getInt		("player_id"));
//				player.setName		(rs.getString	("player_name"));
//				player.setSex		(rs.getInt	("player_sex"));
//				player.setRemark	(rs.getString	("player_remark"));
//				player.setHp		(rs.getInt	("player_hp"));
//				player.setAtk		(rs.getInt	("player_atk"));
//				player.setDef		(rs.getInt	("player_def"));
//				player.setSpd		(rs.getInt	("player_spd"));
//				player.setRp		(rs.getInt	("player_rp"));
//				player.setCritical	(rs.getInt	("player_critical"));
//				player.setDodge		(rs.getInt	("player_dodge"));
//				player.setLv		(rs.getInt	("player_lv"));
//				player.setExp		(rs.getInt	("player_exp"));
//				player.setWugong	(ListAndString.StringToList( rs.getString	("player_wugong")));
//				player.setEquipment	(ListAndString.StringToList( rs.getString	("player_equipment")));
//				player.setBackpack	(ListAndString.StringToList( rs.getString	("player_backpack")));
//				player.setCampId		(rs.getInt	("player_campId"));
//				player.setTeamId		(rs.getInt	("player_teamId"));
//				player.setCoreCheck		(rs.getInt	("player_coreCheck"));
//				player.setState		(rs.getInt	("player_state"));
//				player.setBuff		(rs.getInt	("player_buff"));
//				player.setLastFightChance		(rs.getInt	("player_lastFightChance"));
//				player.setXiuwei(rs.getInt	("player_xiuwei"));
//				player.setPoints(rs.getInt	("player_points"));
//				
//				playerList.add(player);
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
//			return playerList;
//	}
//
//	@Override
//	public Player daoSelectPlayerAllInfo(Connection conn,int id)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select  player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points from player where player_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//			 
//			Player player = new Player();
//			
//			player.setId		(id);
//			player.setName		(rs.getString	("player_name"));
//			player.setSex		(rs.getInt	("player_sex"));
//			player.setRemark	(rs.getString	("player_remark"));
//			player.setHp		(rs.getInt	("player_hp"));
//			player.setAtk		(rs.getInt	("player_atk"));
//			player.setDef		(rs.getInt	("player_def"));
//			player.setSpd		(rs.getInt	("player_spd"));
//			player.setRp		(rs.getInt	("player_rp"));
//			player.setCritical	(rs.getInt	("player_critical"));
//			player.setDodge		(rs.getInt	("player_dodge"));
//			player.setLv		(rs.getInt	("player_lv"));
//			player.setExp		(rs.getInt	("player_exp"));
//			player.setWugong	(ListAndString.StringToList( rs.getString	("player_wugong")));
//			player.setEquipment	(ListAndString.StringToList( rs.getString	("player_equipment")));
//			player.setBackpack	(ListAndString.StringToList( rs.getString	("player_backpack")));
//			player.setCampId		(rs.getInt	("player_campId"));
//			player.setTeamId		(rs.getInt	("player_teamId"));
//			player.setCoreCheck		(rs.getInt	("player_coreCheck"));
//			player.setState		(rs.getInt	("player_state"));
//			player.setBuff		(rs.getInt	("player_buff"));
//			player.setLastFightChance		(rs.getInt	("player_lastFightChance"));
//			player.setXiuwei(rs.getInt	("player_xiuwei"));
//			player.setPoints(rs.getInt	("player_points"));	
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
//			return player;
//	}
//
//	@Override
//	public String daoSelectPlayerName(Connection conn,int id)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select  player_name from player where player_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//			 
//			String name = rs.getString("player_name");
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
//			return name;
//	}
//
//	@Override
//	public int daoSelectPlayerIdByName(Connection conn,String name)throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	
//			String sql = "select  player_id from player where player_name = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, name);
//			rs = ps.executeQuery();
//			rs.next();
//			 
//			int id = rs.getInt("player_id");	
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
//			return id;
//	}
}
