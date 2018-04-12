package com.jimboo.entity;

public class Money {
	private double yearMoney;
	private double monthMoney;
	private double dayMoney;
	private double money;
	public Money() {
		super();
	}
	public double getYearMoney() {
		return yearMoney;
	}
	public void setYearMoney(double yearMoney) {
		this.yearMoney = yearMoney;
	}
	public double getMonthMoney() {
		return monthMoney;
	}
	public void setMonthMoney(double monthMoney) {
		this.monthMoney = monthMoney;
	}
	public double getDayMoney() {
		return dayMoney;
	}
	public void setDayMoney(double dayMoney) {
		this.dayMoney = dayMoney;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Money [yearMoney=" + yearMoney + ", monthMoney=" + monthMoney + ", dayMoney=" + dayMoney + ", money="
				+ money + "]";
	}
	
	
	
}
