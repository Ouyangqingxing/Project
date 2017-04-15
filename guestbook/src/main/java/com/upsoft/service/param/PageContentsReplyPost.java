package com.upsoft.service.param;

public class PageContentsReplyPost {
	private String topicPostId;
	private int pageNum;
	
	public PageContentsReplyPost(){}
	public PageContentsReplyPost(String topicPostId, int pageNum) {
		super();
		this.topicPostId = topicPostId;
		this.pageNum = pageNum;
	}
	public String getTopicPostId() {
		return topicPostId;
	}
	public void setTopicPostId(String topicPostId) {
		this.topicPostId = topicPostId;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}