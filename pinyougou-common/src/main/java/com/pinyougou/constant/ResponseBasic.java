package com.pinyougou.constant;


import com.pinyougou.util.RedisLock;

import lombok.Data;

/**
 * 
 * @author: 
 * 描述: 构建基础返回组件
 * @date: 
 * @version: 
 */
@Data
public class ResponseBasic {
	/**
	 * results
	 */
	boolean success;
	
	/**
	 * reason
	 */
	String msg;

	public ResponseBasic(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public static ResponseBasic responseSuccess(String msg){
		return new ResponseBasic(true,msg);
	}
	
	public static ResponseBasic responseFailed(String msg){
		return new ResponseBasic(false,msg);
	}
	
	public static ResponseBasic responseError(){
		return new ResponseBasic(false,RedisLock.GET_USER_LOCK_ERROR_MSG);
	}

	@Override
	public String toString() {
		return "ResponseBasic [success=" + success + ", msg=" + msg + "]";
	}
}
