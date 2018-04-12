package com.jimboo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Message;
import com.jimboo.service.MessageService;
import com.jimboo.service.impl.MessageServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/viewmessage")
public class ViewMessageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...viewmessage");
		MessageService ms=new MessageServiceImpl();
		List<Message> messlist=ms.queryAll();
		req.setAttribute("messlist", messlist);
		req.getRequestDispatcher("view/message.jsp").forward(req, resp);
	}
}







