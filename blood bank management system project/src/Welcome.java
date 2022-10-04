
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 673);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headlbl = new JLabel("Welcome!");
		headlbl.setForeground(new Color(0, 0, 0));
		headlbl.setFont(new Font("Times New Roman", Font.PLAIN, 44));
		headlbl.setBounds(270, 118, 297, 79);
		contentPane.add(headlbl);
		
		JLabel pt1lbl = new JLabel("Your Blood is safe with us.");
		pt1lbl.setForeground(Color.BLACK);
		pt1lbl.setFont(new Font("Times New Roman", Font.BOLD, 19));
		pt1lbl.setBounds(242, 230, 291, 41);
		contentPane.add(pt1lbl);
		
		JLabel line1lbl = new JLabel("We ensure safety precautions when");
		line1lbl.setForeground(Color.BLACK);
		line1lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		line1lbl.setBounds(242, 263, 291, 32);
		contentPane.add(line1lbl);
		
		JLabel line2lbl = new JLabel("receiving blood from the donors.");
		line2lbl.setForeground(Color.BLACK);
		line2lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		line2lbl.setBounds(242, 291, 276, 24);
		contentPane.add(line2lbl);
		
		JLabel label = new JLabel("1.");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(211, 239, 21, 24);
		contentPane.add(label);
		
		JLabel pt2lbl = new JLabel("Your data is safe with us.");
		pt2lbl.setForeground(Color.BLACK);
		pt2lbl.setFont(new Font("Times New Roman", Font.BOLD, 19));
		pt2lbl.setBounds(242, 394, 276, 32);
		contentPane.add(pt2lbl);
		
		JLabel ln1lbl = new JLabel("Information that you provide is");
		ln1lbl.setForeground(Color.BLACK);
		ln1lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ln1lbl.setBounds(242, 423, 276, 24);
		contentPane.add(ln1lbl);
		
		JLabel ln2lbl = new JLabel("is safe in our database and is");
		ln2lbl.setForeground(Color.BLACK);
		ln2lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ln2lbl.setBounds(242, 444, 244, 24);
		contentPane.add(ln2lbl);
		
		JLabel ln3lbl = new JLabel("not shared with anyone without ");
		ln3lbl.setForeground(Color.BLACK);
		ln3lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ln3lbl.setBounds(242, 467, 247, 24);
		contentPane.add(ln3lbl);
		
		JLabel ln4lbl = new JLabel("your permission.");
		ln4lbl.setForeground(Color.BLACK);
		ln4lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ln4lbl.setBounds(242, 489, 244, 24);
		contentPane.add(ln4lbl);
		
		JLabel lblNewLabel_7 = new JLabel("2.");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(211, 404, 21, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel linelbl = new JLabel("Before using the interface, please read the terms and conditions :");
		linelbl.setForeground(Color.BLACK);
		linelbl.setBounds(135, 194, 541, 25);
		contentPane.add(linelbl);
		linelbl.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		
		JCheckBox chktc = new JCheckBox("I accept the terms and conditions.");
		chktc.setForeground(Color.BLACK);
		chktc.setBackground(new Color(255, 255, 255));
		chktc.setFont(new Font("Times New Roman", Font.BOLD, 21));
		chktc.setBounds(192, 526, 333, 32);
		contentPane.add(chktc);
		
		JButton contbtn = new JButton("Continue");
		contbtn.setForeground(Color.WHITE);
		contbtn.setBackground(Color.DARK_GRAY);
		contbtn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chktc.isSelected() == false)
				{
					JOptionPane.showMessageDialog(null, "Kindly agree to the Terms and Conditions.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Welcome!");
					dispose();
					FirstFrame f= new FirstFrame();
					f.setVisible(true);
				}
				
			}
		});
		contbtn.setBounds(270, 570, 154, 43);
		contentPane.add(contbtn);
		
		JLabel line3lbl = new JLabel("The donated blood is not being");
		line3lbl.setForeground(Color.BLACK);
		line3lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		line3lbl.setBounds(242, 313, 276, 24);
		contentPane.add(line3lbl);
		
		JLabel line4lbl = new JLabel("misused and is delivered with");
		line4lbl.setForeground(Color.BLACK);
		line4lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		line4lbl.setBounds(242, 336, 276, 24);
		contentPane.add(line4lbl);
		
		JLabel line5lbl = new JLabel("full transparency to those in need.");
		line5lbl.setForeground(Color.BLACK);
		line5lbl.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		line5lbl.setBounds(242, 358, 276, 24);
		contentPane.add(line5lbl);
		
		JLabel imglbl = new JLabel("");
		imglbl.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot_2020-12-11_112340_4_50 (1).jpg"));
		imglbl.setBounds(211, 30, 339, 108);
		contentPane.add(imglbl);
	}
}













