//package fs.battle.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import fs.battle.model.BackPack;
//
///** @author Jason_★
// *	管理员权限下对  背包类   的增改查操作
// *	增()改()查(id/playerId/GoodsId)
// */
//public interface BackPackDaoByManager
//{
//	//增---------------------------------------------
//	/**新增一个背包格物品-管理员权限
//	 * @param playerId 玩家id
//	 * @param goodsId 物品id
//	 * @param goodsType 物品类型
//	 * @param goodsNumber 物品数量
//	 * @param goodsState 物品状态
//	 */
//	public void daoAddBackPack(Connection conn,int playerId,int goodsId,int goodsType,int goodsNumber,int goodsState)throws SQLException;
//	
//	//改---------------------------------------------
//	/**更新一个背包信息-管理员权限
//	 * @param id 背包格id
//	 * @param playerId 背包格持有玩家id
//	 * @param goodsId  背包格物品id
//	 * @param goodsType 背包格物品类型
//	 * @param goodsNumber 背包格物品数量
//	 * @param goodsState 背包格物品状态
//	 */
//	public void daoUpdateBackPack(Connection conn,int id,int playerId,int goodsId,int goodsType,int goodsNumber,int goodsState)throws SQLException;
//	
//	//查---------------------------------------------
//	/**查看指定id的背包格信息-管理员权限
//	 * @param id 背包id
//	 * @return 背包对象
//	 */
//	public BackPack daoSelectBackPackById(Connection conn,int id)throws SQLException;
//	
//	/**查看指定玩家id的背包格信息-管理员权限 
//	 * @param playerId 玩家id
//	 * @return 背包对象
//	 */
//	public List<BackPack> daoSelectBackPackByPlayerId(Connection conn,int playerId)throws SQLException;
//	
//	/**查看指定物品id的背包格信息-管理员权限
//	 * @param goodsId 物品id
//	 * @return 背包对象
//	 */
//	public List<BackPack> daoSelectBackPackByGoodsId(Connection conn,int goodsId)throws SQLException;
//	
//}
