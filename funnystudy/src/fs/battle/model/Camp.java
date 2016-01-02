package fs.battle.model;

import java.io.Serializable;

/**阵营类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Camp implements Serializable
{
	private int id;					//联盟id
	private String name;			//联盟名字
	private String remark;			//联盟备注
	private int population;			//联盟中人数
	private int teamNumber;			//联盟中的队伍数
	
	public Camp()
	{
		super();
	}
	
	public Camp(int id, String name, String remark, int population,
			int teamNumber) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.population = population;
		this.teamNumber = teamNumber;
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
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	} 
}
