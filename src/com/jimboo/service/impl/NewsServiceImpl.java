package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.NewsDao;
import com.jimboo.dao.impl.NewsDaoImpl;
import com.jimboo.entity.News;
import com.jimboo.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao dao=new NewsDaoImpl();
	@Override
	public List<News> queryAllNews() {
		
		return dao.queryAllNews();
	}
	@Override
	public News queryNewsById(int news_id) {
		List<News> list=dao.queryNewsById(news_id);
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public boolean addNews(News n) {
		int i = dao.addNews(n);
		if(i>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean del(int news_id) {
		int i = dao.del(news_id);
		if(i>0) {
			return true;
		}
		return false;
	}

}
