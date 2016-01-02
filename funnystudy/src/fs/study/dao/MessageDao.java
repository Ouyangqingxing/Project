package fs.study.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import fs.study.model.Message;
import fs.study.model.MessageX;

/**对留言板的操作[增 删(2权限) 查(1按照时间差集合 2id查留言)]
 * @author Jason_★ 
 */
public interface MessageDao 
{
	//增-----------------------------------------------------
	/**增加一个留言
	 * @param conn 链接
	 * @param userId 发表留言的用户id
	 * @param beUserId 被留言的用户id
	 * @param content 留言内容
	 * @throws SQLException
	 */
	public void daoAddMessage(Connection conn,int userId,
			int beUserId,String content)throws SQLException;
	
	//删-----------------------------------------------------
	/**删除留言
	 * @param conn 链接
	 * @param messageId 删除的留言id数组
	 * @throws SQLException
	 */
	public void daoDeleteMessage(Connection conn,String[] messageId)throws SQLException;
	
	//查-----------------------------------------------------
	/**查看一个已知用户的所有留言
	 * @param conn 链接
	 * @param userId 用户id
	 * @return 留言集合
	 * @throws SQLException
	 */
	public List<Message> daoSelectMessageByUserId(Connection conn,int userId)throws SQLException;
	
	/**通过留言id查询留言
	 * @param conn 链接
	 * @param messageId 留言id
	 * @return 一个留言
	 * @throws SQLException
	 */
	public Message daoSelectMessageById(Connection conn,int messageId)throws SQLException;
	
	/**该方法用于查询数据库里action表的数据总条数
	 * @param conn 链接
	 * @return int totalItem 返回的数据总条数
	 */
	public int getTotalItem(Connection conn);
	
	/**实际页面中显示的留言
	 * 该方法用于查询指定条数的数据
	 * @param userId 用户id
	 * @param eachPage 每页显示条数
	 * @param CurrentPage 当前页数
	 * @return List<Message> messageList 封装了数据的messageList
	 */
	public List<MessageX> getMessageXList(Connection conn,int userId,int eachPage,int currentPage);
}
