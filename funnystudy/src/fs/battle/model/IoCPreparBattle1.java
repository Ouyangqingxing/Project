package fs.battle.model;

import java.sql.Connection; 

 
import fs.battle.dao.WeaponDaoByUser;
import fs.battle.dao.WuGongDaoByUser; 
import fs.battle.daoImp.WeaponDaoImpU;
import fs.battle.daoImp.WuGongDaoImpU;
import fs.common.util.LuckNumber;
import fs.common.util.MySQLConnection;

/**战斗开始前进行准备的类
 * @author Jason_★ 
 */
public class IoCPreparBattle1  
{
	/**判断双方是否可以进行战斗(如有封号修炼的State状态的玩家、战斗次数不足的玩家)
	 * @param p 待检测的玩家
	 * @return 结果
	 */
	public static boolean checkBattle(Player p,int check)
	{
		boolean result = true;
		if(p.getLastFightChance()<1 && check == 1)
		{
			result = false;
		}
		if(p.getState() != 1 )
		{
			result = false;
		}
		return result;
	}
	
	
	/**准备战斗的函数。使得战斗类和武功装备等类解耦。
	 * @param p 直接拿到一个即将战斗的玩家
	 * @return 读取玩家的buff属性并得到实际属性【包括永久buff型武功、装备产生的buff、帮会等级buff、玩家自身buff属性、可能出现的luckNumberBuff】。
	 */
	public static Player preparBattle(Player p)
	{
		p = prepar1(p);
		p = prepar2(p);
		//p = prepar3(p);
		//p = prepar4(p);
		p = prepar5(p);
		
		return p;
	}
	
	public static Player prepar1(Player p)
	{
		//1、永久buff型武功
		//获取玩家WuGongId集合	→	根据此id集合查WuGong type为5的 	→ 如果有则依次根据buffName buffPower更新Player属性/否则不做处理（1被动反击2无需武器武功3需武器武功4临时增益武功5永久被动增益心法）
		WuGongDaoByUser wu1 = new WuGongDaoImpU();
		for(int i = 0 ; i < p.getWugong().size() ; i++)
		{
			if(p.getWugong().get(i)==0){continue;}//由于默认武器武功背包均有0，故取到0时直接continue
			int WuGongType;	
			int buffPower;
			int buffName;
					
			try//这里为了防止取到的数据因为各种可能出现的意外，如果有意外则无视此id,continue,增强鲁棒性
			{ 
				Connection conn = MySQLConnection.getMySQLConnection();
				WuGongType = wu1.daoSelectWuGong(conn,p.getWugong().get(i)).getType();
				buffPower = wu1.daoSelectWuGong(conn,p.getWugong().get(i)).getBuffPower();
				buffName  =	wu1.daoSelectWuGong(conn,p.getWugong().get(i)).getBuffName();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				continue;
			}
						
			if(WuGongType == 5)//如果进行到这儿 则可以取出buffpower buffName 进行buff
			{
				switch(buffName)//如果拿到的数据没有问题进行buff
				{
					case 1:{p.setAtk( (int)( p.getAtk()*buffPower) );			break;}
					case 2:{p.setDef( (int)( p.getDef()*buffPower) );			break;}
					case 3:{p.setSpd( (int)( p.getSpd()*buffPower) );			break;}
					case 4:{p.setRp( (int)( p.getRp()+5) );			break;}
					case 5:{p.setCritical( (int)( p.getCritical()+5) );			break;}
					case 6:{p.setDodge( (int)( p.getDodge()+5) );			break;}
							 
					default:
					{
						break;
					}
				} 
			}
		}
		return p;
	}
	
