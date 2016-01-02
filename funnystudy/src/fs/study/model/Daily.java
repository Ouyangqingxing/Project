package fs.study.model;

import java.io.Serializable;

/**日常元气类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Daily implements Serializable
{
	private int id;			//日常id
	private String date;	//日期(xxxx-xx-xx)
	private int power;		//总元气
	private int camp1;		//1盟元气
	private int camp2;		//2盟元气
	private int camp3;		//3盟元气
	
	public Daily() 
	{
		super();
	}

	public Daily(int id, String date, int power, int camp1, int camp2, int camp3) {
		super();
		this.id = id;
		this.date = date;
		this.power = power;
		this.camp1 = camp1;
		this.camp2 = camp2;
		this.camp3 = camp3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCamp1() {
		return camp1;
	}

	public void setCamp1(int camp1) {
		this.camp1 = camp1;
	}

	public int getCamp2() {
		return camp2;
	}

	public void setCamp2(int camp2) {
		this.camp2 = camp2;
	}

	public int getCamp3() {
		return camp3;
	}

	public void setCamp3(int camp3) {
		this.camp3 = camp3;
	}
}
