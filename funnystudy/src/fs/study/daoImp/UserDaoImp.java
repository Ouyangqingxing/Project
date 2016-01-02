package fs.study.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fs.study.dao.UserDao;
import fs.study.model.User;

public class UserDaoImp implements UserDao
{

	@Override
	public void daoAddUser(Connection conn, String username, String password,
			int playerId, String remark, int state, String face)
			throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "insert user(user_name,user_password,player_id,user_remark,user_state,user_face)" +
				" values(?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setInt(3, playerId);
		ps.setString(4, remark);
		ps.setInt(5, state);
		ps.setString(6, face); 
		
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
	public void daoUpdateUserPlayerId(Connection conn, int id, int playerId)
			throws SQLException
	{
		PreparedStatement ps = null;
		String sql = "update user set player_id=? where user_id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, playerId);
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
	
//	@Override
//	public void daoUpdateUserState(Connection conn, int id, int state)
//			throws SQLException 
//	{
//		PreparedStatement ps = null;
//		String sql = "update user set user_state=? where user_id=?";
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, state);
//		ps.setInt(2, id); 
//		
//		ps.executeUpdate();
//
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
//	}
	
	@Override
	public void daoUpdateUserInfo(Connection conn,int id, String password,
			String remark) throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "update user set user_remark=? , user_password = ? where user_id=?";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, remark);
		ps.setString(2, password); 
		ps.setInt(3, id); 
		
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
	public void daoUpdateUserFace(Connection conn,int id, String face)
			throws SQLException
	{
		PreparedStatement ps = null;
		String sql = "update user set user_face=? where user_id=?";
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, face);
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
	public boolean daoCheckUserName(Connection conn, String username)
	{
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try 
		{
			String sql = "select user_password " +
					" from user where user_name = ? ";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
				rs.next();
				
				rs.getString("user_password"); 
		} 
		catch (SQLException e1) 
		{ 
			return true; 
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
		return false;
	}

	@Override
	public boolean daoCheckPassword(Connection conn, String username,
			String password)
	{  
		String sql = "select user_name,user_password from user where user_name=? and user_password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try 
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next())//如果有结果返回true
			{
				return true;
			} 
		}
		catch (SQLException e) 
		{
			System.out.println("发生数据库异常啦！");
			e.printStackTrace();
		} 
		finally 
		{
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
		}
		return false;//默认错误
	}

	
	@Override
	public int daoSelectIdByUserName(Connection conn, String userName)
			throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

			String sql = "select user_id from user where user_name = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			rs.next();		 
			int id = rs.getInt("user_id");
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
			return id;
		} 
	 
	@Override
	public int daoSelectIdByPlayerId(Connection conn, int playerId)
			throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

			String sql = "select user_id from user where player_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			rs.next();		 
			int id = rs.getInt("user_id");
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
			return id;
	}

	@Override
	public User daoSelectUserById(Connection conn, int id)
			throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select user_name,user_password,player_id,user_remark,user_state,user_face " +
					" from user where user_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			 
			User user = new User();
			
			user.setId		(id);
			user.setUsername		(rs.getString	("user_name"));
			user.setPassword	(rs.getString	("user_password"));
			user.setPlayerId	(rs.getInt	("player_id"));
			user.setRemark	(rs.getString	("user_remark"));
			user.setState		(rs.getInt	("user_state"));
			user.setFace		(rs.getString	("user_face")); 

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
			return user;
	} 
}
