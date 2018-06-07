package com.karthik.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karthik.model.User;
import com.karthik.service.LoginService;
import com.karthik.service.impl.LoginServiceImpl;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5870276453152924286L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginServiceImpl();
		
		boolean validUser = loginService.authenticate(username, password);
		
		if (validUser) {
			User user = loginService.getUserDetails(username);
			request.setAttribute("user", user);
			request.getSession().setAttribute("user", user);
			request.setAttribute("nextPage", "input.jsp");
			request.setAttribute("delay", 2);
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
	

}
