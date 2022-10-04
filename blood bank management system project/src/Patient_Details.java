import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.border.TitledBorder;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Patient_Details extends JFrame {

	private JPanel contentPane;
	private JTextField t_PName;
	private JTextField t_PAge;
	private JTextField t_PAddress;
	private JTextField t_Pno;
	private JTextField t_Hname;
	private JTextField t_Haddr;
	private JTextField t_Drn;
	private JTextField t_Q;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Details frame = new Patient_Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public Patient_Details() {
		Font f1=new Font("Times New Roman",Font.PLAIN,19);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1309, 785);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JLabel lbl1_Pname = new JLabel("Name:");
		lbl1_Pname.setBounds(50, 27, 72, 49);
		lbl1_Pname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		t_PName = new JTextField();
		t_PName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_PName.setBounds(181, 39, 255, 30);
		t_PName.setColumns(10);		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(50, 87, 53, 30);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 20));	
		t_PAge = new JTextField();
		t_PAge.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_PAge.setBounds(181, 90, 255, 31);
		t_PAge.setColumns(10);
		t_PAge.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke2) 
	         {
	            if (ke2.getKeyChar() >= '0' && ke2.getKeyChar() <= '9'|| ke2.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	t_PAge.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(49, 126, 73, 30);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton rb1_M = new JRadioButton("Male");
		rb1_M.setBackground(new Color(255, 255, 255));
		rb1_M.setBounds(181, 130, 109, 23);
		rb1_M.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JRadioButton rb2_F = new JRadioButton("Female");
		rb2_F.setBackground(new Color(255, 255, 255));
		rb2_F.setBounds(327, 130, 109, 23);
		rb2_F.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		 JRadioButton rb3_O = new JRadioButton("Other");
	     rb3_O.setBackground(Color.WHITE);
	     rb3_O.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     rb3_O.setBounds(473, 121, 103, 21);
		
		t_PAddress = new JTextField();
		t_PAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_PAddress.setBounds(181, 171, 255, 58);
		t_PAddress.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lbl1_Pname);
		contentPane.add(t_PName);
		contentPane.add(lblAge);
		contentPane.add(t_PAge);
		contentPane.add(lblGender);
		contentPane.add(rb1_M);
		contentPane.add(rb2_F);
		contentPane.add(t_PAddress);
		
		JLabel lblNewLabel = new JLabel("Phone No:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(50, 242, 92, 21);
		contentPane.add(lblNewLabel);
		
		t_Pno = new JTextField();
		t_Pno.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_Pno.setColumns(10);
		t_Pno.setBounds(181, 240, 255, 30);
		contentPane.add(t_Pno);
		t_Pno.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	           
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9' || ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	t_Pno.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
		
		JLabel label = new JLabel("");
		label.setBounds(297, 287, 46, 14);
		contentPane.add(label);
		
		JLabel lbl1_Hname = new JLabel("Hospital Name:");
		lbl1_Hname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl1_Hname.setBounds(710, 32, 135, 49);
		contentPane.add(lbl1_Hname);
		
		t_Hname = new JTextField();
		t_Hname.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_Hname.setColumns(10);
		t_Hname.setBounds(922, 39, 287, 30);
		contentPane.add(t_Hname);
		
		JLabel lbl_Haddr = new JLabel("Hospital Address:");
		lbl_Haddr.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_Haddr.setBounds(710, 82, 172, 49);
		contentPane.add(lbl_Haddr);
		
		t_Haddr = new JTextField();
		t_Haddr.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_Haddr.setColumns(10);
		t_Haddr.setBounds(922, 80, 287, 73);
		contentPane.add(t_Haddr);
		
		JLabel lbl_drn = new JLabel("Doctor's Name:");
		lbl_drn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_drn.setBounds(710, 152, 153, 49);
		contentPane.add(lbl_drn);
		
		t_Drn = new JTextField("Dr.");
		t_Drn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		t_Drn.setColumns(10);
		t_Drn.setBounds(922, 168, 287, 30);
		contentPane.add(t_Drn);
		
		JLabel lbl_rbt = new JLabel("Required Blood Type:");
		lbl_rbt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_rbt.setBounds(31, 313, 204, 49);
		contentPane.add(lbl_rbt);
		
		JRadioButton rb_Ap = new JRadioButton("A+");
		rb_Ap.setBackground(new Color(255, 255, 255));
		rb_Ap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Ap.setBounds(253, 326, 60, 23);
		contentPane.add(rb_Ap);
		
		JRadioButton rb_Bp = new JRadioButton("B+");
		rb_Bp.setBackground(new Color(255, 255, 255));
		rb_Bp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Bp.setBounds(327, 326, 53, 23);
		contentPane.add(rb_Bp);
		
		JRadioButton rb_ABp = new JRadioButton("AB+");
		rb_ABp.setBackground(new Color(255, 255, 255));
		rb_ABp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_ABp.setBounds(409, 326, 63, 23);
		contentPane.add(rb_ABp);
		
		JRadioButton rb_An = new JRadioButton("A-");
		rb_An.setBackground(new Color(255, 255, 255));
		rb_An.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_An.setBounds(496, 326, 53, 23);
		contentPane.add(rb_An);
		
		JRadioButton rb_Bn = new JRadioButton("B-");
		rb_Bn.setBackground(new Color(255, 255, 255));
		rb_Bn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Bn.setBounds(566, 326, 60, 23);
		contentPane.add(rb_Bn);
		
		JRadioButton rb_ABn = new JRadioButton("AB-");
		rb_ABn.setBackground(new Color(255, 255, 255));
		rb_ABn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_ABn.setBounds(628, 326, 60, 23);
		contentPane.add(rb_ABn);
		
		JRadioButton rb_Op = new JRadioButton("O+");
		rb_Op.setBackground(new Color(255, 255, 255));
		rb_Op.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Op.setBounds(707, 326, 60, 23);
		contentPane.add(rb_Op);
		
		JRadioButton rb_On = new JRadioButton("O-");
		rb_On.setBackground(new Color(255, 255, 255));
		rb_On.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_On.setBounds(769, 326, 60, 23);
		contentPane.add(rb_On);
		 ButtonGroup group1 = new ButtonGroup();
	     group1.add(rb1_M);
	     group1.add(rb2_F);
	     group1.add(rb3_O);
	     ButtonGroup group2 = new ButtonGroup();
	     group2.add(rb_Ap);
	     group2.add(rb_Bp);
	     group2.add(rb_ABp);
	     group2.add(rb_An);
	     group2.add(rb_Bn);
	     group2.add(rb_ABn);
	     group2.add(rb_Op);
	     group2.add(rb_On);

	     
	     JLabel lblNewLabel_1 = new JLabel("Quantity:");
	     lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	     lblNewLabel_1.setBounds(31, 373, 145, 31);
	     contentPane.add(lblNewLabel_1);
	     
	     t_Q = new JTextField();
	     t_Q.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	     t_Q.setBounds(253, 376, 158, 30);
	     contentPane.add(t_Q);
	     t_Q.setColumns(10);
	     JRadioButton rb_U = new JRadioButton("Urgent");
	     rb_U.setBackground(new Color(255, 255, 255));
	     rb_U.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     rb_U.setBounds(257, 430, 86, 23);
	     contentPane.add(rb_U);
	     
	     JRadioButton rb_N = new JRadioButton("Normal");
	     rb_N.setBackground(new Color(255, 255, 255));
	     rb_N.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     rb_N.setBounds(363, 430, 109, 23);
	     contentPane.add(rb_N);
	     t_Q.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9'|| ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	t_Q.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
	     ButtonGroup group3 = new ButtonGroup();
	     group3.add(rb_U);
	     group3.add(rb_N);
	     JTextArea textArea1 = new JTextArea();
	     textArea1.setBackground(Color.WHITE);
	     textArea1.setBounds(21, 514, 387, 210);
	     contentPane.add(textArea1);
	     
	     JTextArea textArea2 = new JTextArea();
	     textArea2.setBackground(Color.WHITE);
	     textArea2.setBounds(418, 514, 374, 210);
	     contentPane.add(textArea2);
	     
	     JPanel panel_1 = new JPanel();
	     panel_1.setBackground(new Color(255, 255, 255));
	     panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hospital Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	     panel_1.setBounds(671, 11, 619, 274);
	     contentPane.add(panel_1);
	     
	     JPanel panel = new JPanel();
	     panel.setBackground(new Color(255, 255, 255));
	     panel.setBorder(new TitledBorder(null, "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	     panel.setBounds(10, 11, 641, 274);
	     contentPane.add(panel);
	     panel.setLayout(null);
	     
	     panel.add(rb3_O);
	     
		
		JLabel lbl_Address = new JLabel("Address:");
		lbl_Address.setBounds(37, 171, 92, 24);
		panel.add(lbl_Address);
		lbl_Address.setFont(new Font("Times New Roman", Font.BOLD, 20));
	     
	     JPanel panel_3 = new JPanel();
	     panel_3.setBackground(new Color(255, 255, 255));
	     panel_3.setBorder(new TitledBorder(null, "Requirement Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	     panel_3.setBounds(10, 282, 1280, 210);
	     contentPane.add(panel_3);
	     panel_3.setLayout(null);
	     
	     JLabel lblNewLabel_1_1 = new JLabel("(In mL)");
	     lblNewLabel_1_1.setBounds(24, 118, 82, 20);
	     lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
	     panel_3.add(lblNewLabel_1_1);
	     
	     JLabel lblNewLabel_2 = new JLabel("Priority:");
	     lblNewLabel_2.setBounds(24, 143, 91, 30);
	     panel_3.add(lblNewLabel_2);
	     lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	     
	     JButton PSubmit = new JButton("Submit");
	     PSubmit.setBounds(477, 158, 137, 30);
	     panel_3.add(PSubmit);
	     PSubmit.setForeground(Color.WHITE);
	     PSubmit.setBackground(Color.DARK_GRAY);
	     PSubmit.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		if(t_PName.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Patient Name");	     			
	     		}
	     		else if(t_PAge.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Patient Age");	     			
	     		}
	     		else if(rb1_M.isSelected()==false && rb2_F.isSelected()==false && rb3_O.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Gender");
	     		}
	     		else if(t_PAddress.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Patient Address");	     			
	     		}
	     		else if(t_Pno.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Patient Phone Number");	     			
	     		}
	     		else if(t_Hname.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Hospital Name");	     			
	     		}
	     		else if(t_Haddr.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Hopital Address");	     			
	     		}
	     		else if(t_Drn.getText().length()<=2)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Doctor's Name");	     			
	     		}
	     		else if(rb_Ap.isSelected()==false && rb_Bp.isSelected()==false && rb_ABp.isSelected()==false && rb_An.isSelected()==false && rb_Bn.isSelected()==false && rb_ABn.isSelected()==false && rb_Op.isSelected()==false && rb_On.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select the Required Blood Type");
	     		}
	     		else if(t_Q.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Valid Quanity");	     			
	     		}
	     		else if(rb_U.isSelected()==false && rb_N.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Priority");
	     		}
	     		else
	     		{
	     			int Page = Integer.parseInt(t_PAge.getText()),q=Integer.parseInt(t_Q.getText());
					String Pname=t_PName.getText(),Paddr=t_PAddress.getText(),g=" ",Hname=t_Hname.getText(),Haddr=t_Haddr.getText(),Drname=t_Drn.getText(),rbt=" ",p1=" ";
	   	         	long Pno = Long.parseLong(t_Pno.getText());
	   	            if(rb_U.isSelected())
					{
						p1="Urgent";
					}
					else if(rb_N.isSelected())
					{
						p1="Normal";
					}
	   	         	if(rb1_M.isSelected())
					{
						g="Male";
					}
					else if(rb2_F.isSelected())
					{
						g="Female";
					}
					else if(rb3_O.isSelected())
					{
						g="Other";
					}
					if(rb_Ap.isSelected())
					{
						rbt="A+";
					}
					if(rb_An.isSelected())
					{
						rbt="A-";
					}
					 if(rb_Bp.isSelected())
					{
						rbt="B+";
					}
					 if(rb_Bn.isSelected())
					{
						rbt="B-";
					}
					 if(rb_ABp.isSelected())
					{
						rbt="AB+";
					}
					 if(rb_ABn.isSelected())
					{
						rbt="AB-";
					}
					 if(rb_Op.isSelected())
					{
						rbt="O+";
					}
					if(rb_On.isSelected())
					{
						rbt="O-";
					}
					textArea1.setFont(f1);
					textArea2.setFont(f1);
	    	        textArea1.setText("Patient Name: "+Pname+"\nPatient Age  : " +Page + "\nPatient Gender : " +g + "\nPatient Address  :  " +Paddr + "\nPatient Phone Number  : "+Pno );
	    	        textArea2.setText("Hospital Name: "+Hname+"\nHospital Address  : " +Haddr + "\nDoctor's Name : " + Drname + "\nPriority  :  "+p1+ "\nRequired BloodType  :  "+rbt +"\nQuantity : "+q+" mL");
	    	        ImageIcon i = new ImageIcon("ThankYou.jpg");
	    	        JOptionPane.showMessageDialog(null, "Your Order has Successfully been Placed.","",JOptionPane.INFORMATION_MESSAGE,i);
	    	        try {
	    	        	Class.forName("com.mysql.jdbc.Driver");
	                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank","Swara","#Swaranjali17" );                   
 
	                    if (conn != null) {
	                         System.out.println("Connected successfully.");
	                     } else {
	                         System.out.println("Failed to make connection!");
	                     }
	                     String query="insert into patients(name, age, sex, bloodtype, address, priority, quantity) values('"+ Pname +"','" +Page+"','"+ g +"','" +rbt+"','" +Paddr+"','" +p1+"','" +q+"')";
	                     String query1="insert into p_phone(phone_no) values('"+ Pno +"')";
	                     String query2="insert into p_hospital(Hospital_name, Hospital_Address, Doctors_Name) values('"+Hname+"','"+Haddr+"','"+Drname+"')";
	                     String query3 = "Update blood set Quantity = (Quantity - '"+q+"') where Bloodtype = '"+rbt+"'";                	
	                     Statement statement= conn.createStatement();
	                 	 statement.executeUpdate(query);
	                 	 statement.executeUpdate(query1);
	                 	 statement.executeUpdate(query2);
	                 	 statement.executeUpdate(query3);
	                     System.out.println("Values inserted successfully");
	                     conn.close();
	                 } 
	    	        catch (Exception e1) 
	    	        {
	                    e1.printStackTrace();
	                 }


	    	        dispose();
	    			FirstFrame np = new FirstFrame();
	    			np.setVisible(true);	     		}
	     	}
	     });
	     PSubmit.setFont(new Font("Times New Roman", Font.BOLD, 22));
	     
	     JPanel panel_3_1 = new JPanel();
	     panel_3_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	     panel_3_1.setBackground(Color.WHITE);
	     panel_3_1.setBounds(10, 493, 1280, 244);
	     contentPane.add(panel_3_1);
	     panel_3_1.setLayout(null);
	     
	     JLabel lblNewLabel_1_1_1 = new JLabel("(In mL)");
	     lblNewLabel_1_1_1.setBounds(48, 118, 82, 20);
	     lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
	     panel_3_1.add(lblNewLabel_1_1_1);
	     
	     JLabel lblNewLabel_2_1 = new JLabel("Priority:");
	     lblNewLabel_2_1.setBounds(35, 143, 80, 30);
	     lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	     panel_3_1.add(lblNewLabel_2_1);
	     
	     JLabel label_1 = new JLabel("");
	     label_1.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
	     label_1.setBounds(1144, 32, 115, 183);
	     panel_3_1.add(label_1);
	    
	}
}






