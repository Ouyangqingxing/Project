package com.upsoft.util;

import org.springframework.web.util.HtmlUtils;

/**
 * 格式转换工具类
 */
public class FormatConverter {
	/**
	 * 截取搜索内容附近的字符串
	 * @param str 原字符串
	 * @param searchStr 搜索内容字符串
	 * @return 截取的子串
	 */
	public static String getSubStrFromContent(String str , String searchStr){
		int index = str.indexOf(searchStr);
		int beginIndex = index - 9;
		int endIndex = index + searchStr.length() + 9;
		if(index < 9){
			beginIndex = 0;
		}
		if(endIndex > str.length()){
			endIndex = str.length();
		}
		String subStr = str.substring(beginIndex,endIndex);
		return subStr;
	}
	
	/**
	 * 从json对象字符串取出需要的子串
	 * @param str 原字符串
	 * @param paraStr 变量名
	 * @return 需要的子串
	 */
	public static String getStrFromJsonObjStr(String str,String paraStr){
		str = str.replace("\"", "");
		str = str.replace("{", "");
		str = str.replace("}", "");
		paraStr = paraStr +":";
		str = str.replace(paraStr, "");
		return str;
	}
	
	/**
	 * 从list字符串中取出需要的子串
	 * @param str 原字符串
	 * @return 需要的子串
	 */
	public static String getStrFromListStr(String str){
		str = str.replace("[", "");
		str = str.replace("]", "");
		str = str.replace(",", " ");
		str = str.replaceAll(" +", " ");
		return str;
	}
	
	/**
	 * 将浏览器输入的搜索内容 转化为sql中需要的字符串
	 * @param str 原字符串
	 * @return 需要的子串
	 */
	public static String getSQLStrFromSearchStr(String str){
		str = str.replace("\"", "");
		str = str.replaceAll(" +", " ");
		str = str.replace(' ', '%');
		str = HtmlUtils.htmlEscape(str);
		str = "%"+str+"%";
		return str;
	}
	
	/**
	 * 将包含html代码的字符串 转化为 仅保留文本的字符串 如<p>12</p>3→123 
	 * @param str 原字符串
	 * @return 需要的子串
	 */
	public static String getStrFromHtmlStr(String string){
		StringBuffer str = new StringBuffer(string);
		StringBuffer result = new StringBuffer();
		boolean check = true;
		for(int i = 0 ; i < str.length() ; i++){
			if('>' == str.charAt(i)){
				check = true;
				continue;
			}
			if('<' == str.charAt(i)){
				check = false;
				continue;
			}
			if(check){
				result = result.append(str.charAt(i));
			}
		}
		return result.toString();
	}

	public static String getFirstWordFromSearchStr(String str){
		str = str.substring(1, str.length()-1);
		if(str.indexOf('%') != -1){
			str = str.substring(0,str.indexOf('%'));
		}
		return str;
	}
}