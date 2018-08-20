package com.pinyougou.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
/**
 * JSON工具类
 * @author: 
 * 描述: TODO
 * @date: 
 * @version: 
 */
public class JsonUtils {
	
	private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> json2Map(String json){
		return JSON.parseObject(json, Map.class);
	}
	public static String obj2JsonString(Object obj){
		return JSON.toJSONString(obj);
	}
	
	/**
	 * 
	 * @Description: 解析银行返回数据，取出data数据返回
	 * 解析前数据：version=2.0&service=reapal.trust.depositApplyAPI&signType=1&sign=4025450c28a791c856c1a97fa3a1d0ad&resData={"bindId":"1fe4bc22-5ee0-4e6e-86c9-54a4f11bd10e","resultMsg":"签约成功","orderNo":"d8fc607a08082008850","resultCode":"0000","processTime":"2017-08-08 20:41:00"}
	 * 解析后数据：{"bindId":"1fe4bc22-5ee0-4e6e-86c9-54a4f11bd10e","resultMsg":"签约成功","orderNo":"d8fc607a08082008850","resultCode":"0000","processTime":"2017-08-08 20:41:00"}
	 *
	 * 
	 * 
	 * {"sign":"3161e0e631739ee273d25dd372fb0512","signType":"0","service":"reapal.trust.depositConfirmAPI","resData":"{\"orderNo\":\"45138ac909010909735\",\"resultCode\":\"0000\",\"resultMsg\":\"扣款成功\",\"processTime\":\"2017-09-01 09:02:30\"}","version":"1.0"}
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param data
	 * @return
	 * @return: String
	 */
	public static String getBankResultData(String data){
		
		logger.info("---------------------in getBankResultData method  data is="+data);
		
		data = resoving(data);
		/**
		 * 解析数据并返回
		 */
		data = data.substring(data.indexOf("{"), data.lastIndexOf("}")+1);
		
		logger.info("---------------------in getBankResultData method  resolving data is="+data);	
		return data;
	}
	
	/**
	 *  递归获取最里层json数据
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param data
	 * @return
	 * @return: String
	 */
	private static String resoving(String data){
		data = data.replaceAll("\\\\", "");
		String judgeData = data.substring(data.indexOf("{")+1, data.lastIndexOf("}"));
		if(judgeData.indexOf("{") != -1 && judgeData.lastIndexOf("}") != -1){
			resoving(judgeData);
			return judgeData;
		}else{
			return data;
		}
	}
	/**
	 * 获取返回数据中的resData
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param data
	 * @return
	 * @return: String
	 */
	/*public static String getJsonResData(String data){
		if(!data.contains("&")){
			JsonResData jsonrd = JSONObject.parseObject(data, JsonResData.class);
			return StringEscapeUtils.unescapeJson(jsonrd.getResData());//获取resData,linux上 
		}else{
			return getBankResultData(data);
		}
	}*/
}