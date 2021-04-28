package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.ultils.SessionUtil;
import com.laptrinhjavaweb.ultils.formUltils;


@WebServlet(urlPatterns = {"/trang-chu","/login","/logout"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;

	ResourceBundle resource = ResourceBundle.getBundle("message");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")){
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (alert != null && message != null) {
				request.setAttribute("message",resource.getString(message));
				request.setAttribute("alert",alert);
			}
			RequestDispatcher rs = request.getRequestDispatcher("/views/login.jsp");
			rs.forward(request, response);
		}else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request,"USER");
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}else  {
			request.setAttribute("categorys", categoryService.findAll());
			RequestDispatcher rd =  request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")){
			User model = formUltils.toModel(User.class, request);
			model = userService.findNByUserNameRole(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(request,"USER",model);
					if (model.getRole().getCode().equals(SystemConstant.USER)) {

					response.sendRedirect(request.getContextPath() +"/trang-chu");
				} else if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					response.sendRedirect(request.getContextPath() +"/admin");
				}

			}else {
				response.sendRedirect(request.getContextPath() +"/login?action=login&message=username_password_invalid&alert=danger");
			}

		}
	}

}
