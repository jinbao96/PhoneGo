package com.jimboo.service;

import com.jimboo.entity.User;

public interface UserService {
	/**注册用户*/
	boolean insertUser(User user);
	/**查询用户*/
	User queryUser(User user);
	boolean queryByName(String username);
	boolean queryById(String idnum);
	boolean queryBytel(String tel);

	

}
