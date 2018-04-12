package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.User;
import com.jimboo.service.UserService;
import com.jimboo.service.impl.UserServiceImpl;
import com.jimboo.util.MD5Utils;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...loginservlet");
		//获取输入的用户名密码
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		User user=new User();
		user.setUsername(username);
		user.setPwd(MD5Utils.md5Encrypt16Upper(pwd));
		UserService us=new UserServiceImpl();
		User u=us.queryUser(user);
		//判断返回的user是否有值
		if(u!=null) {
			//u中有数据
			//登录成功
			//保存session
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			//
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else {
			//登录失败
			//返回登录页面,输出一个登录失败
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp?status=error");
		}
	}
}





