package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;

/**更新玩家头像的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class UpdateUserFaceServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//拿到链接 用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	
		UserDao ud = new UserDaoImp();
		//拿到传参新头像 以及已登陆的玩家id
		String newFace = request.getParameter("newFace"); 
		int selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		
		try 
		{
			int userId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);
			ud.daoUpdateUserFace(conn, userId, newFace);
			
			request.getSession().invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} 
		catch (SQLException e)
		{
			request.getRequestDispatcher("/selfstudy.jsp").forward(request, response);
			return;
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
