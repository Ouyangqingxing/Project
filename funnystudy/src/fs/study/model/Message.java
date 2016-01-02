package fs.study.model;

import java.io.Serializable;

/**留言板类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class Message implements Serializable
{
	private int id;				//留言板id
	private int userId;			//留言用户id
	private int beUserId;		//被留言的用户id
	private String content;		//留言内容
	private String time;		//留言时间
	
	public Message() 
	{
		super();
	}
	public Message(int id, int userId, int beUserId, String content, String time) {
		super();
		this.id = id;
		this.userId = userId;
		this.beUserId = beUserId;
		this.content = content;
		this.time = time;
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



	public int getBeUserId() {
		return beUserId;
	}



	public void setBeUserId(int beUserId) {
		this.beUserId = beUserId;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
