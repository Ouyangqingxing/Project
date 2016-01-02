package fs.battle.dao;

import java.sql.Connection;
import java.sql.SQLException; 

/** @author Jason_★
 *	用户权限下对阵营的改查操作
 *  改(Camp 修改阵营人数、修改阵营队伍数)查(Camp查看所有阵营、通过阵营id)
 */
public interface CampDaoByUser
{
	//改-----------------------------------------------------
	/** 用于修改阵营信息-用户权限
	 *  新增用户时阵营人口+1(注册成功)
	 *  @param id 阵营id
	 */
	public void daoUpdateCampPopulation(Connection conn,int id)throws SQLException;
	
//	/** 用于修改阵营队伍数-用户权限
//	 *  用户建立队伍时 +1
//	 *  @param id 阵营id
//	 *  @param check 9增加5减少
//	 */
//	public void daoUpdateCampTeamNumber(Connection conn,int id,int check)throws SQLException;
	
	
	//查-----------------------------------------------------
	/** 用于查找指定id阵营人口信息-用户权限
	 * @param id 阵营id
	 * @return 人口数
	 */
	public int daoSelectCampPopulation(Connection conn,int id)throws SQLException;
	
//	/** 用于查找指定id阵营队伍数信息-用户权限
//	 * @param id 阵营id
//	 * @return 队伍数
//	 */
//	public int daoSelectCampTeamNumber(Connection conn,int id)throws SQLException;
	
//	/** 用于查找指定id阵营信息-用户权限
//	 * @param id 阵营id
//	 * @return 返回一个阵营类
//	 */
//	public Camp daoSelectCampById(Connection conn,int id)throws SQLException;
	
//	/** 用于查找所有阵营信息-用户权限
//	 *  @return List<Camp> 阵营集合
//	 */
//	public List<Camp> daoSelectAllCamp(Connection conn)throws SQLException;
}
