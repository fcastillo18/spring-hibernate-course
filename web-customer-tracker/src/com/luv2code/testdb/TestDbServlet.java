package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:sqlserver://172.27.17.156:1433;DatabaseName=Winplexdb";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String userName = "winplex";
        String password = "codetel";
        
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database");
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			System.out.println("Succesful!");
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
