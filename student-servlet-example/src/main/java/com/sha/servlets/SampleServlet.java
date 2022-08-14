package com.sha.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static long count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("reached sampleServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>"
				+ "<h4>Welcome back to Servlets"
				+ "</body>"
				+ "</br></br>");
		out.append("Served at: " + request.getContextPath() + "</br>");
		out.print("Counter: " + count++);
		response.getWriter().append("</br>" + new Date().toString());
		out.print("</html>");
		
	}

}
