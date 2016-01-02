package fs.battle.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fs.battle.dao.CampDaoByUser;
import fs.battle.dao.PlayerDaoByUser;
import fs.battle.dao.WeaponDaoByUser;
import fs.battle.dao.WuGongDaoByUser;
import fs.battle.daoImp.CampDaoImpU;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.battle.daoImp.WeaponDaoImpU;
import fs.battle.daoImp.WuGongDaoImpU;
import fs.battle.model.Player;
import fs.battle.model.Weapon;
import fs.battle.model.WuGong;
import fs.common.bean.PageBean;
import fs.common.util.MySQLConnection;
import fs.study.dao.UserDao;
import fs.study.daoImp.UserDaoImp;

/**展示战斗页面的servlet_★
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class ShowBattleServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//加载战斗页面
		//需要加载	1登陆的玩家的信息	2随机四个玩家信息	3排行榜
		//拿到已登陆玩家id 链接 玩家处理类
		int loginPlayerId= 0;
		loginPlayerId = (Integer) request.getSession().getAttribute("selfPlayerId");
		Connection conn = MySQLConnection.getMySQLConnection();	 
		PlayerDaoByUser pu = new PlayerDaoImpU();
		Player p1 = new Player();
		
		try //1登陆的玩家的信息 包括player和武功武器集合--------------------------------------------------------------------------------------
		{
			WeaponDaoByUser we = new WeaponDaoImpU();
			WuGongDaoByUser wu = new WuGongDaoImpU();
			
			p1 = pu.daoSelectPlayerAllInfo(conn, loginPlayerId); 
			
			List<Weapon> weaponList = new ArrayList<Weapon>();
			List<WuGong> wugongList = new ArrayList<WuGong>();
			
			for(int i = 0 ; i<4 ; i++)
			{
				try{weaponList.add(we.daoSelectWeapon(conn, p1.getEquipment().get(i)));}catch(Exception e){}
				try{wugongList.add(wu.daoSelectWuGong(conn, p1.getWugong().get(i)));}catch(Exception e){}
			}
request.setAttribute("weaponList", weaponList);			
request.setAttribute("wugongList", wugongList);		
request.setAttribute("player1", p1); 			
		} catch (SQLException e){e.printStackTrace();}
	
		try
		{
//			TeamDaoByUser tu = new TeamDaoImpU();
//			String selfTeamName =tu.daoSelectTeaminfo(conn, p1.getTeamId()).getName();
//			request.getSession().setAttribute("selfTeamName", selfTeamName); 
			
			//2取得所有武器的信息--------------------------------------------------------------------------------------
			List<Weapon> allWeaponList = new ArrayList<Weapon>();
			WeaponDaoByUser wu = new WeaponDaoImpU();
			allWeaponList = wu.daoSelectAllWeapon(conn);
request.setAttribute("allWeaponList", allWeaponList);
		}catch(Exception e){}
		
		try
		{
			//3取得阵营人数信息--------------------------------------------------------------------------------------
			CampDaoByUser cu = new CampDaoImpU(); 
			int population1 = cu.daoSelectCampPopulation(conn, 1);
			int population2 = cu.daoSelectCampPopulation(conn, 2);
			int population3 = cu.daoSelectCampPopulation(conn, 3);
request.setAttribute("population1", population1);
request.setAttribute("population2", population2);
request.setAttribute("population3", population3);
		}
		catch(Exception e){}
		
		//4取得品剑玩家信息--------------------------------------------------------------------------------------
		int p1ranking = p1.getRanking();
		int p2ranking = 1;
		int p3ranking = 1;
		int p4ranking = 1;
		int p5ranking = 1;
		//取随机4位玩家的信息	当p1排名小于10时 随机取10以内的4个玩家，
		//大于10时 分别为50%p1-random[10%p1]  70%p1-random[10%p1]  80%p1-random[10%p1]  90%p1-random[10%p1]
		if(p1ranking > 10)
		{
			Random r1 = new Random();
			p2ranking = (int)(0.5*p1ranking)-r1.nextInt( (int)(0.1*p1ranking) + 1 );
			p3ranking = (int)(0.7*p1ranking)-r1.nextInt( (int)(0.1*p1ranking) + 1 );
			p4ranking = (int)(0.8*p1ranking)-r1.nextInt( (int)(0.1*p1ranking) + 1 );
			p5ranking = (int)(0.9*p1ranking)-r1.nextInt( (int)(0.1*p1ranking) + 1 );
		}
		//5-10时显示自然数递减前4个
		else if(p1ranking > 4)
		{
			p2ranking = p1ranking - 4;
			p3ranking = p1ranking - 3;
			p4ranking = p1ranking - 2;
			p5ranking = p1ranking - 1;
		}
		//否则显示前5除了自己的4位玩家
		else
		{
			if(p1ranking == 1){p2ranking = 2;p3ranking = 3;p4ranking = 4;p5ranking = 5;}
			else if(p1ranking == 2){p2ranking = 1;p3ranking = 3;p4ranking = 4;p5ranking = 5;}
			else if(p1ranking == 3){p2ranking = 1;p3ranking = 2;p4ranking = 4;p5ranking = 5;}
			else if(p1ranking == 4){p2ranking = 1;p3ranking = 2;p4ranking = 3;p5ranking = 5;}
		}
		//通过前面算法拿到的排名查看对于的玩家并将其写进域
		try
		{
			UserDao ud = new UserDaoImp();
			
			Player p2 = pu.daoSelectPlayerInfoByRanking(conn, p2ranking);
			p2.setSex( Integer.parseInt(ud.daoSelectUserById(conn, ud.daoSelectIdByPlayerId(conn, p2.getId()	) ).getFace()));
			Player p3 = pu.daoSelectPlayerInfoByRanking(conn, p3ranking);
			p3.setSex( Integer.parseInt(ud.daoSelectUserById(conn, ud.daoSelectIdByPlayerId(conn, p3.getId()	) ).getFace()));
			Player p4 = pu.daoSelectPlayerInfoByRanking(conn, p4ranking);
			p4.setSex( Integer.parseInt(ud.daoSelectUserById(conn, ud.daoSelectIdByPlayerId(conn, p4.getId()	) ).getFace()));
			Player p5 = pu.daoSelectPlayerInfoByRanking(conn, p5ranking);
			p5.setSex( Integer.parseInt(ud.daoSelectUserById(conn, ud.daoSelectIdByPlayerId(conn, p5.getId()	) ).getFace()));
				
request.setAttribute("player2", p2); 
request.setAttribute("player3", p3); 
request.setAttribute("player4", p4); 
request.setAttribute("player5", p5); 
		}catch(Exception e){}
		
		
		int battlePhb = 3;//查看的排行榜  默认3等级榜  1仙剑榜 2枭雄榜 3pk榜
		try
		{
			battlePhb = Integer.parseInt(request.getParameter("battlePhb"));//先看下是否传参过来
		}
		catch(Exception e)
		{
			//没有传参的话则去session取，如果也没有的话就默认为3了
			try{battlePhb = (Integer) request.getSession().getAttribute("battlePhb");}
			catch(Exception e1){}
		}
		//5排行榜---------------------------------------------------------------------------------------
		PageBean pageBean1 = new PageBean();//1.数据总条数，去数据库里查询得到  T 
		pageBean1.setTotalItem(pu.getTotalItem(conn));//2.每页显示条数  E
		pageBean1.setEachPage(10);	//3.总页数   P  T/E + ( T%E>0?1:0 )
		pageBean1.setTotalPage(pageBean1.getTotalItem()/pageBean1.getEachPage() + (pageBean1.getTotalItem()%pageBean1.getEachPage()>0?1:0));//4.当前页数   C
		try
		{
			//查看是否有页数传来，没有则默认第一页
			pageBean1.setCurrentPage(Integer.parseInt(request.getParameter("currentPage1")));
		} 
		catch (Exception e) 
		{
			pageBean1.setCurrentPage(1);
		} 
		//5.得到当前页的actionList数据
		List<Player> playerList =null;//System.out.println("userId = "+userId+"  playerId = "+playerId);
		playerList = pu.getPlayerList(conn,pageBean1.getEachPage(), pageBean1.getCurrentPage(),battlePhb);	
request.getSession().setAttribute("battlePhb", battlePhb); 
request.setAttribute("battlePage1", pageBean1); 
request.setAttribute("battlePlayerList", playerList); 
		
		request.getRequestDispatcher("/battle.jsp").forward(request, response);
		return;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
}
