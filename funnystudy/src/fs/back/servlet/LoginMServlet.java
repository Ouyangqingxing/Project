package fs.back.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import fs.common.util.MySQLConnection;
import fs.study.daoImp.ManagerDaoImp;

/**@author Jason_★
 *处理管理员登陆的Servlet
 */
@SuppressWarnings("serial")
public class LoginMServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{		
		//通过登陆页面login.jsp表单提交，拿到用户名和密码两个参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//初始化数据库连接和管理员处理类
		ManagerDaoImp md = new ManagerDaoImp();	 
		Connection conn = MySQLConnection.getMySQLConnection();	 
		//判断管理员的用户名密码是否匹配
		boolean flag = md.daoCheckPassword(conn,name, password); 
		if(flag)
		{		
			//匹配成功，跳转至后台管理页面，并向session域里添加登陆名
request.getSession().setAttribute("selfManagerName", name);//登陆玩家的昵称 

			response.sendRedirect("ShowBackPlayer.action");
			return;
		}
		else 
		{ 
			//没有匹配成功，返回到登陆页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
