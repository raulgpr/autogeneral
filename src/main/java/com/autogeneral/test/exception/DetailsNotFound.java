package com.autogeneral.test.exception;

public class DetailsNotFound {

	private String message;

	public DetailsNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
