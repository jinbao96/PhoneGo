package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.User;

public interface UserDao {

	int insetUser(User user);

	User queryUser(User user);

	List<User> queryByName(String username);

	List<User> queryById(String idnum);

	List<User> queryBytel(String tel);

}
