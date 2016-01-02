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

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.study.dao.MessageDao;
import fs.study.dao.UserDao;
import fs.study.model.Message;
import fs.study.model.MessageX;

public class MessageDaoImp implements MessageDao
{
	@Override
	public void daoAddMessage(Connection conn, int userId, int beUserId,
			String content) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "insert Message(user_id,beuser_id,message_content,message_time)" +
				" values(?,?,?,?)";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, userId);
		ps.setInt(2, beUserId);
		ps.setString(3, content);

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = df.format(date);
		ps.setString(4, dateString);
		
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
	public void daoDeleteMessage(Connection conn, String[] messageId)
			throws SQLException
	{ 
		PreparedStatement ps = null;
		String sql = "delete from message where message_id = ?";
		ps = conn.prepareStatement(sql);
		for (String idString : messageId) 
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
	public List<Message> daoSelectMessageByUserId(Connection conn, int userId)
			throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
	 
			String sql = "select message_id,beuser_id,message_content,message_time  " +
					" from message where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery(); 
			
			List<Message> messageList = new ArrayList<Message>();
			while(rs.next())
			{
				Message message = new Message();
				
				message.setId		(rs.getInt	("message_id"));
				message.setUserId		(userId);
				message.setBeUserId	(rs.getInt	("beuser_id"));
				message.setContent	(rs.getString	("message_content")); 
				message.setTime	(rs.getString	("message_time")); 
				
				messageList.add(message);
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
			return messageList;
	}

	@Override
	public Message daoSelectMessageById(Connection conn, int id)
			throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select user_id,beuser_id,message_content,message_time " +
					" from message where message_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			 
			Message message = new Message();
			
			message.setId		(id);
			message.setUserId		(rs.getInt	("user_id"));
			message.setBeUserId	(rs.getInt	("beuser_id"));
			message.setContent	(rs.getString	("message_content")); 
			message.setTime	(rs.getString	("message_time"));
			
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
			return message;
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
			String sql = "select count(message_id) as totalItem from message";
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
	public List<MessageX> getMessageXList(Connection conn,int beUserId,int eachPage, int currentPage) 
	{ 
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MessageX> messageXList = new ArrayList<MessageX>();
		try 
		{ 
			String sql = "select message_id,message_time,message_content,user_id " +
					" from message where beuser_id=? order by message_time desc limit ?,? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, beUserId);
			ps.setInt(2, (currentPage-1)*eachPage);
			ps.setInt(3, eachPage);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				MessageX messageX = new MessageX();
				
				messageX.setId		(rs.getInt	("message_id"));
				messageX.setUserId	(rs.getInt	("user_id"));
				messageX.setTime		(rs.getString	("message_time"));
				messageX.setContent	(rs.getString	("message_content")); 				
				messageX.setBeUserId	(beUserId); 
				
				UserDao ud = new UserDaoImp();
				PlayerDaoByUser pu = new PlayerDaoImpU();
				int userId =  rs.getInt("user_id");
				int playerId = ud.daoSelectUserById(conn, userId).getPlayerId();
				messageX.setUserName( ud.daoSelectUserById(conn,userId).getUsername() );
				messageX.setUserLv(pu.daoSelectPlayerAllInfo(conn,playerId).getLv());
				messageX.setUserFace(Integer.parseInt(ud.daoSelectUserById(conn, userId).getFace()));
				messageX.setPlayerId(playerId);
				messageXList.add(messageX);
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
		return messageXList;
	}
}
