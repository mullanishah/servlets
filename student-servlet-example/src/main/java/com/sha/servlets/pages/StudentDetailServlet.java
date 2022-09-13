package com.sha.servlets.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sha.servlets.dao.StudentDao;
import com.sha.servlets.dto.Faculty;
import com.sha.servlets.dto.Student;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/student-details")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reached student details servlet");
		
		String selectedRegNum = request.getParameter("selectedRegNum");
		
		StudentDao studentDao;
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter();) {
			out.print("<form method='post' action='student-details'>");

			Faculty validatedAdmin = (Faculty) request.getSession().getAttribute("validatedAdmin");
			out.print("Welcome " + validatedAdmin.getName() + ", " + validatedAdmin + "<br/><br/>");
			
			studentDao = new StudentDao();
			Student student = studentDao.getStudentDetails(selectedRegNum);
			System.out.println(student);
			
			out.print("<table style='background-color: cyan; margin: auto;'>");
			out.print("<tr>"
					+ "<th>Registration Number</th><th>Student Name</th><th>Birth Date</th><th>Course Details</th>"
					+ "<th>Address</th><th>Contact Number</th>"
					+ "</tr>");
			out.print("<tr>"
					+ "<td><label for='" +student.getRegistrationNum() + "'>" + student.getRegistrationNum() + "</label></td> " + "<td>" + student.getFullName()+"</td> "
					+ "<td>" + student.getBdate() +"</td> " + "<td>" + student.getCourse() +", "+ student.getSemester() +"</td>"
					+ "<td>" + student.getAddress() +"</td>"+ "<td>" + student.getContactNum() +"</td>"
					+ "</tr>");
			out.print("<tr><td colspan='5'><input type='submit' value='EDIT' size='35'></td>"
					+ "<td colspan='5'><input type='submit' value='DELETE' size='35'></td>"
					+ "</tr>");
			out.print("</table></form>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
