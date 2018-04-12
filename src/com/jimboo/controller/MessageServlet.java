package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Message;
import com.jimboo.service.MessageService;
import com.jimboo.service.impl.MessageServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/message")
public class MessageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...mseeage");
		req.setCharacterEncoding("utf-8");
		//获取用户id'
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		//获取留言标题
		String message_title = req.getParameter("message_title");
		//获取留言内容
		String message_text = req.getParameter("message_text");
		Message message=new Message(user_id, message_title, message_text);
		System.out.println(message);
		MessageService ms=new MessageServiceImpl();
		boolean flag=ms.insert(message);
		if(flag) {
			resp.sendRedirect(req.getContextPath() + "/viewmessage");
			//req.getRequestDispatcher("viewmessage").forward(req, resp);
			
		}
	}
}






