package com.jimboo.service.impl;

import java.util.List;

import com.jimboo.dao.CategoryDao;
import com.jimboo.dao.impl.CategoryDaoImpl;
import com.jimboo.entity.Category;
import com.jimboo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao dao=new CategoryDaoImpl();
	@Override
	public List<Category> queryAllCategory() {
		return dao.queryAllCategory();
	}
	
}
