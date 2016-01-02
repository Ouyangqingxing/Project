package fs.battle.servlet;

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

/**修改战护的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class UpdatePkServlet extends HttpServlet 
{ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 
		//初始化连接 拿到已登陆的玩家id 将要修改的值
		Connection conn = MySQLConnection.getMySQLConnection();	 
		int selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		int pk = Integer.parseInt(request.getParameter("pk"));
		PlayerDaoByUser pu = new PlayerDaoImpU();
		
		if(pk==0 || pk==1)//考虑安全性 仅有1 0才可以操作
		{
			try 
			{
				pu.daoUpdatePlayerPK(conn, selfPlayerId, pk);
			} catch (SQLException e){}
		}
		request.getRequestDispatcher("ShowBattle.action").forward(request, response);
		return;	
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 
		this.doGet(request, response);
	}
}
