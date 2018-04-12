package com.jimboo.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.News;
import com.jimboo.service.NewsService;
import com.jimboo.service.impl.NewsServiceImpl;
@SuppressWarnings("serial")
@WebServlet("/AddNews")
public class AddNews extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		News n = new News();
		n.setNews_title(req.getParameter("news_title"));
		n.setNews_text(req.getParameter("news_text"));
		n.setNews_date(new Date(System.currentTimeMillis()));
		n.setIsuse(0);
		System.out.println("new..新闻:" + n);
		NewsService ns = new NewsServiceImpl();
		boolean flag = ns.addNews(n);
		if(flag) {
			System.out.println("成功");
			resp.sendRedirect("addNews.jsp?status=success");
		}else {
			resp.sendRedirect("addNews.jsp?status=error");
		}
	}
}






