//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.Camp;
//
///** @author Jason_★
// *	管理员权限下对阵营的增改查操作
// *  增(Camp类似新开服务器可能会有活动)改(Camp)查(Camp Id/全部)
// */
//public interface CampDaoByManager 
//{
//	//增-----------------------------------------------------
//	/** 用于添加阵营信息-管理员权限
//	 * @param name 	   阵营名
//	 * @param remark 阵营备注
//	 */
//	public void daoAddCamp(Connection conn,String name,String remark)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/** 用于修改阵营信息-管理员权限
//	 *  @param id 阵营Id
//	 *  @param name 阵营名
//	 *  @param population 阵营人口 
//	 *  @param remark 阵营备注
//	 */
//	public void daoUpdateCamp(Connection conn,int id,String name,int population,String remark,int teamNumber)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/** 用于查找指定id阵营信息-管理员权限
//	 * @param id 阵营id
//	 * @return 返回一个阵营类
//	 */
//	public Camp daoSelectCampById(Connection conn,int id)throws SQLException;
//	
//	/** 用于查找所有阵营信息-管理员权限
//	 *  @return List<Camp> 阵营集合
//	 */
//	public List<Camp> daoSelectAllCamp(Connection conn)throws SQLException;
//}
