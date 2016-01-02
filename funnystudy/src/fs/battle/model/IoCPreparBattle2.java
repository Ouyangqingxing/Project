package fs.battle.model;

import java.sql.Connection;


import fs.battle.dao.WeaponDaoByUser;
import fs.battle.dao.WuGongDaoByUser;
import fs.battle.daoImp.WeaponDaoImpU;
import fs.battle.daoImp.WuGongDaoImpU;
import fs.common.util.MySQLConnection;

/**战斗准备类2，负责处理战斗中的信息准备
 * @author Jason_★
 */
public class IoCPreparBattle2
{
	/**战斗中让战斗类拿到武功数据的函数，使得让战斗和武功类解耦。
	 * @param WuGongId 武功id
	 * @return 武功
	 */
	public static String[] getWuGonginfo(int WuGongId) 
	{
		//各个类型的武功应有的属性-----------------------------------------------------------
		//	    id ; type=1 ; name; remark 			   buffPower;	 		 		|
		//	    id ; type=2 ; name; remark  buffName;  buffPower; buffRound; hits;  |	
		//	    id ; type=3 ; name; remark  buffName;  buffPower; buffRound; hits;  |
		//	    id ; type=4 ; name; remark  buffName;  buffPower; buffRound; 	    |
		//	    id ; type=5 ; name; remark  buffName;  buffPower;					|
		//			（1被动反击2无需武器武功3需武器武功4临时增益武功5永久被动增益心法）					|	
		//---------------------------------------------------------------------------
		String[] WuGongInfo={"0","三脚猫拳法","江湖上人人都会的皮毛功夫","0","0","0","0","0"};//默认信息(type,name,remark,buffName,buffPower,buffRound,hits,specialNumber)，当type为0即没查到
		if(WuGongId==0){return WuGongInfo;}//由于默认武功武器背包有id为0 ,故为0直接返回默认信息
		try//防止查询数据库时的意外，有意外则返回默认信息
		{
			Connection conn = MySQLConnection.getMySQLConnection();
			
			WuGongDaoByUser wu = new WuGongDaoImpU();
			WuGong wg = wu.daoSelectWuGong(conn,WuGongId);
			
			WuGongInfo[0] = wg.getType()+"";
			WuGongInfo[1] = wg.getName(); 
			WuGongInfo[2] = wg.getRemark();
			WuGongInfo[3] = wg.getBuffName()+"";
			WuGongInfo[4] = wg.getBuffPower()+"";
			WuGongInfo[5] = wg.getBuffRound()+"";
			WuGongInfo[6] = wg.getHits()+""; 
			WuGongInfo[7] = wg.getSpecialNumber()+"";
		}
		catch(Exception e){return WuGongInfo;}
	
		return WuGongInfo;
	}

	/**战斗中让战斗类拿到装备数据的函数，使得战斗和装备解耦。
	 **@param WeaponId 装备Id
	 * @return 装备数组信息
	 */
	public static String[] getWeapon(int WeaponId)//注意因为放置为空而默认添加的0
	{
		//type holderId name remark buffName buffPower specialNumber
		String[] weaponInfo = {"0","0","破木剑","不知道是谁留下的一把剑","0","0","0"};
		if(WeaponId==0){return weaponInfo;}//由于默认武功武器背包有id为0 ,故为0直接返回默认信息
		try//防止查询数据库时的意外，有意外则返回默认信息
		{
			Connection conn = MySQLConnection.getMySQLConnection();
			WeaponDaoByUser wu = new WeaponDaoImpU();
			Weapon wp = wu.daoSelectWeapon(conn,WeaponId);
			
			weaponInfo[0] = wp.getType()+"";
			weaponInfo[1] = wp.getHolderId()+"";
			weaponInfo[2] = wp.getName();
			weaponInfo[3] = wp.getRemark();
			weaponInfo[4] = wp.getBuffName()+"";
			weaponInfo[5] = wp.getBuffPower()+"";
			weaponInfo[6] = wp.getSpecialNumber()+"";
					
		}
		catch(Exception e){return weaponInfo;}

		return weaponInfo;
	}
}
