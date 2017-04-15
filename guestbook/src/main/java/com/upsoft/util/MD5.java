package com.upsoft.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	/**md5加密
	 * @param oldString 待加密的字符串
	 * @return 加密后的字符串
	 */
    public static String getMd5(String oldString) {  
    	try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(oldString.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           return oldString;
        } 
    }  
}