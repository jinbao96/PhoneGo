package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Order;
import com.jimboo.entity.QueryOrder;

public interface OrderService {

	boolean insert(int user_id, int i, int j, int k, long order_number, String address);

	List<Order> query(long order_number);

	boolean insertNocart(int user_id, int goods_id, int quantity, long order_number, String address);

	List<QueryOrder> queryAll();

	double queryMoney(String format);

	

}
