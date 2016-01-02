 package fs.battle.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fs.battle.model.Player;

/** @author Jason_★
 *	用户权限下对  玩家类   的增改查操作
 *	增()改()查()
 */
public interface PlayerDaoByUser
{
	//判断-------------------------------------------
	/**判断用户名是否已存在
	 * @param name 待检查的用户名
	 * @return true可以使用false不能使用
	 */
	public boolean daoCheckUserName(Connection conn,String name);
	
	/**判断玩家是否在首页的排行榜上
	 * @param conn 链接
	 * @param playerId 需要进行判断的玩家id
	 * @return 是否
	 */
	public boolean daoCheckPlayerPhb(Connection conn,int playerId);
	
	
	//增---------------------------------------------
	/**新增一个玩家-用户权限 
	 * @param name 玩家名
	 * @param remark 签名
	 * @return 新增的玩家所在的盟派id
	 */
	public int daoAddPlayer(Connection conn,String name,int sex,String remark)throws SQLException;

	
	//改---------------------------------------------
	/**更新玩家基础属性 
	 * @param conn 链接
	 * @param playerId 将要更新的玩家id 
	 * @param getHp 增加的血量
	 * @param getAtk 增加的攻击
	 * @param getDef 增加的防御
	 * @param getSpd 增加的速度
	 * @throws SQLException
	 */
	public void daoUpdatePlayerBaseValue(Connection conn,int playerId,int getHp,int getAtk,int getDef,int getSpd)throws SQLException;

	/**更新玩家的进阶属性
	 * @param conn 链接
	 * @param playerId 待更新的玩家的id
	 * @param getRp 将增加的运势率
	 * @param getCritical 将增加的暴击率
	 * @param getDodge 将增加的闪避率
	 * @throws SQLException 
	 */
	public void daoUpdatePlayerHighValue(Connection conn,int playerId ,int getRp,int getCritical,int getDodge)throws SQLException;
	
	/**修改玩家的身份-3魔  -2鬼  -1 妖  0人  1侠   2仙  3神
	 * @param conn 链接
	 * @param playerId 将要修改的玩家id
	 * @param backpack 玩家目前的身份
	 * @throws SQLException 
	 */
	public void daoUpdatePlayerLv(Connection conn,int playerId,String backpack)throws SQLException;
	
	/**更新玩家的可分配点数
	 * @param conn 链接
	 * @param playerId 将要更新的玩家id
	 * @param getPoints 增量
	 * @param check 失去/获得
	 * @throws SQLException
	 */
	public void daoUpdatePlayerPoint(Connection conn,int playerId,int getPoints,int check)throws SQLException;
	
	/**直接修改玩家的等级
	 * @param conn 链接
	 * @param playerId 将要修改的玩家id
	 * @throws SQLException
	 */
	public void daoUpdatePlayerLV(Connection conn,int playerId)throws SQLException;
	
	/**修改玩家的灵气/煞气
	 * @param conn 链接
	 * @param playerId 将要修改的玩家id
	 * @param check 增加/减少
	 * @throws SQLException
	 */
	public void daoUpdatePlayerCoreCheck(Connection conn,int playerId,int check)throws SQLException;
	
	/** 修改玩家基础属性(个人说明 性别)-用户权限
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param remark 玩家新个人说明
	 */
	public void daoUpdatePlayerBaseInfo(Connection conn,int playerId,String remark,int sex)throws SQLException;
	
//	/**修改玩家所属帮会id
//	 * @param conn 链接
//	 * @param playerId 玩家Id
//	 * @param teamId 帮会id
//	 * @throws SQLException
//	 */
//	public void daoUpdatePlayerTeamId(Connection conn,int playerId,int teamId)throws SQLException;
	
	/**首先修改玩家经验值,如果经验值满足大于f(lv)则lv++并增长属性-用户权限 
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param exp 玩家本次获得的经验
	 * @param return 描述过程的文字
	 */
	public String daoUpdatePlayerLV(Connection conn,int playerId ,int exp)throws SQLException;
	
	/**修改武器信息（调用此函数时请注意是否修改双方以及修改武器持有者信息）-用户权限
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param WeaponId 武器id
	 * @param check 判断丢失还是获得(算法中同时注意是否能丢失/获取)
	 */
	public void daoUpdatePlayerWeapon(Connection conn,int playerId,int WeaponId,int check)throws SQLException;
 	
	/**修改武功信息-用户权限
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param WuGongId 武功id
	 * @param check 习得或是遗忘(算法中同时注意是否能习得/遗忘)
	 */
	public boolean daoUpdatePlayerWuGong(Connection conn,int playerId , int WuGongId,int check)throws SQLException;
	 
