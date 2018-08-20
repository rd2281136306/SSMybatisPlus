package com.pinyougou.manager.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.pinyougou.config.HttpServletConfig;
import com.pinyougou.constant.Constants;
import com.pinyougou.constant.HttpCode;
import com.pinyougou.entity.User;
import com.pinyougou.enums.ErrorEnum;
import com.pinyougou.exception.org.ORGException;
import com.pinyougou.result.Result;


public class BaseController implements HttpServletConfig {
	Logger logger = Logger.getLogger(BaseController.class);

	public BaseController() {
		super();
	}

	/**
	 * @Description: 从session中取出已登录用户的信息
	 * @author: 
	 * @date: 
	 * @version: 
	 * @return
	 * @return: 
	 */
	public User getSysUserOfSession(HttpSession session) {
		// session为空，抛异常
		if (session == null)
			throw new ORGException(ErrorEnum.SESSION_NULL_ERROR);
		// session中没有该key，抛异常
		Object object = null;
		if ((object = session.getAttribute(Constants.CURRENT_USER)) == null)
			throw new ORGException(ErrorEnum.NOT_LOGIN);
		// 存储的不是CustomerInfo该类型的该key，抛异常
		User user = null;
		try {
			user = (User) object;
		} catch (Exception e) {
			throw new ORGException(ErrorEnum.NOT_LOGIN);
		}
		return user;
	}

	/**
	 * 渲染失败数据
	 *
	 * @return result
	 */
	protected static Result renderError() {
		Result result = new Result();
		result.setSuccess(false);
		result.setStatus(HttpCode.INTERNAL_SERVER_ERROR);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	protected static Result renderError(String msg) {
		Result result = renderError();
		result.setMsg(msg);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	protected static Result renderError(String code, String msg) {
		Result result = new Result();
		result.setSuccess(false);
		result.setMsg(msg);
		result.setStatus(HttpCode.OK);
		result.setBusinessCode(code);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	protected static Result renderError(Object o, String msg) {
		Result result = renderError();
		result.setMsg(msg);
		return result;
	}

	/**
	 * 渲染成功数据
	 *
	 * @return result
	 */
	protected static Result renderSuccess() {
		Result result = new Result();
		result.setSuccess(true);
		result.setStatus(HttpCode.OK);
		return result;
	}

	/**
	 * 渲染成功数据（带信息）
	 *
	 * @param msg
	 *            需要返回的信息
	 * @return result
	 */
	protected static Result renderSuccess(String msg) {
		Result result = renderSuccess();
		result.setMsg(msg);
		return result;
	}

	protected static Result renderSuccess(String msg, Object obj) {
		Result result = renderSuccess();
		result.setMsg(msg);
		result.setObj(obj);
		return result;
	}

	/**
	 * 渲染成功数据（带数据）
	 *
	 * @param obj
	 *            需要返回的对象
	 * @return result
	 */
	protected static Result renderSuccess(Object obj) {
		Result result = renderSuccess();
		result.setObj(obj);
		return result;
	}

	/**
	 * 绑定搜索对象
	 *
	 * @param binder
	 */
	@InitBinder("search")
	public void initSearchBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("search.");
	}

	/**
	 * 绑定搜索对象
	 *
	 * @param binder
	 */
	@InitBinder("vo")
	public void initVoBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("vo.");
	}

	/**
	 * @Description: 获取session
	 * @author: 
	 * @date: 
	 * @version: 
	 * @return
	 * @return: HttpSession
	 */
	public static HttpSession getSession() {
		return HttpServletConfig.getHttpSession();
	}

	/**
	 * 
	 * 
	 * @param request
	 * @return
	 * @author 
	 */
	public static String getRequestTeaParam(HttpServletRequest request) {
		String data = request.getParameter("data");
		try {
			if(StringUtils.isEmpty(data)){
				return null;
			}
			return URLDecoder.decode(URLDecoder.decode(data, "UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
