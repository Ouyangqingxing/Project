package fs.battle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fs.battle.model.Player;

/** @author Jason_★
 *	管理员权限下对  玩家类   的增改(封)查操作
 *	增()封(封就是改玩家的state属性为-1，战前会检查该属性从而达到封的效果)改()查()
 */
public interface PlayerDaoByManager 
{
//	/**判断用户名是否已存在
//	 * @param name 待检查的用户名
//	 * @return 正确与否
//	 */
//	public boolean daoCheckUserName(Connection conn,String name)throws SQLException;
	
	
	//增---------------------------------------------
//	/**新增一个玩家-管理员权限 (注意这里是后台页面新建npc型玩家)
//	 * @param name 玩家名
//	 */
//	public int daoAddPlayer(Connection conn,String name,String remark,int hp,int atk,int def,int spd,int rp,int critical,int dodge ,int lv,String wugong,String weapon,int campId,int coreCheck)throws SQLException;
	
	//改---------------------------------------------
	/**
	 * 修改玩家状态（核心，关键）-管理员权限
	 * @param playerId 被封印的玩家id
	 * @param state 新的状态码（-1 0 1 2 封印 绝情 常态 试练）
	 */
	public void daoUpdatePlayerState(Connection conn,int playerId,int state)throws SQLException;
	
//	/**
//	 * 修改玩家的信息-管理员权限
//	 * @param id 被修改的玩家id
//	 * @param name 玩家昵称
//	 * @param sex 玩家性别
//	 * @param remark 玩家签名
//	 * @param hp 玩家血量
//	 * @param atk 玩家攻击
//	 * @param def 玩家防御
//	 * @param spd 玩家速度
//	 * @param rp 玩家运势
//	 * @param critical 玩家暴击
//	 * @param dodge 玩家闪避
//	 * @param exp 玩家经验
//	 * @param coreCheck 玩家正邪点
//	 * @param buff 增益情况
//	 * @param lastfightchance 剩余战斗次数
//	 */
//	public void daoUpdatePlayerAllInfo(Connection conn,int id,String name,int sex,String remark,int hp,int atk,int def,int spd,int rp,double critical,int dodge,int exp,int coreCheck,int buff,int lastfightchance)throws SQLException;
	
	//查---------------------------------------------
//	/**查看玩家id-管理员权限
//	 * @param name 玩家昵称
//	 * @return 玩家Id
//	 */
//	public int daoSelectPlayerIdByName(Connection conn,String name)throws SQLException;
	
//	/**查看所有玩家所有信息-管理员权限
//	 * @param List<Player> 玩家集合
//	 */
//	public List<Player> daoSelectAllPlayerInfo(Connection conn)throws SQLException;
	
	/**后台查看所有玩家的信息
	 * @param conn 链接
	 * @param eachPage 每个页面查看的人数
	 * @param currentPage 当前查看的页面
	 * @return 玩家集合
	 */
	public List<Player> getPlayerList(Connection conn,int eachPage, int currentPage);
	
	/**查看数据库中的玩家数
	 * @param conn 链接
	 * @return 玩家数
	 */
	public int getTotalItem(Connection conn); 	
	
	
//	/**查看一个指定id的玩家所有信息-管理员权限
//	 * @param id 玩家id
//	 * @return 一个玩家
//	 */
//	public Player daoSelectPlayerAllInfo(Connection conn,int id)throws SQLException;
	
//	/**查看一个指定id的玩家姓名
//	 * @param id 玩家id
//	 * @return 玩家名
//	 */
//	public String daoSelectPlayerName(Connection conn,int id)throws SQLException;
}
