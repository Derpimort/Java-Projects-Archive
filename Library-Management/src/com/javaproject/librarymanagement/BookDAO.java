package com.javaproject.librarymanagement;
import com.javaproject.librarymanagement.BookBean;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class BookDAO 
{
	public ArrayList getBookDetailsById(int bookId)
	throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = BookDB.getConnection();
		
    String sel_str ="Select title,price,author,quantity from book where bookid=?";
		  
		  
		  pstmt = con.prepareStatement(sel_str);
		  pstmt.setInt(1,bookId);
		  rs = pstmt.executeQuery();
		  
		  ArrayList result = new ArrayList();
		  if(rs.next())
		  {
			  result.add(rs.getString(1));
			  result.add(rs.getString(2));
			  result.add(rs.getString(3));
			  result.add(rs.getString(4));
		  }
		  else
		  {
			  result.add("Invalid Id");
		  }
		  return result;
		
	}
	
  public int addBook(BookBean obj)
  {
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  try
	  {
		  /* Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	         "jdbc:mysql://localhost:3309/accdb","root","root"); 
	     */
		  con=BookDB.getConnection(); 
		  
		  String ins_str = 
			  "insert into book values(?,?,?,?,?)";
		  
		  pstmt = con.prepareStatement(ins_str);
		  
		  pstmt.setInt(1,obj.getBookId());
		  pstmt.setString(2,obj.getTitle());
		  pstmt.setFloat(3,obj.getPrice());
		  pstmt.setString(4, obj.getAuthor());
		  pstmt.setInt(5, obj.getQuantity());
		  
		  
		  int updateCount = pstmt.executeUpdate();
		  
		  con.close();
		  
		  return updateCount;
		  
		  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex.toString());
		  return 0;
	  }
	  
  }
  public int issueBook(int bookId,String username)
  {
	  Connection con = null;
	  PreparedStatement pstmt = null,pstmt1=null;
	  
	  try
	  {
		  /* Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	         "jdbc:mysql://localhost:3309/accdb","root","root"); 
	     */
		  LocalDate localDate = LocalDate.now();
	        String date=DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
		  con=BookDB.getConnection(); 
		  String userup=("insert into issuedb values(\'"+username+"\',"+Integer.toString(bookId)+",DATE \'"+date+"\');");
		  String ins_str = 
			  "update book set quantity=quantity-1 where bookId=?";
		  
		  pstmt = con.prepareStatement(ins_str);
		  pstmt1=con.prepareStatement(userup);
		  pstmt.setInt(1,bookId);
		  int updatecount=0;
		  if(pstmt.executeUpdate()==1&&pstmt1.executeUpdate()==1)
		  {
			  updatecount=1;
		  }
		  con.close();  
		  return updatecount;  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex.toString());
		  return 0;
	  }
	  
  }
}
