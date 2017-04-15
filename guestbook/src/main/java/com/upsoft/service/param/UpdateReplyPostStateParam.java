package com.upsoft.service.param;

public class UpdateReplyPostStateParam {
	private String replyPostId;
	private int state;
	
	public String getReplyPostId() {
		return replyPostId;
	}
	public void setReplyPostId(String replyPostId) {
		this.replyPostId = replyPostId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}