package com.pinyougou.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * 处理spring mvc 对象绑定注解 
 * @author 
 * 
 */  
@Target(ElementType.PARAMETER)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface RequestBean {  
    String value() default "_def_param_name";  
} 
