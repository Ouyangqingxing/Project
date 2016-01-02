//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.TeamPlayer;
//
///** @author Jason_★
// *	管理员权限下对 帮会玩家 的增删改查操作
// *	增( )删(修改玩家teamId属性)改( )查(2id/all双表)
// */
//public interface TeamPlayerDaoByManager 
//{
//	//增-----------------------------------------------------
//	/**新增一个帮会玩家-管理员权限
//	 * @param teamId	所在帮会id
//	 * @param playerId	玩家id
//	 */
//	public void daoAddTeamPlayer(Connection conn,int teamId,int playerId)throws SQLException;
//	
//	//删-----------------------------------------------------
//	/**删除一个帮会玩家-管理员权限
//	 * @param playerId 玩家id
//	 */
//	public void daoDeleteTeamPlayer(Connection conn,String[] playerId)throws SQLException;
//	
//	//改-----------------------------------------------------
//	/**修改一个帮会玩家-管理员权限
//	 * @param id 帮会玩家id
//	 * @param teamId	所在帮会id
//	 * @param playerId	玩家id
//	 * @param contribution 贡献值
//	 * @param job 职位
//	 */
//	public void daoUpdateTeamPlayer(Connection conn,int id,int teamId,int playerId,int contribution,int job)throws SQLException;
//	
//	//查-----------------------------------------------------
//	/**通过id查看一个帮会玩家-管理员权限
//	 * @param id id
//	 * @return 帮会玩家
//	 */
//	public TeamPlayer daoSelectTeamPlayerById(Connection conn,int id)throws SQLException;
//	
//	/**通过帮会id查看一个帮会玩家-管理员权限
//	 * @param teamId 帮会id
//	 * @return 帮会玩家
//	 */
//	public TeamPlayer daoSelectTeamPlayerByTeamId(Connection conn,int teamId)throws SQLException;
//	
//	/**通过玩家id查看一个帮会玩家-管理员权限
//	 * @param playerId 玩家id
//	 * @return 帮会玩家
//	 */
//	public TeamPlayer daoSelectTeamPlayerByPlayerId(Connection conn,int playerId)throws SQLException;
//	
//	/**查看所有帮会玩家-管理员权限 
//	 * @return 帮会玩家集合
//	 */
//	public List<TeamPlayer> daoSelectTeamPlayer(Connection conn)throws SQLException;
//}
