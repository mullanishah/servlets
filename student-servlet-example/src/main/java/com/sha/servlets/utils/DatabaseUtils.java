package com.sha.servlets.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

	private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost/students_db";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName(DB_DRIVER);
		System.out.println("db drivers loaded");
		Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		System.out.println("Connection made successfully to db");
		return connection;
	}
}
