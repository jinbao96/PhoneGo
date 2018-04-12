package com.jimboo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jimboo.dao.CategoryDao;
import com.jimboo.entity.Category;
import com.jimboo.util.JdbcTemplate;
import com.jimboo.util.RowMapper;

public class CategoryDaoImpl implements CategoryDao {
	private JdbcTemplate jt=new JdbcTemplate();
	@Override
	public List<Category> queryAllCategory() {
		String sql="select * from a_category";
		return jt.query(sql, new RowMapper<Category>() {

			@Override
			public Category getInstance(ResultSet rs) throws SQLException {
				Category category=new Category();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				category.setUrl(rs.getString("url"));
				return category;
			}
		});
	}

}
