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
//import fs.battle.dao.TeamDaoByUser;
//import fs.battle.model.Team;
//import fs.common.util.MathMethod;
//
//public class TeamDaoImpU implements TeamDaoByUser
//{
//	@Override
//	public boolean daoCheckTeamName(Connection conn, String teamName)
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try
//		{ 
//			String sql = "select team_remark " +
//					" from team where team_name = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, teamName);
//			rs = ps.executeQuery();
//			rs.next();
//			
//			rs.getString("team_remark");
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
//
//	@Override
//	public boolean daoCheckAuthority(Connection conn, int playerId, int teamId)
//			throws SQLException 
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try
//		{ 
//			String sql = "select team_leaderid,team_viceleaderId " +
//					" from team where team_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, teamId);
//			rs = ps.executeQuery();
//			rs.next();
//			
//			int leaderId = rs.getInt("team_leaderid");
//			int viceLeaderId = rs.getInt("team_viceleaderId");
//			
//			if(playerId == leaderId || playerId == viceLeaderId)
//			{
//				return true;
//			}
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
//		return false;
//	}
//	
//	
//	@Override
//	public void daoAddTeam(Connection conn,int leaderId,int campId, String name, String remark)throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "insert team(camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign)" +
//					" values(?,?,?,?,?,?,?,?,?)";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, campId);
//			ps.setInt(2, leaderId);
//			ps.setInt(3, 0);
//			ps.setString(4, name);
//			ps.setString(5, remark);
//			ps.setInt(6, 0);
//			ps.setInt(7, 1);
//			ps.setInt(8, 1);
//			ps.setInt(9, 0);
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
//	public void daoDelete(Connection conn,String[] userids) throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "delete from team where team_id = ?";
//			ps = conn.prepareStatement(sql);
//			for (String idString : userids) 
//			{
//				ps.setInt(1, Integer.parseInt(idString));
//				ps.executeUpdate();
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
//	}
//
//	@Override
//	public void daoUpdateTeamViceLeader(Connection conn,int teamId, int viceLeaderId)throws SQLException
//	{
//		PreparedStatement ps = null;
//
//			String sql = "update team set team_viceLeaderId=? " +
//					"where team_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, viceLeaderId);
//			ps.setInt(2, teamId);
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
//	public void daoUpdateTeamRemark(Connection conn,int teamId, String remark)throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = "update team set team_remark=? " +
//					"where team_id=?";
//			ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, remark);
//			ps.setInt(2, teamId);
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
//	public void daoUpdateTeamLv(Connection conn,int teamId, int exp,Team t1) throws SQLException
//	{
//		//调用该类的查找方法拿到对应id的队伍目前 经验和等级
//		
//		int oldLv = t1.getLevel();
//		int oldExp = t1.getExp();
//		
//		//1、计算出所需经验
//		int needExp = MathMethod.getNeedExp(oldLv*2);//本级到下一级共需的经验 
//		//2、判断是否能升级	如果可以则 lv++ exp=0
//		if(oldExp+exp > needExp )
//		{
//			System.out.println("来自TeamDaoImpU的提示：你的帮会升级啦！");
//				
//			//提高各属性
//			PreparedStatement ps = null;
//			
//				String sql = "update team set team_exp=0,team_level=team_level+1 " +
//						"where team_id=?";
//				ps = conn.prepareStatement(sql);
//				ps.setInt(1, teamId); 
//				ps.executeUpdate();
//				
//				if(ps != null)
//				{
//					try 
//					{
//						ps.close();
//					} 
//					catch (SQLException e) 
//					{
//						System.out.println("发生数据库异常啦！");
//						e.printStackTrace();
//					}
//				}	
//		}
//		else
//		{
//			PreparedStatement ps = null;
//			
//				String sql = "update team set team_exp=? " +
//						"where team_id=?";
//				ps = conn.prepareStatement(sql);
//				ps.setInt(1, (oldExp+exp) );  
//				ps.setInt(2, teamId); 
//				ps.executeUpdate();
//			
//				if(ps != null)
//				{
//					try 
//					{
//						ps.close();
//					} 
//					catch (SQLException e) 
//					{
//						System.out.println("发生数据库异常啦！");
//						e.printStackTrace();
//					}
//				}
//			}
//			System.out.println("来自TeamDaoImpU的提示：你的帮会获得了 "+exp+" 经验值！");
//	}
//
//	@Override
//	public void daoUpdatePopulation(Connection conn,int teamId, int check) throws SQLException
//	{
//		PreparedStatement ps = null;
//		
//			String sql = null;
//			if(check == 9)//增加
//			{
//				sql = "update team set team_population=team_population+1 " +
//						"where team_id=?";
//			}
//			else if(check == 5)//减少
//			{
//				sql = "update team set team_population=team_population-1 " +
//						"where team_id=?";
//			}
//			else
//			{  System.out.println("【来自TeamDaoImpU的提示】输入的参数有误！"); 	}
//			
//			ps = conn.prepareStatement(sql); 
//			ps.setInt(1, teamId); 
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
//	public void daoUpdateSign(Connection conn,int teamId, int[] totleSign) throws SQLException
//	{
//		int result = 0 ;
//		
//		for(int i = 0 ; i<totleSign.length ; i++)
//		{
//			result = result + totleSign[i];
//		}
//		
//		result = (int)(result / totleSign.length);
//		
//		PreparedStatement ps = null;
//		
//			String sql = null;
//			if( result<101 && result > -1)
//			{
//				sql = "update team set team_sign=? " +
//					"where team_id=?";
//			}
//			else
//			{  System.out.println("【来自TeamDaoImpU的提示】输入的参数有误！"); 	}
//			
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, result);
//			ps.setInt(2, teamId);
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
//	public int daoSelectTeamLv(Connection conn,int id) throws SQLException
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//			String sql = "select team_level " +
//					" from team where team_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//			int lv = rs.getInt	("team_level") ;  
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
//			return lv;
//	}
//
//	@Override
//	public Team daoSelectTeaminfo(Connection conn,int id) throws SQLException
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	 
//			String sql = "select camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign " +
//					" from team where team_id = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			Team team = new Team();
//			 
//			team.setId	( id );
//			team.setCampId	(rs.getInt	("camp_id"));
//			team.setLeaderId	(rs.getInt	("team_leaderId"));
//			team.setViceLeaderId	(rs.getInt	("team_viceLeaderId"));
//			team.setName	(rs.getString	("team_name"));
//			team.setRemark	(rs.getString	("team_remark"));
//			team.setExp	(rs.getInt	("team_exp"));
//			team.setLevel	(rs.getInt	("team_level"));
//			team.setPopulation	(rs.getInt	("team_population"));
//			team.setSign	(rs.getInt	("team_sign"));
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
//			return team;
//	}
//
//	@Override
//	public List<Team> daoSelectAllTeamInfo(Connection conn)throws SQLException
//	{
//		Statement stat = null;
//		ResultSet rs = null;
//		
//			stat = conn.createStatement();
//			String sql = "select team_id,camp_id,team_leaderId,team_viceLeaderId,team_name,team_remark,team_exp,team_level,team_population,team_sign  " +
//					" from team";
//			rs = stat.executeQuery(sql);
//			List<Team> teamList = new ArrayList<Team>();
//			while(rs.next())
//			{
//				Team team = new Team();
//				 
//				team.setId	(rs.getInt	("team_id"));
//				team.setCampId	(rs.getInt	("camp_id"));
//				team.setLeaderId	(rs.getInt	("team_leaderId"));
//				team.setViceLeaderId	(rs.getInt	("team_viceLeaderId"));
//				team.setName	(rs.getString	("team_name"));
//				team.setRemark	(rs.getString	("team_remark"));
//				team.setExp	(rs.getInt	("team_exp"));
//				team.setLevel	(rs.getInt	("team_level"));
//				team.setPopulation	(rs.getInt	("team_population"));
//				team.setSign	(rs.getInt	("team_sign"));
//				
//				teamList.add(team);
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
//			return teamList;
//	}
//
//	@Override
//	public int daoSelectTeamIdByLeaderId(Connection conn, int playerId)
//			throws SQLException 
//	{ 
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//	 
//			String sql = "select team_id " +
//					" from team where team_leaderid = ? ";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, playerId);
//			rs = ps.executeQuery();
//			
//			int result = 0;
//			rs.next();
//			result =  rs.getInt	("team_id"); 
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
//			return result;
//	}
//
//
//}
