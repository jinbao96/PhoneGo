package com.jimboo.entity;

import java.sql.Timestamp;

public class User {
	private int user_id;
	private String username;
	private String pwd;
	private int sex;
	private Timestamp birthday;							
	private String id_card;
	private String email;							
	private String tel;
	private String address;
	public User() {
		super();
	}
	public User(String username, String pwd, int sex, Timestamp birthday, String id_card, String email, String tel,String address) {
		this.username = username;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.id_card = id_card;
		this.email = email;
		this.tel = tel;
		this.address = address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", pwd=" + pwd + ", sex=" + sex + ", birthday="
				+ birthday + ", id_card=" + id_card + ", email=" + email + ", tel=" + tel + ", address=" + address
				+ "]";
	}
	
}
