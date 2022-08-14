package com.sha.servlets.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sha.servlets.dao.FacultyDao;
import com.sha.servlets.dto.Faculty;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet({ "/ValidateLogin", "/validate-login" })
public class ValidateLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	System.out.println("reached validate-login servlet");
    	response.setContentType("text/html");
    	try{
    		PrintWriter out = response.getWriter();
    		
    		//read username, pwd from request object
    		String email = request.getParameter("email");
    		String password = request.getParameter("password");
    		
    		//validate the user
    		Faculty faculty = null;
    		FacultyDao facultyDao = new FacultyDao();
    		
    		faculty = facultyDao.validateAdminCredentials(email, password);
    		boolean hasAdminAuthority = faculty.hasAdminRole();
    		
    		if(hasAdminAuthority) {
    			//setup empty lists, nd maps
    			HttpSession session = request.getSession();
    			session.setAttribute("validatedAdmin", faculty);
    			//redirect to all students page
    			response.sendRedirect("students");
    		} else {
    			//else invalid user
    			out.print("Invalid login details. ");
    			out.print("Please <a href='login.html'>retry login</a>");
    		}
    	} catch (Exception e) {
			if(e instanceof ServletException)
				throw new ServletException("Error in doPost() of " + getClass().getName(), e);
			e.printStackTrace();
		}
	}

}
