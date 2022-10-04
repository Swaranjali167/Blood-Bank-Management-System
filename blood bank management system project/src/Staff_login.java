import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Staff_login extends JFrame {

	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField passtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_login frame = new Staff_login();
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
	public Staff_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluser = new JLabel("User id :");
		lbluser.setForeground(new Color(0, 0, 0));
		lbluser.setBounds(126, 167, 108, 88);
		lbluser.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbluser.setBackground(new Color(255, 250, 250));
		contentPane.add(lbluser);
		
		JLabel lblPass = new JLabel("Password :");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setBackground(new Color(0, 0, 0));
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPass.setBounds(116, 265, 108, 73);
		contentPane.add(lblPass);
		
		usertxt = new JTextField();
		usertxt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		usertxt.setBackground(Color.WHITE);
		usertxt.setBounds(248, 191, 262, 44);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		passtext = new JPasswordField();
		passtext.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passtext.setBackground(Color.WHITE);
		passtext.setBounds(248, 281, 262, 44);
		contentPane.add(passtext);
		
		JLabel lblStaffLogin = new JLabel("Staff Login");
		lblStaffLogin.setForeground(new Color(0, 0, 0));
		lblStaffLogin.setBackground(Color.GRAY);
		lblStaffLogin.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblStaffLogin.setBounds(268, 80, 228, 73);
		contentPane.add(lblStaffLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(SystemColor.text);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String u= usertxt.getText();
			String p= passtext.getText();
			if(usertxt.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please enter userid");
			}
			else if(passtext.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please enter the password");
			}
			else
			 {
			   if(u.contentEquals("1101")||u.contentEquals("1102")||u.contentEquals("1103"))
				   
			   {
			    if(p.contentEquals("pass123"))
			    {
				    JOptionPane.showMessageDialog(null,"Login Successful");
				       dispose();
					   Staff s= new Staff();
					   s.setVisible(true);
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null,"Invalid credentials");
			    }
			   }
			   else
			   {
				    JOptionPane.showMessageDialog(null,"Invalid credentials");
			   } 
			 }  
		}
		});
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnLogin.setBounds(286, 387, 114, 44);
		contentPane.add(btnLogin);
		
		JLabel imglbl = new JLabel("");
		imglbl.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
		imglbl.setBounds(599, 441, 131, 185);
		contentPane.add(imglbl);
		
		
	}
}
















