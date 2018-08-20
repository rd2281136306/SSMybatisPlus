package com.pinyougou.util;

import java.math.BigDecimal;
import java.util.Date;

public class OpinionUtils {

	/**
	 * 
	 * @Description: 验证数值类型数据是否为空/可传入数值(Long/Double/Integer)
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param param    验证参数
	 * @param validZero   是否验证值为0的情况返回false
	 * @return
	 * @return: boolean
	 */
	public static boolean notEmpty(Object param,boolean validZero){
		
		/**
		 * 判断参数是否为空
		 */
		if(param == null)
			return false;
		
		/**
		 * 验证参数是否合法
		 */
		if(!(param instanceof Integer) && !(param instanceof Long) && !(param instanceof Double) && !(param instanceof BigDecimal))
			return false;
		
		
		/**
		 * 判断是否验证value等于0返回false
		 */
		if(validZero)
			return !"0".equals(String.valueOf(param));
		
		return true;
	}
	
	/**
	 * 
	 * @Description: 判断时间是否为空
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param param
	 * @return
	 * @return: boolean
	 */
	@SuppressWarnings("unused")
	public static boolean notEmpty(Date param){
		
		/**
		 * 验证参数是否合法
		 */
		if(!(param instanceof Date))
			return false;
		
		/**
		 * 判断参数是否为空
		 */
		if(param == null)
			return false;
		
		return true;
	}
	
	/**
	 * 
	 * @Description: 判断对象是否为空
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param param
	 * @return
	 * @return: boolean
	 */
	public static boolean notEmpty(Object param){
		
		/**
		 * 判断参数是否为空
		 */
		if(param == null)
			return false;
		
		/**
		 * 验证参数是否合法
		 */
/*		if(!(param instanceof Model))
			return false;*/
		
		return true;
	}
	
	
	public static void main(String[] args) {
//		Bidding b = new Bidding();
//		HttpClientUtils sdf = new HttpClientUtils();
//		Long s = 0L;
//		System.out.println(NoEmpiy(b, true));
//		Integer i = 0;
//		System.out.println("----i instanceof Integer-------"+(i instanceof Integer));
	}
}
