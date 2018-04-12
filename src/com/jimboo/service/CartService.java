package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Cart;

public interface CartService {
	/**查询购物车中是否有这个商品的可用数据*/
	boolean queryCart(int user_id, int goods_id);
	/**添加数量*/
	boolean updateCartAdd(Cart cart);
	/**插入一条购物车数据*/
	boolean updateCartGoods(Cart cart);
	/**通过用户id查询购物车*/
	List<Cart> queryCartByUid(int user_id);
	/**通过用户id和购物车id'删除数据*/
	boolean delCartById(int user_id, int cart_id);
}
