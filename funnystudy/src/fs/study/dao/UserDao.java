package fs.study.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fs.study.model.User;

/**对用户的操作[增(注册 注意对用户名的合法性判断！！！)封(管理员修改state属性)查(4查看用户名重复，姓名查id,playerId查id，id查玩家)]
 * @author Jason_★
 */
public interface UserDao 
{
	//增-----------------------------------------------------
	/**增加一个用户（注册）
	 * @param conn	链接
	 * @param username 用户名（注意1字符2判断重复）
	 * @param password 密码
	 * @param playerId 对应的玩家id
	 * @param remark 备注
	 * @param state 状态
	 * @param face 头像地址
	 * @throws SQLException
	 */
	public void daoAddUser(Connection conn,String username,String password,
			int playerId,String remark,int state,String face)throws SQLException;
	
	//改-----------------------------------------------------
	/**修改用户对应的玩家id
	 * @param conn 链接
	 * @param id 用户id
	 * @param playerId 玩家id
	 * @throws SQLException
	 */
	public void daoUpdateUserPlayerId(Connection conn,int id,int playerId)throws SQLException;
	
//	/** 修改一个用户状态
//	 * @param conn 链接
//	 * @param id 玩家Id
//	 * @param state 玩家的新状态
//	 * @throws SQLException
//	 */
//	public void daoUpdateUserState(Connection conn,int id,int state)throws SQLException;
	
	/**修改用户基本信息密码和签名
	 * @param conn 链接
	 * @param userId 用户id
	 * @param password 密码
	 * @param remark 签名
	 * @throws SQLException
	 */
	public void daoUpdateUserInfo(Connection conn,int userId,String password,String remark)throws SQLException;
	
	/**修改用户头像
	 * @param conn 链接
	 * @param face 新头像地址
	 * @throws SQLException
	 */
	public void daoUpdateUserFace(Connection conn,int id,String face)throws SQLException;
	
	//查-----------------------------------------------------
	/**判断用户名是否可用
	 * @param conn 链接
	 * @param username 用户名
	 * @return true可用不重复false不能用重复
	 * @throws SQLException
	 */
	public boolean daoCheckUserName(Connection conn,String username);
	
	/**判断密码是否正确
	 * @param conn 链接
	 * @param username 用户名
	 * @param password 密码
	 * @return 是否正确
	 * @throws SQLException
	 */
	public boolean daoCheckPassword(Connection conn,String username,String password);
	
	/** 通过用户名查询用户Id
	 * @param conn 链接
	 * @param userName 用户名
	 * @return 用户id
	 * @throws SQLException
	 */
	public int daoSelectIdByUserName(Connection conn,String userName)throws SQLException;
	
	/**通过玩家id查用户id
	 * @param conn 链接
	 * @param playerId 玩家Id
	 * @return 用户Id
	 * @throws SQLException
	 */
	public int daoSelectIdByPlayerId(Connection conn,int playerId)throws SQLException;
	
	/**通过id查用户
	 * @param conn 链接
	 * @param userId 用户Id
	 * @return 用户
	 * @throws SQLException
	 */
	public User daoSelectUserById(Connection conn,int userId)throws SQLException;
}
