package com.jimboo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/noworder")
public class NowOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//获取用户id
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		System.out.println("用户id"+user_id);
				
		String address = req.getParameter("address");
		//按毫秒值生成订单号
		Date date=new Date();
		long order_number = date.getTime();
		//获取购买数量数组
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		//获取商品id数组
		int goods_id=Integer.parseInt(req.getParameter("goods_id"));
		
		OrderService os=new OrderServiceImpl();
		boolean flag = os.insertNocart(user_id, goods_id, quantity, order_number, address);
		if(flag) {
			System.out.println("订单成功");
			resp.sendRedirect("queryorder?order_number="+order_number);
		}
	}
}
