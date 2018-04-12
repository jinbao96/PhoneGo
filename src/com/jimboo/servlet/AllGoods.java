package com.jimboo.servlet;

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
@WebServlet("/allGoods")
public class AllGoods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获取page页码
		String pg = req.getParameter("pageNum");
		int pageNum = pg == null ? 1 : Integer.parseInt(pg);
		System.out.println(pageNum);
		GoodsService gs = new GoodsServiceImpl();
		// 查询有多少数据
		List<Goods> allGoods = gs.queryAllGoods();
		// 创建page对象
		Page page = new Page(pageNum, 6, allGoods.size());
		List<Goods> glist=gs.queryGoodsPage(page);
		System.out.println(page);
		req.setAttribute("glist", glist);
		req.setAttribute("page", page);
		req.getRequestDispatcher("allGoods.jsp").forward(req, resp);
	}
}
