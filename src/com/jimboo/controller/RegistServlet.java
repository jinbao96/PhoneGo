package com.jimboo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.User;
import com.jimboo.service.UserService;
import com.jimboo.service.impl.UserServiceImpl;
import com.jimboo.util.MD5Utils;

@SuppressWarnings("serial")
@WebServlet("/regist")
public class RegistServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...registservlet");
		req.setCharacterEncoding("utf-8");
		//获取注册信息
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String date = req.getParameter("birthday");
		System.out.println(date);
		//转换日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Timestamp birthday=null;
		try {
			birthday = new Timestamp(sdf.parse(date).getTime());
			System.out.println(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String id_card = req.getParameter("id_card");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		//创建service层对象
		UserService us=new UserServiceImpl();
		User user=new User(username, MD5Utils.md5Encrypt16Upper(pwd), sex, birthday, id_card, email, tel, address);
		System.out.println(user);
		//调用插入用户的方法
		boolean flag=us.insertUser(user);
		if(flag) {
			//注册成功
			//跳转到登录页面
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else {
			//注册失败
			//返回注册页面,但会显示一个注册失败,继续注册
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp?status=error");
		}
		
	}
}





