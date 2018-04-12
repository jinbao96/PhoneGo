package com.jimboo.controller;

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
@WebServlet("/news")
public class AllNewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询所有新闻
		System.out.println("into...news");
		NewsService ns=new NewsServiceImpl();
		List<News> nlist=ns.queryAllNews();
		req.setAttribute("nlist", nlist);
		System.out.println(nlist);
		req.getRequestDispatcher("view/news.jsp").forward(req, resp);
//		String njson = JSON.toJSONString(nlist);
//		resp.setContentType("application/json;chart=utf-8");
//		resp.setCharacterEncoding("utf-8");
//		ServletOutputStream out = resp.getOutputStream();
//		out.write(njson.getBytes("utf-8"));

		
	}
}




