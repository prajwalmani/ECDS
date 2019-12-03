package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class rpass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rpass frame = new rpass();
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
	public rpass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpid = new JLabel("EmpID");
		lblEmpid.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblEmpid.setForeground(Color.WHITE);
		lblEmpid.setBounds(36, 120, 85, 45);
		contentPane.add(lblEmpid);
		
		textField = new JTextField();
		textField.setFont(new Font("Bell MT", Font.PLAIN, 20));
		textField.setForeground(Color.WHITE);
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(36, 168, 139, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 196, 139, 22);
		contentPane.add(separator);
		
		JLabel lblEnterNewPassword = new JLabel("Enter new password");
		lblEnterNewPassword.setForeground(Color.WHITE);
		lblEnterNewPassword.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblEnterNewPassword.setBounds(36, 220, 187, 45);
		contentPane.add(lblEnterNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bell MT", Font.PLAIN, 20));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setOpaque(false);
		passwordField.setBounds(36, 275, 159, 29);
		contentPane.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 305, 159, 22);
		contentPane.add(separator_1);
		
		JLabel lblReconfirmPassword = new JLabel("Re-enter Password");
		lblReconfirmPassword.setForeground(Color.WHITE);
		lblReconfirmPassword.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblReconfirmPassword.setBounds(36, 337, 187, 45);
		contentPane.add(lblReconfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setOpaque(false);
		passwordField_1.setForeground(new Color(255, 255, 255));
		passwordField_1.setFont(new Font("Bell MT", Font.PLAIN, 20));
		passwordField_1.setBorder(null);
		passwordField_1.setBounds(36, 382, 159, 29);
		contentPane.add(passwordField_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(36, 408, 159, 37);
		contentPane.add(separator_2);
		
		JButton btnSave = new JButton("Save");
		
					
			
				
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql="select * from employee where Eid= ? ";
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,textField.getText());
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next())
	{  if((Arrays.equals(passwordField.getPassword(), passwordField_1.getPassword()))    ) {
					String sql2="UPDATE employee SET Password =? WHERE Eid=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn1 =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt1 = conn1.prepareStatement(sql2);
					pstmt1.setInt(1, Integer.parseInt( textField.getText()) );
					pstmt1.setString(2,new String(passwordField.getPassword()));

					
					 pstmt1.executeUpdate();
					login l=new login();
					setVisible(false);
					l.setVisible(true);
					}
				else
				{
					JOptionPane.showMessageDialog(null, "Passwords Doesnt match",
							"Warning", JOptionPane.ERROR_MESSAGE);
				}
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Invalid Eid",
				"Warning", JOptionPane.ERROR_MESSAGE);
	}
}
catch(Exception e1)
{
	e1.printStackTrace();
}
			}
		});
	
		btnSave.setFont(new Font("Bell MT", Font.PLAIN, 22));
		btnSave.setBounds(92, 437, 104, 45);
		contentPane.add(btnSave);
		
		JLabel lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setForeground(Color.WHITE);
		lblResetPassword.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblResetPassword.setBounds(36, 62, 187, 45);
		contentPane.add(lblResetPassword);
	}

}
