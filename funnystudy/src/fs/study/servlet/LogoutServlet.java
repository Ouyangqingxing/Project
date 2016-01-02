package fs.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**处理登出的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//将session域的东西移除
		request.getSession().invalidate();
		request.getRequestDispatcher("/public/header.jsp").forward(request, response);
		return;
	}
}
