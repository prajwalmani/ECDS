package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.CallableStatement;

import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;

public class searc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searc frame = new searc();
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
	public searc() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 746);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				
				
			}

			
		});
		textField.setText("Enter the text");
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Bell MT", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBorder(new CompoundBorder());
		textField.setBounds(81, 35, 142, 43);
		contentPane.add(textField);
		
		JButton button = new JButton("Search");
		
		
		button.setFont(new Font("Bell MT", Font.BOLD, 18));
		button.setBounds(225, 38, 125, 38);
		contentPane.add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 70, 155, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(49, 112, 473, 542);
		contentPane.add(scrollPane);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Bell MT", Font.BOLD, 18));
		scrollPane.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Bell MT", Font.BOLD, 21));
		textField_1.setColumns(10);
		textField_1.setBorder(new CompoundBorder());
		textField_1.setBounds(360, 35, 265, 43);
		contentPane.add(textField_1);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String sql="{ call smsgs(?,?) } ";
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
			Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
          CallableStatement stmt = (CallableStatement) conn.prepareCall(sql) ;
          stmt.setString(1, textField.getText());
          stmt.registerOutParameter(2, java.sql.Types.INTEGER);
          stmt.executeUpdate();
          int count=stmt.getInt(2);
          
  		textField_1.setText("Total messages displayed:"+count);

	 }catch(Exception e1)
	 {
		 e1.printStackTrace();
	 }
		String sql1="SELECT employee.Ename, `txt`, `time` FROM `msg1`  INNER JOIN employee WHERE msg1.Empid=employee.Empid";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
			PreparedStatement ps = conn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();			
            while(rs.next())
            {           	   
				textArea.append(rs.getString(1)+":"+rs.getString(2)+"\t\t\t\t"+rs.getString(3)+"\n");   
				textArea.append("------------------------------------------------\n");
            }
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	 
			}

				
			
		});
	}
}
