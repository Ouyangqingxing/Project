package fs.battle.model;

import java.io.Serializable;

/**武器类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Weapon implements Serializable
{
	private int id;							//武器id
	private int type;						//武器类型
	private int holderId;					//武功持有者id，若无则为0
	private String name;					//武器名字
	private String remark;					//武器说明
	private int buffName;					//该武器能提升的属性
	private int buffPower;					//该武器能提升的强度
	private int specialNumber;				//武器特殊代码
	
	public Weapon()
	{
		super();
	}
	
	public Weapon(int id,int type,String name,String remark,int buffName,int buffPower,int specialNumber)
	{
		this.id=id;
		this.type=type;
		this.name=name;
		this.remark=remark;
		this.buffName=buffName;
		this.buffPower=buffPower;
		this.specialNumber = specialNumber;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public int getSpecialNumber() {
		return specialNumber;
	}

	public void setSpecialNumber(int specialNumber) {
		this.specialNumber = specialNumber;
	}

	public int getHolderId() {
		return holderId;
	}

	public void setHolderId(int holderId) {
		this.holderId = holderId;
	} 
}
