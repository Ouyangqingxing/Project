//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.PlayerRelationship;
//
///** @author Jason_★
// *	用户权限下对  玩家关系类   的增删查操作
// *	增()删()查( )
// */
//public interface PlayerRelationshipDaoByUser
//{
//	//增---------------------------------------------
//	/** 新增一个关系-用户权限
//	 * @param playerId 主动玩家id
//	 * @param bePlayerId 被动玩家id
//	 * @param relationship 玩家关系 
//	 */
//	public void daoAddPR(Connection conn,int playerId,int bePlayerId,int relationship)throws SQLException;
//	
//	//改---------------------------------------------
//	/**修改一个关系-用户权限
//	 * @param conn
//	 * @param playerId 主动玩家id
//	 * @param relationship 关系
//	 */
//	public void daoUpdatePR(Connection conn,int playerId,int beplayerId,int relationship)throws SQLException;
//	
//	//删---------------------------------------------
//	/**删除一个关系-用户权限
//	 * @param playerId 关系中的主动玩家id
//	 * @param beplayerId 关系中的被动玩家id
//	 */
//	public void daoDeletePR(Connection conn,String[] id)throws SQLException;
//	
//	//查---------------------------------------------
//	/** 查看指定主动被动方是否有关系并返回关系
//	 * @param conn
//	 * @param playerId 主动玩家
//	 * @param beplayerId 被动玩家
//	 * @return 关系
//	 * @throws SQLException
//	 */
//	public int daoSelect (Connection conn,int playerId,int beplayerId)throws Exception;
//	
//	/**查看已知主动玩家id的所有关系-用户权限
//	 * @param playerId 主动玩家id
//	 * @return 关系集合
//	 */
//	public List<PlayerRelationship> daoSelectPR(Connection conn,int playerId)throws SQLException;
//}
