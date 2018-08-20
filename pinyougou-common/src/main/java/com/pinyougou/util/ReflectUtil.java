package com.pinyougou.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {

	/**
	 * @Description: TODO  反射获取对象中不为空的属性和属性值
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param obj
	 * @return
	 * @throws Exception
	 * @throws IllegalAccessException
	 * @return: Map<String,String>
	 */
	public static Map<String,String> checkObjFieldIsNull(Object obj) {
		Map<String,String> map =new HashMap<String,String>();
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.get(obj) != null && !f.getName().equals("serialVersionUID")) {
					map.put(f.getName(),f.get(obj).toString());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/*public static void main(String[] args) throws IllegalAccessException, Exception {
		SysUser u=new SysUser();
		u.setAccount("123");
		Map<String, String> map = ReflectUtil.checkObjFieldIsNull(u);
		System.out.println(JSON.toJSONString(map));
	}*/
}
