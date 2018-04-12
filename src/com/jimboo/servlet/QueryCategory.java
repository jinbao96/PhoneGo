package com.jimboo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Category;
import com.jimboo.service.CategoryService;
import com.jimboo.service.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/queryCate")
public class QueryCategory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		CategoryService cs = new CategoryServiceImpl();
		List<Category> list = cs.queryAllCategory();
		req.setAttribute("clist", list);
		req.getRequestDispatcher("addGoods.jsp").forward(req, resp);
	}
}
