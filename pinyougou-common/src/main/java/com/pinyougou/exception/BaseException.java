package com.pinyougou.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.pinyougou.constant.HttpCode;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 
 * @author 
 * @version 
 */
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	//异常消息
	protected String msg;
	//异常代码
	protected String code;
	//http_code
	protected HttpCode httpCode;
	
	public BaseException() {
	}

	public BaseException(Throwable ex) {
		super(ex);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable ex) {
		super(message, ex);
	}

	public void handler(ModelAndView modelAndView) {
		modelAndView.addObject("httpCode", getHttpCode());
		if (!StringUtils.isEmpty(getMsg())) {
			modelAndView.addObject("msg", getMsg());
		} else {
			modelAndView.addObject("msg", getMessage());
		}
		modelAndView.addObject("timestamp", System.currentTimeMillis());
		modelAndView.setViewName("404");
	}
	
}
