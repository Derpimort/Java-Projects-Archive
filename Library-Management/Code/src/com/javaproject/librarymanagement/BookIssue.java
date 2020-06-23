package com.javaproject.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class BookIssue {
	private static JFrame frame;
	private JPasswordField passwordField;
	public static void main(String[] args) {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public BookIssue(int biD,String userid) {
		/*frame=new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblpass = new JLabel("Please Re-enter your password");
		lblpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblpass.setBounds(0, 11, 261, 14);
		frame.getContentPane().add(lblpass);
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 39, 241, 20);
		frame.getContentPane().add(passwordField);*/
		
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
								JOptionPane.showMessageDialog(null,"Please return the book with id: "+rs.getString(2)+" before issuing a new book");
							}
							else {
								Class.forName(driverName);
								Connection con1=DriverManager.getConnection(url+dbName, "root", "root");
								java.sql.PreparedStatement st1=con1.prepareStatement("Select quantity from book where bookId=?");
								st1.setInt(1, biD);
								ResultSet rs1=st1.executeQuery();
								 if(rs1.next())
								  {
									 String result=rs1.getString(1);
										if(Integer.parseInt(result)>0)
										{
											BookService bs=new BookService();
											if(bs.issueBook(biD, userid)==1)
											{
												JOptionPane.showMessageDialog(null,"Successfully issued book with ID: "+biD);
											}
											else
											{
												JOptionPane.showMessageDialog(null,"Unable to issue book, contact librarian");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null,"We're sorry, this book is currently not available");
										}
								  }
								  else
								  {
									  JOptionPane.showMessageDialog(null,"Invalid Id");
								  }
								
								
							}
							
				}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
	}
}
