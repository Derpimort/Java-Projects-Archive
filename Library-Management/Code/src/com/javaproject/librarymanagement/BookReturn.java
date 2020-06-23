package com.javaproject.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class BookReturn {

	public BookReturn(String userid) {
		String dbName="libraryDB";
		String driverName="com.mysql.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/";
					
					try{
						Class.forName(driverName);
						Connection con=DriverManager.getConnection(url+dbName, "root", "root");
						java.sql.PreparedStatement st=con.prepareStatement("Select * from issuedb where userid=?");
						st.setString(1, userid);
						ResultSet rs=st.executeQuery();
						
							if(rs.next()) {
								String book=rs.getString(2);
								Connection con1=DriverManager.getConnection(url+dbName, "root", "root");
								java.sql.PreparedStatement st1=con1.prepareStatement("update book set quantity=quantity+1 where bookId=?");
								int bookid=Integer.parseInt(book);
								st1.setInt(1, bookid);
								java.sql.PreparedStatement st2=con1.prepareStatement("insert into bookrecords values(?,?,?,?)");
								 LocalDate localDate = LocalDate.now();
							        String date=DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
								st2.setString(1, book);
								st2.setString(2, userid);
								st2.setString(3, rs.getString(3));
								st2.setString(4, date);
								java.sql.PreparedStatement st3=con1.prepareStatement("delete from issuedb where userid=?");
								st3.setString(1, userid);
								int result=st1.executeUpdate()+st2.executeUpdate()+st3.executeUpdate();
								if(result>2)
								{
									JOptionPane.showMessageDialog(null,"Please return the book with id: "+book+" and get the fine receipt(if any) from the admin");
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Error in updating records, contact admin.");
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"Error, no records found.");
							}
							
				}
					catch(Exception e)
					{
						e.printStackTrace();
					}
	}

}
