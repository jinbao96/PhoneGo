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
		//�жϷ��ص�user�Ƿ���ֵ
				if(ad!=null) {
					//u��������
					//��¼�ɹ�
					//����session
					HttpSession session = req.getSession();
					session.setAttribute("adminuser", ad);
					//
					resp.sendRedirect(req.getContextPath()+"/index");
				}else {
					//��¼ʧ��
					//���ص�¼ҳ��,���һ����¼ʧ��
					resp.sendRedirect(req.getContextPath()+"/adminlogin.jsp?status=error");
				}
	}
}




