package fs.common.util;

import java.util.Random;

import fs.battle.model.IoCAfterBattle1;
import fs.battle.model.IoCAfterBattle2;
import fs.battle.model.IoCPreparBattle2;
import fs.battle.model.Player;

/**战斗核心类
 * @author Jason_★  
 */
public class FightEvents 
{	
	/** 功能函数-判读事件能否发生
	 * @param a 事件发生的概率a%
	 * @return 是否能够发生 
	 */
	public static boolean checkHappen(int a,int rp)
	{ 
		//a为事件发生的概率，例如a=10 为10%
		//b为生成在【0-100】的数字，若生成的值小于b 即b<a相当于发生。  
		boolean result = false;
		Random rd = new Random();
		int b = rd.nextInt(100);	
		if(b<a+rp)
		{
			result=true;
		}
		return result;
	}

	/** 功能函数-判读事件能否发生相对于两个值
	 * @param a 事件发生的数值a
	 * @param b	制约事件的数值b
	 * @param rp 增益a
	 * @return 是否能够发生 
	 */
	public static boolean checkHappen2(int a,int b,int rp)
	{ 
		//倍数 与发生概率分别为
		//	10   8   6   4   2   1.5   1
		//	   90  75  50  30  20   10   5
		boolean result = false;//默认不发生
		
		//如果a不及b
		if( (a+rp)<b )
		{
			result = checkHappen(5,rp);
		}
		//当a领先1-1.5倍时 
		else if( (a+rp)<(int)(1.5*b))
		{
			result = checkHappen(10,rp);
		}
		//a领先1.5-2倍
		else if((a+rp)<(int)(2*b))
		{
			result = checkHappen(20,rp);
		}
		//a领先2-4倍
		else if((a+rp)<(int)(4*b))
		{
			result = checkHappen(30,rp);
		}
		//a领先4-6倍
		else if((a+rp)<(int)(6*b))
		{
			result = checkHappen(50,rp);
		}
		//a领先6-8倍
		else if((a+rp)<(int)(8*b))
		{
			result = checkHappen(75,rp);
		}
		//a领先8-10倍
		else if((a+rp)<(int)(10*b))
		{
			result = checkHappen(90,rp);
		}
		//a领先10倍以上
		else
		{
			return true;
		}
		
		return result;
	}
	
	/** 功能函数-得到实际输出值
	 * @param atk 攻击
	 * @param critical 暴击率
	 * @return 实际输出值
	 */
	public static int getRandomDamage(int atk,int critical,int rp)
	{ 
		//取攻击力一半，随机生成一个0至此值间的一个数，加上攻击即为实际输出值。
		Random r1=new Random();
		int number=(int)atk/2;
		int b =atk + r1.nextInt(number);
		
		if(checkHappen(critical,rp))
		{
			//System.out.println("暴击！");
			b=b*2;
		}
		
		return b;
	}

	/** 功能函数-判断战斗结果
	 * @param p1 挑战方
	 * @param p2 被挑战方
	 * @param atker 战斗结束时的攻击者
	 * @param defer 防御者
	 * @return 返回战斗结果
	 */
	public static int getBattleResult(String p1Name,int p1Hp,int p2Hp,int p1realHp,int p2realHp)
	{
		if(p1Hp<0)//如果defer为P1
		{
			if(p2realHp==p2Hp){return -2;}
			else if(p2Hp<=10){return 0;}
			else{return -1;}
		}
		else//atker为p1
		{
			if(p1realHp==p1Hp){return 3;}
			else if(p1Hp<=10){return 1;}
			else{return 2;}
		}
	}
	
	/** 功能函数-buff时候调用
	 * @param buffName buff的属性
	 * @param buffPower buff的强度
	 * @param p1 buff的玩家
	 * @return 玩家
	 */
	public static Player buff(int buffName,int buffPower,Player p1)
	{
		switch(buffName)
		{
			case 1:{	p1.setAtk((int)(p1.getAtk()*buffPower/100));		break;}
			case 2:{	p1.setDef((int)(p1.getDef()*buffPower/100));		break;}
			case 3:{	p1.setSpd((int)(p1.getSpd()*buffPower/100));		break;}
			case 4:{	p1.setRp((int)(p1.getRp()+buffPower));			break;}
			case 5:{	p1.setCritical((int)(p1.getCritical()+buffPower));	break;}
			case 6:{	p1.setDodge((int)(p1.getDodge()+buffPower));	break;}
		}

		return p1;
	}
	
