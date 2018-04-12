package com.jimboo.entity;

import java.sql.Date;

public class News {
	private int news_id;
	private String news_title;
	private String news_text;
	private Date news_date;
	private int isuse;
	public News() {
		super();
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_text() {
		return news_text;
	}
	public void setNews_text(String news_text) {
		this.news_text = news_text;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public int getIsuse() {
		return isuse;
	}
	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", news_title=" + news_title + ", news_text=" + news_text + ", news_date="
				+ news_date + ", isuse=" + isuse + "]";
	}
	
}
