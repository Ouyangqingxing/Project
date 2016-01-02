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

/**处理玩家加点逻辑的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class ChangeCheckServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int playerId = 0 ;	//登陆的玩家id
		int check = -1;		//将要进行的业务 1分配点数 0将修为转换为修炼点
		int points = 0;
		try
		{
			//拿到链接 玩家处理类 已登陆玩家 业务选择 玩家剩余分配点
			Connection conn = MySQLConnection.getMySQLConnection();	
			PlayerDaoByUser pu = new PlayerDaoImpU();
			playerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			check = Integer.parseInt(request.getParameter("check"));
			points = pu.daoSelectPlayerAllInfo(conn, playerId).getPoints();
		}
		catch(Exception e){}
		 
		if(check == 1 && playerId != 0)//提交表单，将表单的参数取到，判断是否合理，合理则事务修改各个属性
		{
			Connection conn = MySQLConnection.getMySQLConnection();	 
			PlayerDaoByUser pu = new PlayerDaoImpU();
			int hp = -1;
			int atk = -1;
			int def = -1;
			int spd = -1;
			try
			{
				//拿到表单中的4个点数
				hp = Integer.parseInt(request.getParameter("hp"));
				atk = Integer.parseInt(request.getParameter("atk"));
				def = Integer.parseInt(request.getParameter("def"));
				spd = Integer.parseInt(request.getParameter("spd"));
			}catch(Exception e){}	
			
			//各个分配点数必须大于0  并且和小于等于总的可用的修炼点
			if( (hp+atk+def+spd) <=  points && hp >= 0  && atk >= 0 && def >= 0 && spd >= 0)
			{
				try 
				{
					conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
					//减少输入的总和的修炼点，然后一次修改基础属性
					
					pu.daoUpdatePlayerPoint(conn, playerId, (hp+atk+def+spd), 5);
					pu.daoUpdatePlayerBaseValue(conn, playerId, hp*10, atk, def, spd);
					pu.daoUpdatePlayerPower(conn, playerId);
					
					conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
				} 
				catch (SQLException e) 
				{   
					try {conn.rollback();} catch (SQLException e1) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
				}
			}
		}
		else if(check == 0 && playerId != 0)//将修为全部转化为修炼点 事务
		{
			Connection conn = MySQLConnection.getMySQLConnection();	 
			try 
			{
				conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
				 
				PlayerDaoByUser pu = new PlayerDaoImpU();
				
				int xiuwei = pu.daoSelectPlayerAllInfo(conn, playerId).getXiuwei();
				
				pu.daoUpdatePlayerPoint(conn, playerId, (int)(xiuwei/1000),9 );
				pu.daoUpdatePlayerXiuWei(conn, playerId, xiuwei, 5);
				
				conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
			} 
			catch (SQLException e) 
			{   
				try {conn.rollback();} catch (SQLException e1) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
			}
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
