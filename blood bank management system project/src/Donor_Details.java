
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
public class Donor_Details extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Dage;
	private JTextField Dpno;
	private JTextField Daddr;

	/**
	 * Launch the application.
	 */
	 JFrame frame;
	private JTextField Dname;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor_Details frame = new Donor_Details();
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
	public Donor_Details() {
		setTitle("Donor Details");
		setBackground(UIManager.getColor("Button.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font f1=new Font("Times New Roman",Font.PLAIN,19);
		Dage = new JTextField();
		Dage.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		 Dage.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	           
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9' || ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	Dage.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
		Dage.setBackground(Color.WHITE);
		Dage.setBounds(190, 101, 273, 32);
		contentPane.add(Dage);
		Dage.setColumns(10);
		
		Dpno = new JTextField();
		Dpno.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Dpno.setBackground(Color.WHITE);
		Dpno.setBounds(190, 203, 273, 32);
		contentPane.add(Dpno);
		Dpno.setColumns(10);
		Dpno.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke3) 
	         {
	            if (ke3.getKeyChar() >= '0' && ke3.getKeyChar() <= '9' || ke3.getKeyCode()  == KeyEvent.VK_BACK_SPACE) 
	            {
	            	Dpno.setEditable(true);	                    
	            } 
	            else 
	            {	               
	            	JOptionPane.showMessageDialog(null, "Invalid Input");
	            }
	         }
	      });
		
		JLabel AgeLabel2 = new JLabel("Age:");
		AgeLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AgeLabel2.setBounds(39, 102, 65, 29);
		contentPane.add(AgeLabel2);
		
		JLabel DonorAddLabel4 = new JLabel("Address:");
		DonorAddLabel4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DonorAddLabel4.setBounds(39, 267, 138, 29);
		contentPane.add(DonorAddLabel4);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 255, 255));
		textArea_1.setBounds(39, 508, 620, 182);
		contentPane.add(textArea_1);
		
		JRadioButton rb1_M = new JRadioButton("Male");
		rb1_M.setBackground(new Color(255, 255, 255));
		rb1_M.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb1_M.setBounds(196, 149, 109, 23);
		contentPane.add(rb1_M);
		
		JRadioButton rb2_F = new JRadioButton("Female");
		rb2_F.setBackground(new Color(255, 255, 255));
		rb2_F.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb2_F.setBounds(334, 146, 109, 23);
		contentPane.add(rb2_F);
		
		JRadioButton rb3_O = new JRadioButton("Other");
		rb3_O.setBackground(Color.WHITE);
		rb3_O.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb3_O.setBounds(496, 136, 103, 21);
		
		 ButtonGroup group1 = new ButtonGroup();
	     group1.add(rb1_M);
	     group1.add(rb2_F);
	     group1.add(rb3_O);
		
		JLabel lbl_rbt = new JLabel("Blood Type:");
		lbl_rbt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_rbt.setBounds(39, 378, 138, 49);
		contentPane.add(lbl_rbt);
		
		JRadioButton rb_Ap = new JRadioButton("A+");
		rb_Ap.setBackground(new Color(255, 255, 255));
		rb_Ap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Ap.setBounds(190, 391, 60, 23);
		contentPane.add(rb_Ap);
		
		JRadioButton rb_An = new JRadioButton("A-");
		rb_An.setBackground(new Color(255, 255, 255));
		rb_An.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_An.setBounds(252, 391, 60, 23);
		contentPane.add(rb_An);
		
		JRadioButton rb_Bp = new JRadioButton("B+");
		rb_Bp.setBackground(new Color(255, 255, 255));
		rb_Bp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Bp.setBounds(314, 391, 60, 23);
		contentPane.add(rb_Bp);
		
		JRadioButton rb_Bn = new JRadioButton("B-");
		rb_Bn.setBackground(new Color(255, 255, 255));
		rb_Bn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Bn.setBounds(376, 391, 60, 23);
		contentPane.add(rb_Bn);
		
		JRadioButton rb_ABp = new JRadioButton("AB+");
		rb_ABp.setBackground(new Color(255, 255, 255));
		rb_ABp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_ABp.setBounds(438, 391, 65, 23);
		contentPane.add(rb_ABp);
		
		JRadioButton rb_ABn = new JRadioButton("AB-");
		rb_ABn.setBackground(new Color(255, 255, 255));
		rb_ABn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_ABn.setBounds(517, 391, 60, 23);
		contentPane.add(rb_ABn);
		
		JRadioButton rb_Op = new JRadioButton("O+");
		rb_Op.setBackground(new Color(255, 255, 255));
		rb_Op.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_Op.setBounds(593, 391, 60, 23);
		contentPane.add(rb_Op);
		
		JRadioButton rb_On = new JRadioButton("O-");
		rb_On.setBackground(new Color(255, 255, 255));
		rb_On.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rb_On.setBounds(655, 391, 60, 23);
		contentPane.add(rb_On);
		 ButtonGroup group2 = new ButtonGroup();
	     group2.add(rb_Ap);
	     group2.add(rb_Bp);
	     group2.add(rb_ABp);
	     group2.add(rb_An);
	     group2.add(rb_Bn);
	     group2.add(rb_ABn);
	     group2.add(rb_Op);
	     group2.add(rb_On);
		
        JButton SubmitBtn = new JButton("Submit");
        SubmitBtn.setForeground(Color.WHITE);
		SubmitBtn.setBackground(Color.DARK_GRAY);
		SubmitBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Dname.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Kindly input Donor Name");
				}
				else if(Dage.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Kindly input Donor Age");
				}
				else if(rb1_M.isSelected()==false && rb2_F.isSelected()==false && rb3_O.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Gender");
	     		}
				else if(Dpno.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Kindly input phone number");
				}
           		else if(Daddr.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Kindly input donor address");
				}
           		else if(rb_Ap.isSelected()==false && rb_Bp.isSelected()==false && rb_ABp.isSelected()==false && rb_An.isSelected()==false && rb_Bn.isSelected()==false && rb_ABn.isSelected()==false && rb_Op.isSelected()==false && rb_On.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select the Required Blood Type");
	     		}
				else 
				{
				String D_name = Dname.getText();
			    long   D_age = Long.parseLong(Dage.getText());
				String D_addr = Daddr.getText();
				long  D_pno = Long.parseLong(Dpno.getText());
				String D_g ="";
				String D_bt=""; 
				if(rb1_M.isSelected())
				{
					D_g="Male";
				}
				else if(rb2_F.isSelected())
				{
					D_g="Female";
				}
				else if(rb3_O.isSelected())
				{
					D_g="Other";
				}
				if(rb_Ap.isSelected())
				{
					D_bt="A+";
				}
				if(rb_An.isSelected())
				{
					D_bt="A-";
				}
				 if(rb_Bp.isSelected())
				{
					 D_bt="B+";
				}
				 if(rb_Bn.isSelected())
				{
					 D_bt="B-";
				}
				 if(rb_ABp.isSelected())
				{
					 D_bt="AB+";
				}
				 if(rb_ABn.isSelected())
				{
					 D_bt="AB-";
				}
				 if(rb_Op.isSelected())
				{
					 D_bt= "O+";
				}
				if(rb_On.isSelected())
				{
					D_bt="O-";
				}
				textArea_1.setFont(f1);
				textArea_1.setText("\nDonor Name: "+D_name+"\nDonor Age: "+D_age+"\nGender: "+D_g+"\nDonor Address: "+D_addr+"\nDonor PhoneNo: "+D_pno+"\nBlood Type: "+D_bt);
				ImageIcon i = new ImageIcon("thank you.jpg");
				JOptionPane.showMessageDialog(null,"Your records have successfully been saved.","",JOptionPane.INFORMATION_MESSAGE,i);
				try {
					Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank","Swara","#Swaranjali17" );                    
                    if (conn != null) {
                       System.out.println("Connected successfully.");
                   } else {
                       System.out.println("Failed to make connection!");
                   }
                   String query="insert into donor(donor_name, sex, age,  address, bloodtype) values('"+ D_name +"','" + D_g +"','"+ D_age +"',' "+D_addr +" ','"+D_bt+"')";
                   String query1="insert into d_phone(phone_no) values('"+ D_pno +"')";
                   String query2 = "Update stock set Quantity = (Quantity + 425) where Bloodtype = '"+D_bt+"'";   
                   
               	Statement statement= conn.createStatement();
               	statement.executeUpdate(query);
               	statement.executeUpdate(query1);
               	statement.executeUpdate(query2);
               	System.out.println("Values inserted successfully");
                   conn.close();
               } catch (Exception e1) {
                  e1.printStackTrace();
               }

				dispose();
				FirstFrame p = new FirstFrame();
				p.setVisible(true);
				}
			}
		});
		
		SubmitBtn.setBounds(228, 432, 146, 41);
		contentPane.add(SubmitBtn);
		
		JLabel PhonenoLabel5 = new JLabel("Phone number:");
		PhonenoLabel5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PhonenoLabel5.setBounds(39, 205, 138, 23);
		contentPane.add(PhonenoLabel5);
		
		Daddr = new JTextField();
		Daddr.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Daddr.setBounds(190, 276, 273, 91);
		contentPane.add(Daddr);
		Daddr.setColumns(10);
		
		JLabel NameLabel1 = new JLabel("Name:");
		NameLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		NameLabel1.setBounds(39, 52, 79, 29);
		contentPane.add(NameLabel1);
		
		Dname = new JTextField();
		Dname.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Dname.setBounds(190, 52, 273, 31);
		contentPane.add(Dname);
		Dname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGender.setBounds(39, 142, 73, 30);
		contentPane.add(lblGender);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "Donor Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 866, 472);
		contentPane.add(panel);
		panel.setLayout(null);
	
		panel.add(rb3_O);
		

		
		JPanel Details_Panel2 = new JPanel();
		Details_Panel2.setBackground(new Color(255, 255, 255));
		Details_Panel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Saved Donor Details", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Details_Panel2.setBounds(10, 484, 866, 219);
		contentPane.add(Details_Panel2);
		Details_Panel2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(726, 18, 116, 191);
		label.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
		Details_Panel2.add(label);
			
	}
}














