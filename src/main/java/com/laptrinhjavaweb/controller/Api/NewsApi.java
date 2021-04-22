package com.laptrinhjavaweb.controller.Api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.News;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.ultils.HttpUltis;


@WebServlet("/api-admin-new")
public class NewsApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		News news = HttpUltis.of(request.getReader()).toModel(News.class);
		newsService.save(news);
		mapper.writeValue(response.getOutputStream(), news);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		News UpdateNews = HttpUltis.of(request.getReader()).toModel(News.class);
		newsService.update(UpdateNews);
		mapper.writeValue(response.getOutputStream(),UpdateNews );

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		News UpdateNews = HttpUltis.of(request.getReader()).toModel(News.class);
		newsService.delete(UpdateNews.getIds());
		mapper.writeValue(response.getOutputStream(),"{}" );
	}


}
