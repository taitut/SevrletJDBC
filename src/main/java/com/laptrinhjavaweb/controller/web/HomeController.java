package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;


@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;
	@Inject
	private INewsService newsService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String title = "bai_10";
////		String content = "hahahahaha";
//		String a = "id";
//		Long b = 1L;
//		Long categoryId = 6L;
//		News news = new News();
////		news.setTitle(newsService.findNBy(a,b).getString("title"));
////		news.setCatgoryId("");
////		news.setContent(content);
//		List<News> n = new ArrayList<>();
//		n= newsService.findNBy(a,b);
		 
		
		//request.setAttribute("test",newsService.findNBy(a,b));
		
//		request.setAttribute("find",newsService.findByCategoryId(categoryId));
//		request.setAttribute("news",newsService.findAllNews(0,9));
		request.setAttribute("categorys", categoryService.findAll());
		
		RequestDispatcher rd =  request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
