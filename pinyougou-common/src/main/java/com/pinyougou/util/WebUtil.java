package com.pinyougou.util;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

/**
 * Web层辅助类
 * 
 * @author 
 * @version 
 */
public final class WebUtil {
	private static Logger logger = LogManager.getLogger(WebUtil.class);
	/** 获取当前用户 */
	public static final Long getCurrentUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			try {
				Session session = currentUser.getSession();
				if (null != session) {
					return (Long) session.getAttribute(com.pinyougou.constant.Constants.CURRENT_USER);
				}
			} catch (InvalidSessionException e) {
				logger.error(e);
			}
		}
		return null;
	}

	/**
	 * 获得参数Map
	 * 
	 * @param request
	 * @return
	 */
	public static final Map<String, Object> getParameterMap(HttpServletRequest request) {
		return WebUtils.getParametersStartingWith(request, null);
	}

	/** 获取客户端IP */
	public static final String getHost(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if ("127.0.0.1".equals(ip)) {
			InetAddress inet = null;
			try { // 根据网卡取本机配置的IP
				inet = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			ip = inet.getHostAddress();
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}
	public static String sign(TreeMap<String,String> map) throws Exception{
		String paramter = "";
		return MD5Utils.encry(paramter);
	}
	/**
	 * 
	 * @Description: TODO 对于重要参数的签名算法
	 * @author: 
	 * @date: 
	 * @version: 
	 * @return: void
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String signatureAlgo(String parameter, String salt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		parameter = parameter.substring(parameter.indexOf("?") + 1, parameter.lastIndexOf("&"));
		String[] param = parameter.split("&");
		for (int i = 0; i < param.length; i++) {
			String[] para = param[i].split("=");
			treeMap.put(para[0], para[1]);
		}
		String newParameter = "";
		Set<String> set = treeMap.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			newParameter = newParameter + s + "=" + treeMap.get(s) + "&";
		}
		newParameter = newParameter.substring(0, newParameter.length() - 1);
		logger.info("parameter: " + newParameter);
		return MD5Utils.encryptPwd(newParameter, salt);
	}
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		logger.info(WebUtil.signatureAlgo("sa?Adusacsa=1&bsa=2&SWa=3&sign=asdf", "123"));
	}

	/**
	 * 示例：src = 18157170715    biginLength=2    endLength = 3
	 * 结果：18******715
	 * 
	 * 
	 * @Description: 模糊数据
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param src（模糊数据）
	 * @param beginLength 保留前几位
	 * @param endLength 保留后几位
	 * @return
	 * @return: String
	 */
	public static  String dimData(String data,int beginLength,int endLength){
		
		/**
		 * 验证传入参数
		 */
		if("".equals(data))
			return "";
		
		/**
		 * 验证数据是否合法
		 */
		if((beginLength+endLength)>data.length()){
			return "beginLength+endLength 不能大于data.length！";
		}
		
		StringBuilder resultBuilder = new StringBuilder();
		String part1 = data.substring(0,beginLength);
		String part2 = data.substring(data.length() - endLength,data.length());
		resultBuilder.append(part1);
		
		for(int i=0;i<(data.length()-beginLength-endLength);i++){
			resultBuilder.append("*");
		}
		
		resultBuilder.append(part2);
		
		return resultBuilder.toString();
	}
}
