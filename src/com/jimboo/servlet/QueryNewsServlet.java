package com.jimboo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.News;
import com.jimboo.service.NewsService;
import com.jimboo.service.impl.NewsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/queryNews")
public class QueryNewsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsService ns = new NewsServiceImpl();
		List<News> allNews = ns.queryAllNews();
		req.setAttribute("allNews", allNews);
		req.getRequestDispatcher("allNews.jsp").forward(req, resp);
	}
}
