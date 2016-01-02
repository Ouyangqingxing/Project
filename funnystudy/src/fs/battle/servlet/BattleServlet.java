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
import fs.battle.model.IoCPreparBattle1;
import fs.battle.model.Player;
import fs.common.util.FightEvents;
import fs.common.util.MySQLConnection;

/**战斗的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class BattleServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 	
		//拿到挑战方和被挑战方的玩家id
		int playerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		int bePlayerId = Integer.parseInt(request.getParameter("bePlayerId"));
		
		//拿到链接和玩家处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		PlayerDaoByUser pu = new PlayerDaoImpU(); 
  
		String battle = "";
		try //实际操作中如果这里报错那么直接不能进行战斗
		{
			Player p1 = pu.daoSelectPlayerAllInfo(conn,playerId);
			Player p2 = pu.daoSelectPlayerAllInfo(conn,bePlayerId); 
			
			battle = "挑战方："+p1.getName()+"，被挑战方："+p2.getName()+"。<br>"; 
			
			if(IoCPreparBattle1.checkBattle(p1,1) && IoCPreparBattle1.checkBattle(p2,0) && bePlayerId!=playerId)//双方有挑战资格
			{
				battle = battle + "双方玩家均有战斗资格！战斗开始！<br>";
				p1 = IoCPreparBattle1.preparBattle(p1);//拿到双方实际属性
				p2 = IoCPreparBattle1.preparBattle(p2);
				String battleDetail = FightEvents.Battle(p1, p2);
				battle = battle + battleDetail;
			}
			else
			{
				battle = battle + "无法进行战斗，请检查玩家状态以及玩家今日剩余挑战次数<br>";
			}
		} catch (SQLException e){} 
request.setAttribute("lastBattleInfo", battle); 
		
		request.getRequestDispatcher("ShowBattle.action").forward(request, response);
		return;		
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
