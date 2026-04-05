package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		      String sa=req.getParameter("roll");
		      
		      //========================================================================
		      try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

				Connection connection;
				String s = "";
				try {
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/company", "root", "root");
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM departments where Dept_ID="+sa);

					while (rs.next()) {
						s=rs.getString("Dept_Name");
						System.out.println("hey "+s);
					}
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		      
		      //========================================================================

		      
		       req.setAttribute("key" ,"hello"+s);
		       req.getRequestDispatcher("index.jsp").forward(req, resp);
		    }
     }
	
		    
