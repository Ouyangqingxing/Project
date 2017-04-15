package com.upsoft.service.param;

import java.sql.Timestamp;

import com.upsoft.entity.TopicPost;

public class TopicPostParam {
	private String id;
	private String userId;
	private String userName;
	private String title;
	private String content;
	private Timestamp time;
	private int replyNumber;
	private int state;
	private String keyword;
	
	public TopicPostParam(){}
	public TopicPostParam(TopicPost topicPost,String keyword){
		this.id = topicPost.getId();
		this.userId = topicPost.getUserId();
		this.userName = topicPost.getUserName();
		this.title = topicPost.getTitle();
		this.content = topicPost.getContent();
		this.time = topicPost.getTime();
		this.replyNumber = topicPost.getReplyNumber();
		this.state = topicPost.getState();
		this.keyword = keyword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}