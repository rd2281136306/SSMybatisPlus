package com.pinyougou.constant;

/**
 * 
 * @author: 
 * 描述: 公共 变动参数集合表
 * @date: 
 * @version: 
 */
public interface CommonParam {

	/**********************************    redis   ***************************/
	
	public static String REDIS_HOST= "127.0.0.1";
	public static int REDIS_PORT= 6380;
	
	
	/**************************  图片上传路径IP  **********************************/
	public static String IMAGE_UPLOAF_IP = "120.77.250.210";
	
	
	/*********************************   crtfilename ****************************/
	
	public static String CRT_FILE_NAME = "itrus001.cer";
	
	
	/***********************************     路径   **********************************/
	
	/*测试*/
	public static String APP_LOCALHOST_= "http://120.77.250.210:8198";

	/*测试*/
	public static String PC_LOCALHOST_= "http://120.77.250.210:8138";	

	
	/***********************************     短信短链接配置   **********************************/
	/* http://120.77.250.210:8088/app/route/link */
	public static String LINK = "http://u6.gg/dpe4B";
	
	
	/***********************************  充值返回路径参数属性配置  **********************************/
	/*测试  http://pbzdvy.natappfree.cc  */   
	public static String BACKSTAGE_LOCALHOST_= "http://120.77.250.210:8178";
	
	
	/**********************************  充值返回路径参数属性配置   **********************************/
	public static String CARD_SECRET_AUTH_OK_= "/app/recharge/cardSecretAuthOk";
	public static String CARD_SECRET_AUTH_ASYN_NOTIFY_= "/app/recharge/cardSecretAuth/asynNotify";
	public static String QUICK_CHARGE_SIGN_ASYN_NOTIFY_= "/app/recharge/quickChargeSign/asynNotify";

	/**
	 * 富民配置参数
	 * 
	 * @author: 
	 * @date: 
	 * @version: 
	 */
	public interface BankParam {
		public static final String IP = "http://113.207.54.122:9100";// 富民请求地址
		public static final String PARTNER = "102100000001535";
		public static final String SELF_PARTNER = "R102100000001535";
		public static final String SEC_KEY = "gfea64375c51a8fef37afaeaf6f9d5a4ge2b5e0d267337cb2b42848e813277e0";
		public static final int PORT = 9100;
		public static final String SERVICE_PREIX = "/reapalreagw";
	}
}
