


import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Donor_Eligibility extends JFrame {

	private JPanel contentPane;
	private JTextField JTextField2_Name;
	private JRadioButton Yes_Radio;
	private JRadioButton No_Radio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor_Eligibility frame = new Donor_Eligibility();
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
	public Donor_Eligibility() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 681);
		
		 contentPane = new JPanel();
		 contentPane.setBackground(Color.WHITE);
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 JRadioButton Yes_Radio_1 = new JRadioButton("Yes");
		
		 JLabel Name_Label = new JLabel("Name:");
		 Name_Label.setHorizontalAlignment(SwingConstants.LEFT);
		 Name_Label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		 Name_Label.setBounds(72, 77, 85, 40);
		 contentPane.add(Name_Label);
		
		 JRadioButton rb_Ay = new JRadioButton("Yes");
		 rb_Ay.setBackground(Color.WHITE);
		 rb_Ay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 rb_Ay.setBounds(418, 256, 95, 23);
		 contentPane.add(rb_Ay);
		
		 JRadioButton rb_An = new JRadioButton("No");
		 rb_An.setBackground(Color.WHITE);
		 rb_An.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 rb_An.setBounds(571, 256, 95, 23);
		 contentPane.add(rb_An);
		 ButtonGroup group1 = new ButtonGroup();
	     group1.add(rb_Ay);
	     group1.add(rb_An);
	     
	     JRadioButton rb_My = new JRadioButton("Yes");
	     rb_My.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 rb_My.setBackground(Color.WHITE);
		 rb_My.setBounds(407, 429, 95, 23);
			
		 JRadioButton rb_Mn = new JRadioButton("No");
		 rb_Mn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 rb_Mn.setBackground(Color.WHITE);
		 rb_Mn.setBounds(565, 429, 103, 23);
			

	     
	     ButtonGroup group2 = new ButtonGroup();
	     ButtonGroup group3 = new ButtonGroup();
	     group3.add(rb_Mn);
	     group3.add(rb_My);
		
		JLabel lblNewLabel = new JLabel("Medical History:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(72, 174, 179, 23);
		contentPane.add(lblNewLabel);
		
		JLabel Tatto_Label_1 = new JLabel("Are you above the age of 18?");
		Tatto_Label_1.setHorizontalAlignment(SwingConstants.LEFT);
		Tatto_Label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Tatto_Label_1.setBounds(72, 253, 286, 27);
		contentPane.add(Tatto_Label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Eligibilty Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 0, 743, 634);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Yes_Radio_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		group2.add(Yes_Radio_1);
		
		JRadioButton No_Radio_1 = new JRadioButton("No");
		No_Radio_1.setBackground(Color.WHITE);
		No_Radio_1.setBounds(565, 338, 103, 23);
		panel.add(No_Radio_1);
		No_Radio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(No_Radio_1.isSelected())
				{
					Yes_Radio_1.setSelected(false);
				}
			}
		});
		No_Radio_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		group2.add(No_Radio_1);
		
		JTextField2_Name = new JTextField();
		JTextField2_Name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JTextField2_Name.setBounds(339, 80, 302, 36);
		panel.add(JTextField2_Name);
		JTextField2_Name.setColumns(10);
		JComboBox MedHis = new JComboBox();
		MedHis.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		MedHis.setBackground(Color.WHITE);
		MedHis.setBounds(339, 169, 302, 36);
		panel.add(MedHis);
		MedHis.setModel(new DefaultComboBoxModel(new String[] {"", "Diabetes", "Cholestrol", "Cancer", "HIV", "High Blood Pressure", "None"}));
		
		
		
		JButton Submit_Btn = new JButton("Submit");
		Submit_Btn.setBounds(289, 520, 117, 47);
		panel.add(Submit_Btn);
		Submit_Btn.setForeground(Color.WHITE);
		Submit_Btn.setBackground(Color.DARK_GRAY);
		Submit_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTextField2_Name.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Kindly input Donor Name");
				}

				else if(rb_An.isSelected()==false && rb_Ay.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Valid Option");
	     		}
							
				else if(MedHis.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Kindly Select a Valid Option");
				}
				
				else if(Yes_Radio_1.isSelected()==false && No_Radio_1.isSelected()==false)
		     		{
		     			JOptionPane.showMessageDialog(null, "Kindly Select a Valid Option");
		     		}
				else if(rb_Mn.isSelected()==false && rb_My.isSelected()==false)
	     		{
	     			JOptionPane.showMessageDialog(null, "Kindly Select a Valid Option");
	     		}
				else if(MedHis.getSelectedIndex()==1 || MedHis.getSelectedIndex()==2 || MedHis.getSelectedIndex()==3 || MedHis.getSelectedIndex()==4 || MedHis.getSelectedIndex()==5 )
				{
					JOptionPane.showMessageDialog(null,"Not Eligible to Donate Blood");
					dispose();
					FirstFrame p = new FirstFrame();
					p.setVisible(true);
				}
				else if(rb_An.isSelected()) 
				{
					JOptionPane.showMessageDialog(null,"Not Eligible to Donate Blood");
					dispose();
					FirstFrame p = new FirstFrame();
					p.setVisible(true);
				}
				else if(Yes_Radio_1.isSelected())
				{
					JOptionPane.showMessageDialog(null,"Not Eligible to Donate Blood");
					dispose();
					FirstFrame p = new FirstFrame();
					p.setVisible(true);
				}
				else if(rb_My.isSelected()) 
				{
				   JOptionPane.showMessageDialog(null,"Not Eligible to Donate Blood");
				   dispose();
				   FirstFrame p = new FirstFrame();
				   p.setVisible(true);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "You are Eligible to donate Blood!");
				dispose();
				Donor_Details d = new Donor_Details();
				d.setVisible(true);
				}
			}
		});
		Submit_Btn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel Tatto_Label = new JLabel("Did you get inked in the ");
		Tatto_Label.setBounds(62, 335, 256, 27);
		panel.add(Tatto_Label);
		Tatto_Label.setHorizontalAlignment(SwingConstants.LEFT);
		Tatto_Label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		
		Yes_Radio_1.setBackground(Color.WHITE);
		Yes_Radio_1.setBounds(407, 338, 95, 23);
		panel.add(Yes_Radio_1);
		Yes_Radio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Yes_Radio_1.isSelected())
				{
					No_Radio_1.setSelected(false);
				}
			}
		});
		
		JLabel imglbl = new JLabel("");
		imglbl.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
		imglbl.setBounds(624, 439, 109, 185);
		panel.add(imglbl);
		
		JLabel lblNewLabel_1 = new JLabel("last 12 months?");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(62, 359, 186, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Are you undergoing");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(62, 416, 217, 47);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" any medications?");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(54, 454, 195, 36);
		panel.add(lblNewLabel_3);
		
		panel.add(rb_My);
		panel.add(rb_Mn);
		
		
	
		
	}
}














