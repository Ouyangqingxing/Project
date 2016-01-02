package fs.study.model;

import java.io.Serializable;

/**留言板虚拟类，只在页面加载时用到
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class MessageX implements Serializable
{
	private int id;				//留言id
	private int userLv; 		//留言者玩家等级
	private String userName;	//留言者昵称
	private int userId;			//留着者用户id
	private int playerId;		//留言者玩家id
	private int beUserId;		//被留言者用户id
	private String content;		//留言内容
	private String time;		//留言时间
	private int userFace;		//留言者头像
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserLv() {
		return userLv;
	}
	public void setUserLv(int userLv) {
		this.userLv = userLv;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
	public int getUserFace() {
		return userFace;
	}
	public void setUserFace(int userFace) {
		this.userFace = userFace;
	} 
}
