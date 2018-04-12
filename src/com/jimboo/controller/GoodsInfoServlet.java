package com.jimboo.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jimboo.entity.Goods;
import com.jimboo.service.GoodsService;
import com.jimboo.service.impl.GoodsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/goodsInfo")
public class GoodsInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("into...goodsinfo");
		int goods_id=Integer.parseInt(req.getParameter("goods_id"));
		String str = req.getParameter("f");
		int f=str==null?0:Integer.parseInt(str);
		
		GoodsService gs=new GoodsServiceImpl();
		Goods goods=gs.queryById(goods_id);
		System.out.println(goods);
		req.setAttribute("goods",goods);
		if(f==1) {
			history(req, goods);
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			req.setAttribute("quantity", quantity);
			req.getRequestDispatcher("view/nowbuy.jsp").forward(req, resp);
		}else if(f==2) {
			req.getRequestDispatcher("changeGoods.jsp").forward(req, resp);
		}
		else {
			history(req, goods);
			req.getRequestDispatcher("view/info.jsp").forward(req, resp);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void history(HttpServletRequest req,Goods goods) {
		
		//获取session
		HttpSession session = req.getSession();
		//获取历史浏览
		LinkedList<Goods> list = (LinkedList<Goods>) session.getAttribute("hlist");

		if(list==null) {
			LinkedList<Goods> hlist=new LinkedList<>();
			hlist.addFirst(goods);
			session.setAttribute("hlist", hlist);
		}else {
			if(list.size()!=0) {
				for (Goods goods2 : list) {
					if(goods2.getGoods_id()==goods.getGoods_id()) {
						list.remove(goods2);
						list.addFirst(goods);
						return;
					}
				}
			}
			if(list.size()<5) {
				list.addFirst(goods);
			}else {
				list.addFirst(goods);
				list.removeLast();
			}
			
		} 
		
	}
}





