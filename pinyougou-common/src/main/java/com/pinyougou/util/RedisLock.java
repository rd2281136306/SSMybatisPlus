package com.pinyougou.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pinyougou.constant.ResponseBasic;


/**
 * 
 * @author: 
 * 描述: Redis Lock acquisition and Release tool class
 * @date: 
 * @version: 
 */
public class RedisLock {
	
	/**
	 * 日志打印
	 */
	public static Logger logger = LoggerFactory.getLogger(RedisLock.class);
	
	/** Reids lock release time seconds*/
	public static int REDIS_LOCK_RELEASE_TIME = 5;
	
	/** user lock identify */
	public static String USER_LOCK_IDENTIFY = "YILIANGJINRONG_USER_LOCK_";
	
	/** get user lock msg success*/
	public static String GET_USER_LOCK_MSG = "持有锁成功";
	
	/** not can get user lock msg */
	public static String NOT_CAN_GET_USER_LOCK_MSG = "持有锁失败";
	
	/** release lock success msg */
	public static String RELEASE_USER_LOCK_SUCCESS_MSG = "释放锁成功";
	
	/** release lock Failed msg */
	public static String RELEASE_USER_LOCK_FAILED_MSG = "释放锁失败";
	
	/**redis tool init*/
	private static RedisUtil redis = RedisUtil.getInstance();
	
	/** get user lock error msg */
	public static String GET_USER_LOCK_ERROR_MSG = "尝试访问Redis资源异常";
	
	/**
	 * 
	 * @Description: 尝试获取锁
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param identify 用户唯一标识
	 * @return
	 * @return: boolean
	 */
	public static ResponseBasic acquisitionLock(Object identify){
		
		try {
			System.out.println(redis.getValue(USER_LOCK_IDENTIFY+identify));
			if(redis.isExist(USER_LOCK_IDENTIFY+identify))
				return ResponseBasic.responseFailed(NOT_CAN_GET_USER_LOCK_MSG);
			
			redis.addKey(USER_LOCK_IDENTIFY+identify,REDIS_LOCK_RELEASE_TIME);
			return ResponseBasic.responseSuccess(GET_USER_LOCK_MSG);
			
		} catch (Exception e) {
			return ResponseBasic.responseError();
		}
	}
	
	/**
	 * 
	 * @Description: 尝试释放锁
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param identify 用户唯一标识
	 * @return
	 * @return: boolean
	 */
	public static ResponseBasic releaseLock(Object identify){
		
		try {
			if(!redis.isExist(USER_LOCK_IDENTIFY+identify))
				return ResponseBasic.responseSuccess(RELEASE_USER_LOCK_SUCCESS_MSG);
			
			redis.deleteKey(USER_LOCK_IDENTIFY+identify);
			return ResponseBasic.responseSuccess(RELEASE_USER_LOCK_SUCCESS_MSG);
		} catch (Exception e) {
			return ResponseBasic.responseError();
		}
	}
	
	public static void main(String[] args) {
		ResponseBasic redisResponse2 = acquisitionLock(103L);
		System.out.println(org.json.JSONObject.valueToString(redisResponse2));
		ResponseBasic redisResponse1 = acquisitionLock(103L);
		System.out.println(org.json.JSONObject.valueToString(redisResponse1));
		ResponseBasic redisResponse3 = releaseLock(103L);
		System.out.println(org.json.JSONObject.valueToString(redisResponse3));
		ResponseBasic redisResponse4 = acquisitionLock(103L);
		System.out.println(org.json.JSONObject.valueToString(redisResponse4));
	}
}
