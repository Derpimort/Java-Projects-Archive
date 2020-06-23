package com.javaproject.librarymanagement;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BookInfo extends JFrame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfo bi = new BookInfo(13,"test","Harry Potter and the Prisoner of Azkaban");
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static JFrame frame;
	//private static JPanel frame;

	public BookInfo(int BiD,String userid, String title1) {
		

		initialize(BiD,userid,title1);

	}

	private void initialize(final int biD,final String userid,final String btitle) {
getContentPane().setBackground(new Color(255, 255, 255));
		
		//frame = new JPanel();
		JPanel panel=new JPanel();
		panel.setBounds(0, 25, 564, 400);
		panel.setLayout(null);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\com\\javaproject\\librarymanagement\\12-512.png"));
		setTitle("Book Info");
		setUndecorated(true);
		setOpacity(0.99f);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 564, 425);
		getContentPane().add(panel);
		BufferedImage img = null;
	    try {
	        img = ImageIO.read(new File("E:\\eclipse\\Jatin-workspace\\Library-Management\\src\\pics\\book3.png"));
	    } catch (IOException e) {
	        //e.printStackTrace();
	    }
	    Image dimg = img.getScaledInstance(564, 400,Image.SCALE_SMOOTH);
	    ImageIcon imageIcon = new ImageIcon(dimg);
		
		
		String dbName="libraryDB";
		String driverName="com.mysql.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/";
					String summ=null;
					
					try{
						Class.forName(driverName);
						Connection con=DriverManager.getConnection(url+dbName, "root", "root");
						java.sql.PreparedStatement st=con.prepareStatement("Select summary from booksumm where bookId=?");
						st.setInt(1,biD);
						ResultSet rs=st.executeQuery();
							if(rs.next()) {
								summ=rs.getString(1);
							}
					}
					catch(Exception e)
					{
					}
					if(summ==null)
					{
						summ="******WILL BE UPDATED SOON******";
					}
					JTextArea textArea = new JTextArea();
					textArea.setFont(new Font("Segoe Script", Font.BOLD, 29));
					textArea.setBackground(new Color(220, 220, 220));
					textArea.setLineWrap(true);
					//textArea.setText("ongbiosgnhiotanio[dnht[oirhnoutbuodb");
					textArea.setBounds(83, 22, 153, 325);
					textArea.setOpaque(false);
					textArea.setBackground(new Color(0,0,0,0));
					textArea.setText(btitle);
					textArea.setEditable(false);
					textArea.setWrapStyleWord(true);
		panel.add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(336, 358, 173, 23);
		panel.add(btnBack);
		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setViewportBorder(null);
		//scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.getVerticalScrollBar().setPreferredSize (new Dimension(0,0)); 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			   public void run() { 
			       scrollPane_1.getVerticalScrollBar().setValue(0);
			   }
			});
		scrollPane_1.setBounds(290, 58, 250, 285);
		scrollPane_1.setOpaque(false);
		
		scrollPane_1.getViewport().setOpaque(false);
		panel.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		//textArea_1.setText("ongbiosgnhiotanio[dnht[oirhnoutbuodb");
		textArea_1.setOpaque(false);
		textArea_1.setLineWrap(true);
		textArea_1.setBackground(new Color(220, 220, 220));
		textArea_1.setText(summ);
		textArea_1.setEditable(false);
		textArea_1.setWrapStyleWord(true);
		//textArea_1.setAutoscrolls(false);
		textArea_1.grabFocus();
		textArea_1.setCaretPosition(20);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSummary.setBounds(336, 22, 173, 32);
		panel.add(lblSummary);
		
		/*JTextPane textpane = new JTextPane();
		textpane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(169, 169, 169), new Color(128, 128, 128)));
		
		textpane.setBounds(48, 22, 194, 325);
		StyledDocument doc = textpane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setCharacterAttributes(10, doc.getLength(), center, true);
		doc.setParagraphAttributes(10, doc.getLength(), center, true);
		textpane.setOpaque(false);
		textpane.setEditable(false);
		textpane.setBackground(new Color(0,0,0,0));
		textpane.setText("Harry Potter and the Prisoner of Azkaban");
		
		panel.add(textpane);*/
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookIssue bk=new BookIssue(biD,userid);
			}
		});
		btnIssueBook.setBounds(48, 358, 173, 23);
		panel.add(btnIssueBook);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(384, 48, 78, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 564, 400);
		lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("     APSIT Library - Issue a Book");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 525, 25);
		getContentPane().add(lblNewLabel_1);

	
		
	}

	protected void Logout() {
		// TODO Auto-generated method stub
		
	}
}
