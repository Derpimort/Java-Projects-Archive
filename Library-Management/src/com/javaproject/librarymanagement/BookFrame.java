package com.javaproject.librarymanagement;

import com.javaproject.librarymanagement.BookService;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;

public class BookFrame extends JFrame
implements ActionListener
{
	Label lb1,lb2,lb3,lb4,lb5;
	TextField t1,t2,t3,t4,t5;
	Panel p1,p2;
	Button btAdd,btShow;
	
	public BookFrame()
	{
		setAutoRequestFocus(false);
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\12-512.png"));
		setTitle("Book Management");
		setSize(403,336);
		getContentPane().setLayout(new BorderLayout());
		p1 = new Panel();
		lb1 = new Label("Enter book Id : ");
		lb1.setBackground(new Color(255, 255, 255));
		lb1.setFont(new Font("Arial", Font.PLAIN, 13));
		lb1.setBounds(0, 1, 192, 41);
		t1 = new TextField(10);
		t1.setBounds(192, 1, 192, 41);
		lb2 = new Label("Enter book Title : ");
		lb2.setBackground(new Color(255, 255, 255));
		lb2.setFont(new Font("Arial", Font.PLAIN, 13));
		lb2.setBounds(0, 42, 192, 41);
		t2 = new TextField(30);
		t2.setBounds(192, 42, 192, 41);
		t3 = new TextField(20);
		t3.setBounds(192, 83, 192, 41);
		p1.setLayout(null);
		p1.add(lb1);p1.add(t1);
		p1.add(lb2);p1.add(t2);lb3 = new Label("Enter book Price : ");
lb3.setBackground(new Color(255, 255, 255));
lb3.setFont(new Font("Arial", Font.PLAIN, 13));
lb3.setBounds(0, 83, 192, 41);
p1.add(lb3);
p1.add(t3);
		

		getContentPane().add(p1,BorderLayout.CENTER);
		
		t4 = new TextField();
		t4.setBounds(192, 124, 192, 41);
		p1.add(t4);
		
		Label lb4 = new Label("Enter book Author : ");
		lb4.setBackground(new Color(255, 255, 255));
		lb4.setFont(new Font("Arial", Font.PLAIN, 13));
		lb4.setBounds(0, 124, 192, 41);
		p1.add(lb4);
		
		lb5 = new Label("Enter book quantity : ");
		lb5.setBackground(new Color(255, 255, 255));
		lb5.setFont(new Font("Arial", Font.PLAIN, 13));
		lb5.setBounds(0, 165, 192, 41);
		p1.add(lb5);
		
		t5 = new TextField();
		t5.setBounds(192, 165, 192, 41);
		p1.add(t5);
		
		p2 = new Panel();
		p2.setBounds(0, 206, 387, 48);
		p1.add(p2);
		btAdd = new Button("Add book to DB");
		btAdd.setBackground(new Color(244, 164, 96));
		btAdd.setBounds(10, 5, 172, 33);
		btShow = new Button("Show book details");
		btShow.setBackground(new Color(244, 164, 96));
		btShow.setBounds(205, 5, 172, 33);
		p2.setLayout(null);
		p2.add(btAdd);
		p2.add(btShow);
		
		btAdd.addActionListener(this);
		btShow.addActionListener(this);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		int bookId=0,quantity=0;
		String title="",author="";
		float price=0;
		
		
		if(ae.getSource()==btAdd)
		{
		//form validation
		if(t1.getText().equals("") || 
				t2.getText().equals("")|| 
				t3.getText().equals("")|| 
				t4.getText().equals("")||
				t5.getText().equals(""))
		{
			JOptionPane.showMessageDialog(
					 this,"Please enter all values",
					 "Attention",
					 JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			bookId = Integer.parseInt(t1.getText());
			title = t2.getText();
			price = Float.parseFloat(t3.getText());
			author=t4.getText();
			quantity= Integer.parseInt(t5.getText());
			
			BookService bookService = new BookService();
			
			try
			{
			int updateCount = 
				bookService.addBookService(
						bookId, title, price,author,quantity);
			JOptionPane.showMessageDialog(
				this,
				"inserted "+updateCount+" record",
				"Success",
				JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(
						 this,
						 ex.toString(),
						 "ERROR",
						 JOptionPane.ERROR_MESSAGE);

			}
		}
	}//end of insert operation
		else if(ae.getSource()==btShow)
		{
			bookId = Integer.parseInt(t1.getText());
			BookService bookService = new BookService();
			try
			{
			ArrayList result = 
				bookService.getBookDetailsById(bookId);
			
			
			
			if(result.size()==4)
			{
				t2.setText(result.get(0).toString());
				t3.setText(result.get(1).toString());
				t4.setText(result.get(2).toString());
				t5.setText(result.get(3).toString());
			}
			else
			{
				JOptionPane.showMessageDialog(
						 this,
						 "Invalid ID",
						 "ERROR",
						 JOptionPane.ERROR_MESSAGE);

			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(
						 this,
						 ex.toString(),
						 "ERROR",
						 JOptionPane.ERROR_MESSAGE);

			}
			
		}
		
		
		
	}

	
}
