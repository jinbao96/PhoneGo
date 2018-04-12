package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.MessageDao;
import com.jimboo.entity.Message;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class MessageDaoImpl implements MessageDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<Message> mapper=new RowMapper<Message>() {

		@Override
		public Message getInstance(ResultSet rs) throws SQLException {
			Message message=new Message();
			message.setMessage_id(rs.getInt("message_id"));
			message.setUser_id(rs.getInt("user_id"));
			message.setMessage_title(rs.getString("message_title"));
			message.setMessage_text(rs.getString("message_text"));
			message.setMessage_date(rs.getTimestamp("message_date"));
			return message;
		}
	};
	@Override
	public int insert(Message message) {
		String sql="insert into a_message values (message_id_seq.nextval,?,?,?,sysdate)";
		return jt.update(sql, message.getUser_id(),message.getMessage_title(),message.getMessage_text());
	}
	@Override
	public List<Message> queryAll() {
		String sql="select * from a_message order by message_id desc";
		return jt.query(sql, mapper);
	}

}
