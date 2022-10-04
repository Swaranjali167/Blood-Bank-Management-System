
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class OptionForm extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionForm frame = new OptionForm();
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
	public OptionForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 700);;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton b_H = new JButton("Hospital");
		b_H.setForeground(new Color(0, 0, 0));
		b_H.setBackground(new Color(255, 160, 122));
		b_H.setBounds(181, 332, 211, 74);
		b_H.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hospital_Details hd = new Hospital_Details();
				hd.setVisible(true);				
			}
		});
		contentPane.setLayout(null);
		b_H.setFont(new Font("Times New Roman", Font.BOLD, 32));
		contentPane.add(b_H);
		
		JButton B_P = new JButton("Patient");
		B_P.setForeground(new Color(0, 0, 0));
		B_P.setBackground(new Color(255, 160, 122));
		B_P.setBounds(601, 332, 211, 74);
		B_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					Patient_Details pd = new Patient_Details();
					pd.setVisible(true);
				}
			
		});
		B_P.setFont(new Font("Times New Roman", Font.BOLD, 32));
		contentPane.add(B_P);
		
		JLabel lblSelectUser = new JLabel("Select User:");
		lblSelectUser.setForeground(new Color(0, 0, 0));
		lblSelectUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectUser.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblSelectUser.setBounds(369, 244, 277, 51);
		contentPane.add(lblSelectUser);
		
		JLabel imglbl = new JLabel("");
		imglbl.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
		imglbl.setBounds(864, 440, 111, 191);
		contentPane.add(imglbl);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-11 130136 (1).jpg"));
		label.setBounds(416, 42, 164, 165);
		contentPane.add(label);
	}

	}
















