package com.karthik.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ArithmeticServlet
 */
@WebServlet(urlPatterns="/ArithmeticServlet", initParams = {@WebInitParam(name="operand1", value="100"),
														   @WebInitParam(name="operand2", value="50")})
public class ArithmeticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ArithmeticServlet() {
		System.out.println("Initialized Arithmetic Servlet");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init method called");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/ArithmeticInput.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		Double out = 0.0, operand1=0.0, operand2=0.0;
		String error = "", additionalInfo="";
		
		if (request.getParameter("operand1").isEmpty() || request.getParameter("operand2").isEmpty()) {
			operand1 = Double.valueOf(getServletConfig().getInitParameter("operand1"));
			operand2 = Double.valueOf(getServletConfig().getInitParameter("operand2"));
			additionalInfo ="Received invalid operand values, Using default values 100 and 50";
		}else {
			operand1 = Double.valueOf(request.getParameter("operand1"));
			operand2 = Double.valueOf(request.getParameter("operand2"));
		}
		
		if("ADD".equalsIgnoreCase(request.getParameter("operation"))) {
			out = operand1 + operand2;
		}else if ("SUB".equalsIgnoreCase(request.getParameter("operation"))) {
			out = operand1 - operand2;
		}else if ("MUL".equalsIgnoreCase(request.getParameter("operation"))) {
			out = operand1 * operand2;
		}else if ("DIV".equalsIgnoreCase(request.getParameter("operation"))) {
			if(operand2==0.0)
				error = "Divide by zero error";
			else
				out = operand1/operand2;
		}else {
			error = "Invalid Operation";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("result", out);
		session.setAttribute("error", error);
		session.setAttribute("additionalInfo", additionalInfo);
		
		request.getRequestDispatcher("/ArithmeticResult.jsp").forward(request, response);
		
	}

}
