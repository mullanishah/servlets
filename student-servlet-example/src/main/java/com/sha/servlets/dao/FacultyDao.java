package com.sha.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sha.servlets.dto.Faculty;
import com.sha.servlets.utils.DatabaseUtils;
import com.sha.servlets.utils.StudentConstants;

public class FacultyDao {

	private Connection connection;
	private PreparedStatement pstAdminLogin;

	public FacultyDao() throws ClassNotFoundException, SQLException {
		try {
			connection = DatabaseUtils.getConnection();
			pstAdminLogin = connection.prepareStatement(StudentConstants.queryAdminLogin);
		} catch (Exception e) {
			if(e instanceof ClassNotFoundException)
				throw new ClassNotFoundException("Error in connecting to db: ", e);
			if(e instanceof SQLException)
				throw new SQLException("Error in connecting to db: ", e);
			e.printStackTrace();
		}
	}

	public void cleanUp() throws Exception {
		if(pstAdminLogin != null)
			pstAdminLogin.close();
		if(connection != null)
			connection.close();
	}

	/*
	 * both email and username are identical
	 */
	public Faculty validateAdminCredentials(String username, String password) throws Exception {

		Faculty faculty = null;
		pstAdminLogin.setString(1, username);
		pstAdminLogin.setString(2, password);
		try(ResultSet rst = pstAdminLogin.executeQuery();){
			if(rst.next()) {
				faculty = new Faculty(rst.getString("name"), 
						rst.getString("username"), 
						rst.getString("password"), 
						rst.getString("email"), 
						rst.getString(6), 
						rst.getBoolean(7));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return faculty;	
	}
}
