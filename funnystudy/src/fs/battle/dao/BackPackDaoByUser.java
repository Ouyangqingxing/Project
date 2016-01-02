// package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.BackPack;
//
///** @author Jason_★
// *	用户权限下对  背包类   的增删改查操作
// *	增()删()改()查()
// */
//public interface BackPackDaoByUser 
//{
//	//增---------------------------------------------
//	/**新增一个背包格物品-用户权限
//	 * @param playerId 玩家id
//	 * @param goodsId 物品id
//	 * @param goodsType 物品类型
//	 * @param goodsNumber 物品数量
//	 * @param goodsState 物品状态
//	 */
//	public void daoAddBackPack(Connection conn,int playerId,int goodsId,int goodsType,int goodsNumber,int goodsState)throws SQLException;
//
//	//删---------------------------------------------
//	/**删除一个物品格(注意：仅当消耗类物品数量为1时才调用,否则应该为修改数量)-用户权限
//	 * @param id 被删除的物品格id
//	 */
//	public void daoDeleteBackPack(Connection conn,String[] backpackId)throws SQLException;
//	
//	//改---------------------------------------------
//	/**修改一个物品格数量(使用或者获取)-用户权限
//	 * @param goodsId 物品id
//	 * @param playerId 玩家id
//	 * @param useOrget 使用还是获取
//	 */
//	public void daoUpdateBackPackGoodsNumber(Connection conn,int goodsId,int playerId,int useOrget)throws SQLException;
//	
//	/**修改一个物品格状态-用户权限
//	 * @param id 物品格id
//	 * @param state 物品格状态
//	 */
//	public void daoUpdateBackPackGoodsState(Connection conn,int id,int state)throws SQLException;
//	
//	//查---------------------------------------------
//	/**根据指定的玩家id 物品id 得到背包格id 没有返回0
//	 * @param conn
//	 * @param playerId
//	 * @param goodsId
//	 * @return
//	 * @throws SQLException
//	 */
//	public int daoSelectBackPackId(Connection conn,int playerId,int goodsId)throws SQLException;
//	
//	/**查找指定玩家是否有指定物品
//	 * @param conn 链接
//	 * @param playerId 玩家id
//	 * @param goodsId 物品Id
//	 * @return 背包
//	 * @throws SQLException
//	 */
//	public BackPack daoSelectBackPack(Connection conn,int playerId,int goodsId)throws SQLException;
//	
//	/**查看自己背包的信息-用户权限
//	 * @param playerId 用户自己的id
//	 * @return 背包格的集合即背包所有物品信息
//	 */
//	public List<BackPack> daoSelectBackPackGoods(Connection conn,int playerId)throws SQLException;
//
//}
