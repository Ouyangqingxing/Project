package com.upsoft.service.param;

public class PageSearchKeyword {
	private int pageNum;
	private String searchContent;
	
	public PageSearchKeyword(){}
	public PageSearchKeyword(int pageNum, String searchContent) {
		super();
		this.pageNum = pageNum;
		this.searchContent = searchContent;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
}