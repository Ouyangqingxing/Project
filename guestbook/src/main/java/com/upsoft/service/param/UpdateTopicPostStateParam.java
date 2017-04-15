package com.upsoft.service.param;

public class UpdateTopicPostStateParam {
	private String topicPostId;
	private int state;
	
	public String getTopicPostId() {
		return topicPostId;
	}
	public void setTopicPostId(String topicPostId) {
		this.topicPostId = topicPostId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}