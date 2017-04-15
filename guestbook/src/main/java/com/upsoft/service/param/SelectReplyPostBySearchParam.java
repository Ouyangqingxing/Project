package com.upsoft.service.param;

import java.sql.Timestamp;

import com.upsoft.entity.ReplyPost;

public class SelectReplyPostBySearchParam {
	private String topicPostId;
	private String topicPostTitle;
	private String replyContent;
	private String userId;
	private String userName;
	private int floor;
	private Timestamp time;
	
	public SelectReplyPostBySearchParam(){}
	public SelectReplyPostBySearchParam(ReplyPost replyPost,String topicPostTitle){
		this.topicPostId = replyPost.getTopicPostId();
		this.topicPostTitle = topicPostTitle;
		this.replyContent = replyPost.getContent();
		this.userId = replyPost.getUserId();
		this.userName = replyPost.getUserName();
		this.floor = replyPost.getFloor();
		this.time = replyPost.getTime();
	}
	
	public String getTopicPostId() {
		return topicPostId;
	}
	public void setTopicPostId(String topicPostId) {
		this.topicPostId = topicPostId;
	}
	public String getTopicPostTitle() {
		return topicPostTitle;
	}
	public void setTopicPostTitle(String topicPostTitle) {
		this.topicPostTitle = topicPostTitle;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}