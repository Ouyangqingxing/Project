//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.Team;
//
///** @author Jason_★
// *	用户权限下对帮会类的增删改查操作
// *	增()删(注意该操作将影响多张表！！！)改(注意TeamPlayer表的修改)查()
// */
//public interface TeamDaoByUser
//{
//	/** 判断帮会名是否已经存在
//	 * @param teamName 帮会名
//	 * @return 是否存在
//	 */
//	public boolean daoCheckTeamName(Connection conn,String teamName)throws SQLException;
//	
//	/** 判断玩家是否有权限操作帮会信息
//	 * @param conn 链接
//	 * @param playerId 玩家id
//	 * @param teamId 帮会id
//	 * @return
//	 * @throws SQLException
//	 */
//	public boolean daoCheckAuthority(Connection conn,int playerId,int teamId)throws SQLException;
//	
//	//增-----------------------------------------------------
//	/**增加一个帮会-玩家权限
//	 * @param leaderId 创建者id
//	 * @param name 帮会名
//	 * @param remark 帮会说明
//	 */
//	public void daoAddTeam(Connection conn,int leaderId,int campId,String name,String remark)throws SQLException;
//	
//	//删-----------------------------------------------------
//	/**删除即解散 一个帮会(注意不仅是单删除同时要更新player、Camp、TeamPlayer)  正帮主权限
//	 * @param String[]  帮会id数组
//	 */
//	public void daoDelete(Connection conn,String[] userids )throws SQLException;
// 
//	
//	//改-----------------------------------------------------
// 
//	
//	/**修改副帮主信息 -正帮主权限
//	 * @param teamId 帮会id
//	 * @param viceLeaderId 新任副帮主id（playerId）
//	 */
//	public void daoUpdateTeamViceLeader(Connection conn,int teamId,int viceLeaderId)throws SQLException;
//	
//	/**修改帮会说明-帮主权限
//	 * @param teamId 帮会id 
//	 * @param remark 新的帮会说明
//	 */
//	public void daoUpdateTeamRemark(Connection conn,int teamId,String remark)throws SQLException;
//	
//	/**修改帮会等级、经验(有一定算法，拿到经验后判断是否升级)-帮主+帮友权限
//	 * @param teamId 帮会id
//	 * @param exp 帮会获得的经验
//	 */
//	public void daoUpdateTeamLv(Connection conn,int teamId,int exp,Team t1)throws SQLException;
//	
//	/**修改帮会人口(每次有人加入或退出帮会 执行)-帮友权限【注意20人满后不能调用此函数】
//	 * @param teamId 帮会id
//	 * @param check 9加入5退出
//	 */
//	public void daoUpdatePopulation(Connection conn,int teamId,int check)throws SQLException;
//	
//	/**修改帮会签到率-帮友权限
//	 * @param teamId 帮会id
//	 * @param totleSign 帮主+帮友的签到率(90%即90)
//	 */
//	public void daoUpdateSign(Connection conn,int teamId,int[] totleSign)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/**查看帮会等级-帮友权限 
//	 * @param id 帮会id
//	 * @return 帮会等级
//	 */
//	public int daoSelectTeamLv(Connection conn,int id)throws SQLException;
//	
//	/**查看自己所在帮会全部信息-帮友权限 
//	 * @param id 帮会id
//	 * @return 帮会
//	 */
//	public Team daoSelectTeaminfo(Connection conn,int id)throws SQLException;
//	 
//	/**通过已知的帮主id获得帮会id
//	 * @param conn
//	 * @param playerId 帮主id
//	 * @return 帮会id
//	 * @throws SQLException
//	 */
//	public int daoSelectTeamIdByLeaderId(Connection conn, int playerId)throws SQLException;
//	
//	
//	/** 查看所有帮会部分信息-帮友权限 
//	 * @return 帮会集合
//	 */
//	public List<Team> daoSelectAllTeamInfo(Connection conn)throws SQLException;
//	
//}
