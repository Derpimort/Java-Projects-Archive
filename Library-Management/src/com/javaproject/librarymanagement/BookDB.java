package com.javaproject.librarymanagement;

import java.sql.*;

public class BookDB 
{
  public static Connection getConnection()
  throws Exception
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  
	Connection  con = DriverManager.getConnection(
			  "jdbc:mysql://localhost:3306/libraryDB",
			  "root",
			  "root");
	return con;
  }

}
