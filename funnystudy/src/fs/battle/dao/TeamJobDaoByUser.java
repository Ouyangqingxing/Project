//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import fs.battle.model.TeamJob;
//
///** @author Jason_★
// *	用户权限下对【帮会职位类】的增改查操作
// *	增()改()查(id)
// */
//public interface TeamJobDaoByUser 
//{
//	//增-----------------------------------------------------
//	/** 增加一个帮会名称-用户权限
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
//	/** 修改一个帮会名称-用户权限
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
//	/** 根据已知帮会id得到帮会昵称
//	 * @param conn 链接
//	 * @param teamId 帮会id
//	 * @return
//	 * @throws SQLException
//	 */
//	public TeamJob daoSelectTeamJobByTeamId(Connection conn,int teamId)throws SQLException;
//	
//	/** 查看一个已知id的帮会名称信息-用户权限
//	 * @param id 帮会名称id
//	 * @return 帮会名称
//	 */
//	public TeamJob daoSelectTeamJobById(Connection conn,int id)throws SQLException;
//}
