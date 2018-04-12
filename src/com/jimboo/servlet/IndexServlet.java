package com.jimboo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Money;
import com.jimboo.service.OrderService;
import com.jimboo.service.impl.OrderServiceImpl;
@WebServlet("/index")
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * ��ҳ������ʾ�Ͳ�ѯ
		 * Ĭ����ʾ����,����,������������
		 * 
		 * 
		 * */
		//��ȡʱ��
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Money m = new Money();
		//������
		OrderService os = new OrderServiceImpl();
		double yearMoney = os.queryMoney(sdf1.format(date));
		//System.out.println(yearMoney);
		m.setYearMoney(yearMoney);
		//������
		double mmonthMoney = os.queryMoney(sdf2.format(date));
		m.setMonthMoney(mmonthMoney);
		//������
		double dayMoney = os.queryMoney(sdf3.format(date));
		m.setDayMoney(dayMoney);
		req.getSession().setAttribute("money", m);
		req.getRequestDispatcher("backIndex.jsp").forward(req, resp);
	}
}




