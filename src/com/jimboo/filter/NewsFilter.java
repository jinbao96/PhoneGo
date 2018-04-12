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

import com.jimboo.entity.News;
import com.jimboo.service.NewsService;
import com.jimboo.service.impl.NewsServiceImpl;

@WebFilter(urlPatterns= {"/index.jsp","/newsinfo"})
public class NewsFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chian)
			throws IOException, ServletException {
		HttpServletRequest req1=(HttpServletRequest) req;
		HttpServletResponse resp1=(HttpServletResponse) resp;
		//ÐÂÎÅ
		NewsService ns=new NewsServiceImpl();
		List<News> nlist=ns.queryAllNews();
		req.setAttribute("nlist", nlist);
		System.out.println(nlist);
		chian.doFilter(req1, resp1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
