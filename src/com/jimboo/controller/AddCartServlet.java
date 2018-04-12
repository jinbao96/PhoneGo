package com.jimboo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.Cart;
import com.jimboo.entity.User;
import com.jimboo.service.CartService;
import com.jimboo.service.impl.CartServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * ���ﳵ  
		 *  1.�Ȱ��û�������Ʒid��ѯ  ���û����ﳵ���Ƿ��д���Ʒ��δ����(isuse   0����δ����)  �������δ���� ֻ�޸�count+n
		 *  		select * from a_cart where user_id=? and goods_id=? and isuse=0
		 * 	2.���û�д˼�¼���� �����(isuse  1  ���������������) ���²���һ������Ʒ������
		 * */
		System.out.println("into...cart");
		req.setCharacterEncoding("utf-8");
		//��ȡuser_id
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int user_id=user.getUser_id();
		//��ȡ��Ʒid
		int goods_id=Integer.parseInt(req.getParameter("goods_id"));
		//��ȡ��������
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		//��ȡ����
		String p = req.getParameter("price");
		double price=Double.parseDouble(p);
		Cart cart=new Cart();
		cart.setUser_id(user_id);
		cart.setGoods_id(goods_id);
		cart.setQuantity(quantity);
		cart.setTotal(price*quantity);
		System.out.println(cart);
		//����Cartservice����
		CartService cs=new CartServiceImpl();
		boolean flag=cs.queryCart(user_id,goods_id);
		resp.setCharacterEncoding("utf-8");
		if(flag) {
			//�����ݲ��ҿ���
			System.out.println("�����ݲ��ҿ���");
			boolean flag1=cs.updateCartAdd(cart);
			if(flag1) {
				//��ӳɹ�
				System.out.println("��ӳɹ�");
				resp.getWriter().write("��ӳɹ�");
			}else {
				//���ʧ��
				System.out.println("���ʧ��");
			}
		}else {
			//�����ݲ����� ��û������
			System.out.println("�����ݲ����� ��û������");
			boolean flag1=cs.updateCartGoods(cart);
			if(flag1) {
				//��ӳɹ�
				System.out.println("��ӳɹ�");
				
				resp.getWriter().write("��ӳɹ�");
			}else {
				//���ʧ��
				System.out.println("���ʧ��");
			}
		}
	}
}




