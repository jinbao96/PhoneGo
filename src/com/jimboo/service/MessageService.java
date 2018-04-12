package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Message;

public interface MessageService {

	boolean insert(Message message);

	List<Message> queryAll();

}
