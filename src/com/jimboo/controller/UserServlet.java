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
@WebServlet("/checkuser")
public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		UserService us=new UserServiceImpl();
		boolean flag=us.queryByName(username);
		resp.setCharacterEncoding("utf-8");
		if(flag) {
			resp.getWriter().write("√√");
		}else {
			resp.getWriter().write("××用户名重复");
		}
	}
}





