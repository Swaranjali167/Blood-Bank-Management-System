import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Color;


public class Staff extends JFrame {

	protected static final String String = null;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTable table_1;
	private JTable table1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Staff frame = new Staff();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Staff() 
	{
		Font f1=new Font("Times New Roman",Font.PLAIN,17);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(18, 11, 568, 555);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Check Blood Type Availability", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Blood Type:");
		lblNewLabel.setBounds(43, 52, 230, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBounds(204, 110, 145, 35);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		panel.add(btnNewButton);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBox.setBounds(324, 58, 191, 31);
		comboBox.setBackground(Color.WHITE);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		
	
 			
		btnNewButton.addActionListener(new ActionListener() {
		
	
			public void actionPerformed(ActionEvent arg0) {
				String o="";
				o=(String) comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank","Swara","#Swaranjali17" );                   
 
                    if (conn != null) {
                         System.out.println("Connected successfully.");
                     } else {
                         System.out.println("Failed to make connection!");
                     }
                    if(o==" ")
                    {
                    	JOptionPane.showMessageDialog(null, "Kindly select a BloodType");
                    }
                   
                   else {
                   if(o=="A+")
                   {
                       String query="Select * from bloodchkAp;" ; 
                       PreparedStatement pst = conn.prepareStatement(query);
     			       ResultSet rs = pst.executeQuery();
     			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="A-")
                   {
                	   String query="Select * from bloodchkAn;" ; 
                       PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="B+")
                   {
                	   String query="Select * from bloodchkBp;" ; 
                       PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="B-")
                   {
                	   String query="Select * from bloodchkBn;" ; 
                   	   PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="AB+")
                   {
                	   String query="Select * from bloodchkABp;" ; 
                	   PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="AB-")
                   {
                	   String query="Select * from bloodchkABn;" ;
                	   PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="O+")
                   {
                	   String query="Select * from bloodchkOp;" ; 
                   	   PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   else if(o=="O-")
                   {
                	   String query="Select * from bloodchkOn;" ; 
                   	   PreparedStatement pst = conn.prepareStatement(query);
      			       ResultSet rs = pst.executeQuery();
      			       table.setModel(DbUtils.resultSetToTableModel(rs));
                   }
                   
                  
           		
                   String query = "Select * from stock;";
                   PreparedStatement pst = conn.prepareStatement(query);
  			       ResultSet rs = pst.executeQuery();
  			       table1.setModel(DbUtils.resultSetToTableModel(rs));
  			       table1.setFont(f1);
                    }
               	System.out.println("Values inserted successfully");
                   conn.close();
               } catch (Exception e1) 
  	            {
                  e1.printStackTrace();
               }

	        }
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 156, 444, 330);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Stock", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 160, 513, 151);
		panel_1.add(scrollPane_1);
		
		table1 = new JTable();
		scrollPane_1.setViewportView(table1);
}
}

