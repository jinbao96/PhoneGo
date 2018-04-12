package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.service.CartService;
import com.jimboo.service.impl.CartServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/delCart")
public class DelCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...del");
		//��ȡҪɾ�����û�id
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		//��ȡҪɾ���Ĺ��ﳵid
		int cart_id=Integer.parseInt(req.getParameter("cart_id"));
		CartService cs=new CartServiceImpl();
		boolean flag=cs.delCartById(user_id,cart_id);
		resp.setCharacterEncoding("utf-8");
		if(flag) {
			System.out.println("ɾ���ɹ�");
			//resp.getWriter().write("ɾ���ɹ�");
			req.getRequestDispatcher("cart?user_id="+user_id).forward(req, resp);
		}
		
	}
}




