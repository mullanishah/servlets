/**
 * 
 */
package com.sha.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public void getAllStudents() {
		
	}
}
