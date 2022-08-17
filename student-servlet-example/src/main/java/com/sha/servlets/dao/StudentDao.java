/**
 * 
 */
package com.sha.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sha.servlets.dto.Student;
import com.sha.servlets.utils.DatabaseUtils;
import com.sha.servlets.utils.StudentConstants;

/**
 * @author Shahrukh
 *
 */
public class StudentDao {
	
	private Connection connection;
	private PreparedStatement pstAllStudents;
	
	public StudentDao() throws ClassNotFoundException, SQLException {
		connection = DatabaseUtils.getConnection();
		pstAllStudents = connection.prepareStatement(StudentConstants.queryGetAllStudents);
	}
	
	public void cleanUp() throws Exception {
		if(null != pstAllStudents)	pstAllStudents.close();
		if(null != connection)	connection.close();
	}
	
	//Get all students
	public List<Student> getAllStudents() throws SQLException {
		
		List<Student> students = new ArrayList<Student>(10);
		ResultSet rst = pstAllStudents.executeQuery();
		while(rst.next() != false) {
			Student student = new Student();
			student.setRollNum(rst.getString(10));
			student.setFullName(rst.getString("name"));
			student.setCourse(rst.getString("course"));
			student.setSemester(rst.getString("semester"));
			student.setAddress(rst.getString("address")); 
			student.setBdate(rst.getDate("bday"));
			student.setContactNum(rst.getInt("contact"));
			student.setEmergencyContact(rst.getLong("emergency"));  
			student.setRegistrationNum(rst.getString(9));
			students.add(student);
		}
		return students;
	}
}
