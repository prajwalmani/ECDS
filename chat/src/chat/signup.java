package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPhoneNo;
	private JTextField txtMempid;
	private JTextField txtEnterPassword;
	private JTextField txtRenterPassword;
	private JTextField txtEmpid;
	private JTextField txtEmailId;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   String date=dtf.format(now);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 607);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setText("");
			}
			
		});
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText(); System.out.println(name);
				
			}
		});
		txtName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtName.setFocusTraversalKeysEnabled(false);
		txtName.setBorder(null);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setForeground(Color.WHITE);
		txtName.setOpaque(false);
		txtName.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtName.setText("Name");
		txtName.setBounds(30, 77, 199, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(49, 163, 170, 17);
		contentPane.add(separator_1);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhoneNo.setText("");
			}
		});
		txtPhoneNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 long phoneno=Long.parseLong( txtPhoneNo.getText()) ;
				System.out.println(phoneno);
			}
		});
		txtPhoneNo.setBorder(null);
		txtPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNo.setForeground(Color.WHITE);
		txtPhoneNo.setOpaque(false);
		txtPhoneNo.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtPhoneNo.setText("Phone No");
		txtPhoneNo.setBounds(49, 211, 154, 39);
		contentPane.add(txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(49, 248, 170, 2);
		contentPane.add(separator_2);
		
		txtMempid = new JTextField();
		txtMempid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMempid.setText("");
				
			}
		});
		txtMempid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mempid=Integer.parseInt(txtPhoneNo.getText());
				System.out.println(mempid);

				
			}
		});
		txtMempid.setText("MEmpid");
		txtMempid.setOpaque(false);
		txtMempid.setHorizontalAlignment(SwingConstants.CENTER);
		txtMempid.setForeground(Color.WHITE);
		txtMempid.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtMempid.setColumns(10);
		txtMempid.setBorder(null);
		txtMempid.setBounds(49, 262, 154, 39);
		contentPane.add(txtMempid);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.WHITE);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(49, 311, 170, -10);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(49, 295, 170, 2);
		contentPane.add(separator_4);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterPassword.setText("");
				
			}
		});
		txtEnterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=txtEnterPassword.getText();
				System.out.println(pass);

			}
		});
		txtEnterPassword.setText("Enter Password");
		txtEnterPassword.setOpaque(false);
		txtEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPassword.setForeground(Color.WHITE);
		txtEnterPassword.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtEnterPassword.setColumns(10);
		txtEnterPassword.setBorder(null);
		txtEnterPassword.setBounds(59, 311, 154, 39);
		contentPane.add(txtEnterPassword);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(49, 348, 170, 2);
		contentPane.add(separator_5);
		
		txtRenterPassword = new JTextField();
		txtRenterPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRenterPassword.setText("");
				
			}
		
			
		});
		txtRenterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rpass=	txtRenterPassword.getText();			;

			}
		});
		txtRenterPassword.setText("Renter Password");
		txtRenterPassword.setOpaque(false);
		txtRenterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenterPassword.setForeground(Color.WHITE);
		txtRenterPassword.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtRenterPassword.setColumns(10);
		txtRenterPassword.setBorder(null);
		txtRenterPassword.setBounds(49, 360, 154, 39);
		contentPane.add(txtRenterPassword);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(49, 397, 170, 2);
		contentPane.add(separator_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 115, 169, 2);
		contentPane.add(separator);
		
		
		
		
		
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseEntered(MouseEvent e) {
				if(!txtEnterPassword.getText().equals(txtRenterPassword.getText()))
				{
					JOptionPane.showMessageDialog(null, "Passwords Dont match",
							"Warning", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql="INSERT INTO employee(Ename, Empid, Email, Phoneno, MEid, Password, DOJ) VALUES (?,?,?,?,?,?,?) ";
				try
				{

					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,txtName.getText());
					pstmt.setInt(2, Integer.parseInt(txtEmpid.getText()));
					pstmt.setString(3, txtEmailId.getText());
					pstmt.setLong(4, Long.parseLong( txtPhoneNo.getText()));
					pstmt.setInt(5, Integer.parseInt(txtMempid.getText()));
					pstmt.setString(6, txtEnterPassword.getText());
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					pstmt.setDate(7,new java.sql.Date(date.getTime()));
					pstmt.executeUpdate();
					msg c=new msg( Integer.parseInt(txtEmpid.getText()));
				
					c.setVisible(true);
					setVisible(false);
					dispose();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}

		});
		btnSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSignup.setFont(new Font("Bell MT", Font.PLAIN, 18));
		btnSignup.setBounds(92, 459, 111, 31);
		contentPane.add(btnSignup);
		
		txtEmpid = new JTextField();
		txtEmpid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmpid.setText("");
			}
		});
		txtEmpid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int empid= Integer.parseInt(txtEmpid.getText())       ;
				System.out.println(empid);
			}
		});
		txtEmpid.setText("Empid");
		txtEmpid.setOpaque(false);
		txtEmpid.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpid.setForeground(Color.WHITE);
		txtEmpid.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtEmpid.setColumns(10);
		txtEmpid.setBorder(null);
		txtEmpid.setBounds(30, 127, 199, 31);
		contentPane.add(txtEmpid);
		
		txtEmailId = new JTextField();
		txtEmailId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmailId.setText("");
				
			}
		});
		txtEmailId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String email=txtEmailId.getText();
		}
		});
		txtEmailId.setText("Email iD");
		txtEmailId.setOpaque(false);
		txtEmailId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmailId.setForeground(Color.WHITE);
		txtEmailId.setFont(new Font("Bell MT", Font.PLAIN, 20));
		txtEmailId.setColumns(10);
		txtEmailId.setBorder(null);
		txtEmailId.setBounds(30, 180, 199, 31);
		contentPane.add(txtEmailId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(55, 209, 164, 2);
		contentPane.add(separator_7);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setIcon(new ImageIcon("C:\\Users\\prajw\\OneDrive\\Desktop\\images\\T2D_MomPage_EmployeeToEmployee.png"));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(387, 33, 398, 500);
		contentPane.add(lblImage);
		
	}
}
