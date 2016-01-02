package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;

/**修改用户基础信息的servlet_★ 
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class UpdateStudyBaseInfoServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//修改学习情况的基本信息 
		//1判断已登陆账户和传参的旧密码是否匹配
		//2匹配了则修改新的签名和密码
		//3修改后清空session
		
		//初始化连接 用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		UserDao ud = new UserDaoImp();	
		
		//拿到旧的密码
		String oldPassword = request.getParameter("oldPassword");
		//拿到登录的玩家id
		int selfPlayerId = 0;
		selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		//拿到登录用户id 用户名 是否匹配
		int selfUserId = 0;
		String username = null;
		boolean check = false;
		try
		{
			selfUserId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);
			username = ud.daoSelectUserById(conn, selfUserId).getUsername();
			check = ud.daoCheckPassword(conn, username, oldPassword);
		}catch(Exception e){}
		
		//如果匹配可以进一步操作
		if(check)
		{
			//拿到新的签名 和 密码
			String remark = request.getParameter("remark");
			String newPassword = request.getParameter("newPassword");
			try 
			{
				ud.daoUpdateUserInfo(conn, selfUserId, newPassword, remark);//如果顺利修改就情况session回到首页
				PlayerDaoByUser pu = new PlayerDaoImpU();
				pu.daoUpdatePlayerBaseInfo(conn, selfPlayerId, remark, 1);
				
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
		else
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
