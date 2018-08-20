package com.pinyougou.util;

/**
 * 字符串工具
 * 
 * @author:  
 * 描述: TODO
 * @date: 
 * @version: 
 */
public class StringUtils {
	public static String realName(String realName) {
		if (isNotEmpty(realName)) {
			return realName;
		}
		return "先生/女士";
	}

	/**
	 * 2个字符串进行比较
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param src
	 * @param des
	 * @return
	 * @return: boolean
	 */
	public static boolean equals(String src, String des) {
		if (src == null || des == null) {
			return false;
		} else {
			return src.equals(des);
		}
	}

	/**
	 * 
	 * @Description: 判斷字符串是否不是空，如果是null，返回false,如果是""返回false
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param src
	 * @return
	 * @return: boolean
	 */
	public static boolean isNotEmpty(String src) {
		return !isEmpty(src);
	}

	/**
	 * 
	 * @Description: 判断字符串是否是空，如果是null， ""返回true
	 * @author:
	 * @date: 
	 * @version: 
	 * @param src
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmpty(Object src) {
		return src == null || src.toString().trim().equals("");
	}

	/**
	 * 对字符串起始终止间的词进行加*，从0开始包前不包后
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @return
	 * @return: String
	 */
	public static String handlerSensitive(String words, Integer begin, Integer end) {
		if (StringUtils.isEmpty(words))
			return null;
		StringBuilder replaceStr = new StringBuilder("");
		for (int i = begin; i < end; i++) {
			replaceStr.append("*");
		}
		StringBuilder sb = new StringBuilder(words);
		sb.replace(begin, end, replaceStr.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(handlerSensitive("哈哈所多多多多多", 2, 5));
	}
}
