package fs.battle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fs.battle.model.Weapon;

/** @author Jason_★
 *	用户权限下对【武器以及因为影响对背包类】的改查操作
 *	改()查(id)
 */
public interface WeaponDaoByUser
{
	//改-----------------------------------------------------
	/**玩家争夺武器成功时时修改武器持有者
	 * @param id 武器id
	 */
	public void daoUpdataWeaponHolder(Connection conn,int id,int newHolderId)throws SQLException;
	
	//查-----------------------------------------------------
	/**查看一个已知id武器的属性-用户权限 
	 * @param id 武器id
	 * @return 武器类
	 */
	public Weapon daoSelectWeapon(Connection conn,int id)throws SQLException;
	
//	/**根据一个玩家的装备属性(String)拿到具体的武器集合
//	 * @param conn 链接
//	 * @param weapon 玩家的武器属性(String)
//	 * @return 武器集合
//	 * @throws SQLException
//	 */
//	public List<Weapon> daoSelectWeapon(Connection conn,String weapon)throws SQLException;
	
	/**查询所有的武器
	 * @param conn 链接
	 * @return 武器集合
	 * @throws SQLException
	 */
	public List<Weapon> daoSelectAllWeapon(Connection conn)throws SQLException;
}
