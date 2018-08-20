package com.pinyougou.enums;


import com.pinyougou.constant.HttpCode;

import lombok.Getter;

/**
 * @author: 
 * 描述: 通用的异常信息枚举
 * @date: 
 * @version: 
 */
@Getter
public enum DBExceptionEnum{
	
	
	UPDATE_ERROR("UPDATE_ERROR","修改异常",HttpCode.INTERNAL_SERVER_ERROR),
	DELETE_ERROR("DELETE_ERROR","删除异常",HttpCode.INTERNAL_SERVER_ERROR),
	SELECT_ERROR("SELECT_ERROR","查询异常",HttpCode.INTERNAL_SERVER_ERROR),
	INSERT_ERROR("INSERT_ERROR","增加异常",HttpCode.INTERNAL_SERVER_ERROR);
	
	//异常代码
	private String code;
	//异常信息
	private String msg;
	//http状态码
	private HttpCode httpCode;

	
	private DBExceptionEnum(String code, String msg, HttpCode httpCode){
		this.code = code;
		this.msg = msg;
		this.httpCode = httpCode;
	}
	


	

	
	
}
