package com.sha.servlets.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllStudentsServlet
 */
@WebServlet("/students")
public class AllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("reached all-students servlet");
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter();){
			
		} catch (Exception e) {
			if(e instanceof ServletException)
				throw new ServletException("Error in doGet() of " + getClass().getName(), e);
			e.printStackTrace();
		}
	}

}
