package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.MessageDao;
import com.jimboo.dao.impl.MessageDaoImpl;
import com.jimboo.entity.Message;
import com.jimboo.service.MessageService;

public class MessageServiceImpl implements MessageService {
	private MessageDao dao=new MessageDaoImpl();
	@Override
	public boolean insert(Message message) {
		int i=dao.insert(message);
		if(i>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Message> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

}
