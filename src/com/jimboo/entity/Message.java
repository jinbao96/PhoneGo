package com.jimboo.entity;

import java.sql.Timestamp;

public class Message {
	private int user_id;
	private int message_id;
	private String message_title;
	private String message_text;
	private Timestamp message_date;
	public Message() {
		super();
	}
	
	public Message(int user_id, String message_title, String message_text) {
		super();
		this.user_id = user_id;
		this.message_title = message_title;
		this.message_text = message_text;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_title() {
		return message_title;
	}
	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	public Timestamp getMessage_date() {
		return message_date;
	}
	public void setMessage_date(Timestamp message_date) {
		this.message_date = message_date;
	}
	@Override
	public String toString() {
		return "Message [user_id=" + user_id + ", message_id=" + message_id + ", message_title=" + message_title
				+ ", message_text=" + message_text + ", message_date=" + message_date + "]";
	}
	
}
