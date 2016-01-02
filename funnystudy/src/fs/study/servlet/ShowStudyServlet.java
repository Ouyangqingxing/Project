package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser; 
import fs.battle.daoImp.PlayerDaoImpU; 
import fs.battle.model.Player;
import fs.common.bean.PageBean;
import fs.common.util.MySQLConnection;
import fs.study.dao.ActionDao;
import fs.study.dao.MessageDao;
import fs.study.dao.UserDao;
import fs.study.daoImp.ActionDaoImp;
import fs.study.daoImp.MessageDaoImp;
import fs.study.daoImp.UserDaoImp;
import fs.study.model.Action;
import fs.study.model.MessageX;

/**查看用户学习页面
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class ShowStudyServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//1、拿到用户的初始各种信息 -------------------------------------------------------------------------------- 
		//加载要查看的用户的学习动态 需要参数playerId 
		//初始化连接 动态处理类
		Connection conn = MySQLConnection.getMySQLConnection();	
		ActionDao ad = new ActionDaoImp();
		int playerId = 0;
		int userId = 0;
		int lv = 1;
		String username ="Jason";
		int face = 1;
		String remark = "。。。";
		Player p1 = new Player();
		//如果是通过链接进入该页面 则更新查看玩家的id
		try
		{
			playerId = Integer.parseInt( request.getParameter("playerId"));	//拿到要查看的玩家id	
			
request.getSession().removeAttribute("playerId"); //更新session域里的要查看的玩家id 
request.getSession().setAttribute("playerId", playerId);
		}
		catch(Exception e){}
		
		//分页操作时不执行上面try的语句 先取得当前查看玩家id	
		if(playerId == 0)
		{
			try
			{
				playerId = Integer.parseInt( request.getParameter("playerId"));	
			}
			catch(Exception e)
			{
				playerId = (Integer) request.getSession().getAttribute("playerId");
			}
			
		}
		try//拿到查看的用户Id 玩家等级玩家昵称
		{
			UserDao ud = new UserDaoImp();
			userId = ud.daoSelectIdByPlayerId(conn, playerId);	
			PlayerDaoByUser pd = new PlayerDaoImpU();
			lv = pd.daoSelectPlayerAllInfo(conn, playerId).getLv();
			username = pd.daoSelectPlayerAllInfo(conn, playerId).getName();	
			face = Integer.parseInt( ud.daoSelectUserById(conn, userId).getFace() );
			remark = ud.daoSelectUserById(conn, userId).getRemark();
			p1 = pd.daoSelectPlayerAllInfo(conn, playerId);
//			TeamDaoByUser tu = new TeamDaoImpU();
//			tu.daoSelectTeaminfo(conn, p1.getTeamId()).getName();
		}
		catch(Exception e1){}
			
		//2、显示动态部分 ---------------------------------------------------------------------------------------------------------------- 	 
			PageBean pageBean1 = new PageBean();//1.数据总条数，去数据库里查询得到  T 
			pageBean1.setTotalItem(ad.getTotalItem(conn));//2.每页显示条数  E
			pageBean1.setEachPage(2);	//3.总页数   P  T/E + ( T%E>0?1:0 )
			pageBean1.setTotalPage(pageBean1.getTotalItem()/pageBean1.getEachPage() + (pageBean1.getTotalItem()%pageBean1.getEachPage()>0?1:0));//4.当前页数   C
			try
			{
				pageBean1.setCurrentPage(Integer.parseInt(request.getParameter("currentPage1")));
				
			} 
			catch (NumberFormatException e) 
			{
				pageBean1.setCurrentPage(1);
			} 
			//5.得到当前页的actionList数据
			List<Action> actionList =null;//System.out.println("userId = "+userId+"  playerId = "+playerId);
			if(userId == 0 || playerId == 0){}
			else
			{
				actionList = ad.getActionList(conn,userId,pageBean1.getEachPage(), pageBean1.getCurrentPage());
			}

request.setAttribute("userName", username); 
request.setAttribute("playerLv", lv); 
request.setAttribute("showStudyActionPage1", pageBean1); 
request.setAttribute("face", face);
request.setAttribute("remark", remark); 
request.setAttribute("player", p1);

			if(actionList != null) 
			{ 
request.setAttribute("actionList", actionList);
			}
			
			
			MessageDao md = new MessageDaoImp(); 
			//3、显示留言板部分 --------------------------------------------------------------------------- 	 
			PageBean pageBean2 = new PageBean();//1.数据总条数，去数据库里查询得到  T 
			pageBean2.setTotalItem(md.getTotalItem(conn));//2.每页显示条数  E
			pageBean2.setEachPage(5);	//3.总页数   P  T/E + ( T%E>0?1:0 )
			pageBean2.setTotalPage(pageBean2.getTotalItem()/pageBean2.getEachPage() + (pageBean2.getTotalItem()%pageBean2.getEachPage()>0?1:0));//4.当前页数   C
			try
			{
				pageBean2.setCurrentPage(Integer.parseInt(request.getParameter("currentPage2")));
				
			} 
			catch (NumberFormatException e) 
			{
				pageBean2.setCurrentPage(1);
			} 
			//5.得到当前页的messageList数据
			List<MessageX> messageList =null;//System.out.println("userId = "+userId+"  playerId = "+playerId);
			if(userId == 0 || playerId == 0){}
			else
			{
				messageList = md.getMessageXList(conn,userId,pageBean2.getEachPage(), pageBean2.getCurrentPage());
			}		
		
request.setAttribute("showStudyMessagePage2", pageBean2); 
request.setAttribute("playerId", playerId); 
			if(messageList != null)
			{
request.setAttribute("messageList", messageList);
			} 
		 
		request.getRequestDispatcher("/study.jsp").forward(request, response);
		return;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
