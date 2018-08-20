package com.pinyougou.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author: 
 * 描述: 三要素工具类
 * @date: 
 * @version: 
 */
public class ThreeElements {
	/**
	 * 相关参数配置
	 */
	private static String HOST = "http://telvertify.market.alicloudapi.com";
	
	private static String PATH = "/lianzhuo/telvertify";
	
	private static String METHOD = "GET";
	
	private static String APP_CODE = "8a3b7f615d624c549cb90b01dd1cd346";
	
	
	/**
	 * 请求示例
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		System.out.println(JSONObject.toJSONString(threeElements("121", "32", "232")));
	
	}
	/**
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param card  身份证
	 * @param name	姓名
	 * @param telnumber	手机号码
	 * @return
	 * @return: String
	 * 
	 * 正确返回示例：{
	 * "data":{"Mobile":"18157170715","Name":"邓贵坤","id":"510902199302207852"},
	 * "resp":{"code":"0","desc":"信息匹配"}}
	 * 
	 * 异常返回示例：{"code":"11","desc":"手机号码错误，请输入正确的手机号码."}
	 * 
	 * 网络异常返回示例：{"code":"555","desc":"实名认证失败！"}
	 */
	public static JSONObject threeElements(String card,String name,String telnumber){
		Map<String, String> headers = new HashMap<String, String>();
	    headers.put("Authorization", "APPCODE " + APP_CODE);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("id", card);
	    querys.put("name", name);
	    querys.put("telnumber",telnumber);

	    try {
	    	HttpResponse response = HttpUtils.doGet(HOST, PATH, METHOD, headers, querys);
	    	String content = EntityUtils.toString(response.getEntity());
	    	int index = content.indexOf("resp")+6;
	    	JSONObject jo = JSONObject.parseObject(content.substring(index, content.length()-1));
	    	return jo;
	    } catch (Exception e) {
	    	JSONObject jo = new JSONObject();
	    	jo.put("code", "555");
	    	jo.put("desc", "实名认证失败！");
	    	return jo;
	    }
	}
}