	/**根据一定算法修改玩家正邪点-用户权限
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param oldCoreCheck 已有正邪点
	 * @param getCoreCheck 本次获得正邪点
	 */
	public void daoUpdatePlayerCoreCheck(Connection conn,int playerId,int oldCoreCheck,int getCoreCheck)throws SQLException;
	
	/**修改玩家状态 （目前存在 -1 0 1 封号、绝情谷、正常、修炼。）-用户权限
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param state 玩家新状态值
	 */
	public void daoUpdatePlayerState(Connection conn,int playerId,int state)throws SQLException;
	
	/**修改玩家修为
	 * @param conn 链接
	 * @param playerId 玩家Id
	 * @param XiuWei 增量
	 * @param check 9增加5减少
	 */
	public void daoUpdatePlayerXiuWei(Connection conn,int playerId,int XiuWei,int check)throws SQLException;
	
	/**修改玩家Buff信息
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param buff 新的buff信息
	 */
	public void daoUpdatePlayerBuff(Connection conn,int playerId , int buff)throws SQLException;
	
	/**修改玩家今日可战斗次数信息
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param check 增加或是减少
	 */
	public void daoUpdatePlayerLastFightChance(Connection conn,int playerId,int check)throws SQLException;
	
	/**修改双方玩家排名 品剑挑战胜利调用该函数 如果挑战方排名大于被挑战者 不做操作 ，否则交换双方排名
	 * @param conn
	 * @param playerId
	 * @param bePlayerId
	 */
	public void daoUpdatePlayerRanking(Connection conn,int playerId ,int bePlayerId)throws SQLException;
	
	/**修改玩家战斗默认选择0
	 * @param conn 链接
	 * @param playerId 修改的玩家id
	 * @param check  0杀1治疗  
	 */
	public void daoUpdatePlayerPK(Connection conn,int playerId,int check)throws SQLException;
	
	/**更新玩家战斗力
	 * @param conn 链接
	 * @param playerId 更新的玩家id
	 */
	public void daoUpdatePlayerPower(Connection conn,int playerId)throws SQLException;
	
	
	//查---------------------------------------------
	/**通过玩家昵称查看玩家id-用户权限
	 * @param conn 链接
	 * @param name 玩家昵称
	 * @return 玩家Id
	 */
	public int daoSelectPlayerIdByName(Connection conn,String name)throws SQLException;
	
	/**查看一个指定id的玩家的武功装备背包其中一个信息
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @param choose 选择情况123分别为武功装备背包
	 * @return 转换成字符串的信息
	 */
	public String daoSelectPlayerWEB(Connection conn,int playerId,int choose)throws SQLException;
	
	/**查看一个指定id的玩家部分信息-用户权限(注意最后只有部分显示！)
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @return 一个玩家
	 */
	public Player daoSelectPlayerAllInfo(Connection conn,int playerId)throws SQLException;
	
	/** 查看首页排行榜
	 * @param conn 链接
	 * @param choose 你想要查看的榜单
	 * @return 7个玩家的集合
	 * @throws SQLException
	 */
	public List<Player> daoSelectPlayerRanking(Connection conn,int choose)throws SQLException;
	
	/**查看一个已知玩家id的天梯排名
	 * @param conn 链接
	 * @param playerId 玩家id
	 * @return 天梯排名
	 * @throws SQLException
	 */
	public int daoSelectPlayerSelfRanking(Connection conn,int playerId)throws SQLException;
	
	/**查看一个已知天梯名次 对应的玩家 
	 * @param conn 链接
	 * @param ranking 查看的天梯名次
	 * @return 一个玩家
	 * @throws SQLException
	 */
	public Player daoSelectPlayerInfoByRanking(Connection conn,int ranking )throws SQLException;
	
	/**在战斗页面battle.jsp,查看一个指定的排行榜信息 
	 * @param conn 链接 
	 * @param eachPage 每一页查看的个数(即最终查看的集合size)
	 * @param currentPage 当前查看的页数
	 * @param choose 选择查看的类型1仙剑奇侠 2乱世枭雄 3世外高人 4擂台贤者
	 * @return 玩家集合
	 */
	public List<Player> getPlayerList(Connection conn,int eachPage, int currentPage,int choose);
	
	/**查看数据库中的玩家数
	 * @param conn 链接
	 * @return 玩家数
	 */
	public int getTotalItem(Connection conn); 	
}
