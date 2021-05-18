package com.laptrinhjavaweb.controller.Api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.Category;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.ultils.HttpUltis;

/**
 * Servlet implementation class CategoryApi
 */
@WebServlet("/api-admin-category")
public class CategoryApi extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ICategoryService CategoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUltis.of(request.getReader()).toModel(Category.class);
        CategoryService.save(category);
        mapper.writeValue(response.getOutputStream(), category.getId());
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUltis.of(request.getReader()).toModel(Category.class);
        CategoryService.update(category);
        mapper.writeValue(response.getOutputStream(), category.getId());
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Category category = HttpUltis.of(request.getReader()).toModel(Category.class);
        CategoryService.delete(category.getIds());
        mapper.writeValue(response.getOutputStream(), "{}");
    }

}
