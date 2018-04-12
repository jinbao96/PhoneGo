package com.jimboo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Order;
import com.jimboo.entity.QueryOrder;
import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/queryAllOrder")
public class QueryAllOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		OrderService os = new OrderServiceImpl();
		List<QueryOrder> allOrder = os.queryAll();
		List<QueryOrder> query = new ArrayList<>();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<allOrder.size();i++) {
			QueryOrder qo = new QueryOrder();
			qo.setOrder_num(allOrder.get(i).getOrder_num());
			List<Order> list = os.query(allOrder.get(i).getOrder_num());
			double total = 0;
			for(int j=0;j<list.size();j++) {
				total += list.get(j).getTotal();
			}
			qo.setTotal(total);
			qo.setOrder_date(allOrder.get(i).getOrder_date());
			qo.setTest(allOrder.get(i).getTest());
			query.add(qo);
		}
		System.out.println("¶©µ¥,,,," + query);
		req.setAttribute("olist", query);
		req.getRequestDispatcher("shouzhi.jsp").forward(req, resp);
	}
}




