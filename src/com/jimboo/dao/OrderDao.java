package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.Order;
import com.jimboo.entity.QueryOrder;

public interface OrderDao {

	int insert(int user_id, int goods_id, int cart_id, int quantity, long order_number, String address);

	List<Order> query(long order_number);

	int insertNocart(int user_id, int goods_id, int quantity, long order_number, String address);

	List<QueryOrder> queryAll();

	double queryMoney(String date);

}
