package com.sha.servlets.utils;

public interface StudentConstants {

	public static String queryAdminLogin = "SELECT * FROM faculty where username=? and password=?";
	
	public static String queryGetAllStudents = "select * from student";
	
	public static String querySearchStudent = "select * from student where name like ";
}
