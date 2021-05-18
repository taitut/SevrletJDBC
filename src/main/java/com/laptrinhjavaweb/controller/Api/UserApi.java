package com.laptrinhjavaweb.controller.Api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.ultils.HttpUltis;


@WebServlet("/api-admin-user")
public class UserApi extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    private IUserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        User user = HttpUltis.of(request.getReader()).toModel(User.class);
        userService.save(user);
        mapper.writeValue(response.getOutputStream(), user);
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        User user = HttpUltis.of(request.getReader()).toModel(User.class);
        userService.update(user);
        mapper.writeValue(response.getOutputStream(), user);
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        User user = HttpUltis.of(request.getReader()).toModel(User.class);
        userService.delete(user.getIds());
        mapper.writeValue(response.getOutputStream(), user);
    }

}
