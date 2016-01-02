package fs.study.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import fs.study.dao.ActionDao;
import fs.study.model.Action;

public class ActionDaoImp implements ActionDao
{

	@Override
	public void daoAddAction(Connection conn, int userId, String content)
			throws SQLException 
	{ 
		PreparedStatement ps = null;
		
		String sql = "insert action(user_id,action_time,action_content,action_number)" +
				" values(?,?,?,?)";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, userId);
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		ps.setString(2, dateString);
		
		ps.setString(3, content);
		ps.setInt(4, 0); 
		
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
	public void daoDeleteAction(Connection conn, String[] actionId)
			throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "delete from action where action_id = ?";
		ps = conn.prepareStatement(sql);
		for (String idString : actionId) 
		{
			ps.setInt(1, Integer.parseInt(idString));
			ps.executeUpdate();
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

	@Override
	public void daoUpdateAction(Connection conn,int id) throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "update action set action_number=action_number+1 where action_id=?";
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
	public List<Action> daoSelectActionByUserId(Connection conn, int userId)
			throws SQLException 
	{
		Statement stat = null;
		ResultSet rs = null;
	
			stat = conn.createStatement();
			String sql = "select action_id,user_id,action_time,action_content,action_number " +
					" from action";
			rs = stat.executeQuery(sql);
			List<Action> actionList = new ArrayList<Action>();
			while(rs.next())
			{
				Action action = new Action();
				
				action.setId		(rs.getInt	("action_id"));
				action.setUserId	(rs.getInt	("user_id"));
				action.setTime		(rs.getString	("action_time"));
				action.setContent	(rs.getString	("action_content")); 
				action.setNumber	(rs.getInt	("action_number")); 
				
				actionList.add(action);
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
			return actionList;
	}

	@Override
	public Action daoSelectActionById(Connection conn, int id)
			throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select user_id,action_time,action_content,action_number " +
					" from action where action_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			 
			Action action = new Action();
			
			action.setId		(id);
			action.setUserId	(rs.getInt	("user_id"));
			action.setTime	(rs.getString	("action_time"));
			action.setContent	(rs.getString	("action_content")); 
			action.setNumber	(rs.getInt	("action_number")); 
			
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
			return action;
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
			String sql = "select count(action_id) as totalItem from action";
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

	@Override
	public List<Action> getActionList(Connection conn,int userId,int eachPage, int currentPage) 
	{ 
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Action> actionList = new ArrayList<Action>();
		try 
		{ 
			String sql = "select action_id,action_time,action_content,action_number " +
					" from action where user_id=? order by action_time desc limit ?,? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, (currentPage-1)*eachPage);
			ps.setInt(3, eachPage);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Action action = new Action();
				
				action.setId		(rs.getInt	("action_id"));
				action.setUserId	(userId);
				action.setTime		(rs.getString	("action_time"));
				action.setContent	(rs.getString	("action_content")); 
				action.setNumber	(rs.getInt	("action_number")); 
				
				actionList.add(action);
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
		return actionList;
	}

}
