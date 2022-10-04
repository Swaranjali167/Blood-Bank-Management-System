import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;


import javax.swing.UIManager;

import javax.swing.border.TitledBorder;

public class Hospital_Details extends JFrame {

	private JPanel contentPane;
	private JTextField t_Hn;
	private JTextField t_Haddr;
	private JTextField txt_pno;
	private JTextField txt_Hc;
	private JTextField t_Q;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital_Details frame = new Hospital_Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Hospital_Details() {
		
		Font f1=new Font("Times New Roman",Font.PLAIN,19);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 255, 255));
	    textArea_1.setBounds(29, 363, 944, 355);
		contentPane.add(textArea_1);
		
		JCheckBox cb_Op = new JCheckBox("O+");
		JCheckBox cb_ABn = new JCheckBox("AB-");
		JCheckBox cb_Bn = new JCheckBox("B-");
		JCheckBox cb_An = new JCheckBox("A-");
		JCheckBox cb_ABp = new JCheckBox("AB+");
		JCheckBox cb_Bp = new JCheckBox("B+");
		JCheckBox cb_Ap = new JCheckBox("A+");
		JCheckBox cb_On = new JCheckBox("O-");
		
		JRadioButton rb_U = new JRadioButton("Urgent");
		JRadioButton rb_N = new JRadioButton("Normal");
		
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		
		JButton HSubmit = new JButton("Place Order");
		HSubmit.setForeground(Color.WHITE);
		HSubmit.setBackground(Color.DARK_GRAY);
		HSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(t_Hn.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Hospital Name");	     			
	     		}
				else if(t_Haddr.getText().length()==0)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Input Hopital Address");	     			
	     		}
				else if(cb_Ap.isSelected()==false && cb_Bp.isSelected()==false && cb_ABp.isSelected()==false && cb_An.isSelected()==false && cb_Bn.isSelected()==false && cb_ABn.isSelected()==false && cb_Op.isSelected()==false && cb_On.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select the Required Blood Type");
	     		}
				else if(rb_U.isSelected()==false && rb_N.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Priority");
	     		}
				else
				{
					
					int hc = Integer.parseInt(txt_Hc.getText()),q=Integer.parseInt(t_Q.getText());
					String Hname=t_Hn.getText();
	    	        String Haddr=t_Haddr.getText();
	    	        long pno = Long.parseLong(txt_pno.getText());
	    	    	String p = " ",r=" "; 
	    	    	if(rb_U.isSelected())
					{
						p="Urgent";
					}
					else if(rb_N.isSelected())
					{
						p="Normal";
					}
					if(cb_Ap.isSelected())
					{
						r="A+";
					}
					if(cb_An.isSelected())
					{
						r="A-";
					}
					 if(cb_Bp.isSelected())
					{
						r="B+";
					}
					 if(cb_Bn.isSelected())
					{
						r="B-";
					}
					 if(cb_ABp.isSelected())
					{
						r="AB+";
					}
					 if(cb_ABn.isSelected())
					{
						r="AB-";
					}
					 if(cb_Op.isSelected())
					{
						r="O+";
					}
					if(cb_On.isSelected())
					{
						r="O-";
					}
					textArea_1.setFont(f1);
	    	        textArea_1.setText("Hospital Name  : " +Hname + "\n\n Hospital Phone  : " +pno + "\n\n Hospital Address  :  " +Haddr + "\n\n Hospital Code  :  " + hc + "\n\n Priority  :  "+p+ "\n\n Required BloodType  :  "+r +"\n\n Quantity  :  "+q+" mL");
	    	        ImageIcon i = new ImageIcon("ThankYou.jpg");
	    	        JOptionPane.showMessageDialog(null, "Your Order has Successfully been Placed.","",JOptionPane.INFORMATION_MESSAGE,i);	                try {
	                	Class.forName("com.mysql.jdbc.Driver");
	                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank","Swara","#Swaranjali17");                    
	                     if (conn != null) {
	                         System.out.println("Connected successfully.");
	                     } else {
	                         System.out.println("Failed to make connection!");
	                     }
	                     String query="insert into hospital(name, address, hospital_no, bloodtype_requirement,quantity) values('"+ Hname +"','"+ Haddr +"','" +hc+"','"+ r +"','"+q+"')";
	                     String query1="insert into h_phone(hospital_no, phone_no) values('"+ hc +"','"+ pno +"')";
	                     String query3 = "Update blood set Quantity = (Quantity - '"+q+"') where Bloodtype = '"+r+"'";   
	                 	Statement statement= conn.createStatement();
	                 	statement.executeUpdate(query);
	                 	statement.executeUpdate(query1);
	                  	statement.executeUpdate(query3);
	                 	System.out.println("Values inserted successfully");
	                     conn.close();
	                 } catch (Exception e) {
	                    e.printStackTrace();
	                 }

					dispose();
	    			FirstFrame np = new FirstFrame();
	    			np.setVisible(true);
				}
			}
		});
		HSubmit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		HSubmit.setBounds(483, 286, 170, 42);
		contentPane.add(HSubmit);
	    
	    JLabel lblNewLabel_3 = new JLabel("Hospital Name: ");
	    lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblNewLabel_3.setBounds(52, 556, 153, 33);
	    contentPane.add(lblNewLabel_3);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setBorder(new TitledBorder(null, "Hospital Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel.setBounds(10, 11, 502, 254);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lbl_Hn = new JLabel("Hospital Name:");
	    lbl_Hn.setForeground(Color.BLACK);
	    lbl_Hn.setBounds(22, 21, 153, 34);
	    panel.add(lbl_Hn);
	    lbl_Hn.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    
	    t_Hn = new JTextField();
	    t_Hn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    t_Hn.setBounds(186, 21, 245, 38);
	    panel.add(t_Hn);
	    t_Hn.setColumns(10);
	    
	    JLabel lblNewLabel = new JLabel("Phone Number:");
	    lblNewLabel.setForeground(Color.BLACK);
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    lblNewLabel.setBounds(22, 79, 136, 26);
	    panel.add(lblNewLabel);
	    
	    txt_pno = new JTextField();
	    txt_pno.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    txt_pno.setBounds(186, 69, 245, 42);
	    panel.add(txt_pno);
	    txt_pno.setColumns(10);
	    txt_pno.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	           
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9' || ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	txt_pno.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
	    
	    JLabel lbl_Haddr = new JLabel("Hospital Address:");
	    lbl_Haddr.setForeground(Color.BLACK);
	    lbl_Haddr.setBounds(22, 135, 153, 24);
	    panel.add(lbl_Haddr);
	    lbl_Haddr.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    
	    t_Haddr = new JTextField();
	    t_Haddr.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    t_Haddr.setBounds(186, 121, 245, 57);
	    panel.add(t_Haddr);
	    t_Haddr.setColumns(10);
	    
	    JLabel lblNewLabel_4 = new JLabel("Hospital Code: ");
	    lblNewLabel_4.setForeground(Color.BLACK);
	    lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    lblNewLabel_4.setBounds(22, 198, 146, 24);
	    panel.add(lblNewLabel_4);
	    
	    txt_Hc = new JTextField();
	    txt_Hc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	    txt_Hc.setBounds(186, 194, 245, 34);
	    panel.add(txt_Hc);
	    txt_Hc.setColumns(10);
	    txt_Hc.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9'|| ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	txt_Hc.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(255, 255, 255));
	    panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel_2.setBounds(10, 338, 1258, 400);
	    contentPane.add(panel_2);
	    panel_2.setLayout(null);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
	    label.setBounds(1103, 96, 129, 213);
	    panel_2.add(label);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setLayout(null);
	    panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Requirement Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel_1.setBounds(538, 11, 730, 254);
	    contentPane.add(panel_1);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Blood Type:");
	    lblNewLabel_2_1.setForeground(Color.BLACK);
	    lblNewLabel_2_1.setBounds(33, 30, 109, 22);
	    panel_1.add(lblNewLabel_2_1);
	    lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    
	    JLabel lblNewLabel_2 = new JLabel("Priority: ");
	    lblNewLabel_2.setForeground(Color.BLACK);
	    lblNewLabel_2.setBounds(33, 85, 87, 24);
	    panel_1.add(lblNewLabel_2);
	    lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    
	    JLabel lblNewLabel_1 = new JLabel("(In mL)");
	    lblNewLabel_1.setForeground(Color.BLACK);
	    lblNewLabel_1.setBounds(33, 161, 82, 20);
	    panel_1.add(lblNewLabel_1);
	    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Quantity :");
	    lblNewLabel_2_2.setForeground(Color.BLACK);
	    lblNewLabel_2_2.setBounds(33, 122, 98, 39);
	    panel_1.add(lblNewLabel_2_2);
	    lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    
	     t_Q = new JTextField();
	     t_Q.setBounds(175, 127, 167, 34);
	     panel_1.add(t_Q);
	     t_Q.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	     t_Q.setColumns(10);
	     
	    
	     rb_U.setBounds(175, 86, 109, 23);
	     panel_1.add(rb_U);
	     rb_U.setBackground(Color.WHITE);
	     rb_U.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group1.add(rb_U);
	     
	     
	     
	     
	     rb_N.setBounds(286, 86, 120, 23);
	     panel_1.add(rb_N);
	     rb_N.setBackground(Color.WHITE);
	     rb_N.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group1.add(rb_N);
	     
	     
	     cb_Ap.setBounds(175, 31, 63, 20);
	     panel_1.add(cb_Ap);
	     cb_Ap.setBackground(Color.WHITE);
	     cb_Ap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_Ap);
	     
	    
	     cb_Bp.setBounds(240, 31, 63, 20);
	     panel_1.add(cb_Bp);
	     cb_Bp.setBackground(Color.WHITE);
	     cb_Bp.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_Bp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_Bp);
	     
	     
	     cb_ABp.setBounds(305, 31, 63, 20);
	     panel_1.add(cb_ABp);
	     cb_ABp.setBackground(Color.WHITE);
	     cb_ABp.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_ABp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_ABp);
	     
	     
	     cb_An.setBounds(384, 31, 63, 20);
	     panel_1.add(cb_An);
	     cb_An.setBackground(Color.WHITE);
	     cb_An.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_An.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_An);
	     
	   
	     cb_Bn.setBounds(449, 31, 63, 20);
	     panel_1.add(cb_Bn);
	     cb_Bn.setBackground(Color.WHITE);
	     cb_Bn.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_Bn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_Bn);
	     
	    
	     cb_ABn.setBounds(514, 31, 63, 20);
	     panel_1.add(cb_ABn);
	     cb_ABn.setBackground(Color.WHITE);
	     cb_ABn.setHorizontalAlignment(SwingConstants.CENTER);
	     cb_ABn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_ABn);
	     
	     
	     cb_Op.setBounds(596, 31, 63, 20);
	     panel_1.add(cb_Op);
	     cb_Op.setBackground(Color.WHITE);
	     cb_Op.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_Op.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_Op);
	     
	     
	     cb_On.setBounds(661, 31, 63, 20);
	     panel_1.add(cb_On);
	     cb_On.setBackground(Color.WHITE);
	     cb_On.setHorizontalAlignment(SwingConstants.LEFT);
	     cb_On.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	     group2.add(cb_On);
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
	    
	   
	    
	    JLabel lbl_Hname = new JLabel("");
	    lbl_Hname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lbl_Hname.setBounds(334, 568, 179, 21);
	   
	}
}



