package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.service.UserService;
import com.jimboo.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/checktel")
public class TelServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...checktel");
		String tel = req.getParameter("tel");
		UserService us=new UserServiceImpl();
		boolean flag=us.queryBytel(tel);
		resp.setCharacterEncoding("utf-8");
		System.out.println(flag);
		if(flag) {
			resp.getWriter().write("°Ã°Ã");
		}else {
			resp.getWriter().write("°¡°¡ ÷ª˙∫≈÷ÿ∏¥");
		}
	}
}
