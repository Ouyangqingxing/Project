package com.upsoft.service.param;

import java.sql.Timestamp;

public class SelectReplyPostByUserIdParam {
	private String replyPostId;
	private String topicPostId;
	private String topicPostTitle;
	private String content;
	private Timestamp time;
	
	public SelectReplyPostByUserIdParam(){}
	public SelectReplyPostByUserIdParam(String replyPostId,String topicPostId,String topicPostTitle,String content,Timestamp time){
		this.replyPostId = replyPostId;
		this.topicPostId = topicPostId;
		this.topicPostTitle = topicPostTitle;
		this.content = content;
		this.time = time;
	}
	public String getReplyPostId() {
		return replyPostId;
	}
	public void setReplyPostId(String replyPostId) {
		this.replyPostId = replyPostId;
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
}