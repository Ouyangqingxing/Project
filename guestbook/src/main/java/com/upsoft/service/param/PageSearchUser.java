package com.upsoft.service.param;

public class PageSearchUser {
	private String searchContent;
	private int pageNum;
	
	public PageSearchUser(){}
	public PageSearchUser(String searchContent, int pageNum) {
		super();
		this.searchContent = searchContent;
		this.pageNum = pageNum;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}