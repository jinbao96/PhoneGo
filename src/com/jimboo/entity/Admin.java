package com.jimboo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Admin {
	private int id;
	private String name;
	private String password;
	private int sex;
	private Date birthday;							
	private String idcard;
	
	public Admin() {
		super();
	}

	public Admin(int id, String name, String password, int sex, Timestamp birthday, String idcard) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.idcard = idcard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", idcard=" + idcard + "]";
	}
	
}
