package fs.battle.dao;

import java.sql.Connection;
import java.sql.SQLException; 

import fs.battle.model.WuGong;

/** @author Jason_★
 *	用户权限下对【武功类】的查操作
 *	查(id)
 */
public interface WuGongDaoByUser 
{
	//查-----------------------------------------------------
	/**查看指定id的武功-用户权限 
	 * @param id 武功id
	 * @return 武功对象
	 */
	public WuGong daoSelectWuGong(Connection conn,int id)throws SQLException;
	
//	/**根据玩家的武功属性(String)拿到具体的武功集合
//	 * @param conn 链接
//	 * @param wugong 武功属性(String)
//	 * @return 武功集合
//	 * @throws SQLException
//	 */
//	public List<WuGong> daoSelectWuGong(Connection conn,String wugong)throws SQLException;
	
	/**查询数据库存在的武功数
	 * @param conn 链接
	 * @return 武功总数
	 * @throws SQLException
	 */
	public int daoSelectWuGongNumber(Connection conn)throws SQLException;
}
