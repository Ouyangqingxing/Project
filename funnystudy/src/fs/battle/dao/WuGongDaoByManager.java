//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.WuGong;
//
///** @author Jason_★
// *	管理员权限下对【武功类】的增改查操作
// *	增()改()查(id/all)
// */
//public interface WuGongDaoByManager
//{
//	//增-----------------------------------------------------
//	/** 增加一个武功-管理员权限
//	 * @param type 武功类型（1被动反击2无需武器武功3需武器武功4临时增益武功5永久被动增益心法）
//	 * @param name 武功名
//	 * @param remark 武功说明
//	 * @param buffName 武功强化的属性
//	 * @param buffPower 武功强化的强度
//	 * @param buffRound 武功强化的回合
//	 * @param hits 连击数
//	 */
//	public void daoAddWuGong(Connection conn,int type , String name ,String remark, int buffName,int buffPower,int buffRound,int hits,int specialNumber )throws SQLException;
//	
//	//改-----------------------------------------------------	
//	/** 修改一个武功-管理员权限
//	 * @param id 武功id
//	 * @param type 武功类型（1被动反击2无需武器武功3需武器武功4临时增益武功5永久被动增益心法）
//	 * @param name 武功名
//	 * @param remark 武功说明
//	 * @param buffName 武功强化的属性
//	 * @param buffPower 武功强化的强度
//	 * @param buffRound 武功强化的回合
//	 * @param hits 连击数
//	 */
//	public void daoUpdateWuGong(Connection conn,int id,int type , String name ,String remark, int buffName,int buffPower,int buffRound,int hits,int specialNumber)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/** 查看所有武功信息-管理员权限
//	 * @return 武功集合
//	 */
//	public List<WuGong> daoSelectAllWuGong(Connection conn)throws SQLException;
//	
//	/** 查看指定id的武功-管理员权限 
//	 * @param id 武功id
//	 * @return 武功对象
//	 */
//	public WuGong daoSelectWuGong(Connection conn,int id)throws SQLException;
//}
