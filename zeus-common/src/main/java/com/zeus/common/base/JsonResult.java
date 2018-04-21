package com.zeus.common.base;

public class JsonResult {

	private Object result;
	private String message;

	public JsonResult() {
	}

	public JsonResult(Object result) {
		this.result = result;
	}

	public JsonResult(Object result, String message) {
		this.result = result;
		this.message = message;
	}

	public static JsonResult success() {
		return new JsonResult(true);
	} 

	public static JsonResult error() {
		return new JsonResult(false);
	} 

	public static JsonResult error(String message) {
		return new JsonResult(false, message);
	} 

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
