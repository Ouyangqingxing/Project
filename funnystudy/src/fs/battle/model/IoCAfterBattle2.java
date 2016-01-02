package fs.battle.model;

import java.sql.Connection;
import java.sql.SQLException;


import fs.battle.dao.PlayerDaoByUser;
import fs.battle.dao.WeaponDaoByUser;
import fs.battle.daoImp.PlayerDaoImpU;
import fs.battle.daoImp.WeaponDaoImpU;
import fs.common.util.FightEvents;
import fs.common.util.MySQLConnection;

/**根据玩家的战护选择进行二次战斗结果处理
 * @author Jason_★ 
 */
public class IoCAfterBattle2 	
{
	public static String killOrCure(int choose,Player p1,Player p2)
	{
		String pk = "";//文本输出
		if(choose == 1)//治疗 疗伤消耗自身一定修为（对方等级*100），同样获得正义点，前几名玩家如仙剑奇侠榜;被疗伤者获得一个小buff。
		{  
			int point = p2.getLv(); //两个点数的大小获得由被挑战等级决定。
			if(p1.getXiuwei()>point*100)
			{
				//玩家  失去修为    增加正邪点  被动玩家获得经验  
				Connection conn = MySQLConnection.getMySQLConnection();
				PlayerDaoByUser pu = new PlayerDaoImpU();
				try
				{
					conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
					
					pu.daoUpdatePlayerXiuWei(conn,p1.getId(), (point*100), 5);
					pu.daoUpdatePlayerCoreCheck(conn,p1.getId(), p1.getCoreCheck(), (p2.getLv()*10) ); 
					pu.daoUpdatePlayerLV(conn, p2.getId(), 2);
				
					conn.commit();//3、上面的两条SQL执行Update语句成功之后就通知数据库提交事务(commit)
					pk= pk +"您对 "+p2.getName()+"疗伤成功！(获得"+(p2.getLv()*10)+"点灵气,消耗"+point*100+"点修为)<br>"; 
				}
				catch(Exception e)
				{
					try 
					{
						System.out.println("事务开始回滚了！");
						conn.rollback();//2、捕获到异常之后手动通知数据库执行回滚事务的操作
					} 
					catch (SQLException e1) 
					{ 
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
			else
			{
				pk = pk +"您的修为不够！无法为其疗伤。<br>";
			}
		}
		
		
		else if(choose == 0)//残杀 残杀有几率夺得对方武器，双方立即成为“仇人”，我方恶意点（属性增加），
		{					//恶人榜上将展示恶意前几位的玩家，普通玩家击杀有一定奖励（根据恶意点），仇人击杀有额外奖励。
			PlayerDaoByUser pu = new PlayerDaoImpU();

			try{Connection conn = MySQLConnection.getMySQLConnection();
			pu.daoUpdatePlayerCoreCheck(conn,p1.getId(), p1.getCoreCheck(), -10);}
			catch(Exception e){}
			
			pk = pk +"您对 "+p2.getName()+"残杀成功！(获得10点煞气)<br>";
			if(p1.getEquipment().size()<5 && FightEvents.checkHappen(5, p1.getRp()) )//夺得武器  如果成功 随机出一个P2的武器,remove掉该元素并加在p1武器集合里。
			{ 
				for(int i = 0 ; i < p2.getEquipment().size() ; i++)
				{
					if(p2.getEquipment().get(i)==0){continue;}//因为默认均有0 故为0跳过
					if(FightEvents.checkHappen(30, p1.getRp()))//再一次有运势时才能夺得武器
					{
						Connection conn = MySQLConnection.getMySQLConnection();
						try
						{
							//p1获得武器p2丢掉武器  更新武器holder 以及双方玩家weaponId 这里用到事务处理3步操作。
							conn.setAutoCommit(false);//1、通知数据库开启事务(start transaction)
							WeaponDaoByUser wu = new WeaponDaoImpU();
							
							wu.daoUpdataWeaponHolder(conn,p2.getEquipment().get(i), p1.getId());
							pu.daoUpdatePlayerWeapon(conn,p2.getId(), p2.getEquipment().get(i), 5);
							pu.daoUpdatePlayerWeapon(conn,p1.getId(), p2.getEquipment().get(i), 9);
							
							conn.commit();//3、上面的两条SQL执行Update语句成功之后就通知数据库提交事务(commit)
							pk = pk + "您成功夺得  "+p2.getName()+" 的武器---"+wu.daoSelectWeapon(conn, p2.getEquipment().get(i)).getName()+"!!!<br>";
							break;
						}
						catch(Exception e)
						{
							try 
							{
								System.out.println("事务开始回滚了！");
								conn.rollback();//2、捕获到异常之后手动通知数据库执行回滚事务的操作
							} 
							catch (Exception e1) 
							{ 
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				}
			}
			else{pk = pk + "额，从"+p2.getName()+"身上什么都没拿到。<br>";} 
		} 
		return pk;
	}
}
