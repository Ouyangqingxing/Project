package fs.back.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByManager;
import fs.battle.daoImp.PlayerDaoImpM;
import fs.battle.model.Player;
import fs.common.bean.PageBean;
import fs.common.util.MySQLConnection;

/**@author Jason_★
 *处理后台展示所有玩家的Servlet
 */
@SuppressWarnings("serial")
public class ShowBackPlayerServlet extends HttpServlet
{	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//初始化连接和用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	 
		PlayerDaoByManager pu = new PlayerDaoImpM();
		//初始化分页bean对象
		PageBean pageBean1 = new PageBean();
		pageBean1.setTotalItem(pu.getTotalItem(conn));//1.查询数据总条数，去数据库里查询得到  T 
		pageBean1.setEachPage(20);					  //2.设置每页显示条数  E
		//3.设置总页数   P  T/E + ( T%E>0?1:0 ) 
		pageBean1.setTotalPage(pageBean1.getTotalItem()/pageBean1.getEachPage() + (pageBean1.getTotalItem()%pageBean1.getEachPage()>0?1:0));
		try
		{
			//4.设置当前页数   C   如果这里出现异常，则说明并没有传页面参数过来，所以catch里就默认设置为第一页。
			pageBean1.setCurrentPage(Integer.parseInt(request.getParameter("currentPage1")));
		} 
		catch (NumberFormatException e) 
		{
			pageBean1.setCurrentPage(1);
		} 
		//5.根据前面的4个参数，得到当前页的playerList的数据
		 List<Player> playerList = pu.getPlayerList(conn,pageBean1.getEachPage(), pageBean1.getCurrentPage());		

		//最后将分页信息和list信息放入request 并将页面转入WEB-INF下的back.jsp
request.setAttribute("backPage1", pageBean1); 
request.setAttribute("backPlayerList", playerList); 
		request.getRequestDispatcher("/WEB-INF/back.jsp").forward(request, response);
		return;
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
