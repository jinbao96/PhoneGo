package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.UserDao;
import com.jimboo.dao.impl.UserDaoImpl;
import com.jimboo.entity.User;
import com.jimboo.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao=new UserDaoImpl();
	@Override
	public boolean insertUser(User user) {
		int i=dao.insetUser(user);
		if(i>=0) {
			return true;
		}
		return false;
	}
	@Override
	public User queryUser(User user) {
		
		return dao.queryUser(user);
	}
	@Override
	public boolean queryByName(String username) {
		List<User> list=dao.queryByName(username);
		System.out.println(list);
		if(list!=null&&list.size()!=0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean queryById(String idnum) {
		List<User> list=dao.queryById(idnum);
		System.out.println(list);
		if(list!=null&&list.size()!=0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean queryBytel(String tel) {
		List<User> list=dao.queryBytel(tel);
		System.out.println(list);
		if(list!=null&&list.size()!=0) {
			return false;
		}
		return true;
	}

	

}
