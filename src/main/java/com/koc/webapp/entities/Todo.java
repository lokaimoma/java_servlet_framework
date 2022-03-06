package com.koc.webapp.entities;

public class Todo {
	private int id;
	private String title;
	private String description;
	private String dateTime;
	public Todo() {
		super();
	}
	
	public Todo(String title, String description, String dateTime) {
		super();
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
	}

	public Todo(int id, String title, String description, String dateTime) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dateTime=" + dateTime + "]";
	}
	
	
}
