package com.pinyougou.constant;

import java.util.Map;

import com.pinyougou.util.InstanceUtil;

/**
 * 常量表
 * 
 * @author 
 * @version 
 */
public interface Constants {
	/**
	 * 异常信息统一头信息<br>
	 * 非常遗憾的通知您,程序发生了异常
	 */
	public static final String Exception_Head = "OH,MY GOD! SOME ERRORS OCCURED! AS FOLLOWS :";
	/** 缓存键值 */
	public static final Map<Class<?>, String> cacheKeyMap = InstanceUtil.newHashMap();
	/** 操作名称 */
	public static final String OPERATION_NAME = "OPERATION_NAME";
	/** 客户端语言 */
	public static final String USERLANGUAGE = "userLanguage";
	/** 客户端主题 */
	public static final String WEBTHEME = "webTheme";
	/** 当前用户 */
	public static final String CURRENT_USER = "CURRENT_USER";
	/** 上次请求地址 */
	public static final String PREREQUEST = "PREREQUEST";
	/** 上次请求时间 */
	public static final String PREREQUEST_TIME = "PREREQUEST_TIME";
	/** 登录地址 */
	public static final String LOGIN_URL = "/login.html";
	/** 非法请求次数 */
	public static final String MALICIOUS_REQUEST_TIMES = "MALICIOUS_REQUEST_TIMES";
	/** 缓存命名空间 */
	public static final String CACHE_NAMESPACE = "yiliang:";
	/** 在线用户数量 */
	public static final String ALLUSER_NUMBER = "SYSTEM:" + CACHE_NAMESPACE + "ALLUSER_NUMBER";
	/** TOKEN */
	public static final String TOKEN_KEY = CACHE_NAMESPACE + "TOKEN_KEY";
	/** 当前用户ID存放 key */
	public static final String CURRERNT_USER_ID = "CURRERNT_USER_ID";
	/** 当前角色操作权限存放 key */
	public static final String CURRERNT_ROLE_AUTHORITY = "CURRERNT_ROLE_AUTHORITY";
	/** 当前角色所有菜单权限IDS存放 key */
	public static final String CURRERNT_ROLE_MENU_AUTHORITY_IDS = "CURRERNT_ROLE_MENU_AUTHORITY_IDS";
	/** 当前用户所有菜单权限IDS存放 key */
	public static final String CURRERNT_USER_MENU_AUTHORITY_IDS = "CURRERNT_USER_MENU_AUTHORITY_IDS";
	/**
	 * 累计投资总额
	 */
	public static final String ACCUMULATEDTOTALINVESTMENT = "accumulatedTotalInvestment";
	/**
	 * 累计收益
	 */
	public static final String GENERATEDINTERESTS = "generatedInterests";

	/**
	 * 用户锁
	 */
	public static final String USER_LOCK_ = "USER_LOCK_";
	/**
	 * 用于复审测试reids是否可链接
	 */
	public static String TEST_REDIS = "testredis";
	/**
	 * 官网模块
	 */
	public static final String SESSION_SAVE_USER_KEY = "USER";
	
	public static final String SESSION_SAVE_CHANNEL_KEY = "CHANNEL";


	/** 日志表状态 */
	public interface JOBSTATE {
		/**
		 * 日志表状态，初始状态，插入
		 */
		public static final String INIT_STATS = "I";
		/**
		 * 日志表状态，成功
		 */
		public static final String SUCCESS_STATS = "S";
		/**
		 * 日志表状态，失败
		 */
		public static final String ERROR_STATS = "E";
		/**
		 * 日志表状态，未执行
		 */
		public static final String UN_STATS = "N";
	}

	
	/**
	 * 云信
	 * @author: 
	 * 描述: TODO
	 * @date: 
	 * @version: 
	 */
	public interface CloudSmsParam {
		public static final String IP = "http://h.1069106.com:1210/Services/MsgSend.asmx/SendMsg";
		public static final String USERCODE = "QDCF";
		public static final String USERPASS = "Yllc123456";

	}
	
	/**
	 * 云信
	 * @author: 
	 * 描述: TODO
	 * @date: 
	 * @version: 
	 */
	public interface CloudSmsCouponParam {
		public static final String IP = "http://112.124.24.5/api/MsgSend.asmx/SendMsg";
		public static final String USERCODE = "QDYX";
		public static final String USERPASS = "Yllc2015";

	}
	
	/**
	 * 云峰
	 * @author: 
	 * 描述: TODO
	 * @date: 
	 * @version: 
	 */
	public interface CloudFengParam {
		public static final String KEY = "orbxkllmynpucf8efdftntlyoeny128u";
		public static final String IP = "http://api.cloudfeng.com/api/v1/manySend";
		public static final String SECRET = "517a4855b37880857a6524ced7580f785597";
		public static final String DEFAULT_BATCHNUM = "qiandaikj100001";
	}

	public interface BankCard4Param {
		public static final String HOST = "https://ali-bankcard4.showapi.com";
		public static final String PATH = "/bank4";
		public static final String APPCODE = "8a3b7f615d624c549cb90b01dd1cd346";
	}

	public interface PlatformParam {
		public static final String CHANNEL = "H5";// PC IOS ANDRIOD
	}
}
