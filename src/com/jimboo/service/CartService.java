package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Cart;

public interface CartService {
	/**��ѯ���ﳵ���Ƿ��������Ʒ�Ŀ�������*/
	boolean queryCart(int user_id, int goods_id);
	/**�������*/
	boolean updateCartAdd(Cart cart);
	/**����һ�����ﳵ����*/
	boolean updateCartGoods(Cart cart);
	/**ͨ���û�id��ѯ���ﳵ*/
	List<Cart> queryCartByUid(int user_id);
	/**ͨ���û�id�͹��ﳵid'ɾ������*/
	boolean delCartById(int user_id, int cart_id);
}
