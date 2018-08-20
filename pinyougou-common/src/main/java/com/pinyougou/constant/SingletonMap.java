package com.pinyougou.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 
 * 描述: 单例Map
 * @date: 
 * @version: 
 */
public class SingletonMap implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	public static Map<String,Object> map; 
	
    private SingletonMap() { 
		 map = new HashMap<String,Object>();
    }   
    private static volatile SingletonMap instance;  

    public static SingletonMap getIstance() { 
        if (instance == null) {
            synchronized (SingletonMap.class) {
                if (instance == null) {
                    instance = new SingletonMap();   
                }   
            }   
        }   
        return instance;   
    }   
}
