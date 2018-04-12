package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.GoodsDao;
import com.jimboo.dao.impl.GoodsDaoImpl;
import com.jimboo.entity.Goods;
import com.jimboo.service.GoodsService;
import com.jimboo.util.Page;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao dao=new GoodsDaoImpl();
	@Override
	public List<Goods> queryAllGoods() {
		return dao.queryAllGoods();
	}
	@Override
	public List<Goods> queryGoodsPage(Page page) {
		return dao.queryGoodsPage(page);
	}
	@Override
	public Goods queryById(int goods_id) {
		// TODO Auto-generated method stub
		return dao.queryById(goods_id);
	}
	@Override
	public List<Goods> queryByGname(String gname) {
		// TODO Auto-generated method stub
		return dao.queryByGname(gname);
	}
	@Override
	public List<Goods> queryByGnamePage(String gname, Page page) {
		// TODO Auto-generated method stub
		return dao.queryByGnamePage(gname,page);
	}
	@Override
	public List<Goods> queryByCid(int category_id) {
		// TODO Auto-generated method stub
		return dao.queryByCid(category_id);
	}
	@Override
	public List<Goods> queryByCidPage(int category_id, Page page) {
		// TODO Auto-generated method stub
		return dao.queryByCidPage(category_id,page);
	}
	
	@Override
	public List<Goods> queryHot() {
		// TODO Auto-generated method stub
		return dao.queryHot();
	}
	@Override
	public boolean addGoods(Goods g) {
		// TODO Auto-generated method stub
		int i = dao.addGoods(g);
		if(i>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean del(int goods_id) {
		// TODO Auto-generated method stub
		int i = dao.del(goods_id);
		if(i>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean changeGoods(Goods g) {
		int i = dao.changeGoods(g);
		if(i>0) {
			return true;
		}
		return false;
	}

}
