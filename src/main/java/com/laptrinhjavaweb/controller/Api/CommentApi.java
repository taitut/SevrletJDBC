package com.laptrinhjavaweb.controller.Api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.Comment;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.ultils.HttpUltis;


@WebServlet("/api-admin-comment")
public class CommentApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICommentService commentS;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Comment comment = HttpUltis.of(request.getReader()).toModel(Comment.class);
		commentS.save(comment);
		mapper.writeValue(response.getOutputStream(), comment);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Comment comment = HttpUltis.of(request.getReader()).toModel(Comment.class);
		commentS.update(comment);
		mapper.writeValue(response.getOutputStream(), comment);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Comment comment = HttpUltis.of(request.getReader()).toModel(Comment.class);
		commentS.delete(comment.getIds());
		mapper.writeValue(response.getOutputStream(), comment);
	}

}
