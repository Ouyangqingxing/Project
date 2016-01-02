package fs.common.servlet;

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
import fs.common.util.LuckNumber;
import fs.common.util.MySQLConnection;
import fs.study.dao.DailyDao;
import fs.study.daoImp.DailyDaoImp;
import fs.study.daoImp.NoticeDaoImp;
import fs.study.daoImp.SentenceDaoImp;

/**展示主页的Servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class ShowMainServlet extends HttpServlet 
{ 
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//初始化处理玩家 名句 公告类 以及链接
		PlayerDaoByUser pu = new PlayerDaoImpU();
		SentenceDaoImp sd = new SentenceDaoImp();
		NoticeDaoImp nd = new NoticeDaoImp();
		Connection conn = MySQLConnection.getMySQLConnection();	 
		List<Player> playerList1 = null;
		String sentence = null;
		int ranking = 3;
		String notice = "大家好，我是公告。";
		//拿到选择的排行榜，如果有异常则说明没有做选择 默认为3 
		try{ranking = Integer.parseInt( request.getParameter("ranking") );}
		catch(Exception e){}
		
		//拿到随机名言
		try 
		{
			sentence = sd.daoSelectSentence(conn);
			playerList1 = pu.daoSelectPlayerRanking(conn, ranking);
		} 
		catch (Exception e) {e.printStackTrace();} 
		
		//拿到公告tips
		try{notice = nd.daoSelectNotice(conn);}
		catch(Exception e){}
		
		//更新元气值 并查询元气值然后写入域
		int WebPower = 1;
		try
		{
			DailyDao dd = new DailyDaoImp();
			dd.daoUpdatePower(conn);
			WebPower = dd.daoSelectDailyByDate(conn, "123").getPower();
		}
		catch(Exception e){}
		
request.setAttribute("WebPower", WebPower); 		
request.setAttribute("playerList1", playerList1); 
request.setAttribute("sentence", sentence);
request.setAttribute("notice", notice);
request.setAttribute("lucky", LuckNumber.getLuckNumber());

		request.getRequestDispatcher("/main.jsp").forward(request, response);
		return;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
