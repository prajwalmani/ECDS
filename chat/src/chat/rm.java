package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class rm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rm frame = new rm();
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
	public rm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("ResourceManagerid");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblUserid.setBounds(46, 111, 236, 37);
		contentPane.add(lblUserid);
		

		JLabel label = new JLabel("Password");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Bell MT", Font.PLAIN, 22));
		label.setBounds(58, 204, 157, 27);
		contentPane.add(label);
		
		JTextField txtEnterUserid = new JTextField();
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
		txtEnterUserid.setBounds(58, 133, 212, 61);
		contentPane.add(txtEnterUserid);
		txtEnterUserid.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 187, 304, 13);
		contentPane.add(separator);
		JPasswordField	passwordField = new JPasswordField();
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
		passwordField.setBounds(58, 231, 212, 38);
		contentPane.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 264, 304, 20);
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
		chckbxShowPassword.setBounds(46, 275, 157, 38);
		contentPane.add(chckbxShowPassword);
		
		
		JButton btnSignin = new JButton("LOGIN");
		btnSignin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtEnterUserid.getText()=="rs"&&passwordField.getText().equals("0000")) {
					JOptionPane.showMessageDialog(null, "Invalid Credentials",
							"Unsuccessful login", JOptionPane.ERROR_MESSAGE);
; 
				}
				else
				{
										rs1 r=new rs1();
					r.setVisible(true);
					dispose(); 
				}
			}
		});
		btnSignin.setFont(new Font("Bell MT", Font.PLAIN, 20));
		btnSignin.setBounds(46, 319, 294, 53);
		contentPane.add(btnSignin);
		
		

	}

}
