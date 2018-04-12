package com.jimboo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.User;
import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;
import com.jimboo.util.Index;

@SuppressWarnings("serial")
@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...order");
		req.setCharacterEncoding("utf-8");
		//��ȡ�û�id
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_id();
		//��ȡ��ַ
		String address = req.getParameter("address");
		//������ֵ���ɶ�����
		Date date=new Date();
		long order_number = date.getTime();
		//��ȡѡ�еĹ��ﳵ��¼
		String[] values = req.getParameterValues("cart");
		//����  Ҫ���ݵĲ�����int����
		int[] cart_id=new int[values.length];
		int[] goods_id=new int[values.length];
		int[] quantity=new int[values.length];
		System.out.println(values.length);
		for (int i = 0; i < values.length; i++) {
			String[] split = values[i].split(",");
			System.out.println(split[0]+","+split[1]);
			goods_id[i]=Integer.parseInt(split[0]);
			System.out.println("��"+(i+1)+"����Ʒid"+goods_id[i]);
			cart_id[i]=Integer.parseInt(split[1]);
			System.out.println("��"+(i+1)+"�����ﳵid"+cart_id[i]);
		}
		
	
		//��ȡ���ﳵid����
		String[] c = req.getParameterValues("cart_id");
		//��ȡ������������
		String[] qu = req.getParameterValues("quantity");
		int[] quan=new int[c.length];
		int[] cart=new int[c.length];
		for(int j=0;j<c.length;j++) {
			quan[j]=Integer.parseInt(qu[j]);
			cart[j]=Integer.parseInt(c[j]);
		}
		for(int k=0;k<values.length;k++) {
			quantity[k]=quan[Index.indexOf(cart, cart_id[k])];
			System.out.println(quantity[k]);
		}
		

		OrderService os=new OrderServiceImpl();
		boolean flag=false;
		for(int b=0;b<values.length;b++) {
			flag = os.insert(user_id,goods_id[b],cart_id[b],quantity[b],order_number,address);
		}
		if(flag) {
			System.out.println("�����ɹ�");
			resp.sendRedirect("queryorder?order_number="+order_number);
		}		
		/**��ȡ��Ʒid����
			String[] g = req.getParameterValues("goods_id");
			
			
			int[] goods_id=new int[g.length];
			//ת����int����
			if(qu!=null) {
				for(int i=0;i<qu.length;i++) {
					quantity[i]=Integer.parseInt(qu[i]);
					System.out.println("����:"+quantity[i]);
					cart_id[i]=Integer.parseInt(c[i]);
					System.out.println("���ﳵid:"+cart_id[i]);
					goods_id[i]=Integer.parseInt(g[i]);
				}
			}
			//System.out.println("����:"+quantity[0]+","+quantity[1]);
			//System.out.println("���ﳵid:"+cart_id[0]+","+cart_id[1]);
			
			System.out.println(order_number);
			
			
			*/
		
		
		
	}
}









