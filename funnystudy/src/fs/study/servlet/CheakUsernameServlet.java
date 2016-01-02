package fs.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;

/**ajax_★异步检查用户名的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class CheakUsernameServlet extends HttpServlet
{ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{	
		//初始化连接 用户处理类
		Connection conn = MySQLConnection.getMySQLConnection();	
		UserDao ud=new UserDaoImp();   
		
		//拿到参数用户名 对编码进行处理，进行判断
		String username=request.getParameter("userName");
		username=URLDecoder.decode(username,"UTF-8");
		username=URLDecoder.decode(username,"UTF-8"); 
		String username2= username.replaceAll(" ", "");
		PrintWriter out = response.getWriter();
			
		if(username2.equals(""))
		{
			//错误2，当用户名为空或者为几个空格时
			out.write("usernameNo2");
		}
		else if(username.equals(username2)==false)
		{
			//错误3，当用户名中包含空格时
			out.write("usernameNo3");
		}
		else if(ud.daoCheckUserName(conn, username)==false)
		{
			//错误1，当用户名已经存在时
			out.write("usernameNo");
		}
		else
		{
			out.write("usernameYes");
		}
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doGet(request, response);
	}
}
