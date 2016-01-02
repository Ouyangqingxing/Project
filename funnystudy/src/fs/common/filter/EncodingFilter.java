package fs.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**处理全局中文乱码的过滤器
 * @author Jason_★ 
 */
public class EncodingFilter implements Filter
{ 
	@SuppressWarnings("unused")
	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy(){}
}
