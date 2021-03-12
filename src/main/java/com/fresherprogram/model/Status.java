package com.fresherprogram.model;

public class Status {
	private String code;
	private String value;
	
	public Status() {
		super();
		this.code = "";
		this.value = "";
	}
	public Status(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
