package com.laptrinhjavaweb.controller.Api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.Role;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.ultils.HttpUltis;

@WebServlet("/api-admin-role")
public class RoleApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IRoleService roleService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Role role = HttpUltis.of(request.getReader()).toModel(Role.class);
		roleService.save(role);
		mapper.writeValue(response.getOutputStream(), role);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Role role = HttpUltis.of(request.getReader()).toModel(Role.class);
		roleService.update(role);
		mapper.writeValue(response.getOutputStream(), role);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Role role = HttpUltis.of(request.getReader()).toModel(Role.class);
		roleService.delete(role.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
