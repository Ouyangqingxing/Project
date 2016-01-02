package fs.battle.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.dao.WuGongDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.battle.daoImp.WuGongDaoImpU;
import fs.common.util.MySQLConnection;

/**处理玩家获得武功的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class GetWuGongServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//隐藏页面获得武功，1判断是否登陆，是继续 否跳转到登陆页面
		//2判断是否已经习得武功 否继续 是跳转到战斗页面
		
		//拿到链接和已登陆玩家的id
		Connection conn = MySQLConnection.getMySQLConnection();	 
		int loginPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		
		try
		{
			PlayerDaoByUser pu = new PlayerDaoImpU();
			//只有还没有武功时才可以在这里习得武功
			if(pu.daoSelectPlayerAllInfo(conn, loginPlayerId).getWugong().size()==1)
			{ 
				//获得所有
				WuGongDaoByUser wu = new WuGongDaoImpU();
				int number = wu.daoSelectWuGongNumber(conn); 
				boolean get = true;
				while(get)
				{ 
					Random random = new Random();
			        int WuGongId = random.nextInt(number)%(number-1+1) + 1;
					if (pu.daoUpdatePlayerWuGong(conn, loginPlayerId, WuGongId, 9))//只有确定拿到武功后才退出循环
					{
						get=false;
					}
				}
			} 
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		catch(Exception e){}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
