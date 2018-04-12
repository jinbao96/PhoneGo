package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.UserDao;
import com.jimboo.entity.User;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<User> mapper=new RowMapper<User>() {

		@Override
		public User getInstance(ResultSet rs) throws SQLException {
			User user=new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUsername(rs.getString("user_name"));
			user.setPwd(rs.getString("pwd"));
			user.setSex(rs.getInt("sex"));
			user.setBirthday(rs.getTimestamp("birthday"));
			user.setId_card(rs.getString("id_card"));
			user.setEmail(rs.getString("email"));
			user.setTel(rs.getString("tel"));
			user.setAddress(rs.getString("address"));		
			return user;
		}
	};
	@Override
	public int insetUser(User user) {
		String sql="insert into a_user values(user_id_seq.nextval,?,?,?,?,?,?,?,?)";
		int i = jt.update(sql,user.getUsername(),user.getPwd(),user.getSex(),user.getBirthday(),user.getId_card(),user.getEmail(),user.getTel(),user.getAddress());
		return i;
	}
	@Override
	public User queryUser(User user) {
		String sql="select * from a_user where user_name=? and pwd=?";
		List<User> list = jt.query(sql, mapper, user.getUsername(),user.getPwd());
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public List<User> queryByName(String username) {
		String sql="select * from a_user where user_name=?";
		return jt.query(sql, mapper, username);
	}
	@Override
	public List<User> queryById(String idnum) {
		String sql="select * from a_user where id_card=?";
		return jt.query(sql, mapper, idnum);
	}
	@Override
	public List<User> queryBytel(String tel) {
		String sql="select * from a_user where tel=?";
		return jt.query(sql, mapper, tel);
	}

}






