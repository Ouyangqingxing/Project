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

/**新增一个动态的servlet_★ 
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class AddActionServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//初始化链接 动态 用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		ActionDao ad = new ActionDaoImp();
		UserDao ud = new UserDaoImp();
		//拿到传来的动态内容参数
		String actionContent = request.getParameter("actionContent");
		int userId = 0; 
		int playerId = 0;
		try
		{
			//拿到登陆的玩家的id-查到对应的用户id-进行新增操作。
			playerId= (Integer) request.getSession().getAttribute("selfPlayerId");
			userId = ud.daoSelectIdByPlayerId(conn, playerId); 
			ad.daoAddAction(conn, userId, actionContent);			 
		}
		catch(Exception e ){}	
		
		request.getRequestDispatcher("ShowSelfStudy.action?selfPlayerId=playerId").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
