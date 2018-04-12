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
import javax.servlet.http.HttpSession;

import com.jimboo.entity.Category;
import com.jimboo.service.CategoryService;
import com.jimboo.service.impl.CategoryServiceImpl;

@WebFilter(urlPatterns= {"/index.jsp"})
public class CategoryFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req1=(HttpServletRequest) req;
		//查询所有类型
		HttpSession session = req1.getSession();
		if(session.getAttribute("catelist")==null) {
			System.out.println(session.getAttribute("catelist"));
			CategoryService cs=new CategoryServiceImpl();
			List<Category> clist=cs.queryAllCategory();
			session.setAttribute("catelist", clist);
			System.out.println("clist:"+clist);
		}
		
		chain.doFilter(req1, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
