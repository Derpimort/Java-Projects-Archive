package com.javaproject.librarymanagement;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMenu extends JFrame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu cs = new AdminMenu("Test");
					contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static JPanel contentPane;
	public AdminMenu(String name) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\12-512.png"));
		setTitle("Apsit Library Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 476, 230);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton registernew1 = new JButton("Register new\r\n customer");
		registernew1.setFont(new Font("Arial", Font.PLAIN, 13));
		registernew1.setBorderPainted(false);
		registernew1.setForeground(Color.BLACK);
		registernew1.setBackground(new Color(255, 218, 185));
		registernew1.setBounds(31, 91, 171, 51);
		registernew1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerNew rn=new registerNew();
			}
		});
		
		
		getContentPane().add(registernew1);
		
			    
			
			  
		    JPanel panel = new JPanel();
		    panel.setBackground(Color.WHITE);
		    panel.setBounds(0, 0, 470, 67);
		    contentPane.add(panel);
		    panel.setLayout(null);
		    JLabel lblApsitLibraryAdmin = new JLabel("Welcome, "+name);
		    lblApsitLibraryAdmin.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		    lblApsitLibraryAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		    lblApsitLibraryAdmin.setBounds(76, 5, 317, 51);
		    panel.add(lblApsitLibraryAdmin);
		    BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File("E:\\\\eclipse\\\\Jatin-workspace\\\\Library-Management\\\\src\\\\com\\\\javaproject\\\\librarymanagement\\\\images.png"));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    
		    JLabel lblNewLabel = new JLabel("New label");
		   
		    lblNewLabel.setBounds(0, 0, 78, 67);
		    panel.add(lblNewLabel);
		    Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		    ImageIcon imageIcon = new ImageIcon(dimg);
		    lblNewLabel.setIcon(imageIcon);
		    
		    JLabel label = new JLabel("New label");
		    label.setBounds(392, 0, 78, 67);
		    panel.add(label);
		    label.setIcon(imageIcon);
		    
		    JButton btnAddNewBook = new JButton("Add new book");
		    btnAddNewBook.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		BookFrame f=new BookFrame();
		    	}
		    });
		    btnAddNewBook.setFont(new Font("Arial", Font.PLAIN, 13));
		    btnAddNewBook.setForeground(Color.BLACK);
		    btnAddNewBook.setBorderPainted(false);
		    btnAddNewBook.setBackground(new Color(255, 218, 185));
		    btnAddNewBook.setBounds(262, 91, 171, 51);
		    contentPane.add(btnAddNewBook);
		    
		    JButton btnListOverdueBooks = new JButton("List overdue books");
		    btnListOverdueBooks.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		setSize(476, 387);
		    		String dbName="libraryDB";
		    		String driverName="com.mysql.jdbc.Driver";
		    					String url="jdbc:mysql://localhost:3306/";
		    		  try {
		    			  Class.forName(driverName);
		    				Connection con=DriverManager.getConnection(url+dbName, "root", "root");
		    				java.sql.PreparedStatement st=con.prepareStatement("SELECT * FROM issuedb WHERE issuedb.IssueDate < DATE_ADD(now(),INTERVAL -15 DAY);");
		    				final ResultSet rs=st.executeQuery();
		    				//final JLabel lblListOfOverdue = new JLabel("List of Overdue books");
		    			   // lblListOfOverdue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		    			   // lblListOfOverdue.setHorizontalAlignment(SwingConstants.CENTER);
		    			  //  lblListOfOverdue.setBounds(152, 206, 156, 14);
		    			 //   lblListOfOverdue.setVisible(false);
		    			   // contentPane.add(lblListOfOverdue);
		    	    		final JTable table=new JTable();
		    	    		table.setBackground(new Color(255, 255, 255));
		    	    		final JScrollPane scrollPane = new JScrollPane(table);
		    	    		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		    	    		scrollPane.setBounds(10, 204, 450, 146);
		    	    		contentPane.add(scrollPane);
		    	    		 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	    	     scrollPane.setViewportView(table);
		    	    	     table.setModel(DbUtils.resultSetToTableModel(rs));
		    	    	     table.setBackground(new Color(255, 218, 185));
		    	    	     /*((Object) table).setCellRenderer( new DefaultTableCellRenderer() {
		    	    	    	    public Component getTableCellRenderer(JTable table, Object value) {
		    	    	    	        super.getTableCellRenderer();
		    	    	    	            setBackground(new Color(244, 164, 96));
		    	    	    	        return this;
		    	    	    	    }
		    		  });*/
		    		//lblListOfOverdue.setVisible(true);
		    		 scrollPane.setVisible(true);
		    		 scrollPane.setBackground(new Color(244, 164, 96));
		    		 scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List of Overdue Books", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0,0,0)));
		    	}
		    		  catch (Exception e) {
		    			  e.printStackTrace();
		  			  }
		    }});
		    btnListOverdueBooks.setForeground(Color.BLACK);
		    btnListOverdueBooks.setFont(new Font("Arial", Font.PLAIN, 13));
		    btnListOverdueBooks.setBorderPainted(false);
		    btnListOverdueBooks.setBackground(new Color(255, 218, 185));
		    btnListOverdueBooks.setBounds(31, 144, 171, 51);
		    contentPane.add(btnListOverdueBooks);
		    
		    JButton btnBack = new JButton("Exit");
		    btnBack.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		System.exit(0);
		    		//dispose();
		    		//Login_page lp=new Login_page();
		    	}
		    });
		    btnBack.setForeground(Color.BLACK);
		    btnBack.setFont(new Font("Arial", Font.PLAIN, 13));
		    btnBack.setBorderPainted(false);
		    btnBack.setBackground(new Color(255, 218, 185));
		    btnBack.setBounds(262, 144, 171, 51);
		    contentPane.add(btnBack);
		  } 
		  
}

