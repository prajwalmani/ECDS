package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rs1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rs1 frame = new rs1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public rs1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1164, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> jc = new JComboBox();
		
		jc.setToolTipText("");
		jc.setBounds(156, 271, 152, 31);
		contentPane.add(jc);
		
		JPanel panel = new JPanel();
		
		JLabel lblSelectTheEmployee = new JLabel("Select the Employee");
		lblSelectTheEmployee.setForeground(Color.WHITE);
		lblSelectTheEmployee.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblSelectTheEmployee.setBounds(156, 208, 206, 49);
		contentPane.add(lblSelectTheEmployee);
		
		JLabel lblSelectThePid = new JLabel("Select the Pid");
		lblSelectThePid.setForeground(Color.WHITE);
		lblSelectThePid.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblSelectThePid.setBounds(156, 89, 206, 49);
		contentPane.add(lblSelectThePid);
		
		JComboBox<Integer> comboBox = new JComboBox();
		jc.addMouseListener(new MouseAdapter()
		{
	public void mouseClicked(MouseEvent e) {
		Integer s = comboBox.getItemAt(comboBox.getSelectedIndex());	
		if(s==1)
		{
			textField.setText("2020-11-24");
		}else if(s==2)
		{
			textField.setText("2020-11-11");

		}else if(s==3)
		{
			textField.setText("2020-02-23");

		}else {
			textField.setText("2020-02-13");

		}
	}
		});
		comboBox.setToolTipText("");
		comboBox.setBounds(156, 148, 152, 31);
		contentPane.add(comboBox);
		
		JLabel lblSelectThe = new JLabel("Select the role");
		lblSelectThe.setForeground(Color.WHITE);
		lblSelectThe.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblSelectThe.setBounds(157, 329, 241, 49);
		contentPane.add(lblSelectThe);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);

		
		JComboBox<String> comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(156, 388, 152, 31);
		contentPane.add(comboBox_1);
		
		JLabel lblSelectTheDeadline = new JLabel("Allocated deadline");
		lblSelectTheDeadline.setForeground(Color.WHITE);
		lblSelectTheDeadline.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblSelectTheDeadline.setBounds(159, 447, 241, 49);
		contentPane.add(lblSelectTheDeadline);
		comboBox_1.addItem("System engineer");
		comboBox_1.addItem("Software architect");
		comboBox_1.addItem("Senior software engineer");
		comboBox_1.addItem("Domain manager");

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Bell MT", Font.PLAIN, 25));
		btnAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String sql="INSERT INTO rs(Ename, pid, role, deadline) VALUES (?,?,?,?)";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jc.getSelectedItem().toString());
				pstmt.setInt(2,  (int) comboBox.getSelectedItem());
				pstmt.setString(3, comboBox_1.getSelectedItem().toString());
                pstmt.setString(4, textField.getText() );
				pstmt.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Successfully Updated.","Alert",JOptionPane.INFORMATION_MESSAGE);     

			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			}
		});


		btnAdd.setBounds(156, 570, 140, 49);
		contentPane.add(btnAdd);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setFont(new Font("Bell MT", Font.BOLD, 23));
		textField.setBounds(156, 506, 142, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		login l=new login();	
		l.setVisible(true);
		dispose();
		
		}
			
		});
		btnLogout.setFont(new Font("Bell MT", Font.PLAIN, 23));
		btnLogout.setBounds(1026, 10, 120, 49);
		contentPane.add(btnLogout);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(156, 532, 152, 2);
		contentPane.add(separator);
		
		table = new JTable();
		table.setFont(new Font("Bell MT", Font.PLAIN, 15));
		table.setBounds(486, 142, 604, 183);
		contentPane.add(table);
		

		String sql="SELECT manger.Mid,manger.PId,manger.pname,manger.Mname,rs.deadline 	FROM manger NATURAL JOIN rs GROUP BY manger.PId" ;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
			PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();	
            table.setModel(DbUtils.resultSetToTableModel(rs));
	
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
table.setEnabled(false);
JLabel lblListOfManagers = new JLabel("List of managers working on different projects");
lblListOfManagers.setForeground(Color.WHITE);
lblListOfManagers.setFont(new Font("Bell MT", Font.BOLD, 23));
lblListOfManagers.setBounds(486, 94, 561, 38);
contentPane.add(lblListOfManagers);

		
		 
		String sql1="select Ename from employee";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
			PreparedStatement pstmt = conn.prepareStatement(sql1);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	jc.addItem(rs.getString(1));
            }

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		JComboBox<String> comboBox1 = new JComboBox();
		comboBox1.setBounds(822, 388, 152, 31);
		contentPane.add(comboBox1);
		
		JLabel lblInvalidEntries = new JLabel("Invalid employee  entries");
		lblInvalidEntries.setForeground(Color.WHITE);
		lblInvalidEntries.setFont(new Font("Bell MT", Font.BOLD, 23));
		lblInvalidEntries.setBounds(534, 381, 278, 38);
		contentPane.add(lblInvalidEntries);
		
		comboBox1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String sql="SELECT `Ename`FROM `rs` WHERE `pid`=0;";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt = conn.prepareStatement(sql);
		            ResultSet rs = pstmt.executeQuery();
		            while(rs.next()) {
		            	comboBox1.addItem(rs.getString(1));
		            }

				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		
		
	}
}