	public static Player prepar2(Player p)
	{
		//2、装备产生的buff	
		//获取玩家WeaponId集合	→	根据此id集合依次拿到Weapon的buffName buffPower更新Player属性	
		WeaponDaoByUser wu2 = new WeaponDaoImpU();
		for(int i = 0 ; i < p.getEquipment().size() ; i++  )
		{
			if(p.getEquipment().get(i)==0){continue;}//由于默认武器武功背包均有0，故取到0时直接continue
			
			int buffName;
			int buffPower;
			
			try//这里为了防止取到的数据因为各种可能出现的意外，如果有意外则无视此id,continue,增强鲁棒性
			{
				Connection conn = MySQLConnection.getMySQLConnection();
				buffName = wu2.daoSelectWeapon(conn,p.getEquipment().get(i)).getBuffName();
				buffPower = wu2.daoSelectWeapon(conn,p.getEquipment().get(i)).getBuffPower();
			}
			catch(Exception e)
			{
				continue;
			}
			
			switch(buffName)//如果拿到的数据没有问题进行buff
			{
				case 1:{p.setAtk( (int)( p.getAtk()*buffPower) );			break;}
				case 2:{p.setDef( (int)( p.getDef()*buffPower) );			break;}
				case 3:{p.setSpd( (int)( p.getSpd()*buffPower) );			break;}
				case 4:{p.setRp( (int)( p.getRp()+20) );			break;}
				case 5:{p.setCritical( (int)( p.getCritical()+20) );			break;}
				case 6:{p.setDodge( (int)( p.getDodge()+20) );			break;}
				 
				case 7://攻速
				{
					p.setAtk( (int)( p.getAtk()*buffPower) );
					p.setSpd( (int)( p.getSpd()*buffPower) );		
					break;
				}
				
				case 8://运速
				{
					p.setDodge( (int)( p.getDodge()*buffPower) );
					p.setRp( (int)( p.getRp()+20) );
					break;
				}
				
				case 9://攻防
				{
					p.setAtk( (int)( p.getAtk()*buffPower) );
					p.setDef( (int)( p.getDef()*buffPower) );	
					break;
				}
				
				case 10://攻暴
				{
					p.setAtk( (int)( p.getAtk()*buffPower) );
					p.setCritical( (int)( p.getCritical()+20) );
					break;
				}
				default:
				{
					break;
				}
			}
		}
		return p;
	}
	
//	public static Player prepar3(Player p)
//	{
		//3、帮会等级buff		(帮主/副帮主 加成)
		//根据玩家id去查TeamPlayer	→ 有结果则拿到TeamId/否则未入帮会结束		→	根据TeamId拿到TeamLevel（TeamLv	0-N	无	无	    1.2倍体       1.5倍体	  1.5体1.2攻		1.5攻体	  1.5攻体1.2防 	 1.5攻体防 	 1.5攻体防1.2速  	1.5攻体防速		1.8攻体防速	1.8+ 0.4*（N-10）攻速体防）	
//		TeamDaoByUser tp = new TeamDaoImpU();
//		
//		int lv=1;
//		double times1 = 1.2;
//		double times2 = 1.5;
//		double times3 = 1.8;
//		boolean authority = false;
//		
//		try//如果发生异常则不做操作认为帮会为1级 不进行buff 
//		{
//			Connection conn = MySQLConnection.getMySQLConnection();
//			lv = tp.daoSelectTeamLv(conn,p.getTeamId());//获得帮会等级
//			authority = tp.daoCheckAuthority(conn, p.getId(), p.getTeamId());//判断是否有权限
//		} 
//		catch (SQLException e){} // 如果有异常则说明还没有加入帮会直接跳过
//		
//		if(authority)//(帮主/副帮主 加成)
//		{
//			times1 = times1 * 2;
//			times2 = times2 * 2;
//			times3 = times3 * 2;
//		}
//		
//		if(lv>10)//1.8+ 0.4*（N-10）攻速体防
//		{
//			double multiple = 1.8 + 0.4*(lv-10);
//			p.setHp(	(int)(p.getHp()*multiple));
//			p.setAtk(	(int)(p.getAtk()*multiple));
//			p.setDef(	(int)(p.getDef()*multiple));
//			p.setSpd(	(int)(p.getSpd()*multiple));
//		}
//		else
//		{
//			switch(lv)
//			{
//				case 2:{	p.setHp(	(int)(p.getHp()*times1));	break;}//1.2hp
//				case 3:{	p.setHp(	(int)(p.getHp()*times2));	break;}//1.5hp
//				case 4://1.5体1.2攻
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times1));
//					break;
//				}
//				case 5://1.5攻体
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times2));
//					break;
//				}  
//				case 6:// 1.5攻体1.2防
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times2));
//					p.setDef(	(int)(p.getDef()*times1));
//					break;
//				}
//				case 7://1.5攻体防
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times2));
//					p.setDef(	(int)(p.getDef()*times2));
//					break;
//				}
//				case 8:// 1.5攻体防1.2速 
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times2));
//					p.setDef(	(int)(p.getDef()*times2));
//					p.setSpd(	(int)(p.getSpd()*times1));
//					break;
//				}
//				case 9://1.5攻体防速
//				{	
//					p.setHp(	(int)(p.getHp()*times2));
//					p.setAtk(	(int)(p.getAtk()*times2));
//					p.setDef(	(int)(p.getDef()*times2));
//					p.setSpd(	(int)(p.getSpd()*times2));
//					break;
//				}
//				case 10://1.8攻体防速
//				{	
//					p.setHp(	(int)(p.getHp()*times3));
//					p.setAtk(	(int)(p.getAtk()*times3));
//					p.setDef(	(int)(p.getDef()*times3));
//					p.setSpd(	(int)(p.getSpd()*times3));
//					break;
//				}
//				default :
//				{
//					break;
//				} 
//			}
//		}
//		return p;
//	}
	
