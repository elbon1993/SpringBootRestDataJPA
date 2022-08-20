package com.example.demo.controller;

import java.io.Serializable;

public class AbstractResponse implements Serializable {

	private static final long serialVersionUID = 722882568761881415L;

	Object data;
	
	String successMsg;
	
	String errorMsg;
	
	Boolean isSuccess;
	
	String devMsg;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getDevMsg() {
		return devMsg;
	}

	public void setDevMsg(String devMsg) {
		this.devMsg = devMsg;
	}
	
}
