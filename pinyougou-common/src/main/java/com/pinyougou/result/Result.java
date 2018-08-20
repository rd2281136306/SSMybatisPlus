package com.pinyougou.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.pinyougou.constant.HttpCode;
import com.pinyougou.enums.CommonEnum;
import com.pinyougou.enums.ErrorEnum;



/**
 * 
 * @author: 
 * 描述: TODO
 * @date: 
 * @version: 
 */
public class Result implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static final String OBJECT = "data";
	
    private boolean success = true;
    private HttpCode status;
    private String businessCode;
    private String msg;
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

	public HttpCode getStatus() {
		return status;
	}

	public void setStatus(HttpCode status) {
		this.status = status;
	}

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public Result(boolean success, HttpCode status, String msg, Object obj) {
		super();
		this.success = success;
		this.status = status;
		this.msg = msg;
		this.obj = obj;
	}

	public Result(boolean success, HttpCode status, String msg) {
		super();
		this.success = success;
		this.status = status;
		this.msg = msg;
	}

	public Result() {
		super();
	}
    
	/**
	 * 渲染失败数据
	 *
	 * @return result
	 */
	public static Result renderError() {
		Result result = new Result();
		result.setSuccess(false);
		result.setStatus(HttpCode.INTERNAL_SERVER_ERROR);
		return result;
	}

	public static Result renderError(CommonEnum commonEnum) {
		Result result = new Result();
		result.setBusinessCode(commonEnum.getCode());
		result.setMsg(commonEnum.getMessage());
		result.setSuccess(false);
		return result;
	}

	public static Result renderError(String code, String message) {
		Result result = new Result();
		result.setBusinessCode(code);
		result.setMsg(message);
		result.setSuccess(false);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	public static Result renderError(String msg) {
		Result result = renderError();
		result.setMsg(msg);
		result.setSuccess(false);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	public static Result renderError(Object o, String msg) {
		Result result = renderError(o);
		result.setMsg(msg);
		result.setSuccess(false);
		return result;
	}

	/**
	 * 渲染失败数据
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	public static Result renderError(Object o) {

		Result result = renderError();
		result.setSuccess(false);
		setObj(result, o);
		return result;
	}

	/**
	 * 渲染成功数据
	 *
	 * @return result
	 */
	public static Result renderSuccess() {
		Result result = new Result();
		result.setSuccess(true);
		result.setStatus(HttpCode.OK);
		result.setBusinessCode(ErrorEnum.SUCCESS.getCode());
		return result;
	}

	/**
	 * 渲染成功数据（带信息）
	 *
	 * @param msg
	 *            需要返回的信息
	 * @return result
	 */
	public static Result renderSuccess(String msg) {
		Result result = renderSuccess();
		result.setSuccess(true);
		result.setMsg(msg);
		result.setBusinessCode(ErrorEnum.SUCCESS.getCode());
		return result;
	}

	public static Result renderSuccess(String msg, Object o) {
		Result result = renderSuccess();
		result.setMsg(msg);
		setObj(result, o);
		result.setSuccess(true);
		result.setBusinessCode(ErrorEnum.SUCCESS.getCode());
		return result;
	}

	/**
	 * 渲染成功数据（带数据）
	 *
	 * @param obj
	 *            需要返回的对象
	 * @return result
	 */
	public static Result renderSuccess(Object o) {
		Result result = renderSuccess();
		setObj(result, o);
		result.setSuccess(true);
		result.setBusinessCode(ErrorEnum.SUCCESS.getCode());
		return result;
	}
	
	/**
	 * 渲染成功数据（带数据）
	 *
	 * @param obj
	 *            需要返回的对象
	 * @return result
	 */
	public static Result renderSuccess(Object o,boolean is) {
		Result result = renderSuccess();
		setObj(result, o);
		result.setSuccess(true);
		result.setBusinessCode(ErrorEnum.SUCCESS.getCode());
		return result;
	}
	
	public static void setObj(Result result, Object o) {
		Map<String, Object> map = new HashMap<>();
		map.put(OBJECT, o);
		result.setObj(map);
	}
}
