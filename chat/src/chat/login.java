package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUserid;
	private JPasswordField passwordField;
	protected Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("EMPid");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblUserid.setBounds(20, 111, 157, 27);
		contentPane.add(lblUserid);
		
		JLabel label = new JLabel("Password");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Bell MT", Font.PLAIN, 22));
		label.setBounds(32, 204, 157, 27);
		contentPane.add(label);
		
		txtEnterUserid = new JTextField();
		txtEnterUserid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterUserid.setText("");
			}
		});
		txtEnterUserid.setBorder(new CompoundBorder());
		txtEnterUserid.setForeground(Color.WHITE);
		txtEnterUserid.setOpaque(false);
		txtEnterUserid.setFont(new Font("Bell MT", Font.PLAIN, 22));
		txtEnterUserid.setText("Enter Empid");
		txtEnterUserid.setBounds(32, 133, 212, 61);
		contentPane.add(txtEnterUserid);
		txtEnterUserid.setColumns(10);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 187, 304, 13);
		contentPane.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
			}
		});
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setText("Password");
		passwordField.setBounds(32, 231, 212, 38);
		contentPane.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 264, 304, 20);
		contentPane.add(separator_1);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if ( chckbxShowPassword.isSelected()) {
				      passwordField.setEchoChar((char)0); //password = JPasswordField
				   } else {
				      passwordField.setEchoChar('*');
				   }
			}
		});
		chckbxShowPassword.setFont(new Font("Bell MT", Font.PLAIN, 17));
		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.setOpaque(false);
		chckbxShowPassword.setBounds(20, 275, 157, 38);
		contentPane.add(chckbxShowPassword);
		
		JLabel lblForgetPassword = new JLabel("Forget Password?");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rpass r=new rpass();
				r.setVisible(true);
				setVisible(false);
			}

			
		});
		lblForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblForgetPassword.setForeground(Color.WHITE);
		lblForgetPassword.setBounds(20, 440, 142, 46);
		contentPane.add(lblForgetPassword);
		
		JLabel lblSignup =  new JLabel("Signup!");
		lblSignup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setBounds(200, 450, 72, 27);
		contentPane.add(lblSignup);
		lblSignup.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	signup sp=new signup(); 		
	        	setVisible(false);			
                sp.setVisible(true);
	        }
	        });
		
		JButton btnSignin = new JButton("LOGIN");
		
	
		btnSignin.setFont(new Font("Bell MT", Font.PLAIN, 20));
		btnSignin.setBounds(20, 387, 294, 53);
		contentPane.add(btnSignin);
		
		JLabel lblResourceManager = new JLabel("Resource Manager?");
		lblResourceManager.setForeground(Color.WHITE);
		lblResourceManager.setFont(new Font("Bell MT", Font.BOLD, 18));
		lblResourceManager.setBounds(84, 470, 179, 48);
		contentPane.add(lblResourceManager);
		
		JComboBox<Integer> comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(187, 330, 57, 31);
		contentPane.add(comboBox);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);

		
		JLabel lblSelectThePid = new JLabel("Select the Pid ");
		lblSelectThePid.setForeground(Color.WHITE);
		lblSelectThePid.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblSelectThePid.setBounds(20, 329, 157, 27);
		contentPane.add(lblSelectThePid);
		
		JLabel lblSign = new JLabel("Login!");
		lblSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblSign.setForeground(Color.WHITE);
		lblSign.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 33));
		lblSign.setBounds(10, 40, 348, 61);
		contentPane.add(lblSign);
		lblResourceManager .addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rm c=new rm();
				c.setVisible(true);
			dispose();
				
			}
			
		
		});

		btnSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql="select * from employee where Empid =? and Password= ? ";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,  txtEnterUserid.getText());
					System.setOut(null);
					pstmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next())
					{
						msg c=new msg(Integer.parseInt(txtEnterUserid.getText()) );
					c.setVisible(true);
				dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Credentials",
						"Unsuccessful login", JOptionPane.ERROR_MESSAGE);
						}
					conn.close();
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
				String sql1="INSERT INTO histroy(Empid, pid, ts) VALUES (?,?,?)";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt = conn.prepareStatement(sql1);
					pstmt.setInt(1, Integer.parseInt(txtEnterUserid.getText()));
					pstmt.setInt(2,  (int) comboBox.getSelectedItem());
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					pstmt.setDate(3,new java.sql.Date(date.getTime()));
					pstmt.executeUpdate();

				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}

		
		});

	}
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
