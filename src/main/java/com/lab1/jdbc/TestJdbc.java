package com.lab1.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";

		try {

			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("Connection Success!!!");


		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
