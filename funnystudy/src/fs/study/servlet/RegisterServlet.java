package fs.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.CampDaoByUser;
import fs.battle.dao.PlayerDaoByUser;
import fs.battle.daoImp.CampDaoImpU;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;

/**处理登陆的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet
{ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//依次从提交的表单中获得 用户名、密码、重复密码、个人说明、验证码，并建立临时变量赋值
		String username	=request.getParameter("username");
		boolean checkUserName = false;
		if(username.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*","").length()==0)
		{ 
			//不包含特殊字符 
			checkUserName = true;    
		} 
		username.replace(" ", "");
		
		String password	=request.getParameter("password");
		String remark  	=request.getParameter("remark");
		String checkcode=request.getParameter("checkcode");
		
		//这个是正确的验证码,验证码正确时才可进入下一个if。
        String checkcodeKey=(String)request.getSession().getAttribute("checkcode"); 
       
        if(checkcodeKey.equals(checkcode) && checkUserName)
        {
        	UserDao ud=new UserDaoImp();	
			PlayerDaoByUser pd = new PlayerDaoImpU();
			CampDaoByUser cu = new CampDaoImpU();
        	Connection conn = MySQLConnection.getMySQLConnection();	
        	
    		if(ud.daoCheckUserName(conn, username)==false)
    		{//当用户名已经存在时
    			request.setAttribute("errorR", "注册失败了。。再检查一下啦！");
    			request.getRequestDispatcher("/register.jsp").forward(request, response);
    			return;
    		}
    		else
    		{//用户注册（新增用户-新增玩家(玩家表新增、盟派表修改)-修改用户属性 事务）   用户登陆
    			int userId = 0 ;
    			boolean checkException = true;
    			try 
    			{
    				conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
    					
    				ud.daoAddUser(conn, username, password, 0, remark, 1, "1");//新增用户
    				int campId = pd.daoAddPlayer(conn, username, 1, remark);//新增玩家 拿到阵营id
    				cu.daoUpdateCampPopulation(conn, campId);//更新玩家阵营属性
    					
    				conn.commit();//3、上面的两条SQL执行成功之后就通知数据库提交事务(commit)
    			} 
    			catch (SQLException e) 
    			{  
    				checkException = false;
    				try {	conn.rollback();} catch (SQLException e1) {}//2、捕获到异常之后手动通知数据库执行回滚事务的操作
    			}
    		
    			if(checkException)//如果上面没有发生异常则执行，如果发生异常则没有注册成功不执行
    			{ 
    				try 
    				{
    					conn.setAutoCommit(true);
    					int playerId = pd.daoSelectPlayerIdByName(conn, username); //拿到玩家id
    					userId = ud.daoSelectIdByUserName(conn, username);//拿到用户id
    					ud.daoUpdateUserPlayerId(conn, userId, playerId); //更新用户对应的玩家id
    				} 
    				catch (SQLException e) {}
    			}
    			request.getRequestDispatcher("/login.jsp").forward(request, response);
    			return;
    		}
        }
        else
        {
			//验证失败，刷新登陆页面，发送错误信息
			request.setAttribute("errorR", "注册失败");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
