package com.pinyougou.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author: 
 * @date: 
 * @version: 
 */
public class CollectionUtil {
	// 对象转Map
	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
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
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;

	}

	/**
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param obj1
	 * @param obj2
	 * @return
	 * @throws Exception
	 * @return: Map<String,Object>
	 */
	public static <T> Map<String, Object> toMap(T obj1, T obj2) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		Field[] fs = obj1.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			Object v1 = f.get(obj1);
			Object v2 = f.get(obj2);
			if (v1 == null) {
				result.put(f.getName(), v2);
			} else {
				result.put(f.getName(), v1);
			}
		}
		return result;
	}

	/**
	 * 
	 * @Description: 
	 * @author: 
	 * @date: 
	 * @version: V1.0
	 * @param obj1
	 *            输入
	 * @param obj2
	 *            原
	 * @return
	 * @throws Exception
	 * @return: T
	 */
	public static <T> T toClass(T inputObj, T obj2) throws Exception {

		Field[] fs = inputObj.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			Object value = f.get(inputObj);
			if (f.getName().equals("serialVersionUID"))
				continue;
			if (!StringUtils.isEmpty(value)) {
				f.set(obj2, value);
			}
		}
		return obj2;
	}

	/**
	 * @Description: 通过List<T> 和field 返回所有field值的list
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param args
	 * @param fieldName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @return: List<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getFieldList(List<T> args, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {

		List<T> resultList = new ArrayList<T>();// 返回容器

		if (StringUtils.isEmpty(args) || StringUtils.isEmpty(fieldName)) {
			return resultList;
		}

		args.forEach(arg -> {
			Field[] fs = arg.getClass().getDeclaredFields();

			for (Field f : fs) {
				try {
					f.setAccessible(true);
					Object value = f.get(arg);
					if (f.getName().equals("serialVersionUID") || StringUtils.isEmpty(value)
							|| !StringUtils.equals(f.getName(), fieldName))
						continue;
					resultList.add((T) value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return resultList;
	}

	/**
	 * 
	 * @Description: 将一个List<Object> 转为Map<String,T> 返回 （注:以id为Key）
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param args
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @return: Map<String,T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, T> listToMaps(List<T> args, String keyName)
			throws IllegalArgumentException, IllegalAccessException {

		Map<String, T> resultMaps = new HashMap<>();// 返回容器

		if (StringUtils.isEmpty(args) || StringUtils.isEmpty(keyName)) {// args
																		// ==
																		// null
																		// ||
																		// args
																		// == ''
																		// return
																		// //
																		// reutrn
			return resultMaps;
		}

		args.forEach(arg -> {
			Field[] fs = arg.getClass().getDeclaredFields();

			for (Field f : fs) {
				try {
					f.setAccessible(true);

					Object value = f.get(arg);

					if (f.getName().equals("serialVersionUID") || StringUtils.isEmpty(value)
							|| !StringUtils.equals(f.getName(), keyName))
						continue;

					resultMaps.put(keyName, (T) f);
					break;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return resultMaps;
	}

	/**
	 * @Description: 传入一个maps 返回一个list集合
	 * @author: 
	 * @date: 
	 * @version: V1.0
	 * @param maps
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @return: List<Value>
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<Value> mapsToList(@SuppressWarnings("rawtypes") Map maps)
			throws IllegalArgumentException, IllegalAccessException {
		return new ArrayList<Value>(maps.values());
	}

	/**
	 * 
	 * @Description: 传入资源/条件/值/寻找field
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param resource
	 * @param conditionField
	 * @param conditionValue
	 * @param findField
	 * @return
	 * @return: List<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> byFieldGetFieldValues(List<T> resource, String conditionField, String conditionValue,
			String findField) {

		List<T> resultData = new ArrayList<>();// 返回容器

		if (StringUtils.isEmpty(resource) || StringUtils.isEmpty(conditionField) || StringUtils.isEmpty(findField)) {// args
																														// ==
																														// null
																														// ||
																														// args
																														// ==
																														// ''
																														// return
																														// reutrn
			return resultData;
		}

		resource.forEach(arg -> {

			Field[] fs = arg.getClass().getDeclaredFields(); // 所有field

			// 暂存当前获取属性值
			T cur_value = (T) "";
			boolean is_exist = false;
			for (Field f : fs) {
				try {

					f.setAccessible(true);

					Object value = f.get(arg);

					if (f.getName().equals("serialVersionUID") || StringUtils.isEmpty(value))
						continue;
					if (StringUtils.equals(f.getName(), conditionField)
							&& StringUtils.equals(String.valueOf(value), conditionValue))
						is_exist = true;
					if (StringUtils.equals(f.getName(), findField))
						cur_value = (T) value;

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			if (is_exist)
				resultData.add(cur_value);
		});
		return resultData;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> byidsFindListValues(List<T> resource, String conditionField, List<Long> conditionValues,
			String findField) {

		List<T> resultData = new ArrayList<>();// 返回容器

		if (StringUtils.isEmpty(resource) || StringUtils.isEmpty(conditionField) || StringUtils.isEmpty(findField)
				|| StringUtils.isEmpty(conditionValues)) {// args == null ||
															// args == '' return
															// reutrn
			return resultData;
		}

		resource.forEach(arg -> {

			Field[] fs = arg.getClass().getDeclaredFields(); // 所有field

			// 暂存当前获取属性值
			T cur_value = (T) "";
			boolean is_exist = false;
			for (Field f : fs) {
				try {

					f.setAccessible(true);

					Object value = f.get(arg);

					if (f.getName().equals("serialVersionUID") || StringUtils.isEmpty(value))
						continue;

					if (StringUtils.equals(f.getName(), findField)) {
						cur_value = (T) value;
					}

					if (StringUtils.equals(f.getName(), conditionField) && conditionValues.contains(value))
						is_exist = true;

					if (is_exist && !StringUtils.isEmpty(cur_value))
						resultData.add(cur_value);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
		return resultData;
	}

	/**
	 * 
	 * @Description: 判断一个集合是否为空
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param list
	 * @return
	 * @return: boolean
	 */
	public static boolean isEmpty(List<Object> list) {
		return (list == null || list.size() == 0);
	}
	/**
	 * "[{"createTime":"2017-08-19
	 * 20:42:35","createUserId":null,"id":null,"lastModifyId":null,"lastModifyTime":null}]"
	 * 转map<String,object>
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param jsonArray
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	public static List<Map<String, Object>> jsonArrayToArrays(String jsonArray)throws Exception{
		String json = jsonArray.substring(jsonArray.indexOf("{"), jsonArray.lastIndexOf("}") + 1);
		List<Map<String, Object>> mapList = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Map maps = (Map) JSON.parse(json);
		for (Object map : maps.entrySet()) {
			Map<String, Object> mapq = new HashMap<>();
			@SuppressWarnings("rawtypes")
			String key = (String) ((Map.Entry) map).getKey();
			@SuppressWarnings("rawtypes")
			Object value = (Object) ((Map.Entry) map).getValue();
			mapq.put(key, value);
			mapList.add(mapq);
		}
		return mapList;
	}
}
