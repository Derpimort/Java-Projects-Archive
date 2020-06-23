package com.javaproject.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdminMenuForward {

	public AdminMenuForward(String ID) {
		String dbName="libraryDB";
		String driverName="com.mysql.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/";
					
					try{
						Class.forName(driverName);
						Connection con=DriverManager.getConnection(url+dbName, "root", "root");
						java.sql.PreparedStatement st1=con.prepareStatement("Select * from librarian where lId=?");
						st1.setString(1, ID);
						ResultSet rs1=st1.executeQuery();
						ArrayList result=new ArrayList();
						
					    if(rs1.next()) {
					    	result.add(rs1.getString(1));
						    String name=result.get(0).toString();
							AdminMenu amd=new AdminMenu(name);
						}
						else {
							JOptionPane.showMessageDialog(null,"invalid username or password");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
	}

}
