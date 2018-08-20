package com.pinyougou.enums;

public enum IsValid {

	VALID("VALID",1), INVALID("INVALID",0);

	public Integer value;
	public String title;

	private IsValid(String title,Integer value) {
		this.title = title;
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
