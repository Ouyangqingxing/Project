package fs.study.model;

import java.io.Serializable;

/**用户类
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class User implements Serializable
{	
	private int id;				//用户id
	private String username;	//用户名
	private String password;	//用户密码
	private int playerId;		//用户对应的玩家id
	private String remark;		//用户签名
	private int state;			//用户状态
	private String face;		//用户头像
	
	public User() 
	{
		super();
	}

	public User(int id, String username, String password, int playerId,
			String remark, int state, String face) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.playerId = playerId;
		this.remark = remark;
		this.state = state;
		this.face = face;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	} 
}
