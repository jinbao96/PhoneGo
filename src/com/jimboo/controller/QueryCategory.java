package com.jimboo.controller;

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
@WebServlet("/queryc")
public class QueryCategory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService cs=new CategoryServiceImpl();
		List<Category> clist=cs.queryAllCategory();
		req.setAttribute("catelist", clist);
		System.out.println("clist:"+clist);
		req.getRequestDispatcher("view/test.jsp");
	}
}









