package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.common.util.MySQLConnection;
import fs.study.dao.ActionDao;
import fs.study.daoImp.ActionDaoImp;

/**修改动态点赞数
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class UpdateActionNumberServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{	
		try 
		{
			//初始化连接 动态处理类
			Connection conn = MySQLConnection.getMySQLConnection();	
			ActionDao ad = new ActionDaoImp();
			//拿到参数动态id 修改点赞数
			int actionId = Integer.parseInt(	request.getParameter("actionId")	);
			ad.daoUpdateAction(conn, actionId);
		} catch (SQLException e){}
		
		//取得当前查看的玩家id和已登陆的玩家id
		int selfPlayerId = -1 ;
		int playerId = -2;
		try
		{
			selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			playerId = Integer.parseInt(	request.getParameter("playerId")	);
		}catch(Exception e){} 
		//如果两个相等则返回个人页面，否则返回查看页面
		if(selfPlayerId == playerId)
		{
			request.getRequestDispatcher("ShowSelfStudy.action?selfPlayId=selfPlayId").forward(request, response);
			return;
		}
		else
		{
			request.getRequestDispatcher("ShowStudy.action?playerId=playerId").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doGet(request, response);
	} 
}
