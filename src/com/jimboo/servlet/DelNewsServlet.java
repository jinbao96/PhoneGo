package com.jimboo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.service.NewsService;
import com.jimboo.service.impl.NewsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/delNews")
public class DelNewsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int news_id = Integer.parseInt(req.getParameter("news_id"));
		NewsService ns = new NewsServiceImpl();
		boolean f = ns.del(news_id);
		if(f) {
			//³É¹¦
			resp.getWriter().write("1");
			
		}else {
			resp.getWriter().write("0");
		}
	}
}







