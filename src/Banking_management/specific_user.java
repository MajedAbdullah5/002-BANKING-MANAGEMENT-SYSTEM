package Banking_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import Banking_management.ConnectionDB;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Cursor;
public class specific_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	String address;
	private JTextField textField_11;
	private JTextField textField_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					specific_user frame = new specific_user();
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
	public specific_user() {
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
		panel.setToolTipText("");
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setToolTipText("Account No");
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchUser = new JLabel("Search user: ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSearchUser, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblSearchUser, -257, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblSearchUser);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblSearchUser);
		lblSearchUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblSearchUser);
		
		JLabel lblFindSpecficUser = new JLabel("Find specfic user details");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFindSpecficUser, 26, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFindSpecficUser, 21, SpringLayout.WEST, panel);
		lblFindSpecficUser.setFont(new Font("Verdana", Font.BOLD, 30));
		panel.add(lblFindSpecficUser);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -371, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setFocusTraversalPolicyProvider(true);
		panel.add(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_9.setColumns(10);
		
//		textField_9 = new JTextField();
//		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		textField_9.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Account No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Date of birth:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Account type:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("Nationality:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("Caste:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("Micr No:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_7 = new JLabel("Gender:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_8 = new JLabel("Mobile:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_11.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_9.setEditable(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-edit-26.png"));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null, "Do you want to update?","Update user",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_NO_OPTION) {
				String sql = "update account set acc=?, name=?, caste=?,micr_no=?,mobile=? where acc=?";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(6, textField.getText());
					ps.setString(1, textField_1.getText());
					ps.setString(2, textField_2.getText());
					ps.setString(3, textField_6.getText());
					ps.setString(4, textField_7.getText());
					ps.setString(5, textField_9.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Successfull!");
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Updated failed!");
					e1.printStackTrace();
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Update Successfully!");
				}
				
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-save-25.png"));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(137)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(textField_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
					.addGap(199)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_8))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(textField_6, Alignment.TRAILING)
						.addComponent(textField_7, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(textField_10)
						.addComponent(textField_8))
					.addGap(73))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBalance)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 585, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(18)
					.addComponent(btnSave)
					.addGap(28))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBalance))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2)
							.addComponent(btnSave)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6))))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(23))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Arraylist();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 2, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 48, SpringLayout.NORTH, panel);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-eye-30.png"));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin ad = new Admin();
				ad.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-back-20.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, panel);
		panel.add(btnNewButton_1);
		
	}
	public void Arraylist() throws SQLException{
		conn = ConnectionDB.connect();
		String sql = "select * from account where acc = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, textField.getText());
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String acc = rs.getString("acc");
			String name = rs.getString("name");
			String dob = rs.getString("dob");
			String acc_type = rs.getString("acc_type");
			String nationality = rs.getString("nationality");
			String caste = rs.getString("caste");
			int micr = rs.getInt("micr_no");
			String gender = rs.getString("gender");
			int mobile = rs.getInt("mobile");
			address = rs.getString("address");
			int balance = rs.getInt("balance");
			
			textField_1.setText(acc);
			textField_2.setText(name);
			textField_3.setText(dob);
			textField_4.setText(acc_type);
			textField_5.setText(nationality);
			textField_6.setText(caste);
			textField_7.setText(String.valueOf(micr));
			textField_8.setText(gender);
			textField_9.setText(String.valueOf(mobile));			
			textField_10.setText(address);
			textField_11.setText(String.valueOf(balance));
			
			
			
			
//				textField_1.setText(rs.getString()),
//				textField_2.setText(rs.getString("name")),
//				textField_3.setText(rs.getString("acc_type")),
//				textField_4.setText(rs.getString("dob")),
//				textField_5.setText(rs.getString("nationality")),
//				textField_6.setText(rs.getString("caste")),
//				textField_7.setText(rs.getString("micr_no")),
//				textField_8.setText(rs.getString("gender")),
//				textField_9.setText(rs.getString("mobile")),
//				textField_10.setText(rs.getString("address")),
//				textField_11.setText(rs.getString("Balance")));
			
			
		}
		
		
		
		
	}
}
