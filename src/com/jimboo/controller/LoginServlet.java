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
		//��ȡ������û�������
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		User user=new User();
		user.setUsername(username);
		user.setPwd(MD5Utils.md5Encrypt16Upper(pwd));
		UserService us=new UserServiceImpl();
		User u=us.queryUser(user);
		//�жϷ��ص�user�Ƿ���ֵ
		if(u!=null) {
			//u��������
			//��¼�ɹ�
			//����session
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			//
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else {
			//��¼ʧ��
			//���ص�¼ҳ��,���һ����¼ʧ��
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp?status=error");
		}
	}
}





