
package com.karthik.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/app/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("Filter called for URI: " + req.getRequestURI());
		
		if (!req.getRequestURI().contains("/login") && (req.getSession().getAttribute("user") == null)) {
			res.sendRedirect(req.getServletContext().getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

}
