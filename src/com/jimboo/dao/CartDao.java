package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.Cart;

public interface CartDao {

	List<Cart> queryCart(int user_id, int goods_id);

	int updateCartAdd(Cart cart);

	int queryCartGoods(Cart cart);

	List<Cart> queryCartByUid(int user_id);

	int delCartById(int user_id, int cart_id);

	

}
