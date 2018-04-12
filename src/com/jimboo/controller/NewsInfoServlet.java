package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.News;
import com.jimboo.service.NewsService;
import com.jimboo.service.impl.NewsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/newsinfo")
public class NewsInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...newsinfo");
		int news_id=Integer.parseInt(req.getParameter("news_id"));
		NewsService ns=new NewsServiceImpl();
		News news=ns.queryNewsById(news_id);
		req.setAttribute("news", news);
		req.getRequestDispatcher("view/newsinfo.jsp").forward(req, resp);
	}
}






