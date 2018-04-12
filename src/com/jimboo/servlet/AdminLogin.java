package com.jimboo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.Admin;
import com.jimboo.service.AdminService;
import com.jimboo.service.impl.AdminServiceImpl;
import com.jimboo.util.MD5Utils;

@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(MD5Utils.md5Encrypt16Upper(password));
		AdminService as = new AdminServiceImpl();
		Admin ad = as.query(admin);
		//判断返回的user是否有值
				if(ad!=null) {
					//u中有数据
					//登录成功
					//保存session
					HttpSession session = req.getSession();
					session.setAttribute("adminuser", ad);
					//
					resp.sendRedirect(req.getContextPath()+"/index");
				}else {
					//登录失败
					//返回登录页面,输出一个登录失败
					resp.sendRedirect(req.getContextPath()+"/adminlogin.jsp?status=error");
				}
	}
}




