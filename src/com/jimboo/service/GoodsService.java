package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.Goods;
import com.jimboo.util.Page;

public interface GoodsService {
	/**查询所有商品*/
	List<Goods> queryAllGoods();
	/**分页显示商品*/
	List<Goods> queryGoodsPage(Page page);
	/**通过商品id查找商品*/
	Goods queryById(int goods_id);
	/**通过商品名查询商品*/
	List<Goods> queryByGname(String gname);
	/**分页显示通过商品名查询的商品*/
	List<Goods> queryByGnamePage(String gname, Page page);
	/**通过类别id'查询商品*/
	List<Goods> queryByCid(int category_id);
	/**分页显示通过类别id'查询的东西*/
	List<Goods> queryByCidPage(int category_id, Page page);
	
	/**查询热卖商品*/
	List<Goods> queryHot();
	boolean addGoods(Goods g);
	boolean del(int goods_id);
	boolean changeGoods(Goods g);

}
