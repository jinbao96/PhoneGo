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
@WebServlet("/dim")
public class DimGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("into...dim");
		String gname = req.getParameter("gname");
		String pg = req.getParameter("pageNum");
		int pageNum=pg==null?1:Integer.parseInt(pg);
		GoodsService gs=new GoodsServiceImpl();
		List<Goods> list=gs.queryByGname(gname);
		System.out.println(list);
		Page page=new Page(pageNum, 12, list.size());
		List<Goods> gnamelist=gs.queryByGnamePage(gname,page);
		System.out.println(gnamelist);
		req.setAttribute("gpage",page);
		req.setAttribute("gnamelist", gnamelist);
		req.setAttribute("gname", gname);
		req.getRequestDispatcher("view/gnamelist.jsp").forward(req, resp);
	}
}




