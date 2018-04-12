package com.jimboo.service.impl;

import com.jimboo.dao.AdminDao;
import com.jimboo.dao.impl.AdminDaoImpl;
import com.jimboo.entity.Admin;
import com.jimboo.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao ad = new AdminDaoImpl();
	@Override
	public Admin query(Admin admin) {
		// TODO Auto-generated method stub
		return ad.query(admin);
	}

}
