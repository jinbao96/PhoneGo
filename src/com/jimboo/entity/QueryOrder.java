package com.jimboo.entity;

public class QueryOrder {
	private long order_num;
	private String order_date;
	private double total;
	private String test;
	public QueryOrder() {
		super();
	}
	public long getOrder_num() {
		return order_num;
	}
	public void setOrder_num(long order_num) {
		this.order_num = order_num;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "QueryOrder [order_num=" + order_num + ", order_date=" + order_date + ", total=" + total + ", test="
				+ test + "]";
	}
	
	
	
}
