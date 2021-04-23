package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.News;
import com.laptrinhjavaweb.service.INewsService;


@WebServlet(urlPatterns ="/admin-new")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private INewsService newsService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News news = new News();
		
		String pageStr =request.getParameter("page");
		String maxPageItemStr =request.getParameter("maxPageItem");
		if (pageStr != null) {
			news.setPage(Integer.parseInt(pageStr));
		}else {
			news.setPage(1);
		}
		if (maxPageItemStr != null) {
			news.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		}
		Integer offset = (news.getPage()-1) * news.getMaxPageItem();
		news.setList(newsService.findAllNews(offset, news.getMaxPageItem()));
		news.setTotalItem(newsService.getTotalItem());
		news.setTotalPage((int)Math.ceil((double) news.getTotalItem()/ news .getMaxPageItem()));
		request.setAttribute(SystemConstant.MODLE, news);
		RequestDispatcher rd =  request.getRequestDispatcher("/views/admin/news/list.jsp");
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
