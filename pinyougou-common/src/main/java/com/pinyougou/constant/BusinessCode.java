package com.pinyougou.constant;

import java.io.Serializable;

/**
 * @author: 
 * 描述: 状态码
 * @date: 
 * @version: 
 */
public interface BusinessCode {
	static class LoginErrorCode implements Serializable{

		private static final long serialVersionUID = 1L;
		
		/** 登陆成功 */
		public static final String LOGIN_OK = "200";
		/** 登录参数有误 */
		public static final String LOGIN_PARAM_ERROR = "201";
		/** 登录超时 */
		public static final String LOGIN_OVERTIME = "202";
		/** 账号密码错误 */
		public static final String LOGIN_ACCOUNT_OR_PASSWORD_ERROR = "203";
		/** 账号无效*/
		public static final String LOGIN_ACCOUT_INVALID = "204";
		/** 安全校验*/
		public static final String SECURITY_VALID = "205";
		/**登陆出错*/
		public static final String SYSTEM_ERROR = "500";
	}

}
