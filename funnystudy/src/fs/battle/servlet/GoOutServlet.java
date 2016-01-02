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
import fs.common.util.ListAndString;
import fs.common.util.MySQLConnection;

/**处理玩家进行外出的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class GoOutServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//拿到地点和已登陆玩家的id
		int where = 0;
		int playerId = 0;
		try{
			playerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			where = Integer.parseInt(request.getParameter("where"));}
		catch(Exception e){}
		
		if(where == 1 && playerId != 0){}
		else if(where == 2 && playerId != 0){}
		
		else if(where == 3 && playerId != 0)
		{
			//消耗20000灵气 等级变为1 事务
			Connection conn = MySQLConnection.getMySQLConnection();	 
			PlayerDaoByUser pu = new PlayerDaoImpU();
			int lingqi = 0;
			try
			{
				lingqi = pu.daoSelectPlayerAllInfo(conn, playerId).getCoreCheck();
			}catch(Exception e){}
			
			if(lingqi > 20000)
			{
				try 
				{
					conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
					pu.daoUpdatePlayerCoreCheck(conn, playerId, 1);
					pu.daoUpdatePlayerLV(conn, playerId);
					//-3魔  -2鬼  -1 妖  0人  1侠   2仙  3神 这里做一个操作，把它+1
					int a = ListAndString.StringToList(pu.daoSelectPlayerWEB(conn, playerId, 3)).get(0)+1;
					pu.daoUpdatePlayerLv(conn, playerId, a+",");
					conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
				} 
				catch (SQLException e) 
				{   
					try {conn.rollback();} catch (SQLException e1) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
				}
			}else{}
		}
		else if(where == 4 && playerId != 0)
		{
			//消耗1万煞气 等级变为1
			Connection conn = MySQLConnection.getMySQLConnection();	 
			PlayerDaoByUser pu = new PlayerDaoImpU();
			int shaqi = 0;
			try
			{
				shaqi = pu.daoSelectPlayerAllInfo(conn, playerId).getCoreCheck();
			}catch(Exception e){}
			
			if(shaqi < -10000)
			{
				try 
				{
					conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
					pu.daoUpdatePlayerCoreCheck(conn, playerId, 0);
					pu.daoUpdatePlayerLV(conn, playerId);
					//-3魔  -2鬼  -1 妖  0人  1侠   2仙  3神 这里做一个操作，把它+1
					int a = ListAndString.StringToList(pu.daoSelectPlayerWEB(conn, playerId, 3)).get(0)-1;
					pu.daoUpdatePlayerLv(conn, playerId, a+",");
					
					conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
				} 
				catch (SQLException e) 
				{   
					try {conn.rollback();} catch (SQLException e1) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
				}
			}else{}
		}
		else{}
		
		request.getRequestDispatcher("ShowBattle.action").forward(request, response);
		return;		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
