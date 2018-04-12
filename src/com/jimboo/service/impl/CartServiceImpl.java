package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.CartDao;
import com.jimboo.dao.impl.CartDaoImpl;
import com.jimboo.entity.Cart;
import com.jimboo.service.CartService;

public class CartServiceImpl implements CartService {
	private CartDao dao=new CartDaoImpl();
	@Override
	public boolean queryCart(int user_id, int goods_id) {
		List<Cart> list=dao.queryCart(user_id,goods_id);
		if(list!=null&&list.size()!=0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean updateCartAdd(Cart cart) {
		int i=dao.updateCartAdd(cart);
		if(i>=0) {
			return true;
		}
		
		return false;
	}
	@Override
	public boolean updateCartGoods(Cart cart) {
		int i=dao.queryCartGoods(cart);
		if(i>=0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Cart> queryCartByUid(int user_id) {

		return dao.queryCartByUid(user_id);
	}
	@Override
	public boolean delCartById(int user_id, int cart_id) {
		int i=dao.delCartById(user_id,cart_id);
		if(i>=0) {
			return true;
		}
		return false;
	}

}
