package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Goods;
import com.jimboo.util.Page;

public interface GoodsService {
	/**��ѯ������Ʒ*/
	List<Goods> queryAllGoods();
	/**��ҳ��ʾ��Ʒ*/
	List<Goods> queryGoodsPage(Page page);
	/**ͨ����Ʒid������Ʒ*/
	Goods queryById(int goods_id);
	/**ͨ����Ʒ����ѯ��Ʒ*/
	List<Goods> queryByGname(String gname);
	/**��ҳ��ʾͨ����Ʒ����ѯ����Ʒ*/
	List<Goods> queryByGnamePage(String gname, Page page);
	/**ͨ�����id'��ѯ��Ʒ*/
	List<Goods> queryByCid(int category_id);
	/**��ҳ��ʾͨ�����id'��ѯ�Ķ���*/
	List<Goods> queryByCidPage(int category_id, Page page);
	
	/**��ѯ������Ʒ*/
	List<Goods> queryHot();
	boolean addGoods(Goods g);
	boolean del(int goods_id);
	boolean changeGoods(Goods g);

}
