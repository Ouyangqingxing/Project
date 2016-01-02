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

/**删除留言的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class DeleteMessageServlet extends HttpServlet 
{ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try
		{
			//拿到链接 留言板处理类
			Connection conn = MySQLConnection.getMySQLConnection();	
			MessageDao md = new MessageDaoImp();
			UserDao ud = new UserDaoImp();
			//拿到留言板id 已登陆的玩家id
			int messageId = Integer.parseInt(	request.getParameter("messageId")	);
			int selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			int messageUserId = md.daoSelectMessageById(conn, messageId).getBeUserId();
			int userId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);
			
			if(messageUserId == userId)
			{
				String[] arr = {messageId+""};
				md.daoDeleteMessage(conn, arr);
			}
		}catch(Exception e){}
		 
		request.getRequestDispatcher("ShowSelfStudy.action?selfPlayerId=selfPlayerId").forward(request, response);
		return;
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
