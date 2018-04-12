package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.Cart;
import com.jimboo.entity.User;
import com.jimboo.service.CartService;
import com.jimboo.service.impl.CartServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 购物车  
		 *  1.先按用户名和商品id查询  此用户购物车里是否有此商品且未购买(isuse   0可用未购买)  如果有且未购买 只修改count+n
		 *  		select * from a_cart where user_id=? and goods_id=? and isuse=0
		 * 	2.如果没有此记录或者 购买过(isuse  1  不可用曾经购买过) 重新插入一条此商品的数据
		 * */
		System.out.println("into...cart");
		req.setCharacterEncoding("utf-8");
		//获取user_id
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int user_id=user.getUser_id();
		//获取商品id
		int goods_id=Integer.parseInt(req.getParameter("goods_id"));
		//获取购买数量
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		//获取单价
		String p = req.getParameter("price");
		double price=Double.parseDouble(p);
		Cart cart=new Cart();
		cart.setUser_id(user_id);
		cart.setGoods_id(goods_id);
		cart.setQuantity(quantity);
		cart.setTotal(price*quantity);
		System.out.println(cart);
		//创建Cartservice对象
		CartService cs=new CartServiceImpl();
		boolean flag=cs.queryCart(user_id,goods_id);
		resp.setCharacterEncoding("utf-8");
		if(flag) {
			//有数据并且可用
			System.out.println("有数据并且可用");
			boolean flag1=cs.updateCartAdd(cart);
			if(flag1) {
				//添加成功
				System.out.println("添加成功");
				resp.getWriter().write("添加成功");
			}else {
				//添加失败
				System.out.println("添加失败");
			}
		}else {
			//有数据不可用 或没有数据
			System.out.println("有数据不可用 或没有数据");
			boolean flag1=cs.updateCartGoods(cart);
			if(flag1) {
				//添加成功
				System.out.println("添加成功");
				
				resp.getWriter().write("添加成功");
			}else {
				//添加失败
				System.out.println("添加失败");
			}
		}
	}
}




