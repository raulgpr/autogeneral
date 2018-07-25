package com.autogeneral.test.exception;

public class ExceptionResponse<T> {
	
	private T details;
	private String name;
	
	public ExceptionResponse(T details, String name) {
		super();
		this.details = details;
		this.name = name;
	}
	
	public T getDetails() {
		return details;
	}
	public void setDetails(T details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