	/** 功能函数-debuff buff时间到了调用
	 * @param buffName buff的项目123456分别为atk/def/spd/rp/critical/dodge
	 * @param buffPower buff时提升的强度，为buffPower%
	 * @param p1 buff的玩家
	 * @return 返回正常状态的玩家
	 */
	public static Player debuff(int buffName,int buffPower,Player p1)
	{
		switch(buffName)
		{
			case 1:
			{	
				double f =(double)(p1.getAtk()*100/ buffPower);
				p1.setAtk((int)f);		
				break;
			}
			case 2:
			{	
				double f =(double)(p1.getDef()*100/ buffPower);
				p1.setDef((int)f);
				break;
			}
			case 3:
			{	
				double f =(double)(p1.getSpd()*100/ buffPower);
				p1.setSpd((int)f);
				break;
			}
			case 4:
			{		 
				p1.setRp(p1.getRp()-buffPower);
			}
			case 5:
			{	
				p1.setCritical(p1.getCritical()-buffPower);
				break;
			}
			case 6:
			{	 
				p1.setDodge(p1.getDodge()-buffPower);
				break;
			}
		}
		return p1;
	}

	/**战斗函数 
	 * @param p1 挑战玩家
	 * @param p2 被挑战玩家
	 * @return 战斗结果 0/-1/-2   p1惜败/战败/完败         1/2/3   险胜/战胜/完胜
	 */
	public static String Battle(Player p1,Player p2)
	{
//[1、战前准备]回合制，战斗闪避以及先手以及伤害根据双方属性而定----------------------------------------------------		
		int p1RealHp = p1.getHp();//拿到初始生命，用于最后判断战斗的结果类型。
		int p2RealHp = p2.getHp();
		int[][] buffImfo = new int[10][4];//各种Buff施展时信息的保存，由于buff均有时效，每回合将减少数值，为0时调用debuff函数将需要数组里的信息。
				//格式 剩余回合数+Buff的属性+幅度+玩家    如【0】【0】=5（回合）   【0】【1】=1（攻击atk） 【0】【2】=50（幅度为50%） 【0】【3】=1 （p1）	
		int buffI=0;			//buff数组游标，表示当前放置Buff信息的下标
		int result = -1;		//挑战方是否获胜 默认为失败
		int round=1;				//记录战斗回合，但这里并不是直接等于回合数
		int hits =1;				//攻击方可以攻击的次数,每次攻击后--。当施展武功等情况时可能将其值改变，详见F。
		boolean checkMiss=false;	//防守方是否可以闪避的一个参数,正常情况下是false。当攻击方使用必中武器等情况时可能将其值改变，详见C。
		
		Player atker = p1;			//默认p1先进攻
		Player defer = p2;
		
		if(p1.getSpd()<p2.getSpd())//根据双方速度判断先手进攻玩家,相等时主动挑战方先手攻击
		{
			atker = p2;
			defer = p1;
		}
		
//[2、开始战斗]-----------------------------------------------------------------------------------
		String battleInfo = "";
		while(true)//整个战斗回合循环
		{ 
			if(round==100)
			{
				battleInfo = battleInfo + "双方玩家大战一百回合不分上下，现根据血量判断胜负。<br>";
				if(p1.getHp()>p2.getHp())
				{
					result = 2;
				}
				else
				{
					result = -1;
				}
				break;
			}
			//System.out.println("rp = " + p1.getRp());
//			if(round%2 != 0 && round != 1)//round每加2才过了一回合，故应该在round为1 3 5时为第1 2 3回合
//			{
//				//System.out.println("round = " + round);
//				//System.out.println("第 "+ (round+1)/2 +" 回合！");
//			}
			
			battleInfo = battleInfo +"第 "+round+" 回合！<br>";
			round++;
			
			for(int i=0;i<buffImfo.length;i++)//新的回合开始，所有用于记录buff信息的数组的记录buff持续回合的数减一。
			{	
				if(buffImfo[i][0]==1)//如果如果为1，调用debuff
				{
					if(buffImfo[i][3]==1){p1=debuff(buffImfo[i][1], buffImfo[i][2],p1);}
					if(buffImfo[i][3]==2){p2=debuff(buffImfo[i][1], buffImfo[i][2],p2);}
					buffImfo[i][0]--;
				}
				else if(buffImfo[i][0]==0)//如果已经灭没有信息，则说明都不做
				{
					
				}
				else//剩余buff持续回合数-1
				{
					buffImfo[i][0]--;
				}
			}
			String[] AtkerWuGongInfo = {"0","三脚猫拳法","江湖上人人都会的皮毛功夫","0","0","0","0","0"};
	/*	A.判断攻击方是否能施展进攻型武功或者buff型武功    施展/不施展---------------------------------------------
	checkHappen(20); True: 修改hits(绝大多数)、buffRound   Buff(属性名，幅度，持续回合,Player)该函数应在处理Player属性的IoC里  /False:无								*/
			//A1、首先要有运势施展
			if(checkHappen(30,atker.getRp()))
			{ 
			//A2、在攻击者拥有的进攻型、Buff型武功中选一个进行（如果没有则结束）
				for(int i = 0 ; i < atker.getWugong().size() ; i++ )
				{
					int strTemp = Integer.parseInt(	IoCPreparBattle2.getWuGonginfo(atker.getWugong().get(i))[0] );
					 
					if(strTemp==2 || strTemp==3 || strTemp==4)//满足要求
					{
						if(checkHappen(30,atker.getRp()))//再次判断运势，如果能发生则拿到武功信息退出循环
						{ 
							AtkerWuGongInfo = IoCPreparBattle2.getWuGonginfo(atker.getWugong().get(i));
							break;
						}
					}
				}
				
			//A3、进行相应的buff操作、修改buffImfo信息。
				//A3.1.1如果是需要武器型的武功，这里进行判断是否有对应所需类型的武器。1-5剑	刀 匕 暗器 棍
				if(AtkerWuGongInfo[0].equals("3"))
				{
				//A3.1.2拿到武功所需的武器类型
					int type = Integer.parseInt( AtkerWuGongInfo[7] );
					for(int i = 0 ; i < atker.getEquipment().size() ; i++)
					{
						int WeaponType = Integer.parseInt(IoCPreparBattle2.getWeapon( atker.getEquipment().get(i) )[0]);
				//A3.1.3如果有对应的武器，buffPower增强为200%
						if(WeaponType==type)
						{
							AtkerWuGongInfo[4]=(Integer.parseInt(AtkerWuGongInfo[4])*2)+"";
							break;
						}
					}
				}
				//A3.2.1对施展者进行增益 注意如果之前没拿到武功无法进行
				if(AtkerWuGongInfo[0].equals("0") == false)
				{
					battleInfo = battleInfo + "逆天！ "+atker.getName()+"竟然施展了传说中的武功 "+AtkerWuGongInfo[1]+"<br>";
					atker=buff(Integer.parseInt(AtkerWuGongInfo[3]),Integer.parseInt(AtkerWuGongInfo[4]),atker);	
						 
					//A3.2.2放置buff信息进数组
					buffImfo[buffI][0]=Integer.parseInt(AtkerWuGongInfo[5]);//buff持续回合					
					buffImfo[buffI][1]=Integer.parseInt(AtkerWuGongInfo[3]);//buffName				 
					buffImfo[buffI][2]=Integer.parseInt(AtkerWuGongInfo[4]);//buffPower
					if(atker.getName().equals(p1.getName())){buffImfo[buffI][3]=1;}//buff的玩家
					else{buffImfo[buffI][3]=2;} 
					hits=Integer.parseInt(AtkerWuGongInfo[6]);//更新连击数 和 当前buff数组游标
					buffI++;
					if(buffI==10){buffI=0;}
					if(AtkerWuGongInfo[7].equals("-1"))
					{
						checkMiss = true;
					}
					
				}
			}		
			
	/*	B.攻击方进攻 ,判断防守方能否闪避, 闪避/不闪避 则防守方承受伤害，减少hp  	 
	getRandomDamage(atker.atk)  Hits--		
	checkHappen(defer.dodge)||checkMiss;				
	defer.setHp(defer.gerHp-damage)	*/
			battleInfo = battleInfo + atker.getName()+"发动了进攻！<br>";
			//B.1 判断防守方是否能闪避	 闪避成功则不进入，否则进入				 						
			if(	 checkMiss||(!checkHappen(  defer.getDodge() , defer.getRp() ))	)
			{
				int damage = getRandomDamage(atker.getAtk(),(int)(atker.getCritical()*100),defer.getRp())-defer.getDef();
				if(damage<0){damage=1;}//如果无法破防伤害为1
				else if(AtkerWuGongInfo[7].equals("-2"))
				{
					atker.setHp((int)(0.5*damage));
					battleInfo = battleInfo + "嗜血！<br>";
				}
				
				int lastHp = defer.getHp()-damage;
				defer.setHp(lastHp);
				battleInfo = battleInfo + defer.getName()+"承受了此次攻击，受到了 "+damage+"("+lastHp+")" +" 点伤害！<br>";
				if(defer.getHp()<0)//判断是否死亡 Hp<0
				{			
					result=getBattleResult(p1.getName(),p1.getHp(),p2.getHp(),p1RealHp,p2RealHp);//交由getBattleResult函数来判断战斗结果	
					break;
				}
				
	/*	C.判断防守方是否能施展反击型武功  		施展/不施展
	checkHappen(10)		True:Buff(属性名，幅度，持续回合,Player)/False:无*/
				//C.1首先需要有一些运势 并且 攻击方攻击时破防了
				if(checkHappen(20,defer.getRp()) && damage>1) 
				{	
					String[] DeferWuGonginfo = {"0","三脚猫拳法","江湖上人人都会的皮毛功夫","0","0","0","0","0"};
					
				//C.2其次判断能否施展
					for(int i = 0 ; i < defer.getWugong().size() ; i++)
					{
						String strTemp = IoCPreparBattle2.getWuGonginfo(defer.getWugong().get(i))[0];
						if(checkHappen(50,defer.getRp()) && strTemp.equals("1"))
						{
							DeferWuGonginfo = IoCPreparBattle2.getWuGonginfo(defer.getWugong().get(i));
							break;
						}
					}
					
					if(DeferWuGonginfo[0].equals("0") == false)
					{
						battleInfo = battleInfo + "逆天！ "+defer.getName()+"竟然施展了传说中的武功 "+DeferWuGonginfo[1]+"<br>";
						int damage2 = damage * Integer.parseInt(DeferWuGonginfo[4]) / 100 - atker.getDef();
						if(damage2<0){damage2=0;}//如果无法破防伤害为0
						int lastHp2 = atker.getHp()-damage2;
						atker.setHp(lastHp2);
						battleInfo = battleInfo+atker.getName()+"承受了此次攻击，受到了 "+damage2+"("+lastHp2+")" +" 点伤害！<br>";
						if(atker.getHp()<0)//判断是否死亡 Hp<0
						{			
							result=getBattleResult(p1.getName(),p1.getHp(),p2.getHp(),p1RealHp,p1RealHp);//交由getBattleResult函数来判断战斗结果	
							break;
						}
					}
				}  
			}
			else
			{
				battleInfo = battleInfo + defer.getName()+"躲过了此次攻击！<br>";
			}
			hits--;//初始为1,每发动一次进攻hits减一,攻击方攻击结束后如果>0则继续攻击。
			if(hits<0){hits=0;}
			
	/*	D.判断攻击方是否能跳过对手一回合  					跳过/不跳过
	checkHappen(atker.spd-defer.spd)||Hits>0  	True 则回到a/ False交换攻击防守方并到a					 */
			if( hits>0 || checkHappen2(atker.getSpd(), defer.getSpd() ,atker.getRp())    )
			{ 
				battleInfo = battleInfo + "斯国一..."+atker.getName()+"凭借着速度的优势继续发动进攻！！！<br>";	
			}
			else
			{
				hits=1;
				Player temp=atker;
				atker = defer;
				defer = temp;
			}
		}
		
		battleInfo = battleInfo + IoCAfterBattle1.getBattleResult(result,p1.getId(),p2.getId());
		if(result > 0)
		{
			battleInfo = battleInfo + "(≧▽≦)y您获得了胜利！<br>";
			
			battleInfo = battleInfo + IoCAfterBattle2.killOrCure(p1.getPk(), p1, p2);
		}			
		else
		{
			battleInfo = battleInfo + "您战败了QAQ。<br>";
		} 
		return battleInfo;
	}	
}