//	public static Player prepar4(Player p)
//	{
		//4、玩家自身因药品产生的buff属性
		//取得玩家的buff属性 → 如果非0则按照对应的情况进行增益（buff0-10		无buff   atk	  def	  spd	   rp	 critical	dodge	攻速	速闪	体防	攻速体防）
//		switch(p.getBuff())
//		{
//			case 1:{	p.setHp(p.getHp()*2);break;}
//			case 2:{	p.setAtk(p.getAtk()*2);break;}
//			case 3:{	p.setDef(p.getDef()*2);break;}
//			case 4:{	p.setSpd(p.getSpd()*2);break;}
//			case 5:{	p.setRp(p.getRp()+5);break;} 
//			case 6:{	p.setDodge(p.getDodge()+5);break;}
//			case 7:{	p.setAtk(p.getAtk()*2);p.setSpd(p.getSpd()*2);	break;}
//			case 8:{	p.setSpd(p.getSpd()*2);p.setDodge(p.getDodge()+5);break;}
//			case 9:{	p.setHp(p.getHp()*2);p.setDef(p.getDef()*2);break;}
//			case 10:{	p.setHp(p.getHp()*2);p.setAtk(p.getAtk()*2);p.setSpd(p.getSpd()*2);p.setDef(p.getDef()*2);break;}
//			default :
//			{
//				break;
//			} 
//		}
//		return p;
//	}
	
	public static Player prepar5(Player p)
	{
		//5、luckNumberBuff:	
		//取到今天的luckNumber/玩家所属盟id/玩家正邪点 → 如果符合则进行增益（luckNumber0-10      无	双倍修为    双倍经验	1盟1.5倍攻  2盟1.5倍攻	3盟1.5倍攻  1萌2倍体	 2萌2倍体     3萌2倍体	 恶人1.2倍攻速体防	仙侠1.2倍攻速体防） 
		int CampId = p.getCampId();
		switch (LuckNumber.getLuckNumber())
		{
			case 3: 
			{	
				if(CampId == 1){  	p.setAtk(	 (int)(p.getAtk()*1.5)	);	}	
				break;
			}
			case 4: 
			{
				if(CampId == 2){		p.setAtk(	 (int)(p.getAtk()*1.5)	);	}
				break;
			}
			case 5: 
			{
				if(CampId == 3){		p.setAtk(	 (int)(p.getAtk()*1.5)	);	}
				break;
			}
			case 6: 	
			{
				if(CampId == 1){		p.setHp(	 p.getHp()*2	)		;	}	
				break;
			}
			case 7: 
			{
				if(CampId == 2){		p.setHp(	 p.getHp()*2	)		;	}
				break;
			}
			case 8: 
			{
				if(CampId == 3){		p.setHp(	 p.getHp()*2	)		;	}
				break;
			}
			case 9: 
			{
				if(p.getCoreCheck()<0)
				{
					p.setHp(	 	 (int)(	 p.getHp()*1.2	)	);
					p.setAtk(	 (int)(	 p.getAtk()*1.2	)	);
					p.setDef(	 (int)(	 p.getDef()*1.2	)	);
					p.setSpd(	 (int)(	 p.getSpd()*1.2	)	);
				}
				break;
			}
			case 10: 
			{
				if(p.getCoreCheck()>0)
				{
					p.setHp(	 	 (int)(	 p.getHp()*1.2	)	);
					p.setAtk(	 (int)(	 p.getAtk()*1.2	)	);
					p.setDef(	 (int)(	 p.getDef()*1.2	)	);
					p.setSpd(	 (int)(	 p.getSpd()*1.2	)	);
				}
				break;
			}
			default :
			{
				break;
			} 
		}
		return p;
	}
}
