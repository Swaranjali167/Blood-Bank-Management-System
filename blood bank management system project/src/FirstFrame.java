
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class FirstFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
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
	public FirstFrame() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 700);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(154, 59, 695, 416);
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
				
				JButton btnDonateBlood = new JButton("Donate Blood");
				btnDonateBlood.setForeground(new Color(0, 0, 0));
				btnDonateBlood.setBounds(10, 265, 252, 112);
				panel.add(btnDonateBlood);
				btnDonateBlood.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Donor_Eligibility De = new Donor_Eligibility();
						De.setVisible(true);
					}
				});
				btnDonateBlood.setFont(new Font("Times New Roman", Font.BOLD, 32));
				btnDonateBlood.setBackground(new Color(255, 160, 122));
				
				JButton btnRequestBlood = new JButton("Request Blood");
				btnRequestBlood.setForeground(new Color(0, 0, 0));
				btnRequestBlood.setBounds(431, 268, 240, 106);
				panel.add(btnRequestBlood);
				btnRequestBlood.setBackground(new Color(255, 160, 122));
				btnRequestBlood.setFont(new Font("Times New Roman", Font.BOLD, 32));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\saipa\\Downloads\\blood.jpg"));
				lblNewLabel.setBounds(203, 44, 365, 187);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
				
				JLabel label = new JLabel("");
				label.setBounds(37, 28, 64, 64);
				getContentPane().add(label);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
						Welcome w = new Welcome();
						w.setVisible(true);
					}
				});
				label.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\iconfinder_home_126572.png"));
				
				JLabel imglbl = new JLabel("");
				imglbl.setIcon(new ImageIcon("C:\\Users\\swara\\Downloads\\Screenshot 2020-12-10 214952 (1) (1).jpg"));
				imglbl.setBounds(875, 462, 116, 191);
				getContentPane().add(imglbl);
				btnRequestBlood.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						OptionForm op = new OptionForm();
						op.setVisible(true);
					}
				});
	}
}






