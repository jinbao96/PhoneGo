package com.jimboo.service;

import java.util.List;

import com.jimboo.entity.News;

public interface NewsService {
	/**��ѯ��������*/
	List<News> queryAllNews();
	/**������id��ѯ����*/
	News queryNewsById(int news_id);
	boolean addNews(News n);
	boolean del(int news_id);

}
