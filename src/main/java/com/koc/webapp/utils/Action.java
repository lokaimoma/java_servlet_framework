package com.koc.webapp.utils;

public class Action {
	private String actionClassName;
	private String payloadKey;
	private String successFile;
	private String errorFile;
	private String methodName;
	
	
	public Action() {
		super();
	}

	public Action(String className, String payloadKey, String successFile, String errorFile, String methodName) {
		super();
		this.actionClassName = className;
		this.payloadKey = payloadKey;
		this.successFile = successFile;
		this.errorFile = errorFile;
		this.methodName = methodName;
	}

	public String getActionClassName() {
		return actionClassName;
	}

	public String getPayloadKey() {
		return payloadKey;
	}

	public String getSuccessFile() {
		return successFile;
	}

	public String getErrorFile() {
		return errorFile;
	}

	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}

	public void setPayloadKey(String payloadKey) {
		this.payloadKey = payloadKey;
	}

	public void setSuccessFile(String successFile) {
		this.successFile = successFile;
	}

	public void setErrorFile(String errorFile) {
		this.errorFile = errorFile;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
}
