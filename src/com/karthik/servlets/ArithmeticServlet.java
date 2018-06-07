package com.karthik.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.karthik.model.ArithmeticResult;

/**
 * Servlet implementation class ArithmeticServlet
 */
@WebServlet(urlPatterns="/app/ArithmeticServlet", initParams = {@WebInitParam(name="operand1", value="100"),
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
		request.getRequestDispatcher("/input.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		Double out = 0.0, operand1 = 0.0, operand2 = 0.0;
		String error = "", additionalInfo = "";
		
		HttpSession session = request.getSession();
		ArithmeticResult result = new ArithmeticResult();
		
		if (request.getParameter("operand1").isEmpty() || request.getParameter("operand2").isEmpty()) {
			operand1 = Double.valueOf(getServletConfig().getInitParameter("operand1"));
			operand2 = Double.valueOf(getServletConfig().getInitParameter("operand2"));
			additionalInfo ="Received invalid operand values, Using default values 100 and 50";
			result.setAdditionalInfo(additionalInfo);
		}else {
			try {
				operand1 = Double.valueOf(request.getParameter("operand1"));
				operand2 = Double.valueOf(request.getParameter("operand2"));
			} catch (NumberFormatException ex) {
				System.err.println("Exception occurred: " + ex.getMessage());
				error = "Invalid operand(s) specified !!";
				result.setError(error);
				request.getSession().setAttribute("result", result);
				request.getRequestDispatcher("/result.jsp").forward(request, response);
				return;
			}
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
			session.setAttribute("error", error);
		}
		
		result.setResult(out);
		
		request.getSession().setAttribute("result", result);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

}
