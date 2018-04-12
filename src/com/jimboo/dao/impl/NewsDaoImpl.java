package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.NewsDao;
import com.jimboo.entity.News;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class NewsDaoImpl implements NewsDao {
	private JdbcTemplate jt=new JdbcTemplate();
	RowMapper<News> mapper=new RowMapper<News>() {

		@Override
		public News getInstance(ResultSet rs) throws SQLException {
			News news=new News();
			news.setNews_id(rs.getInt("news_id"));
			news.setNews_title(rs.getString("news_title"));
			news.setNews_text(rs.getString("news_text"));
			news.setNews_date(rs.getDate("news_date"));
			news.setIsuse(rs.getInt("isuse"));
			return news;
		}
	};
	@Override
	public List<News> queryAllNews() {
		String sql="SELECT ROWNUM rn,g.* FROM(select * from a_news where isuse=0 order by news_id desc) g where ROWNUM<=9";
		return jt.query(sql, mapper);
	}
	@Override
	public List<News> queryNewsById(int news_id) {
		String sql="select * from a_news where news_id=?";
		return jt.query(sql, mapper, news_id);
	}
	@Override
	public int addNews(News n) {
		String sql = "insert into a_news values (news_id_seq.nextval,?,?,?,?)";
		return jt.update(sql, n.getNews_title(),n.getNews_text(),n.getNews_date(),n.getIsuse());
	}
	@Override
	public int del(int news_id) {
		String sql = "delete from a_news where news_id=?";
		return jt.update(sql, news_id);
	}

}
