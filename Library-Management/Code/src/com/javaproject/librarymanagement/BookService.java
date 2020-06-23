package com.javaproject.librarymanagement;

import com.javaproject.librarymanagement.BookBean;
import com.javaproject.librarymanagement.BookDAO;

import java.util.ArrayList;

public class BookService 
{
 public int addBookService(int bookId,
		                   String title,
		                   float price,String author,int quantity)
 {
	 //implement the business logic

	 BookDAO bookDAO = new BookDAO();
	 BookBean bookBean = new BookBean();
	 //wrap up all the four field values into bean
	 
	 bookBean.setBookId(bookId);
	 bookBean.setTitle(title);
	 bookBean.setPrice(price);
	 bookBean.setAuthor(author);
	 bookBean.setQuantity(quantity);
	 int updateResult = 0;
	 try
	 {
		 updateResult = bookDAO.addBook(bookBean);
		 return updateResult;
	 }
	 catch(Exception ex)
	 {
		 System.out.println(ex.toString());
		 return 0;
	 }
 }
 
  public ArrayList getBookDetailsById(int bookId)
  throws Exception
  {
	  BookDAO bookDAO = new BookDAO();
	 ArrayList result =  
		 bookDAO.getBookDetailsById(bookId);
	 
	 return result;
	 
  }
  public int issueBook(int bookId,String username)
  {
	  BookDAO bookDAO=new BookDAO();
	  int result=bookDAO.issueBook(bookId,username);
	  return result;
  }
}
