package fs.battle.model;

import java.io.Serializable;
import java.util.List;

/**玩家类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Player implements Serializable
{
	private int id;			//用户id
	private String name;	//玩家昵称
	private int sex;		//玩家性别
	private String remark;  //个人说明
	
	private int hp;			//血量 注意 属性均为int!!!
	private int atk;		//攻击
	private int def;		//防御
	private int spd;		//速度 是否能先手以及连续进攻的参数
	private int rp;			//运势
	private int critical;	//暴击
	private int dodge;		//闪避 是否能躲过进攻的参数 如为10即闪避为10%  不能过高
	private int lv=1;		//等级
	private int exp=0;		//经验
	
	private List<Integer> wugong;	//武功
	private List<Integer> equipment;//装备
	private List<Integer> backpack; //背包
	private int campId=0;			//联盟id
	private int teamId=0;  			//帮会id
	
	private int coreCheck;			//正 负
	private int state=1;			//用户账号状态，目前存在 -1 0 1 封号、修炼、正常。
	private int buff;				//玩家增益情况，如吃了增益药
	private int lastFightChance;	//玩家今日剩余战斗次数
	private int xiuwei;				//修为
	private int points;				//可分配点数
	private int ranking;			//天梯排名，初始为目前总人数
	private int power;				//战斗力hp*0.5+atk*13+def*11+spd*15+rp*150+dodge*100+critical*120
	private int pk;					//选择0战或者1护
	
	public Player() 
	{
		super();
	} 
	public Player(int id, String name, int sex, String remark, int hp, int atk,
			int def, int spd, int rp, int critical, int dodge, int lv, int exp,
			List<Integer> wugong, List<Integer> equipment,
			List<Integer> backpack, int campId, int teamId, int coreCheck,
			int state, int buff, int lastFightChance, int xiuwei, int points,
			int ranking, int power, int pk) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.remark = remark;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		this.rp = rp;
		this.critical = critical;
		this.dodge = dodge;
		this.lv = lv;
		this.exp = exp;
		this.wugong = wugong;
		this.equipment = equipment;
		this.backpack = backpack;
		this.campId = campId;
		this.teamId = teamId;
		this.coreCheck = coreCheck;
		this.state = state;
		this.buff = buff;
		this.lastFightChance = lastFightChance;
		this.xiuwei = xiuwei;
		this.points = points;
		this.ranking = ranking;
		this.power = power;
		this.pk = pk;
	}

	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<Integer> getWugong() {
		return wugong;
	}

	public void setWugong(List<Integer> wugong) {
		this.wugong = wugong;
	}

	public List<Integer> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Integer> equipment) {
		this.equipment = equipment;
	}

	public List<Integer> getBackpack() {
		return backpack;
	}

	public void setBackpack(List<Integer> backpack) {
		this.backpack = backpack;
	}

	public int getCampId() {
		return campId;
	}

	public void setCampId(int campId) {
		this.campId = campId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getCoreCheck() {
		return coreCheck;
	}

	public void setCoreCheck(int coreCheck) {
		this.coreCheck = coreCheck;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getBuff() {
		return buff;
	}

	public void setBuff(int buff) {
		this.buff = buff;
	}

	public int getLastFightChance() {
		return lastFightChance;
	}

	public void setLastFightChance(int lastFightChance) {
		this.lastFightChance = lastFightChance;
	}

	public int getXiuwei() {
		return xiuwei;
	}

	public void setXiuwei(int xiuwei) {
		this.xiuwei = xiuwei;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	} 
}
