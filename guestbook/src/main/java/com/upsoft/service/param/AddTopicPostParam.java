package com.upsoft.service.param;

public class AddTopicPostParam {
	private String title;
	private String content;
	private String keywordStr;
	
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
	public String getKeywordStr() {
		return keywordStr;
	}
	public void setKeywordStr(String keywordStr) {
		this.keywordStr = keywordStr;
	}
}