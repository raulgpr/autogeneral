package com.autogeneral.test.models;

public class ToDoItem {

	public ToDoItem() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String text;
	private boolean isCompleted;
	private String createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
