package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.common.bean.PageBean;
import fs.common.util.MySQLConnection;
import fs.study.dao.ActionDao;
import fs.study.dao.MessageDao;
import fs.study.dao.StudyInfoDao;
import fs.study.dao.UserDao;
import fs.study.daoImp.ActionDaoImp;
import fs.study.daoImp.MessageDaoImp;
import fs.study.daoImp.StudyInfoDaoImp;
import fs.study.daoImp.UserDaoImp;
import fs.study.model.Action;
import fs.study.model.MessageX;
import fs.study.model.StudyInfo;

/**展示个人学习页面的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class ShowSelfStudyServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//1、基础信息的获取----------------------------------------------------------------------------------
		//该页面需要加载的东西：actionList,messageXList,selfPlayerName,selfPlayerLv,pageBean1,pageBean2
		//studyInfoTime,studyInfo,checkStudyInfo
		//首先判断登陆后写入域里的selfPlayerId和传参过来的selfPlayerId是否相等。只有相等才可以加载页面。
		
		int loginPlayerId = 0;
		int selfPlayerId = 0;
		int checkWay = 0;
		//拿到登陆的玩家id 如果没有则不能加载页面
		try
		{
			loginPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
			selfPlayerId = Integer.parseInt(request.getParameter("playerId"));
			checkWay = 1;
		}catch(Exception e){selfPlayerId = loginPlayerId;}
		
		if(loginPlayerId == selfPlayerId)//当登陆的玩家id和查看的自己学习情况的id相等时才可以加载页面，否则一定会报错进入错误页面
		{
			//判断是在什么情况下进入该链接，从而通过if进行不同的业务逻辑处理，减少一定的空间时间消耗
			//1、通过 盾牌 进入页面-有参数 selfPlayerId传来--完整的加载页面
			//2、通过 动态分页进入页面-有参数currentPage1--加载2不更新34
			//3、通过 留言板分页进入页面-有参数currentPage2--加载3不更新24
			//4、通过 学习情况翻页进入页面-有参数addOrSub--加载4不更新23
			//5、通过一些其他的action进入该页面，没有参数--完整的加载页面
			//2 3 4操作互不干扰，不需要重新加载其他两方的数据
			
			//判断进入该页面的方式
			try{@SuppressWarnings("unused")
			int currentPage1 = Integer.parseInt( request.getParameter("currentPage1") );
				checkWay = 2;}catch(Exception e){}			
			try{@SuppressWarnings("unused")
			int currentPage2 = Integer.parseInt( request.getParameter("currentPage2") );
			checkWay = 3;}catch(Exception e){}			
			try{@SuppressWarnings("unused")
			int addOrSub = Integer.parseInt( request.getParameter("addOrSub") );
			checkWay = 4;}catch(Exception e){}			
			
			//if(checkWay != 3 && checkWay != 4)//只要不是通过留言板 学习情况进入该链接，，都将更新动态部分
			if(true)
			{
				Connection conn = MySQLConnection.getMySQLConnection();	
				//-------------------------------------- 显示动态部分 -------------------------------------- 
				//加载要查看的用户的学习动态 需要参数playerId 
				
				ActionDao ad = new ActionDaoImp();
				
				int selfUserId = 0;
				int selfPlayerLv = 1;
				String selfUserName ="Jason";
				try
				{	
					UserDao ud = new UserDaoImp();
					selfUserId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);	
					PlayerDaoByUser pd = new PlayerDaoImpU();
					selfPlayerLv = pd.daoSelectPlayerAllInfo(conn, selfPlayerId).getLv();
					selfUserName = pd.daoSelectPlayerAllInfo(conn, selfPlayerId).getName();	
				}
				catch(Exception e){}
				
					 
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
				if(selfUserId == 0 || selfPlayerId == 0){}
				else
				{
					actionList = ad.getActionList(conn,selfUserId,pageBean1.getEachPage(), pageBean1.getCurrentPage());
				}

request.setAttribute("selfUserName", selfUserName);  
request.setAttribute("selfPlayerLv", selfPlayerLv); 
request.setAttribute("showSelfActionPage1", pageBean1); 

				if(actionList != null)
				{
request.setAttribute("actionList", actionList);
				} 
			} 
			
			//if(checkWay != 3 && checkWay != 2)
			if(true)
			{
				Connection conn = MySQLConnection.getMySQLConnection();	
				UserDao ud = new UserDaoImp();
				int selfUserId = 0;
				try {selfUserId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);} 
				catch (SQLException e2) {}	
				//-------------------------------------- 显示学习情况部分 -------------------------------------- 	 
				String studyInfoTime = null;//当前查看的学习情况的日期
			   
				Date d=new Date();  
			    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");       
				String today =  df.format(d);//今天的日期 
				
				StudyInfo studyinfo = new StudyInfo();//学习情况
				int checkStudyInfo = -1;//该日期的学习存在情况 		-1不存在不能新增     0不存在可以新增    1存在
				StudyInfoDao sd = new StudyInfoDaoImp();
				int addOrSub = -1;
				
				//进入这里只有3个情况  无studyInfoTime参数 即为初次加载页面  左1 右0箭头
				try//取得是左还是右箭头
				{ 
					addOrSub = Integer.parseInt( request.getParameter("addOrSub") );
					//取出当前查看的学习情况的日期
					studyInfoTime =  (String) request.getAttribute("studyInfoTime") ; 
					if(studyInfoTime.equals(null)){} 
				}
				catch(Exception e)
				{
					//如果有异常则默认为当前日期--初次加载页面
					studyInfoTime = today; 
					//取不到addOrSub则非左右箭头进入。然后去取今日的学习情况 
					try
					{
						//取到今日则为1
						studyinfo=sd.daoSelectStudyInfoByUserIdandTime(conn, selfUserId, studyInfoTime);
						checkStudyInfo = 1;
					} 
					catch (SQLException e1) 
					{ 
						//取不到则为0状态
						checkStudyInfo = 0;
					}  
				}
					
				//左箭头(1)：1、 取到当前查看的学习情况日期studyInfoTime(String) 3、是否等于今天     不做操作并结束/按照日期算法减一  
				//2、查询加1天后的日期的学习情况，更新域里的studyInfoTime(String) studyInfoContent(String)重新加载页面。
				if(addOrSub == 1)
				{
					try
					{
						if(studyInfoTime.equals(today))
						{//如果要已经是今天了 就不能再查看第二天的情况了 
							//尝试着去取今天的学习情况
							studyinfo = sd.daoSelectStudyInfoByUserIdandTime(conn, selfUserId, studyInfoTime);
							checkStudyInfo = 1;
						}
						else
						{
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date date = sdf.parse(studyInfoTime);
							Calendar calendar = new GregorianCalendar(); 
							calendar.setTime(date); 
							calendar.add(Calendar.DATE,1);//的明天
							date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
								
							studyInfoTime = sdf.format(date);
							//尝试着去取后推1天的学习情况
							studyinfo = sd.daoSelectStudyInfoByUserIdandTime(conn, selfUserId, studyInfoTime);
						
							//a 如果能执行到这 则说明第二天有值 checkStudyInfo = 1; 
							checkStudyInfo = 1;
						}
					}
					catch (Exception e)
					{
						//b 执行到这里说明并不能取到下一天的学习情况， 判断是否为今天， 是则为0 否则为-1
						if(studyInfoTime.equals(today))
						{
							checkStudyInfo = 0;
						}  
					} 
				}
				
				//右箭头(0)：1、 取到当前查看的学习情况日期studyInfoTime(String) 2、查询减1天后的学习情况 是否存在  
				// 更新域里的studyInfoTime(String) studyInfoContent(String)重新加载页面/不做操作并结束
				//checkStudyInfo 判断查看的学习情况是否存在 1存在 0不存在 
				else if(addOrSub == 0)
				{
					try
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(studyInfoTime); 
						Calendar calendar = new GregorianCalendar(); 
						calendar.setTime(date);  
						calendar.add(Calendar.DATE,-1);//的昨天 
						date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
						studyInfoTime = sdf.format(date);  
						//尝试着去取 前一天的学习情况
						studyinfo = sd.daoSelectStudyInfoByUserIdandTime(conn, selfUserId, studyInfoTime);
						
						//如果执行到这儿 说明前一天是有学习情况的
						checkStudyInfo = 1;
					} 
					catch (Exception e)
					{ 
						//如果执行到这儿 说明前一天没有学习情况，默认为-1 所以这里不做操作了。
					}
				} 
request.setAttribute("studyInfoTime", studyInfoTime); 	
request.setAttribute("studyinfo", studyinfo); 
request.setAttribute("checkStudyInfo", checkStudyInfo);  
			}
			
			if(true)
			//if(checkWay != 4 && checkWay != 2)
			{
				Connection conn = MySQLConnection.getMySQLConnection();	
				MessageDao md = new MessageDaoImp();
				UserDao ud = new UserDaoImp();
				int selfUserId = 0;
				try {selfUserId = ud.daoSelectIdByPlayerId(conn, selfPlayerId);}
				catch (SQLException e1) {}	
				//-------------------------------------- 显示留言板部分 -------------------------------------- 	 
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
				if(selfUserId == 0 || selfPlayerId == 0){}
				else
				{
					messageList = md.getMessageXList(conn,selfUserId,pageBean2.getEachPage(), pageBean2.getCurrentPage());
				}		
			
request.setAttribute("showSelfMessagePage2", pageBean2); 
request.getSession().setAttribute("playerId", selfPlayerId); 
				if(messageList != null)
				{
request.setAttribute("messageList", messageList);
				} 
			}
			
			request.getRequestDispatcher("/selfstudy.jsp").forward(request, response);
			return;		
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
