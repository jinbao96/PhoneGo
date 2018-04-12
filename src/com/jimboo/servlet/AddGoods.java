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
@WebServlet("/AddGoods")
public class AddGoods extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Goods g = new Goods();
		String gname = (String) req.getAttribute("gname");
		g.setGname(gname);
		String info = (String) req.getAttribute("info");
		g.setInfo(info);
		g.setCategory_id(Integer.parseInt((String) req.getAttribute("catagory_id")));
		g.setCount(Integer.parseInt((String) req.getAttribute("count")));
		g.setPrice(Double.parseDouble((String) req.getAttribute("price")));
		g.setStatus(0);
		g.setUrl((String) req.getAttribute("url"));
		g.setIsuse(0);
		System.out.println("添加的商品详情:" + g);
		/**
		 * 
		 * 
		 * */
		GoodsService gs = new GoodsServiceImpl();
		boolean flag = gs.addGoods(g);
		if(flag) {
			resp.sendRedirect("addGoods.jsp?status=success");			
		}else {
			resp.sendRedirect("addGoods.jsp?status=error");
		}
//		resp.getWriter().print("<script type=\"text/javascript\">\r\n" + 
//				"	$(function () {\r\n" + 
//				"		alert(\"添加成功\");\r\n" + 
//				"	});\r\n" + 
//				"</script>");
		
	}
}



