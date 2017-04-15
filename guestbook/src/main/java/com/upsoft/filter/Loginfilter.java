package com.upsoft.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.upsoft.dao.JurisdictionDao;
import com.upsoft.entity.Jurisdiction;
import com.upsoft.entity.User;

/**
 * Servlet Filter implementation class Loginfilter
 */
public class Loginfilter implements Filter {

	//private JurisdictionDao jurdao;
    /**
     * Default constructor. 
     */
    public Loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//设置禁止缓存的消息头  
       ((HttpServletResponse)response).setHeader("Pragma","No-cache");       
       ((HttpServletResponse)response).setHeader("Cache-Control","no-cache");       
       ((HttpServletResponse)response).setHeader("Expires","0");//禁止缓存     
       
		HttpServletRequest req = (HttpServletRequest) request;  
        HttpSession session = req.getSession();  
        User user = (User)session.getAttribute("user"); 
        List<Jurisdiction> jurs = (List<Jurisdiction>)session.getAttribute("jurs"); 
        //权限检查
        if(user !=null){
	        boolean result = false;
	        for (Jurisdiction jurisdiction : jurs) {
	        	if(req.getRequestURI().equals(jurisdiction.getUrl())){
	        		result = true;
	        		break;
	        	}
			}
	        if(result){
	        	chain.doFilter(request, response);  
	        }else{
	        	((HttpServletResponse) response).sendRedirect("/guestbook/error_admin.html");
	        }
        }else{
        	((HttpServletResponse) response).sendRedirect("/guestbook/error_login.html");
        }
//        if (user != null) {  
//        	int state = user.getState();
//            // 如果现在存在了session，则判断是否有管理员权限
//        	if(state == 2){
//            	chain.doFilter(request, response);  
//
//        	}else{
//        		((HttpServletResponse) response).sendRedirect("/guestbook/error_admin.html");
//        	}
//        } else {  
//            // 跳转到提示登陆页面  
//        	((HttpServletResponse) response).sendRedirect("/guestbook/error_login.html");
//        }  
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/*//获得spring托管的对象
		ServletContext servletContext=fConfig.getServletContext();
		XmlWebApplicationContext xcxt=(XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.jurdao = (JurisdictionDao) xcxt.getBean("jurisdictionDao");*/
	}

}
