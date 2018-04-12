package com.jimboo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Cart;
import com.jimboo.service.CartService;
import com.jimboo.service.impl.CartServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 通过用户id
		 * 查询 此用户所有的购物车纪录  (isuse=0)
		 * */
		System.out.println("into...cart");
		req.setCharacterEncoding("utf-8");
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		CartService cs=new CartServiceImpl();
		List<Cart> clist = cs.queryCartByUid(user_id);
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("view/cart.jsp").forward(req, resp);
		
	}
}






