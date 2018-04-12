package com.jimboo.dao;

import java.util.List;

import com.jimboo.entity.News;

public interface NewsDao {

	List<News> queryAllNews();

	List<News> queryNewsById(int news_id);

	int addNews(News n);

	int del(int news_id);

}
