package com.upsoft.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Jurisdiction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String url;
	private int serialNumber;
	
	public Jurisdiction() {
		super();
	}
	public Jurisdiction(String id, String name, String url, int serialNumber) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.serialNumber = serialNumber;
	}
	@Override
	public String toString() {
		return "Jurisdiction [id=" + id + ", name=" + name + ", url=" + url
				+ ", serialNumber=" + serialNumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + serialNumber;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Jurisdiction other = (Jurisdiction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serialNumber != other.serialNumber)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}