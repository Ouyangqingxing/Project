package com.upsoft.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class ReplyPost implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;
	private String userName;
	private String topicPostId;
	private String content;
	private Timestamp time;
	private int floor;
	private int state;
	
	public ReplyPost() {
		super();
	}
	public ReplyPost(String id, String userId, String userName,
			String topicPostId, String content, Timestamp time, int floor,
			int state) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.topicPostId = topicPostId;
		this.content = content;
		this.time = time;
		this.floor = floor;
		this.state = state;
	}
	@Override
	public String toString() {
		return "ReplyPost [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", topicPostId=" + topicPostId + ", content="
				+ content + ", time=" + time + ", floor=" + floor + ", state="
				+ state + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + floor;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + state;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result
				+ ((topicPostId == null) ? 0 : topicPostId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		ReplyPost other = (ReplyPost) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (floor != other.floor)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state != other.state)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (topicPostId == null) {
			if (other.topicPostId != null)
				return false;
		} else if (!topicPostId.equals(other.topicPostId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}