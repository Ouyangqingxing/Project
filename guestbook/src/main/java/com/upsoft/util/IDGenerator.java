package com.upsoft.util;

import java.util.UUID;

public class IDGenerator {
	/**
	 * jdk生成UUID后去掉'-' 32个字符
	 * @return id 
	 */
	public static String getId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		id = id.replace("-","");
		return id;
	}
}