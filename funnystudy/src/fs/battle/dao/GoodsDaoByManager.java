//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.Goods;
//
///** @author Jason_★
// *	管理员权限下对【物品类】的增改查操作
// *	增()改()查(id/all)
// */
//public interface GoodsDaoByManager 
//{
//	//增-----------------------------------------------------
//	/** 增加一个新的物品-管理员权限
//	 * @param name 物品名
//	 * @param type 物品类型
//	 * @param buffName 物品增益属性
//	 * @param buffPower 物品增益强度
//	 */
//	public void daoAddGoods(Connection conn,String name,String remark,int type,int buffName,int buffPower)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/** 修改一个物品-管理员权限
//	 * @param id 被修改的物品id
//	 * @param name 物品名
//	 * @param type 物品类型
//	 * @param buffName 物品增益属性
//	 * @param buffPower 物品增益强度
//	 */
//	public void daoUpdateGoods(Connection conn,int id,String name, String remark,int type,int buffName,int buffPower)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/** 查看一个已知id的物品信息-管理员权限
//	 * @param id 物品id
//	 * @return 物品对象
//	 */
//	public Goods daoSelectGoods(Connection conn,int id)throws SQLException;
//	
//	/** 查看所有物品信息-管理员权限
//	 * @return 物品集合
//	 */
//	public List<Goods> daoSelectAllGoods(Connection conn)throws SQLException;
//}
