package com.upsoft.service.param;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.upsoft.entity.User;

@Component
public class CustAdminParam implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String password;
	private int postNumber;
	private int replyNumber;
	private int state;
	private String roleName;
	
	public CustAdminParam() {
		super();
	}
	public CustAdminParam(User user,int replyNumber, String roleName) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.replyNumber = replyNumber;
		this.postNumber = user.getPostNumber() - replyNumber;
		this.state = user.getState();
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}