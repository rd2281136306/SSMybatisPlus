package com.pinyougou.constant;

import java.io.Serializable;

public class Token implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String value;
	private Long time;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
}
