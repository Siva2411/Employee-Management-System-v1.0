package com.shankar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static String DATABASE_URL = "jdbc:mysql://localhost:3306/employeedb";
	public static String USERNAME = "root";
	public static String PASSWORD = "root";
	public static Connection con = null;
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException e) {
			System.err.println("Driver is not loaded");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		} 
		return null;
	}
}

