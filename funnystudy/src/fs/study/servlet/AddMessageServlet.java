package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.common.util.MySQLConnection;
import fs.study.dao.MessageDao;
import fs.study.dao.UserDao;
import fs.study.daoImp.MessageDaoImp;
import fs.study.daoImp.UserDaoImp;

/**新增一条留言的servlet_★ 
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class AddMessageServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//初始化连接 留言 用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		MessageDao md = new MessageDaoImp();
		UserDao ud = new UserDaoImp();
		//拿到参数留言内容 留言者用户玩家id　被留言者用户玩家id
		String messageContent = request.getParameter("messageContent");
		int userId = 0;
		int playerId = -2;
		int beUserId = -1;
		int bePlayerId = 0;
		try
		{
			playerId= (Integer) request.getSession().getAttribute("selfPlayerId");
			userId = ud.daoSelectIdByPlayerId(conn, playerId);
			
			try
			{
				bePlayerId = (Integer) request.getSession().getAttribute("playerId");
				bePlayerId = Integer.parseInt(	request.getParameter("playerId") );//如果有参数说明给自己留言 修改被留言者，否则说明不修改	
			}catch(Exception e){}
			
			beUserId = ud.daoSelectIdByPlayerId(conn, bePlayerId);
			//userId留言者--当前登录的用户Id  beUserId被留言者--当前查看的用户id
			md.daoAddMessage(conn, userId, beUserId, messageContent);
		}
		catch(Exception e ){e.printStackTrace();}	
 
		//新增后根据当前的登录和查看的玩家id，来判断是在给自己留言还是给别人留言，从而跳转回不同的页面
		if(playerId == bePlayerId)
		{
			//给自己留言 跳回自己的页面 传参数 selfPlayerId  值为playerId
			request.getRequestDispatcher("ShowSelfStudy.action?selfPlayerId=playerId").forward(request, response);
			return;
		}
		else
		{
			//给别人留言 跳回别人的页面 传参数playerId 值为 bePlayerId
			request.getRequestDispatcher("ShowStudy.action?playerId=bePlayerId").forward(request, response);
			return;			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 
		this.doGet(request, response);
	} 
}
