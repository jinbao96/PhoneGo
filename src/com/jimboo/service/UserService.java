package com.jimboo.service;

import com.jimboo.entity.User;

public interface UserService {
	/**ע���û�*/
	boolean insertUser(User user);
	/**��ѯ�û�*/
	User queryUser(User user);
	boolean queryByName(String username);
	boolean queryById(String idnum);
	boolean queryBytel(String tel);

	

}
