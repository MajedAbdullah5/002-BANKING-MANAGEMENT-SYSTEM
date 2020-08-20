package Banking_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class admin_authentication extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
           

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_authentication frame = new admin_authentication();
					frame.setTitle("Admin authentication");
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
	public admin_authentication() {
		conn = null;
		ps = null;
		rs = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		textField = new JTextField();
		textField.setToolTipText("Collect usernmae from developer");
		textField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Collect password from developer");
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -286, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_1);
		textField_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = ConnectionDB.connect();
				String sql="select * from admin";
				try {
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						String username = rs.getString("ausername");
						String password = rs.getString("apassword");
						if((textField.getText().equals("")) || (textField_1.getText().equals(""))) {
							JOptionPane.showMessageDialog(null, "Empty input!");
						}
						else {
							if(!(textField.getText().equals(username)) && !(textField_1.getText().equals(password))) {
								JOptionPane.showMessageDialog(null, "Enter correct input!");
							}else{
								Admin ad = new Admin();							
								ad.setVisible(true);
								
//								Admin ad = new Admin();
//								ad.setVisible(true);
							}
						}
						
				
				
				}
			}
				 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
	
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 562, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, textField);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-enter-30.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 361, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_2, -53, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 33, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -127, SpringLayout.SOUTH, panel);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startup st = new Startup();
				st.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-back-20.png"));
		panel.add(btnNewButton_2);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 118, SpringLayout.SOUTH, lblAdminLogin);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblAdminLogin, -350, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblAdminLogin, 196, SpringLayout.WEST, panel);
		lblAdminLogin.setFont(new Font("Lucida Sans", Font.PLAIN, 36));
		panel.add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -545, SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 27, SpringLayout.EAST, lblPassword);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -49, SpringLayout.NORTH, lblPassword);
		sl_panel.putConstraint(SpringLayout.NORTH, lblPassword, 5, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblPassword, -545, SpringLayout.EAST, panel);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblPassword);
		
		JLabel lblCollectYourUsername = new JLabel("Collect your username and password from developer");
		lblCollectYourUsername.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCollectYourUsername, 52, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblCollectYourUsername, 0, SpringLayout.WEST, btnNewButton_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblCollectYourUsername, 0, SpringLayout.EAST, textField);
		lblCollectYourUsername.setForeground(Color.RED);
		panel.add(lblCollectYourUsername);
	}
}
