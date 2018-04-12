package com.jimboo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.service.GoodsService;
import com.jimboo.service.impl.GoodsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/del")
public class DelGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		GoodsService gs = new GoodsServiceImpl();
		boolean f = gs.del(goods_id);
		if(f) {
			//³É¹¦
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
	}
}




