package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.OrderDao;
import com.jimboo.dao.impl.OrderDaoImpl;
import com.jimboo.entity.Order;
import com.jimboo.entity.QueryOrder;
import com.jimboo.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao=new OrderDaoImpl();
	@Override
	public boolean insert(int user_id, int goods_id, int cart_id, int quantity, long order_number, String address) {
		int i=dao.insert(user_id,goods_id,cart_id,quantity,order_number,address);
		if(i>=0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Order> query(long order_number) {
		// TODO Auto-generated method stub
		return dao.query(order_number);
	}
	@Override
	public boolean insertNocart(int user_id, int goods_id, int quantity, long order_number, String address) {
		int i=dao.insertNocart(user_id, goods_id, quantity, order_number, address);
		if(i>=0) {
			return true;
		}
		return false;
	}
	@Override
	public List<QueryOrder> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	@Override
	public double queryMoney(String date) {
		// TODO Auto-generated method stub
		return dao.queryMoney(date);
	}

}
