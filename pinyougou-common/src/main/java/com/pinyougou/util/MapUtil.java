package com.pinyougou.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 
 * 描述: TODO 把list,Object等存放到map当中
 * @date: 
 * @version: 
 */
public class MapUtil {

	/**
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param list
	 * @param objAttr
	 * @return
	 * @return: Map
	 */
	@SuppressWarnings("rawtypes")
	public static Map listInMap(List list, String objAttr) {
		Map<String, Object> m = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			Class objCla = list.get(i).getClass();
			try {
				Field[] fs = objCla.getDeclaredFields();
				for (int j = 0; j < fs.length; j++) {
					Field f = fs[j];
					f.setAccessible(true);// 设置这些属性是可访问的
					// 得到此属性的值
					if (f.getName().equals(objAttr)) {
						Object o = f.get(list.get(i));
						m.put(o.toString(), list.get(i));
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	 // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
    public static Map<String, String> transBean2Map(Object obj) {  
        if(obj == null){  
            return null;  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value.toString());  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
        return map;  
    }  
    
    
}
