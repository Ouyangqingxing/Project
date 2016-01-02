//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import fs.battle.model.TeamPlayer;
//
///** @author Jason_★
// *	用户权限下对 帮会玩家 的增删改查操作
// *	增( )删(修改玩家teamId属性)改(贡献值、职位 )查(id)
// */
//public interface TeamPlayerDaoByUser 
//{
//	//增-----------------------------------------------------
//	/**新增一个帮会玩家-用户权限
//	 * @param teamId	所在帮会id
//	 * @param playerId	玩家id 
//	 * @param check 是否为创建
//	 */
//	public void daoAddTeamPlayer(Connection conn,int teamId,int playerId,boolean check )throws SQLException;
//	
//	//删-----------------------------------------------------
//	/**删除一个帮会玩家-用户权限
//	 * @param id 帮会玩家id
//	 */
//	public void daoDeleteTeamPlayer(Connection conn,String[] id)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/**修改一个帮会玩家贡献值-用户权限
//	 * @param id 帮会玩家id
//	 */
//	public void daoUpdateTeamPlayerCTB(Connection conn,int id,int contribution )throws SQLException;
//	
//	/**修改一个帮会玩家职位-用户权限
//	 * @param id 帮会玩家id
//	 */
//	public void daoUpdateTeamPlayerJOB(Connection conn,int id, int job)throws SQLException;
//	//查-----------------------------------------------------	
//	/**通过玩家id查看一个帮会玩家-用户权限
//	 * @param playerId 玩家id
//	 * @return 帮会玩家
//	 */
//	public TeamPlayer daoSelectTeamPlayerByPlayerId(Connection conn,int playerId)throws SQLException;
//	
//	/**通过id去查看一个帮会玩家
//	 * @param conn 链接
//	 * @param id 
//	 * @return
//	 * @throws SQLException
//	 */
//	public TeamPlayer daoSelectTeamPlayerById(Connection conn,int id)throws SQLException;
//}
