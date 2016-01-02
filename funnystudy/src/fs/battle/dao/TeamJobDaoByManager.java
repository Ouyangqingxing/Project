//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.TeamJob;
//
///** @author Jason_★
// *	管理员权限下对【帮会职位类】的增改查操作
// *	增()改()查(2id/all)
// */
//public interface TeamJobDaoByManager 
//{
//	//增-----------------------------------------------------
//	/** 增加一个帮会名称-管理员权限
//	 * @param team_id	帮会Id
//	 * @param oneName	1级名字
//	 * @param twoName	2级名字
//	 * @param threeName	3级名字
//	 * @param fourName	4级名字
//	 * @param fiveName	5级名字
//	 */
//	public void daoAddTeamJob(Connection conn,int team_id,String oneName,String twoName,String threeName,String fourName,String fiveName)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/** 修改一个帮会名称-管理员权限
//	 * @param id 帮会名称id
//	 * @param oneName	1级名字
//	 * @param twoName	2级名字
//	 * @param threeName	3级名字
//	 * @param fourName	4级名字
//	 * @param fiveName	5级名字
//	 */
//	public void daoUpdateTeamJob(Connection conn,int id,String oneName,String twoName,String threeName,String fourName,String fiveName)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/** 查看一个已知id的帮会名称信息-管理员权限
//	 * @param id 帮会名称id
//	 * @return 帮会名称
//	 */
//	public TeamJob daoSelectTeamJobById(Connection conn,int id)throws SQLException;
//	
//	/** 查看所有帮会名称信息-管理员权限
//	 * @return 帮会名称集合
//	 */
//	public List<TeamJob> daoSelectAllTeamJob(Connection conn)throws SQLException;
//}
