package com.javaproject.librarymanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class registerNew {

	static private JFrame frame;
	private static JTextField textFieldname;
	private static JLabel lblEmailid;
	private static JTextField textFieldemail;
	private static JLabel lblContactno;
	private static JTextField textFieldContactno;
	private static JLabel lblAge;
	private static JTextField textFieldUsername;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	private static JList list;
	private static JButton btnSubmit;
	private static JSpinner spinner;
	private static JRadioButton rdbtnF;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public registerNew() {
		initialize();
	}

	public static void initialize() {
		frame=new JFrame();
		frame.setSize(466, 500);
		frame.setTitle("Registration form");
		frame.setBounds(100, 100, 469, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(40, 35, 83, 14);
		frame.getContentPane().add(lblName);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(133, 32, 301, 20);
		frame.getContentPane().add(textFieldname);
		textFieldname.setColumns(10);
		
		lblEmailid = new JLabel("Email-id :");
		lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmailid.setBounds(40, 75, 83, 14);
		frame.getContentPane().add(lblEmailid);
		
		textFieldemail = new JTextField();
		textFieldemail.setBounds(133, 73, 301, 20);
		frame.getContentPane().add(textFieldemail);
		textFieldemail.setColumns(10);
		
		lblContactno = new JLabel("Contact no. :");
		lblContactno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContactno.setBounds(40, 115, 83, 14);
		frame.getContentPane().add(lblContactno);
		
		textFieldContactno = new JTextField();
		textFieldContactno.setBounds(133, 113, 301, 20);
		frame.getContentPane().add(textFieldContactno);
		textFieldContactno.setColumns(10);
		
		lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAge.setBounds(40, 155, 83, 14);
		frame.getContentPane().add(lblAge);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(133, 152, 49, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(40, 195, 83, 14);
		frame.getContentPane().add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(133, 193, 301, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(40, 235, 83, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Re-enter");
		lblNewLabel.setBounds(40, 275, 83, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword_1 = new JLabel("Password :");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword_1.setBounds(40, 295, 83, 14);
		frame.getContentPane().add(lblPassword_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 233, 301, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 293, 301, 20);
		frame.getContentPane().add(passwordField_1);
		
		list = new JList();
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"M", "F"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(332, 144, 20, 31);
		frame.getContentPane().add(list);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(textFieldUsername.getText().equals("") || textFieldemail.getText().equals("") || textFieldContactno.getText().equals("") ||(int) spinner.getValue()==0||list.isSelectionEmpty()||passwordField.getPassword().equals("") ||passwordField_1.getPassword().equals(""))
				{
					JOptionPane.showMessageDialog(
							 null,"Please enter all values",
							 "Attention",
							 JOptionPane.ERROR_MESSAGE);
				}
				else {
				if(isAlpha(textFieldname.getText()))
				{
					if(checkduplicate(textFieldUsername.getText()))
					{
						textFieldname.getText();
						textFieldemail.getText();
						textFieldContactno.getText();
						spinner.getValue();
						passwordField.getPassword();
						passwordField_1.getPassword();
						textFieldUsername.getText();
						
						if(!passwordField_1.getText().equals(passwordField.getText())) {
							JOptionPane.showMessageDialog(null,"password does not match");
						}
						if(passwordField_1.getText().equals(passwordField.getText())) {
							
							String dbName="libraryDB";
							String driverName="com.mysql.jdbc.Driver";
							
										String url="jdbc:mysql://localhost:3306/";
										
										try{String a[]= {"M","F"};
											Class.forName(driverName);
											Connection con=DriverManager.getConnection(url+dbName, "root", "root");
											
											java.sql.PreparedStatement st=con.prepareStatement("insert into custdetails values(?,?,?,?,?,?)");
											
											java.sql.PreparedStatement st1=con.prepareStatement("insert into custlogin values(?,?)");
											st.setString(1, textFieldUsername.getText());
											st.setString(2, textFieldname.getText());
											st.setString(3,textFieldemail.getText());
											st.setString(4,textFieldContactno.getText());
											st.setInt(5,(int) spinner.getValue());
											st.setString(6,a[list.getSelectedIndex()]);
											st1.setString(1,textFieldUsername.getText());
											st1.setString(2,passwordField.getText());
											java.sql.PreparedStatement st3=con.prepareStatement("Select * from custlogin where userid=?");
											st3.setString(1, textFieldUsername.getText());
											ResultSet rs3=st3.executeQuery();
												if(rs3.next()) {
													JOptionPane.showMessageDialog(null,"username already exists");
												}else{
													int rs=st.executeUpdate();
													int rs1=st1.executeUpdate();
													frame.setEnabled(false);
													JOptionPane.showMessageDialog(null,"Registration successful");
													frame.setVisible(false);
												}
												
												
									}
										catch(Exception e)
										{
											e.printStackTrace();
										}
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"User Id already exists");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Name");
				}
				}
			}
		});
			
		btnSubmit.setBounds(182, 379, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(280, 156, 46, 14);
		frame.getContentPane().add(lblGender);
		/*ButtonGroup btng=new ButtonGroup();
		String Gender = btng.getSelection().getActionCommand();
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(358, 140, 33, 23);
		frame.getContentPane().add(rdbtnM);
		rdbtnM.setActionCommand("M");
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(358, 163, 33, 23);
		frame.getContentPane().add(rdbtnF);
		rdbtnF.setActionCommand("F");*/
		frame.transferFocus();
	}

private static boolean checkduplicate(String text) {
	String dbName="libraryDB";
	String driverName="com.mysql.jdbc.Driver";
	
				String url="jdbc:mysql://localhost:3306/";
				try {
					Class.forName(driverName);
					Connection con=DriverManager.getConnection(url+dbName, "root", "root");
					
					java.sql.PreparedStatement st=con.prepareStatement("select * from custdetails where userid=?");
					st.setString(1, text);
					ResultSet rs=st.executeQuery();
					if(rs.next())
						return false;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return true;
			}

public static boolean isAlpha(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c)&&c!=' ') {
        	
            return false;
        }
    }

    return true;
}
}
