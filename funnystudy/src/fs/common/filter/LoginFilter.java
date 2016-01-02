package fs.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse; 

/**
 * 登陆过滤器，用于过滤所有请求，如果没有登陆，则不能访问该web应用下的资源
 * @author Ryan_
 */
public class LoginFilter implements Filter
{	
	//private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
//		config = filterConfig;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
//		HttpServletRequest req = (HttpServletRequest)request;
//		String uri = req.getRequestURI();
//		
//		//以下内容不需要过滤，因为本身就是静态的，过滤之后浏览器会因访问到时间过长而以为资源并不存在
//		if(uri.endsWith(".css")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".js")||
//		   uri.endsWith(".gif")||uri.endsWith("Login.action") ||uri.endsWith("Logout.action")||
//		   uri.endsWith("Identify.action")||uri.endsWith("CheckName.action")||uri.endsWith("/ShowMain.action")||
//		   uri.endsWith("Register.action")||uri.endsWith("ShowStudy.action")||uri.endsWith("UpdateActionNumber.action")||
//		   uri.endsWith("index.jsp")||uri.endsWith("/"))
//		{
//			chain.doFilter(request, response);
//			return;
//		}
//		if(req.getSession(false) != null)
//		{
//			chain.doFilter(request, response);
//			return;
//		}
//		else 
//		{
//			req.setAttribute("error", "没有访问权限，请先登陆");
//			req.getRequestDispatcher("/login.jsp").forward(request, response);
//			return;
//		}
	}

	@Override
	public void destroy() 
	{
		
	}
}
