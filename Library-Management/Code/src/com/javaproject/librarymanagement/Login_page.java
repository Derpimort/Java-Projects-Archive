package com.javaproject.librarymanagement;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import java.awt.Window.Type;


public class Login_page extends JFrame{
	private JPanel frame;
	private JTextField userid;
	private JPasswordField password;

	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_page() {
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\12-512.png"));
			setTitle("Login page");
			setVisible(true);
			initialize();
	}

public void initialize() {

	
	frame = new JPanel();
	getContentPane().setLayout(null);
	setBounds(100, 100, 549, 353);
	setLocationRelativeTo(null);
	frame.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	JLabel loginlabel = new JLabel("User ID:");
	loginlabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	loginlabel.setForeground(Color.BLACK);
	loginlabel.setBounds(361, 103, 76, 14);
	getContentPane().add(loginlabel);
	
	JLabel passwordlabel = new JLabel("Password:");
	passwordlabel.setBounds(361, 128, 76, 14);
	getContentPane().add(passwordlabel);
	
	userid = new JTextField();
	userid.setBounds(434, 100, 89, 20);
	getContentPane().add(userid);
	userid.setColumns(10);
	
	JButton cust_login = new JButton("User Login");
	cust_login.setBorderPainted(false);
	cust_login.setForeground(Color.BLACK);
	cust_login.setBackground(Color.LIGHT_GRAY);
	cust_login.setBounds(361, 175, 162, 23);
	cust_login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		String dbName="libraryDB";
String driverName="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/";
			try{
				Class.forName(driverName);
				Connection con=DriverManager.getConnection(url+dbName, "root", "root");
				java.sql.PreparedStatement st=con.prepareStatement("Select * from custlogin where userid=? and password=?");
				st.setString(1, userid.getText());
				st.setString(2,String.valueOf(password.getText()));
				ResultSet rs=st.executeQuery();
					if(rs.next()) {
						dispose();
						CustomerMenu cs=new CustomerMenu(userid.getText());
					}
					else {
						JOptionPane.showMessageDialog(null,"invalid username or password");
					}
					
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}}
	);
	/*cust_login.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae)
	{
		try {
			if()
		String customerusername=cust_userid.getText();
		String customerpassword=cust_password.getText();
			loginsuccess success=new loginsuccess();
			success.setVisible(true);
			Login_page window = new Login_page();
			window.frame.setVisible(false);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	});*/
	getContentPane().add(cust_login);
	
	password = new JPasswordField();
	password.setBounds(434, 128, 89, 20);
	getContentPane().add(password);
	
	
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(0, 255, 127));
	panel.setBounds(0, 0, 351, 326);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\icon-books.gif"));
	label.setBounds(10, 11, 315, 238);
	panel.add(label);
	
	JLabel lblWelcomeToApsit = new JLabel("Welcome to APSIT Library");
	lblWelcomeToApsit.setHorizontalAlignment(SwingConstants.CENTER);
	lblWelcomeToApsit.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
	lblWelcomeToApsit.setBounds(10, 260, 315, 34);
	panel.add(lblWelcomeToApsit);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.DARK_GRAY);
	separator.setBackground(Color.LIGHT_GRAY);
	separator.setBounds(22, 293, 300, 1);
	panel.add(separator);
	
	JLabel lblWithOver = new JLabel("With over 1000+ books");
	lblWithOver.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	lblWithOver.setHorizontalAlignment(SwingConstants.CENTER);
	lblWithOver.setBounds(73, 301, 197, 14);
	panel.add(lblWithOver);
	
	JLabel lblLogin = new JLabel("Login");
	lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogin.setFont(new Font("Sitka Heading", Font.BOLD, 17));
	lblLogin.setBounds(399, 61, 89, 20);
	getContentPane().add(lblLogin);
	
	JButton btnAdminLogin = new JButton("Admin Login");
	btnAdminLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String dbName="libraryDB";
			String driverName="com.mysql.jdbc.Driver";
						String url="jdbc:mysql://localhost:3306/";
						
						try{
							Class.forName(driverName);
							Connection con=DriverManager.getConnection(url+dbName, "root", "root");
							java.sql.PreparedStatement st=con.prepareStatement("Select * from librarianlogin where lId=? and lpass=?");
							st.setString(1, userid.getText());
							st.setString(2,String.valueOf(password.getText()));
							ResultSet rs=st.executeQuery();
								if(rs.next()) {
									dispose();
									AdminMenuForward amd=new AdminMenuForward(userid.getText());
								}
								else {
									JOptionPane.showMessageDialog(null,"invalid username or password");
								}
								
					}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
				}}
				);

	btnAdminLogin.setForeground(new Color(0, 0, 0));
	btnAdminLogin.setBackground(Color.LIGHT_GRAY);
	btnAdminLogin.setBorderPainted(false);
	btnAdminLogin.setBounds(381, 209, 122, 23);
	getContentPane().add(btnAdminLogin);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}