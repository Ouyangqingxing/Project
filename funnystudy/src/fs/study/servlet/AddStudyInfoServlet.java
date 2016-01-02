package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.common.util.MathMethod;
import fs.common.util.MySQLConnection;
import fs.study.dao.StudyInfoDao;
import fs.study.dao.UserDao;
import fs.study.daoImp.StudyInfoDaoImp;
import fs.study.daoImp.UserDaoImp;

/**新增学习情况的servlet_★ 
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class AddStudyInfoServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//新增一个新的学习情况
		//1、检查今日是否已经有学习情况了。如果有则不能新增。（虽然不大可能出现这种情况，还是写着。）
		//2、新增学习情况 + 更新发表学习情况的用户对于的玩家适当经验值 （事务）
		Connection conn = MySQLConnection.getMySQLConnection();	
		int selfPlayerId = 0;
		int selfUserId = 0; 
		int checkAdd = 0;
		try
		{	
			//依次取得 已登陆玩家id 已登陆用户id 今天的日期xxxx-xx-xx 是否可以新增参数
			StudyInfoDao sd = new StudyInfoDaoImp();
			UserDao ud = new UserDaoImp();
			selfPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			selfUserId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);	
			Date d=new Date();  
		    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");       
			String today =  df.format(d);//今天的日期 
			checkAdd = 1;
			sd.daoSelectStudyInfoByUserIdandTime(conn, selfUserId, today);
			checkAdd = 0;
		}
		catch(Exception e)
		{
			if(checkAdd == 1)//可以进行新增操作的情况
			{
    			try 
    			{
    				conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
    				//新增学习情况 增加玩家经验值
    				StudyInfoDao sd = new StudyInfoDaoImp();
    				sd.daoAddStudyInfo(conn, selfUserId, request.getParameter("studyInfoContent"));
    				
    				PlayerDaoByUser pu = new PlayerDaoImpU();//获得当前升级所需经验20%的经验
    				int exp = MathMethod.getNeedExp(pu.daoSelectPlayerAllInfo(conn, selfPlayerId).getLv())/10;
    				pu.daoUpdatePlayerLV(conn,selfPlayerId,exp);
    				
    				if(pu.daoSelectPlayerAllInfo(conn, selfPlayerId).getCritical()<50)
    				{
    					pu.daoUpdatePlayerHighValue(conn, selfPlayerId, 0, 1, 0);
    				}
    				
    				conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
    			} 
    			catch (SQLException e1) 
    			{   
    				try {	conn.rollback();} catch (SQLException e2) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
    			}
			}
		}
		request.getRequestDispatcher("ShowSelfStudy.action?selfPlayerId=selfPlayerId").forward(request, response);
		return;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
