package fs.battle.model;

import java.sql.Connection;
import fs.battle.dao.PlayerDaoByUser; 
import fs.battle.daoImp.PlayerDaoImpU; 
import fs.common.util.MySQLConnection; 

/**该类用来处理战斗结束后的基础事宜如获得经验、修为等
 * @author Jason_★
 */
public class IoCAfterBattle1 
{
	//战斗力计算公式hp*2+atk*13+def*11+spd*15+rp*150+dodge*100+critical*120
	public static int getFightPower(Player p)
	{
		int fightPower = 0;
		fightPower = p.getHp()*2+p.getAtk()*13+p.getDef()*11+p.getSpd()*15+p.getRp()*150+p.getDodge()*100+p.getCritical()*120;
		return fightPower;
	}
	
	public static String getBattleResult(int result,int p1Id,int p2Id)
	{
		//初始化连接 玩家处理类 挑战方被挑战方 双方战斗力 双方获得的经验和修为 输出文本
		Connection conn = MySQLConnection.getMySQLConnection();
		PlayerDaoByUser pu = new PlayerDaoImpU();
		Player p1 = new Player();
		Player p2 = new Player();
		try
		{
			p1 = pu.daoSelectPlayerAllInfo(conn, p1Id);
			p2 = pu.daoSelectPlayerAllInfo(conn, p2Id);
		}catch(Exception e){}
		
		int fightPower1 = getFightPower(p1);
		int fightPower2 = getFightPower(p2);
		int A1 = 0;
		int A2 = 0;
		int B1 = 0;
		int B2 = 0;
		String pk = "";
		
		//根据战斗结果对双方获得的经验和修为进行赋值
		switch(result)
		{
			case 3:
			{
				//对主动方的操作		主动战斗完胜-获得对方战斗力数值的修为值*2	20经验值
				A1 = (int)(fightPower2/5); 
				A2 = 20;
				//对被动方的操作		被动战斗失败-获得自己战斗力数值*0.2的修为值	2经验值
				B1 = (int)(fightPower2*0.2/10);
				B2 = 2;
				pk = pk +"完胜！<br>";
				
				if(pu.daoCheckPlayerPhb(conn, p2Id));
				{
					A1 = A1 * 3;
					A2 = A2 * 3;
					pk = pk +"您击败了排行榜上的玩家，获得三倍修为、经验！<br>";
				}			
				break;
			}
			case 2:
			{
				//对主动方的操作	主动战斗胜利-获得对方战斗力数值的修为值		10经验值
				A1 = (int)(fightPower2/10);
				A2 = 10;
				//对被动方的操作	被动战斗失败-获得自己战斗力数值*0.2的修为值	2经验值
				B1 = (int)(fightPower2*0.2/10);
				B2 = 2;
				pk = pk +"胜利！<br>";
				if(pu.daoCheckPlayerPhb(conn, p2Id));
				{
					A1 = A1 * 3;
					A2 = A2 * 3;
					pk = pk +"您击败了排行榜上的玩家，获得三倍修为、经验！<br>";
				}
				break;
			}
			case 1:
			{ 
				//对主动方的操作	主动战斗险胜-获得对方战斗力数值的修为值0.8		8经验值
				A1 = (int)(fightPower2*0.8/10);
				A2 = 8;
				//对被动方的操作	被动战斗失败-获得自己战斗力数值*0.2的修为值	2经验值
				B1 = (int)(fightPower2*0.2/10);
				B2 = 2;
				pk = pk +"险胜！<br>";
				if(pu.daoCheckPlayerPhb(conn, p2Id));
				{
					A1 = A1 * 3;
					A2 = A2 * 3;
					pk = pk +"您击败了排行榜上的玩家，获得三倍修为、经验！<br>";
				}
				break;
			}
			case 0:
			{ 
				//对主动方的操作	主动战斗惜败-获得对方战斗力数值的修为值0.8		8经验值
				A1 = (int)(fightPower2*0.8/10);
				A2 = 8;
				//对被动方的操作	被动战斗胜利-获得对方战斗力数值的修为值		5经验值
				B1 = (int)(fightPower1/10);
				B2 = 5;
				pk = pk +"惜败！<br>";
				break;
			}
			case -1:
			{ 
				//对主动方的操作	主动战斗失败-获得自己战斗力数值的修为值		6经验值
				A1 = (int)(fightPower1/10);
				A2 = 6;
				//对被动方的操作	被动战斗胜利-获得对方战斗力数值的修为值		5经验值 
				B1 = (int)(fightPower1/10);
				B2 = 5;
				pk = pk +"战败！<br>";
				break;
			}
			case -2:
			{ 
				//对主动方的操作	主动战斗完败-获得自己战斗力数值的修为值0.5	3经验值
				A1 = (int)(fightPower1/20);
				A2 = 3;
				//对被动方的操作	被动战斗胜利-获得对方战斗力数值的修为值		5经验值
				B1 = (int)(fightPower1/10);
				B2 = 5;
				pk = pk +"完败！<br>";
				break;
			}
		} 
		
		//如果修为大于10w 赋为10w
		if(A1>100000){A1=100000;}
		if(B1>100000){B1=100000;}
		
//		try//增加今日挑战方盟派的元气
//		{
//			DailyDao dd = new DailyDaoImp();
//			dd.daoUpdateCamp(conn, p1.getCampId());
//		} catch (SQLException e1){}
		
		try//挑战方清空Buff 玩家减少1次挑战次数 。
		{	
			//pu.daoUpdatePlayerBuff(conn,p1Id, 0);
			
			if(p1.getName().contains("★") == false)
			{
				pu.daoUpdatePlayerLastFightChance(conn,p1Id, 5);
			}
		}catch(Exception e){}
 		
		try
		{
			//双方获得经验和修为。
			if(p1.getName().contains("★") == false)
			{
				pu.daoUpdatePlayerXiuWei(conn,p1Id, A1, 9);
				pk = pk + "您获得了"+A1+"点修为、"+A2+"点经验值。<br>";
				pk = pk + pu.daoUpdatePlayerLV(conn,p1Id, A2 );
			}
		}catch(Exception e){}	
			
//		try//修改帮派玩家表帮派表  玩家获得等同于经验值的贡献 帮派获得同等经验    没有加入帮会则不会进行
//		{
//			TeamDaoByUser tu = new TeamDaoImpU();
//			TeamPlayerDaoByUser tu2 = new TeamPlayerDaoImpU();
//			int teamId = p1.getTeamId();
//			int TeamPlayerId = tu2.daoSelectTeamPlayerByPlayerId(conn, p1Id).getId();
//			Team t1 = tu.daoSelectTeaminfo(conn, teamId);
//			
//			tu.daoUpdateTeamLv(conn, teamId, A2, t1);//更新帮会经验
//			tu2.daoUpdateTeamPlayerCTB(conn, TeamPlayerId, A2);//更新玩家贡献值
//		}catch(Exception e){}	
		
		try{
			if(p2.getName().contains("★") == false)
			{
				pu.daoUpdatePlayerXiuWei(conn,p2Id, B1, 9);
				pu.daoUpdatePlayerLV(conn,p2Id, B2);
				pk = pk +"被挑战方"+p2.getName()+" 获得了"+B1+"点修为、"+B2+"点经验值。<br>";
			}
		}catch(Exception e){}
		
		//更新双方玩家战斗力
		try
		{
			pu.daoUpdatePlayerPower(conn, p1Id);
			pu.daoUpdatePlayerPower(conn, p2Id);
		}
		catch(Exception e){}
		
		//交换双方排名
		if(result>0)
		{
			try
			{
				if(p1.getRanking() > p2.getRanking())
				{
					pk = pk + "您的排名由 "+p1.getRanking()+" 上升至 "+p2.getRanking()+" !<br>";
				}
				pu.daoUpdatePlayerRanking(conn, p1Id, p2Id);
			}
			catch(Exception e){}
		}
		return pk;
	}
}
