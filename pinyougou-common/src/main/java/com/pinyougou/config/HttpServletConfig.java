package com.pinyougou.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
public interface HttpServletConfig {  
    default HttpServletRequest getHttpServletRequest() {  
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    } 
    
    static HttpSession getHttpSession() {  
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    } 
}  