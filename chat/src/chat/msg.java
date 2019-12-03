package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class msg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int eid=0;
				try {
					msg frame = new msg(eid);
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
	public msg(int eid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 605);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(28, 26, 479, 463);
		textArea.setFont(new Font("Bell MT", Font.BOLD, 18));

		contentPane.add(textArea);
textArea.setEditable(false);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 516, 479, -432);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String sql3="SELECT employee.Ename, `txt`, `time` FROM `msg`  INNER JOIN employee WHERE msg.Empid=employee.Empid";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement ps = conn.prepareStatement(sql3);
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
		textField.setBounds(28, 502, 404, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String sql="INSERT INTO msg(Empid, pid, txt, time) VALUES (?,?,?,?)";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, eid);
					pstmt.setInt(2,01);
					pstmt.setString(3, textField.getText());
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					pstmt.setDate(4,new java.sql.Date(date.getTime()));
					pstmt.executeUpdate();

				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {@Override
			public void mouseClicked(MouseEvent e) {
				String sql3="SELECT employee.Ename, `txt`, `time` FROM `msg`  INNER JOIN employee WHERE msg.Empid=employee.Empid";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement ps = conn.prepareStatement(sql3);
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
		btnNewButton.setFont(new Font("Bell MT", Font.PLAIN, 17));
		btnNewButton.setBounds(431, 500, 76, 35);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("Deadlines");
		button_1.setFont(new Font("Bell MT", Font.BOLD, 18));
		button_1.setBounds(601, 298, 125, 38);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Settings");
		button_2.setFont(new Font("Bell MT", Font.BOLD, 18));
		button_2.setBounds(601, 373, 125, 38);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Search");
		button_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				searc s=new searc();
				s.setVisible(true);
				

			}

				
		
		});
		button_3.setFont(new Font("Bell MT", Font.BOLD, 18));
		button_3.setBounds(601, 451, 125, 38);
		contentPane.add(button_3);
		
		JButton btnlogout = new JButton("Logout");
		btnlogout.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		login l=new login();	
		l.setVisible(true);
		dispose();
		
		}
			
		});
		btnlogout.setFont(new Font("Bell MT", Font.BOLD, 18));
		btnlogout.setBounds(933, 10, 125, 38);
		contentPane.add(btnlogout);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(564, 26, 253, 226);
		contentPane.add(scrollPane_1);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setFont(new Font("Bell MT", Font.BOLD, 23));
		textArea_1.append("waq ");
		textArea_1.append("\nvinod");
		textArea_1.append("\nravi");



		JButton button = new JButton("Refresh");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String sql="Select ename From employee Where empid in(select Empid from histroy where ts=?)"; 
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
					PreparedStatement ps = conn.prepareStatement(sql);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					ps.setDate(1,new java.sql.Date(date.getTime()));
		            ResultSet rs = ps.executeQuery();		
		            textArea_1.setText("");
		            while(rs.next())
		            {   
		            	textArea_1.append(rs.getString(1)+"\n");
		            }
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}

			
		});
		button.setFont(new Font("Bell MT", Font.BOLD, 15));
		button.setBounds(732, 262, 85, 21);
		contentPane.add(button); 
	}


	 public static java.sql.Time getCurrentJavaSqlTime() {
		    java.util.Date date = new java.util.Date();
		    return new java.sql.Time(date.getTime());
	}
}
