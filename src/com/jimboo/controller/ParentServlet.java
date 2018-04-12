package com.jimboo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Goods;
import com.jimboo.service.GoodsService;
import com.jimboo.service.impl.GoodsServiceImpl;
import com.jimboo.util.Page;

@SuppressWarnings("serial")
@WebServlet("/parent")
public class ParentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...parent");
		int category_id=Integer.parseInt(req.getParameter("category_id"));
		System.out.println(category_id);
		String pg = req.getParameter("pageNum");
		System.out.println(pg);
		int pageNum=pg==null?1:Integer.parseInt(pg);
		System.out.println(pageNum);
		GoodsService gs=new GoodsServiceImpl();
		List<Goods> list=gs.queryByCid(category_id);
		System.out.println(list);
		
		Page page=new Page(pageNum, 12, list.size());
		System.out.println(page);
		List<Goods> catelist=gs.queryByCidPage(category_id,page);
		System.out.println(catelist);
		req.setAttribute("glist", catelist);
		req.setAttribute("page", page);
		req.setAttribute("category_id",category_id);
		req.getRequestDispatcher("view/category.jsp").forward(req, resp);
	}
}








