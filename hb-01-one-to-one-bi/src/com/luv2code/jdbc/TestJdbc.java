package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:sqlserver://172.27.17.156:1433;DatabaseName=Winplexdb";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String userName = "winplex";
        String password = "codetel";
        
		try {
			System.out.println("Connection to database");
			
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			System.out.println("Succesful!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
