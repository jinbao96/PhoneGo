package com.jimboo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.User;
import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;
import com.jimboo.util.Index;

@SuppressWarnings("serial")
@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...order");
		req.setCharacterEncoding("utf-8");
		//获取用户id
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_id();
		//获取地址
		String address = req.getParameter("address");
		//按毫秒值生成订单号
		Date date=new Date();
		long order_number = date.getTime();
		//获取选中的购物车记录
		String[] values = req.getParameterValues("cart");
		//创建  要传递的参数的int数组
		int[] cart_id=new int[values.length];
		int[] goods_id=new int[values.length];
		int[] quantity=new int[values.length];
		System.out.println(values.length);
		for (int i = 0; i < values.length; i++) {
			String[] split = values[i].split(",");
			System.out.println(split[0]+","+split[1]);
			goods_id[i]=Integer.parseInt(split[0]);
			System.out.println("第"+(i+1)+"个商品id"+goods_id[i]);
			cart_id[i]=Integer.parseInt(split[1]);
			System.out.println("第"+(i+1)+"个购物车id"+cart_id[i]);
		}
		
	
		//获取购物车id数组
		String[] c = req.getParameterValues("cart_id");
		//获取购买数量数组
		String[] qu = req.getParameterValues("quantity");
		int[] quan=new int[c.length];
		int[] cart=new int[c.length];
		for(int j=0;j<c.length;j++) {
			quan[j]=Integer.parseInt(qu[j]);
			cart[j]=Integer.parseInt(c[j]);
		}
		for(int k=0;k<values.length;k++) {
			quantity[k]=quan[Index.indexOf(cart, cart_id[k])];
			System.out.println(quantity[k]);
		}
		

		OrderService os=new OrderServiceImpl();
		boolean flag=false;
		for(int b=0;b<values.length;b++) {
			flag = os.insert(user_id,goods_id[b],cart_id[b],quantity[b],order_number,address);
		}
		if(flag) {
			System.out.println("订单成功");
			resp.sendRedirect("queryorder?order_number="+order_number);
		}		
		/**获取商品id数组
			String[] g = req.getParameterValues("goods_id");
			
			
			int[] goods_id=new int[g.length];
			//转换成int数组
			if(qu!=null) {
				for(int i=0;i<qu.length;i++) {
					quantity[i]=Integer.parseInt(qu[i]);
					System.out.println("数量:"+quantity[i]);
					cart_id[i]=Integer.parseInt(c[i]);
					System.out.println("购物车id:"+cart_id[i]);
					goods_id[i]=Integer.parseInt(g[i]);
				}
			}
			//System.out.println("数量:"+quantity[0]+","+quantity[1]);
			//System.out.println("购物车id:"+cart_id[0]+","+cart_id[1]);
			
			System.out.println(order_number);
			
			
			*/
		
		
		
	}
}









