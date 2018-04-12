package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.Message;

public interface MessageDao {

	int insert(Message message);

	List<Message> queryAll();

}
