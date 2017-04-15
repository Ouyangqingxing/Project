package com.upsoft.service.param;

public class PageCustInfoReplyPost {
	private String userId;
	private int pageNum;
	
	public PageCustInfoReplyPost(){}
	public PageCustInfoReplyPost(String userId, int pageNum) {
		super();
		this.userId = userId;
		this.pageNum = pageNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}