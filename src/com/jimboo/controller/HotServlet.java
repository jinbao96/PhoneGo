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

@SuppressWarnings("serial")
@WebServlet("/hot")
public class HotServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...hot");
		//≤È—Ø»»¬Ù
		GoodsService gs=new GoodsServiceImpl();
		List<Goods> hotlist=gs.queryHot();
		req.setAttribute("hotlist", hotlist);
		//String hotjson = JSON.toJSONString(hotlist);
		req.getRequestDispatcher("view/hot.jsp").forward(req, resp);
	}
}




