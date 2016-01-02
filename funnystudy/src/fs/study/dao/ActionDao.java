package fs.study.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fs.study.model.Action;

/**动态表的操作[增删(权限)改(修改点赞数)查(1按时间查集合 2根据id查)]
 * @author Jason_★
 */
public interface ActionDao 
{
	//增-----------------------------------------------------
	/**新增一条动态
	 * @param conn 链接
	 * @param userId 用户id
	 * @param content 原文
	 * @throws SQLException
	 */
	public void daoAddAction(Connection conn,int userId,
			String content)throws SQLException;
	
	//删-----------------------------------------------------
	/**删除一个动态(权限)
	 * @param conn 链接
	 * @param actionId 动态id
	 * @throws SQLException
	 */
	public void daoDeleteAction(Connection conn,String[] actionId)throws SQLException;
	
	//改-----------------------------------------------------
	/**增加一个动态的点赞数(修改点赞数) 
	 * @param conn 链接
	 * @param actionId 动态id
	 * @throws SQLException
	 */
	public void daoUpdateAction(Connection conn,int actionId)throws SQLException;
	
	//查-----------------------------------------------------
	/** 查看一个用户的所有动态
	 * @param conn 链接
	 * @param userId 用户id
	 * @return 动态集合
	 * @throws SQLException
	 */
	public List<Action> daoSelectActionByUserId(Connection conn,int userId)throws SQLException;
	
	/** 查看一个指定id的动态
	 * @param conn 链接
	 * @param actionId 动态id
	 * @return 动态
	 * @throws SQLException
	 */
	public Action daoSelectActionById(Connection conn,int actionId)throws SQLException;
	
	/**
	 * 该方法用于查询数据库里action表的数据总条数
	 * @return int totalItem 返回的数据总条数
	 */
	public int getTotalItem(Connection conn);
	
	/** 该方法用于查询指定条数的数据
	 * @param userId 用户id
	 * @param eachPage 每页显示条数
	 * @param CurrentPage 当前页数
	 * @return List<Action> actionList 封装了数据的actionList
	 */
	public List<Action> getActionList(Connection conn,int userId,int eachPage,int currentPage);
}
