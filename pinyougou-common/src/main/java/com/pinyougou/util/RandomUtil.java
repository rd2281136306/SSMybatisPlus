package com.pinyougou.util;

import java.util.Random;

/**
 * @author:  
 * 描述: 随机工具类
 * @date: 
 * @version: 
 */
public class RandomUtil {
	public static final String ALLCHAR = "0123456789";
	public static final String NUMBERCHAR = "0123456789";
	public static final String NUMBER_LETTER_CHAR = "0123456789abcdefghij";
	/**
	 * @Description: 返回一个定长的随机纯数字字符串
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param length
	 * @return: String随机盐
	 */
	public static String generateRandomNumber(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
		}
		return sb.toString();
	}
	
	/**
	 * @Description: 返回一个定长的随机数字+字母的字符串
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param length
	 * @return: String随机盐
	 */
	public static String generateRandomNumberAndLetter(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBER_LETTER_CHAR.charAt(random.nextInt(NUMBER_LETTER_CHAR.length())));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.println(RandomUtil.generateRandomNumberAndLetter(10));
		}
	}
}
