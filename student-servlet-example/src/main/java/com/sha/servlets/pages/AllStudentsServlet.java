package com.sha.servlets.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.sha.servlets.dao.StudentDao;
import com.sha.servlets.dto.Faculty;
import com.sha.servlets.dto.Student;

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
		try(PrintWriter out = response.getWriter();){
			Faculty validatedAdmin = (Faculty) request.getSession().getAttribute("validatedAdmin");
			out.print("Welcome " + validatedAdmin.getName() + ", " + validatedAdmin + "<br/><br/>");
			
			out.print("Search Student: " + "<input type='text' name='search' size='50' placeholder='Enter student name to search'>" + "<br/><br/>");
			
			StudentDao studentDao = new StudentDao();
			List<Student> studentList = studentDao.getAllStudents();
			out.print("<table style='background-color: cyan; margin: auto;'>");
			out.print("<tr>"
					+ "<th>Registration Number</th><th>Student Name</th><th>Birth Date</th><th>Course Details</th>"
					+ "<th>Address</th><th>Contact Number</th>"
					+ "</tr>");
			for(Student student : studentList) {
				out.print("<tr>"
						+ "<td>" + student.getRegistrationNum()+"</td> " + "<td>" + student.getFullName()+"</td> "
						+ "<td>" + student.getBdate() +"</td> " + "<td>" + student.getCourse() +", "+ student.getSemester() +"</td>"
						+ "<td>" + student.getAddress() +"</td>"+ "<td>" + student.getContactNum() +"</td>"
						+ "</tr>");
			}
			out.print("</table>");
		} catch (Exception e) {
			if(e instanceof ServletException)
				throw new ServletException("Error in doGet() of " + getClass().getName(), e);
			e.printStackTrace();
		}
	}

}
