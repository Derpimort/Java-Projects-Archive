package com.javaproject.librarymanagement;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.applet.*;  

public class CustomerMenu extends JFrame{
	private static JPanel frame;
	//private final JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu cs = new CustomerMenu("Test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CustomerMenu(String text) throws Exception {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\12-512.png"));
		setTitle("Customer Menu");
		setVisible(true);
		initialize(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initialize(final String text) throws Exception {
		frame = new JPanel();
		setBounds(100, 100, 689, 693);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 683, 69);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, "+text);
		lblWelcome.setForeground(new Color(255, 218, 185));
		lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 11, 457, 47);
		panel.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Return a book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookReturn br=new BookReturn(text);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(255, 218, 185));
		btnNewButton.setBounds(534, 0, 149, 69);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login_page lp=new Login_page();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 218, 185));
		btnNewButton_2.setBounds(462, 0, 72, 69);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 69, 683, 595);
		getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setLayout(new GridLayout(0, 5, 10, 10));;
		setLocationRelativeTo(null);
		int lwe=1;
		int max=0;
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		String dbName="libraryDB";
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/";
		try{
			Class.forName(driverName);
			Connection con=DriverManager.getConnection(url+dbName, "root", "root");
			java.sql.PreparedStatement st=con.prepareStatement("select count(*) from book;");
			ResultSet rs=st.executeQuery();
				if(rs.next()) {
					max=Integer.parseInt(rs.getString(1));
				}
				
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		String title=null,author=null,qty=null,Id=null;
		
		
			try{
				Class.forName(driverName);
				Connection con=DriverManager.getConnection(url+dbName, "root", "root");
				java.sql.PreparedStatement st1=con.prepareStatement("select * from book;");
				ResultSet rs1=st1.executeQuery();
				for(int i=0;i<max;i++)
				{
					if(rs1.next()) {
								Id=rs1.getString(1);
							title=rs1.getString(2);
								author=rs1.getString(4);
								qty=rs1.getString(5);
								JLabel l = new JLabel();
								 BufferedImage img = null;
								    try {
								        img = ImageIO.read(new File("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\pics\\"+Id+ ".jpg"));
								    } catch (IOException e) {
								        //e.printStackTrace();
								    }
								    if(img==null)
								    {
								    	img = ImageIO.read(new File("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\pics\\default.jpg"));
								    }
								    Image dimg = img.getScaledInstance(125, 188,Image.SCALE_SMOOTH);
								    ImageIcon imageIcon = new ImageIcon(dimg);
								    l.setIcon(imageIcon);
								l.setToolTipText("ID: "+Id+"\t; Title: "+title+"\t; Author: "+author+"\t; Availablity: "+qty);
								final int i2=Integer.parseInt(Id);
								final String title1=title;
								l.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										//BookFrame bf=new BookFrame();.
										BookInfo bi=new BookInfo(i2,text,title1);
									}
								});
								panel_1.add(l);
								lwe++;
					}
				}
					
		}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			BookService bookService = new BookService();
			ArrayList result = 
					bookService.getBookDetailsById(lwe);
			
			
		}
		// JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//    container.add(panel_1);
		    
		   /* JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 218, 185));
			panel_2.setBounds(0, 69, 683, 595);
			//getContentPane().add(panel_1);
			panel_2.setLayout(new GridLayout(0, 5, 10, 10));;
			setLocationRelativeTo(null);
			frame.setBorder(new EmptyBorder(5, 5, 5, 5));
			for(int j=0;j<3;j++)
			{
			for(int i=0;i<5;i++)
			{
				BookService bookService = new BookService();
				ArrayList result = 
						bookService.getBookDetailsById(lwe);
				String title=result.get(0).toString();
				String author=result.get(2).toString();
				String qty=result.get(3).toString();
				JLabel l = new JLabel(Integer.toString(i));
				 BufferedImage img = null;
				    try {
				        img = ImageIO.read(new File("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\pics\\"+lwe+ ".jpg"));
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
				    Image dimg = img.getScaledInstance(128, 191,Image.SCALE_SMOOTH);
				    ImageIcon imageIcon = new ImageIcon(dimg);
				    l.setIcon(imageIcon);
				l.setToolTipText("ID: "+lwe+"\t; Title: "+title+"\t; Author: "+author+"\t; Availablity: "+qty);
				panel_2.add(l);
				lwe++;
			}
			}

			    container.add(panel_2);*/
			   /* JScrollPane scrollPane = new JScrollPane(container);
			    getContentPane().add(scrollPane);
			    scrollPane.setVisible(true);
			    getContentPane().setVisible(true);*/
	
	public void dis()
	{
		dispose();
	}
}
