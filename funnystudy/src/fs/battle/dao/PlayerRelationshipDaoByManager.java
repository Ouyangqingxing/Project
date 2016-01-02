//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.PlayerRelationship;
//
///** @author Jason_★
// *	管理员权限下对  玩家关系类   的增删改查操作
// *	增()删()改()查(id playerId relationship)
// */
//public interface PlayerRelationshipDaoByManager 
//{
//	//增---------------------------------------------
//	/** 新增一个关系-管理员权限
//	 * @param playerId 主动玩家id
//	 * @param bePlayerId 被动玩家id
//	 * @param relationship 玩家关系 
//	 */
//	public void daoAddPR(Connection conn,int playerId,int bePlayerId,int relationship )throws SQLException;
//	
//	//删---------------------------------------------
//	/**删除一个关系-管理员权限
//	 * @param id id 
//	 */
//	public void daoDeletePR(Connection conn,String[] id)throws SQLException;
//	
//	//改---------------------------------------------
//	/**修改一个关系-管理员权限
//	 * @param id 关系id
//	 * @param playerId 主动玩家id
//	 * @param bePlayerId 被动玩家id
//	 * @param relationship 关系
//	 * @param time 发生时间
//	 */
//	public void daoUpdatePR(Connection conn,int id,int playerId,int bePlayerId,int relationship,String time)throws SQLException;
//	
//	//查---------------------------------------------
//	/**通过关系id查-管理员权限
//	 * @param id 关系id
//	 * @return 关系对象
//	 */
//	public PlayerRelationship daoSelectPRId(Connection conn,int id)throws SQLException;
//	
//	/**通过主动玩家id查所有关系(如查张三所有关系)-管理员权限
//	 * @param playerId 主动玩家id
//	 * @return 关系集合
//	 */
//	public List<PlayerRelationship> daoSelectPRplyerId(Connection conn,int playerId)throws SQLException;
//	
//	/**通过关系类型查询所有关系(如查所有仇人关系)-管理员权限
//	 * @param Relationship 关系类型
//	 * @return 关系集合
//	 */
//	public List<PlayerRelationship> daoSelectPRR(Connection conn,int Relationship)throws SQLException;
//	
//}
