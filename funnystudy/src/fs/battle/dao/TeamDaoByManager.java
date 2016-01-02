//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.Team;
//
///** @author Jason_★
// *	管理员权限下对 帮会类以及帮会玩家 的增改查操作
// *	增(npc)改(Team防恶意数据_TeamPlayer)查(id/all双表)
// */
//public interface TeamDaoByManager 
//{
//	/** 判断帮会名是否已经存在
//	 * @param teamName 帮会名
//	 * @return 是否存在
//	 */
//	public boolean daoCheckTeamName(Connection conn,String teamName)throws SQLException;
//	
//	//增-----------------------------------------------------
//	/**增加一个帮会-管理员权限
//	 * @param leaderId 创建者id
//	 * @param name 帮会名
//	 * @param remark 帮会说明
//	 */
//	public void daoAddTeam(Connection conn,int leaderId,int campId,String name,String remark)throws SQLException;
//
//	//改-----------------------------------------------------
//	/** 修改帮会信息-管理员权限
//	 * @param id 帮会id
//	 * @param campId 联盟id
//	 * @param leaderId 帮主id
//	 * @param viceLeaderId 副帮主id
//	 * @param name 帮会名
//	 * @param remark 帮会说明
//	 * @param exp 经验
//	 * @param level 等级
//	 * @param population 人口
//	 * @param sign 签到率
//	 */
//	public void daoUpdateTeam(Connection conn,int id,int campId,int leaderId,int viceLeaderId,String name,String remark,int exp,int level,int population,int sign)throws SQLException;
//	
// 
//	
//	//查-----------------------------------------------------
//	
//	/** 查看指定id帮会信息-管理员权限
//	 * @param id 帮会id
//	 * @return 帮会
//	 */
//	public Team daoSelectTeaminfo(Connection conn,int id)throws SQLException;
//	
//	/** 查看所有帮会信息-管理员权限
//	 * @return 帮会集合
//	 */
//	public List<Team> daoSelectAllTeamInfo(Connection conn)throws SQLException;
//	
////	
////	/** 查看所有帮会信息-管理员权限
////	 * @return 帮会集合
////	 */
////	public List<TeamPlayer> daoSelectAllTeamPlayerInfo();
////	
//}
