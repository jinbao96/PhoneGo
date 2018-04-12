package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.News;

public interface NewsService {
	/**查询所有新闻*/
	List<News> queryAllNews();
	/**按新闻id查询新闻*/
	News queryNewsById(int news_id);
	boolean addNews(News n);
	boolean del(int news_id);

}
