package com.jimboo.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jimboo.entity.Goods;
import com.jimboo.service.GoodsService;
import com.jimboo.service.impl.GoodsServiceImpl;
import com.jimboo.util.Page;

@WebFilter(urlPatterns= {"/index.jsp"})
public class IndexFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req1=(HttpServletRequest) req;
		HttpServletResponse resp1=(HttpServletResponse) resp;
		
		
		
		
		
		GoodsService gs=new GoodsServiceImpl();
		//全部商品
		//获取page页码
		String pg = req.getParameter("pageNum");
		int pageNum=pg==null?1:Integer.parseInt(pg);
		System.out.println(pageNum);
		//查询有多少数据
		List<Goods> allGoods = gs.queryAllGoods();
		//创建page对象  
		Page page=new Page(pageNum, 12, allGoods.size());
		List<Goods> glist=gs.queryGoodsPage(page);
		System.out.println(page);
		req.setAttribute("glist", glist);
		req.setAttribute("page", page);
		
		//类别查询
		//大类查询
		String parent = req.getParameter("category_id");
		if(parent!=null&&parent.length()>0) {
			int category_id=Integer.parseInt(parent);
			String pg1 = req.getParameter("pageNum");
			System.out.println(pg1);
			int pageNum1=pg1==null?1:Integer.parseInt(pg1);
			System.out.println(pageNum1);
			List<Goods> list=gs.queryByCid(category_id);
			System.out.println(list);
			
			Page page1=new Page(pageNum1, 12, list.size());
			System.out.println(page1);
			List<Goods> catelist=gs.queryByCidPage(category_id,page1);
			System.out.println(catelist);
			req.setAttribute("glist", catelist);
			req.setAttribute("page", page1);
			req.setAttribute("category_id",category_id);
		}
	
		
		//模糊查询
		String gname = req.getParameter("gname");
		if(gname!=null&&gname.length()>0) {
			String pg1 = req.getParameter("pageNum");
			int pageNum1=pg1==null?1:Integer.parseInt(pg1);
			List<Goods> list=gs.queryByGname(gname);
			System.out.println(list);
			Page page1=new Page(pageNum1, 12, list.size());
			List<Goods> gnamelist=gs.queryByGnamePage(gname,page1);
			System.out.println(gnamelist);
			req.setAttribute("page",page1);
			req.setAttribute("glist", gnamelist);
			req.setAttribute("gname", gname);
		}

		chain.doFilter(req1, resp1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("加载");
	}

}
