package com.hexaware.OnlineExamSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexamsystem","root","root1234");
		return con;
	}
}
