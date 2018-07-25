package com.autogeneral.test.models;

public class ToDoItemUpdateRequest {

	public ToDoItemUpdateRequest() {
		// TODO Auto-generated constructor stub
	}
	
	private String text;
	private boolean isIsCompleted;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getIsIsCompleted() {
		return isIsCompleted;
	}

	public void setIsIsCompleted(boolean isIsCompleted) {
		this.isIsCompleted = isIsCompleted;
	}

}
