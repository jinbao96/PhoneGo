package com.jimboo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Order;
import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/queryorder")
public class QueryOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long order_number=Long.parseLong(req.getParameter("order_number"));
		System.out.println("into...query");
		System.out.println(order_number);
		OrderService os=new OrderServiceImpl();
		List<Order> olist=os.query(order_number);
		//获取订单总额
		double all=0;
		for(int i=0;i<olist.size();i++) {
			all+=olist.get(i).getTotal();
		}
		req.setAttribute("olist",olist);
		System.out.println(olist);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		req.setAttribute("order_number", order_number);
		req.setAttribute("date", olist.get(0).getDate());
		req.setAttribute("all", all);
		req.setAttribute("address", olist.get(0).getAddress());
		System.out.println(all+","+olist.get(0).getAddress());
		req.getRequestDispatcher("view/order.jsp").forward(req, resp);
	}
}






