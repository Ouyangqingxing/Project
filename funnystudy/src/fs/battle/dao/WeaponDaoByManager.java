//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.Weapon;
//
///** @author Jason_★
// *	管理员权限下对【武器以及因为影响对背包类】的增改查操作
// *	增()改()查(id/all)
// */
//public interface WeaponDaoByManager
//{
//	//增-----------------------------------------------------
//	/** 增加一个新的武器-管理员权限
//	 * @param type 武器类型
//	 * @param name 武器名
//	 * @param remark 武器说明
//	 * @param buffName 武器buff的属性
//	 * @param buffPower 武器buff的强度
//	 */
//	public void daoAddWeapon(Connection conn,int type,String name,String remark,int buffName,int buffPower,int specialNumber)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/**修改一个武器的属性-管理员权限
//	 * @param id 武器id
//	 * @param type 武器类型
//	 * @param name 武器名
//	 * @param remark 武器说明
//	 * @param buffName 武器buff的属性
//	 * @param buffPower 武器buff的强度
//	 */
//	public void daoUpdateWeapon(Connection conn,int id,int type,int holderId,String name,String remark,int buffName,int buffPower,int specialNumber)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/**查看所有武器的属性-管理员权限
//	 * @param List<Weapon> 武器集合
//	 */
//	public List<Weapon> daoSelectAllWeapon(Connection conn)throws SQLException;
//	
//	/**查看一个已知id武器的属性-管理员权限 
//	 * @param id 武器id
//	 * @return 武器类
//	 */
//	public Weapon daoSelectWeapon(Connection conn,int id)throws SQLException;
//}
