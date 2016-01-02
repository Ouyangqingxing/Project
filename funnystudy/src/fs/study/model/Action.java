package fs.study.model;

import java.io.Serializable;

/**动态类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Action implements Serializable
{
	private int id;				//动态id
	private int userId;			//发表用户Id
	private String time;		//发表时间
	private String content;		//发表内容
	private int number;			//点赞数
	
	public Action() 
	{
		super();
	} 
	public Action(int id, int userId, String time, String content, int number) {
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.content = content;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
