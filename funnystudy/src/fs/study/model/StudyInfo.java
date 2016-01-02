package fs.study.model;

import java.io.Serializable;

/**学习情况类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class StudyInfo implements Serializable
{
	private int id;			//学习情况id
	private int userId;		//发表用户id
	private String time;	//发表时间(XXXX-XX-XX)
	private String content;	//发表内容300字以内
	
	public StudyInfo()
	{
		super();
	}
	public StudyInfo(int id, int userId, String time, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.content = content;
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
}
