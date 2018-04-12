package com.jimboo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Goods;
import com.jimboo.service.GoodsService;
import com.jimboo.service.impl.GoodsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/changeGoods")
public class ChangeGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Goods g = new Goods();
		g.setGoods_id(Integer.parseInt(req.getParameter("goods_id")));
		g.setGname(req.getParameter("gname"));
		g.setPrice(Double.parseDouble(req.getParameter("price")));
		g.setInfo(req.getParameter("info"));
		g.setCount(Integer.parseInt(req.getParameter("count")));
		System.out.println("ÐÞ¸Ä>>>>" + g);
		GoodsService gs = new GoodsServiceImpl();
		boolean f = gs.changeGoods(g);
		if(f) {
			//³É¹¦
			resp.getWriter().write("1");
		}else {
			resp.getWriter().write("0");
		}
	}
}





