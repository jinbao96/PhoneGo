package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.AdminDao;
import com.jimboo.entity.Admin;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class AdminDaoImpl implements AdminDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<Admin> mapper = new RowMapper<Admin>() {
		
		@Override
		public Admin getInstance(ResultSet rs) throws SQLException {
			Admin admin = new Admin();
			admin.setId(rs.getInt("id"));
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
			admin.setSex(rs.getInt("sex"));
			admin.setBirthday(rs.getDate("birthday"));
			admin.setIdcard(rs.getString("idcard"));
			return admin;
		}
	};
	@Override
	public Admin query(Admin admin) {
		String sql="select * from admin_user where name=? and password=?";
		List<Admin> list = jt.query(sql, mapper, admin.getName(),admin.getPassword());
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}
		return null;
	}

}
