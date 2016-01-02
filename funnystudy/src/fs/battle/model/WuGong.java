package fs.battle.model;

import java.io.Serializable;

/**武功类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class WuGong implements Serializable
{
	//各个类型的武功应有的属性-----------------------------------------------------------
	//	    id ; type=1 ; name; remark 			   buffPower;	 		 		|
	//	    id ; type=2 ; name; remark  buffName;  buffPower; buffRound; hits;  |	
	//	    id ; type=3 ; name; remark  buffName;  buffPower; buffRound; hits;  |
	//	    id ; type=4 ; name; remark  buffName;  buffPower; buffRound; 	    |
	//	    id ; type=5 ; name; remark  buffName;  buffPower;					|
	//			（1被动反击2无需武器武功3需武器武功4临时增益武功5永久被动增益心法）					|	
	//---------------------------------------------------------------------------
	private int id;				//武功id
	private int type;			//武功类型
	private String  name;		//武功名
	private String remark;		//武功详情
	private int  buffName;		//buff的属性
	private int buffPower;		//buff的强度
	private int buffRound;		//buff持续回合
	private int hits;			//连击数
	private int specialNumber;  //特殊代码
	
	public WuGong()
	{
		super();
	} 
	public WuGong(int id, int type, String name, String remark, int buffName,
			int buffPower, int buffRound, int hits,int specialNumber) 
	{
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.remark = remark;
		this.buffName = buffName;
		this.buffPower = buffPower;
		this.buffRound = buffRound;
		this.hits = hits;
		this.specialNumber = specialNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBuffName() {
		return buffName;
	}
	public void setBuffName(int buffName) {
		this.buffName = buffName;
	}
	public int getBuffPower() {
		return buffPower;
	}
	public void setBuffPower(int buffPower) {
		this.buffPower = buffPower;
	}
	public int getBuffRound() {
		return buffRound;
	}
	public void setBuffRound(int buffRound) {
		this.buffRound = buffRound;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(int specialNumber) {
		this.specialNumber = specialNumber;
	} 
} 