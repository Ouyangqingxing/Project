package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;
 
/**处理用户登录的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{		
		//拿到参数用户名和密码
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		
		//初始化用户 玩家处理类 链接 判断是否
		UserDao ud=new UserDaoImp();
		PlayerDaoByUser pu = new PlayerDaoImpU();
		Connection conn = MySQLConnection.getMySQLConnection();	 
		boolean flag = ud.daoCheckPassword(conn,username, password); 
		if(flag)
		{
			int userId = 0;
			int playerId = 0;
			int playerlv = 1;
			int face = 1; 
			try
			{
				//依次拿到用户id 玩家id 玩家等级 头像 
				userId = ud.daoSelectIdByUserName(conn, username);
				playerId = ud.daoSelectUserById(conn,userId).getPlayerId();
				playerlv = pu.daoSelectPlayerAllInfo(conn, playerId).getLv(); 
				face = Integer.parseInt(ud.daoSelectUserById(conn, userId).getFace());
			}
			catch(Exception e)
			{e.printStackTrace();} 
				
			//验证成功，跳转至主页，并向session域里添加用户名 等级，用于展示
			//request.setAttribute("selfUserName", username);
			//request.setAttribute("selfPlayerlv", playerlv); 
request.getSession().setAttribute("selfPlayerInfo", username+"   Lv."+playerlv);//登陆玩家的昵称和等级
request.getSession().setAttribute("selfPlayerId", playerId);//登陆玩家的id 
request.getSession().setAttribute("selfFace", face); 
 
			request.getRequestDispatcher("ShowMain.action?ranking=3").forward(request, response);
			return;
		}
		else 
		{
			//验证失败，刷新登陆页面，发送错误信息
request.setAttribute("errorL", "用户名或密码错误");
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
