package fs.study.dao;

import java.sql.Connection;
import java.sql.SQLException; 

import fs.study.model.Daily;

/**日常的操作[(用事件来增加!!!)改查(1通过id查 2通过日期查 3查集合)]
 * @author Jason_★
 */
public interface DailyDao 
{	
//	//增-----------------------------------------------------
//	/**新增一个
//	 * @param conn
//	 * @throws SQLException
//	 */
//	public void daoAddDaily(Connection conn)throws SQLException;
	
	//改-----------------------------------------------------
	/**增加当天的元气值
	 * @param conn 链接
	 * @throws SQLException
	 */
	public void daoUpdatePower(Connection conn)throws SQLException;
	
//	/**增加自己阵营的元气值
//	 * @param conn 链接
//	 * @param choose 自己的阵营id
//	 * @throws SQLException 
//	 */
//	public void daoUpdateCamp(Connection conn,int choose)throws SQLException;
	
	//查-----------------------------------------------------
	/**通过id查看一个日常，返回用数组保存的数据（总元气值，阵营123的元气值）
	 * @param conn 链接
	 * @param dailyId 日常id
	 * @return 一个日常
	 * @throws SQLException
	 */
	public Daily daoSelectDailyById(Connection conn,int dailyId)throws SQLException;
	
	/** 通过日期查看一个日常，返回用数组保存的数据（总元气值，阵营123的元气值）
	 * @param conn 链接
	 * @param date 日期
	 * @return 一个日常
	 * @throws SQLException
	 */
	public Daily daoSelectDailyByDate(Connection conn, String date)throws SQLException;
	
//	/** 查看所有的日常
//	 * @param conn 链接
//	 * @return 日常集合
//	 * @throws SQLException
//	 */
//	public List<Daily> daoSelectDaily(Connection conn)throws SQLException;
}
