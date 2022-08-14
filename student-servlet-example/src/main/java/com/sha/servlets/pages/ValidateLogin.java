package com.sha.servlets.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet({ "/ValidateLogin", "/validate-login" })
public class ValidateLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	System.out.println("reached validate-login servlet");
    	response.setContentType("text/html");
    	try{
    		PrintWriter out = response.getWriter();
    	} catch (Exception e) {
			
		}
	}

}
