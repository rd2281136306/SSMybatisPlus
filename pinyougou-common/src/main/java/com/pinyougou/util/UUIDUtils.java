package com.pinyougou.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: 
 * 描述: TODO 
 * @date: 
 * @version: 
 */
public class UUIDUtils {

	/**
	 * 
	 * @Description: TODO 生成19位的uuid
	 * @author: 
	 * @date: 
	 * @version:  
	 * @return
	 * @return: String
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String sdf = new SimpleDateFormat("MMddHHMMSS").format(new Date());
		String order = uuid.toString().substring(0, 8) + sdf;
		return order;
	}

/*	public static void main(String[] args) {
		System.out.println(UUIDUtils.getUUID().length());
	}*/
}
