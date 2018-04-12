package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.Goods;
import com.jimboo.util.Page;

public interface GoodsDao {

	List<Goods> queryAllGoods();

	List<Goods> queryGoodsPage(Page page);

	Goods queryById(int goods_id);

	List<Goods> queryByGname(String gname);

	List<Goods> queryByGnamePage(String gname, Page page);

	List<Goods> queryByCid(int category_id);

	List<Goods> queryByCidPage(int category_id, Page page);


	List<Goods> queryHot();

	int addGoods(Goods g);

	int del(int goods_id);

	int changeGoods(Goods g);

}
