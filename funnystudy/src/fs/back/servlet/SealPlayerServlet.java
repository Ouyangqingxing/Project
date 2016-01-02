package fs.back.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByManager;
import fs.battle.daoImp.PlayerDaoImpM;
import fs.common.util.MySQLConnection;

/**@author Jason_★
 *封玩家号的Servlet
 */
@SuppressWarnings("serial")
public class SealPlayerServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//初始化连接和玩家处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		PlayerDaoByManager pu = new PlayerDaoImpM();
		//拿到前台传来的参数，即将要封的玩家id
		int playerId = Integer.parseInt( request.getParameter("playerId") );
		try 
		{//执行操作
			pu.daoUpdatePlayerState(conn, playerId, 0);
		} catch (SQLException e){}
		//转到展示玩家的servlet
		request.getRequestDispatcher("ShowBackPlayer.action").forward(request, response);
		return;		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
