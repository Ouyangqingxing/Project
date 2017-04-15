package com.upsoft.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Keyword implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String topicPostId;
	private String content;

	public Keyword() {
		super();
	}
	public Keyword(String id, String topicPostId, String content) {
		super();
		this.id = id;
		this.topicPostId = topicPostId;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Keyword [id=" + id + ", topicPostId=" + topicPostId
				+ ", content=" + content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((topicPostId == null) ? 0 : topicPostId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keyword other = (Keyword) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (topicPostId == null) {
			if (other.topicPostId != null)
				return false;
		} else if (!topicPostId.equals(other.topicPostId))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopicPostId() {
		return topicPostId;
	}
	public void setTopicPostId(String topicPostId) {
		this.topicPostId = topicPostId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}