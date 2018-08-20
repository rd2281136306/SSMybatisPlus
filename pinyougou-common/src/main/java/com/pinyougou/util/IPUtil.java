package com.pinyougou.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author: 
 * 描述: ip工具类
 * @date: 
 * @version: 
 */
public class IPUtil {

	/**
	 * 
	 * @Description: 获取ip
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param request
	 * @return
	 * @return: String
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) 
			return ip;
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

}
