package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.common.util.MySQLConnection;
import fs.study.dao.ActionDao;
import fs.study.dao.UserDao;
import fs.study.daoImp.ActionDaoImp;
import fs.study.daoImp.UserDaoImp;

/**删除动态的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class DeleteActionServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try
		{
			//拿到链接 动态处理类
			Connection conn = MySQLConnection.getMySQLConnection();	
			ActionDao ad = new ActionDaoImp();
			UserDao ud = new UserDaoImp();
			//拿到传来的动态id 已登陆的玩家id 判断发表动态的动态对应的玩家是否为该已登陆玩家id 是继续操作，否则不做操作
			int actionId = Integer.parseInt(	request.getParameter("actionId")	);
			int selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			int actionUserId = ad.daoSelectActionById(conn, actionId).getUserId();//该动态的发表用户id
			int userId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);//登陆的用户id
			if(actionUserId == userId)
			{
				String[] arr = {actionId+""};
				ad.daoDeleteAction(conn, arr);
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
