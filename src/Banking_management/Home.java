package Banking_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Home extends JFrame {
	

	private JPanel contentPane;
	Connection conn;
	ResultSet rs;
	PreparedStatement ps;
	private JTextField allTimeDate;
	private JTextField searchUser;
	private JTextField name;
	private JTextField dob;
	private JTextField nationality;
	private JTextField gender;
	private JTextField address;
	private JTextField accountno;
	private JTextField accounttype;
	private JTextField amount;
	private JTextField mobile;
	private JTextField secq;
	private JTextField depositText;
	private JTextField withdrawText;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel labelBalance;
	private JLabel labelBalance_1;
	private JLabel lblNewLabel_13;
	private JTable transTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setTitle("Banking Management");
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public Home() throws SQLException {
		conn = null;
		ps = null;
		rs = null;
		conn = (Connection) ConnectionDB.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		
		allTimeDate = new JTextField();
		allTimeDate.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.EAST, allTimeDate, -117, SpringLayout.EAST, panel);
		allTimeDate.setEditable(false);
		allTimeDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(allTimeDate);
		allTimeDate.setColumns(10);
		
		searchUser = new JTextField();
		searchUser.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, allTimeDate, 16, SpringLayout.SOUTH, searchUser);
		sl_panel.putConstraint(SpringLayout.NORTH, searchUser, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, searchUser, -411, SpringLayout.SOUTH, panel);
		searchUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(searchUser);
		searchUser.setColumns(10);
		//Calendar();
		
		JButton btnNewButton_1 = new JButton("");
		sl_panel.putConstraint(SpringLayout.EAST, searchUser, -10, SpringLayout.WEST, btnNewButton_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 48, SpringLayout.NORTH, panel);
		
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 889, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, panel);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-eye-30.png"));
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Banking Management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 32, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 84, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 447, SpringLayout.WEST, panel);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User name: ");
		sl_panel.putConstraint(SpringLayout.WEST, searchUser, 0, SpringLayout.EAST, lblUser);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUser, 21, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUser, 179, SpringLayout.EAST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblUser, -273, SpringLayout.EAST, panel);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblUser);
		
		JLabel lblDate = new JLabel("Date:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblUser, -12, SpringLayout.NORTH, lblDate);
		sl_panel.putConstraint(SpringLayout.WEST, allTimeDate, 6, SpringLayout.EAST, lblDate);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDate, 61, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblDate, 0, SpringLayout.WEST, lblUser);
		sl_panel.putConstraint(SpringLayout.EAST, lblDate, -279, SpringLayout.EAST, panel);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblDate);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		sl_panel.putConstraint(SpringLayout.SOUTH, allTimeDate, -27, SpringLayout.NORTH, tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDate, -30, SpringLayout.NORTH, tabbedPane);
		sl_panel.putConstraint(SpringLayout.NORTH, tabbedPane, -340, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, tabbedPane, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, panel);
		panel.add(tabbedPane);
		
		JPanel profile = new JPanel();
		profile.setToolTipText("");
		profile.setBackground(Color.WHITE);
		profile.setForeground(Color.BLACK);
		tabbedPane.addTab("Profile", null, profile, null);
		SpringLayout sl_profile = new SpringLayout();
		profile.setLayout(sl_profile);
		
		name = new JTextField();
		sl_profile.putConstraint(SpringLayout.NORTH, name, 28, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.EAST, name, 411, SpringLayout.WEST, profile);
		name.setEditable(false);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(name);
		name.setColumns(10);
		
		dob = new JTextField();
		sl_profile.putConstraint(SpringLayout.WEST, name, 0, SpringLayout.WEST, dob);
		sl_profile.putConstraint(SpringLayout.SOUTH, name, -18, SpringLayout.NORTH, dob);
		sl_profile.putConstraint(SpringLayout.EAST, dob, -590, SpringLayout.EAST, profile);
		dob.setEditable(false);
		dob.setHorizontalAlignment(SwingConstants.CENTER);
		dob.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(dob);
		dob.setColumns(10);
		
		nationality = new JTextField();
		sl_profile.putConstraint(SpringLayout.EAST, nationality, -590, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.NORTH, dob, -47, SpringLayout.NORTH, nationality);
		sl_profile.putConstraint(SpringLayout.SOUTH, dob, -19, SpringLayout.NORTH, nationality);
		sl_profile.putConstraint(SpringLayout.NORTH, nationality, 121, SpringLayout.NORTH, profile);
		nationality.setEditable(false);
		sl_profile.putConstraint(SpringLayout.SOUTH, nationality, -161, SpringLayout.SOUTH, profile);
		nationality.setHorizontalAlignment(SwingConstants.CENTER);
		nationality.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(nationality);
		nationality.setColumns(10);
		
		gender = new JTextField();
		sl_profile.putConstraint(SpringLayout.WEST, gender, 0, SpringLayout.WEST, name);
		gender.setEditable(false);
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(gender);
		gender.setColumns(10);
		
		address = new JTextField();
		sl_profile.putConstraint(SpringLayout.SOUTH, gender, -20, SpringLayout.NORTH, address);
		sl_profile.putConstraint(SpringLayout.EAST, address, -590, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.NORTH, address, 217, SpringLayout.NORTH, profile);
		address.setEditable(false);
		sl_profile.putConstraint(SpringLayout.SOUTH, address, -65, SpringLayout.SOUTH, profile);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(address);
		address.setColumns(10);
		
		accountno = new JTextField();
		sl_profile.putConstraint(SpringLayout.NORTH, accountno, 28, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.EAST, accountno, -174, SpringLayout.EAST, profile);
		accountno.setEditable(false);
		accountno.setHorizontalAlignment(SwingConstants.CENTER);
		accountno.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(accountno);
		accountno.setColumns(10);
		
		accounttype = new JTextField();
		sl_profile.putConstraint(SpringLayout.SOUTH, accountno, -18, SpringLayout.NORTH, accounttype);
		sl_profile.putConstraint(SpringLayout.NORTH, accounttype, 74, SpringLayout.NORTH, profile);
		accounttype.setEditable(false);
		accounttype.setHorizontalAlignment(SwingConstants.CENTER);
		accounttype.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(accounttype);
		accounttype.setColumns(10);
		
		amount = new JTextField();
		sl_profile.putConstraint(SpringLayout.EAST, amount, -174, SpringLayout.EAST, profile);
		amount.setEditable(false);
		sl_profile.putConstraint(SpringLayout.NORTH, amount, 121, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, accounttype, -19, SpringLayout.NORTH, amount);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(amount);
		amount.setColumns(10);
		
		mobile = new JTextField();
		sl_profile.putConstraint(SpringLayout.NORTH, gender, 0, SpringLayout.NORTH, mobile);
		sl_profile.putConstraint(SpringLayout.NORTH, mobile, 169, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.EAST, mobile, -174, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, amount, -20, SpringLayout.NORTH, mobile);
		mobile.setEditable(false);
		mobile.setHorizontalAlignment(SwingConstants.CENTER);
		mobile.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(mobile);
		mobile.setColumns(10);
		
		secq = new JTextField();
		sl_profile.putConstraint(SpringLayout.EAST, secq, -174, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, mobile, -20, SpringLayout.NORTH, secq);
		sl_profile.putConstraint(SpringLayout.NORTH, secq, 217, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, secq, -65, SpringLayout.SOUTH, profile);
		secq.setEditable(false);
		secq.setHorizontalAlignment(SwingConstants.CENTER);
		secq.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		profile.add(secq);
		secq.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		sl_profile.putConstraint(SpringLayout.WEST, lblName, 135, SpringLayout.WEST, profile);
		sl_profile.putConstraint(SpringLayout.EAST, lblName, -794, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.NORTH, lblName, 33, SpringLayout.NORTH, profile);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		sl_profile.putConstraint(SpringLayout.WEST, dob, 6, SpringLayout.EAST, lblDateOfBirth);
		sl_profile.putConstraint(SpringLayout.NORTH, lblDateOfBirth, 79, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblName, -26, SpringLayout.NORTH, lblDateOfBirth);
		sl_profile.putConstraint(SpringLayout.WEST, lblDateOfBirth, 102, SpringLayout.WEST, profile);
		sl_profile.putConstraint(SpringLayout.EAST, lblDateOfBirth, -794, SpringLayout.EAST, profile);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblDateOfBirth);
		
		JLabel lblNationality = new JLabel("Nationality:");
		sl_profile.putConstraint(SpringLayout.WEST, nationality, 6, SpringLayout.EAST, lblNationality);
		sl_profile.putConstraint(SpringLayout.NORTH, lblNationality, 126, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblDateOfBirth, -27, SpringLayout.NORTH, lblNationality);
		sl_profile.putConstraint(SpringLayout.EAST, lblNationality, -794, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.WEST, lblNationality, 113, SpringLayout.WEST, profile);
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblNationality);
		
		JLabel lblGender = new JLabel("Gender: ");
		sl_profile.putConstraint(SpringLayout.NORTH, lblGender, 174, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblGender, -116, SpringLayout.SOUTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblNationality, -28, SpringLayout.NORTH, lblGender);
		sl_profile.putConstraint(SpringLayout.WEST, lblGender, 135, SpringLayout.WEST, profile);
		sl_profile.putConstraint(SpringLayout.EAST, lblGender, -794, SpringLayout.EAST, profile);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address:");
		sl_profile.putConstraint(SpringLayout.WEST, address, 8, SpringLayout.EAST, lblAddress);
		sl_profile.putConstraint(SpringLayout.NORTH, lblAddress, 31, SpringLayout.SOUTH, lblGender);
		sl_profile.putConstraint(SpringLayout.WEST, lblAddress, 132, SpringLayout.WEST, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblAddress, -65, SpringLayout.SOUTH, profile);
		sl_profile.putConstraint(SpringLayout.EAST, lblAddress, -796, SpringLayout.EAST, profile);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblAddress);
		
		JLabel lblAccountNo = new JLabel("Account no:");
		sl_profile.putConstraint(SpringLayout.NORTH, lblAccountNo, 36, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.WEST, lblAccountNo, 116, SpringLayout.EAST, name);
		sl_profile.putConstraint(SpringLayout.EAST, lblAccountNo, -378, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.WEST, accountno, 6, SpringLayout.EAST, lblAccountNo);
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblAccountNo);
		
		JLabel lblNewLabel_1 = new JLabel("Account type:");
		sl_profile.putConstraint(SpringLayout.WEST, accounttype, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_profile.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 82, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -208, SpringLayout.SOUTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblAccountNo, -26, SpringLayout.NORTH, lblNewLabel_1);
		sl_profile.putConstraint(SpringLayout.WEST, lblNewLabel_1, 114, SpringLayout.EAST, dob);
		sl_profile.putConstraint(SpringLayout.EAST, lblNewLabel_1, -378, SpringLayout.EAST, profile);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblNewLabel_1);
		
		JLabel lblCaste = new JLabel("Amount:");
		sl_profile.putConstraint(SpringLayout.NORTH, lblCaste, 27, SpringLayout.SOUTH, lblNewLabel_1);
		sl_profile.putConstraint(SpringLayout.WEST, amount, 7, SpringLayout.EAST, lblCaste);
		sl_profile.putConstraint(SpringLayout.WEST, lblCaste, 148, SpringLayout.EAST, nationality);
		sl_profile.putConstraint(SpringLayout.EAST, lblCaste, -379, SpringLayout.EAST, profile);
		lblCaste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblCaste);
		
		JLabel lblMobile = new JLabel("Mobile:");
		sl_profile.putConstraint(SpringLayout.EAST, gender, -148, SpringLayout.WEST, lblMobile);
		sl_profile.putConstraint(SpringLayout.WEST, mobile, 6, SpringLayout.EAST, lblMobile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblCaste, -26, SpringLayout.NORTH, lblMobile);
		sl_profile.putConstraint(SpringLayout.WEST, lblMobile, 0, SpringLayout.WEST, lblCaste);
		sl_profile.putConstraint(SpringLayout.EAST, lblMobile, -378, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.NORTH, lblMobile, 175, SpringLayout.NORTH, profile);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblMobile);
		
		JLabel lblSecurityQ = new JLabel("Security Q:");
		sl_profile.putConstraint(SpringLayout.NORTH, lblSecurityQ, 225, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblSecurityQ, -65, SpringLayout.SOUTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, lblMobile, -30, SpringLayout.NORTH, lblSecurityQ);
		sl_profile.putConstraint(SpringLayout.WEST, secq, 6, SpringLayout.EAST, lblSecurityQ);
		sl_profile.putConstraint(SpringLayout.WEST, lblSecurityQ, 133, SpringLayout.EAST, address);
		sl_profile.putConstraint(SpringLayout.EAST, lblSecurityQ, -378, SpringLayout.EAST, profile);
		lblSecurityQ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(lblSecurityQ);
		
		JButton btnNewButton = new JButton("Edit");
		sl_profile.putConstraint(SpringLayout.EAST, accounttype, -57, SpringLayout.WEST, btnNewButton);
		sl_profile.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.WEST, btnNewButton, -117, SpringLayout.EAST, profile);
		sl_profile.putConstraint(SpringLayout.NORTH, btnNewButton, 72, SpringLayout.NORTH, profile);
		sl_profile.putConstraint(SpringLayout.SOUTH, btnNewButton, 107, SpringLayout.NORTH, profile);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setEditable(true);
				dob.setEditable(true);				
				address.setEditable(true);				
				mobile.setEditable(true);
				secq.setEditable(true);				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-edit-26.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		sl_profile.putConstraint(SpringLayout.WEST, btnSave, 57, SpringLayout.EAST, mobile);
		sl_profile.putConstraint(SpringLayout.SOUTH, btnSave, -109, SpringLayout.SOUTH, profile);
		sl_profile.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, btnNewButton);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null, "Are you sure?","Update information",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_NO_OPTION) {
				String sql = "update account set name=?,dob=?,address=?,mobile=?,sec_q=? where name=?";
				try {					
						ps = conn.prepareStatement(sql);
						ps.setString(6,searchUser.getText());				
						ps.setString(1, name.getText());
						ps.setString(2, dob.getText());
						ps.setString(3, address.getText());
						ps.setString(4, mobile.getText());
						ps.setString(5, secq.getText());
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update Successfull!");
						updateUserInfo();
						getBalanceUpdate();
					}														
				catch (SQLException e1) {				
					JOptionPane.showMessageDialog(null,  e1);
				}
			}
				else{
				JOptionPane.showMessageDialog(null, "Information haven't updated!");
				}				
			}
		});
		sl_profile.putConstraint(SpringLayout.NORTH, btnSave, 168, SpringLayout.NORTH, profile);
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-save-25.png"));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profile.add(btnSave);
		
		JPanel deposit = new JPanel();
		tabbedPane.addTab("Deposit", null, deposit, null);
		SpringLayout sl_deposit = new SpringLayout();
		deposit.setLayout(sl_deposit);
		
		JLabel lblAvailableBalance = new JLabel("Balance:");
		sl_deposit.putConstraint(SpringLayout.NORTH, lblAvailableBalance, 10, SpringLayout.NORTH, deposit);
		sl_deposit.putConstraint(SpringLayout.WEST, lblAvailableBalance, 48, SpringLayout.WEST, deposit);
		sl_deposit.putConstraint(SpringLayout.SOUTH, lblAvailableBalance, 85, SpringLayout.NORTH, deposit);
		sl_deposit.putConstraint(SpringLayout.EAST, lblAvailableBalance, 256, SpringLayout.WEST, deposit);
		lblAvailableBalance.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-money-60.png"));
		lblAvailableBalance.setFont(new Font("Verdana", Font.BOLD, 30));
		deposit.add(lblAvailableBalance);
		
		labelBalance = new JLabel("00");
		
		sl_deposit.putConstraint(SpringLayout.NORTH, labelBalance, 18, SpringLayout.NORTH, lblAvailableBalance);
		sl_deposit.putConstraint(SpringLayout.WEST, labelBalance, 7, SpringLayout.EAST, lblAvailableBalance);
		labelBalance.setFont(new Font("Verdana", Font.BOLD, 30));
		deposit.add(labelBalance);
		
		JLabel Userlabel = new JLabel("");
		sl_deposit.putConstraint(SpringLayout.NORTH, Userlabel, 28, SpringLayout.SOUTH, lblAvailableBalance);
		Userlabel.setHorizontalAlignment(SwingConstants.LEFT);
		Userlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		deposit.add(Userlabel);
		
		depositText = new JTextField();
		depositText.setHorizontalAlignment(SwingConstants.CENTER);
		depositText.setFont(new Font("Verdana", Font.BOLD, 30));
		sl_deposit.putConstraint(SpringLayout.SOUTH, Userlabel, 0, SpringLayout.SOUTH, depositText);
		sl_deposit.putConstraint(SpringLayout.EAST, Userlabel, -159, SpringLayout.WEST, depositText);
		sl_deposit.putConstraint(SpringLayout.NORTH, depositText, 92, SpringLayout.NORTH, deposit);
		sl_deposit.putConstraint(SpringLayout.EAST, depositText, -126, SpringLayout.EAST, deposit);
		deposit.add(depositText);
		depositText.setColumns(10);
		
		JLabel Accountlabel = new JLabel("");
		sl_deposit.putConstraint(SpringLayout.NORTH, Accountlabel, 25, SpringLayout.SOUTH, Userlabel);
		sl_deposit.putConstraint(SpringLayout.WEST, Accountlabel, 234, SpringLayout.WEST, deposit);
		sl_deposit.putConstraint(SpringLayout.SOUTH, Accountlabel, -84, SpringLayout.SOUTH, deposit);
		Accountlabel.setHorizontalAlignment(SwingConstants.LEFT);
		Accountlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		deposit.add(Accountlabel);
		
		JButton btnDeposit = new JButton("Deposit");
		sl_deposit.putConstraint(SpringLayout.WEST, btnDeposit, 620, SpringLayout.WEST, deposit);
		sl_deposit.putConstraint(SpringLayout.EAST, Accountlabel, -159, SpringLayout.WEST, btnDeposit);
		sl_deposit.putConstraint(SpringLayout.EAST, btnDeposit, -126, SpringLayout.EAST, deposit);
		sl_deposit.putConstraint(SpringLayout.SOUTH, depositText, -27, SpringLayout.NORTH, btnDeposit);
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(depositText.getText().isEmpty() || depositText.getText().matches("[a-zA-Z_]+")) {
					JOptionPane.showMessageDialog(null, "Please enter valid operation!");
				}
			else {
				int Dbalance = Integer.parseInt(depositText.getText());
				int bal = Integer.parseInt(getBalance());			
				int total = Dbalance+bal;
				String finalBalance = String.valueOf(total);
				int choise = JOptionPane.showConfirmDialog(null, "Do you want to Deposit money?","Deposit",JOptionPane.YES_NO_OPTION);
				if(choise==JOptionPane.YES_OPTION) {
				String sql = "update account set balance=? where name=?";
				try {									
					if(!(Dbalance<=0)) {
					ps = conn.prepareStatement(sql);
					ps.setString(2, searchUser.getText());
					ps.setString(1, finalBalance);
					ps.executeUpdate();					
					JOptionPane.showMessageDialog(null, "Balance Deposited!");
					setDeposit();
					getBalanceUpdate();
				}
					else {
						JOptionPane.showMessageDialog(null, "Balance can't be empty!");
					}
				}
			 catch (Exception e1) {					
					JOptionPane.showMessageDialog(null, "Balance failed to deposit!");
					JOptionPane.showMessageDialog(null, e1);					
				}				
			}
				else {
					JOptionPane.showMessageDialog(null, "Deposit Cancelled!");
				}
			}
		}
	});
		sl_deposit.putConstraint(SpringLayout.NORTH, btnDeposit, 184, SpringLayout.NORTH, deposit);
		sl_deposit.putConstraint(SpringLayout.WEST, depositText, 0, SpringLayout.WEST, btnDeposit);
		btnDeposit.setFont(new Font("Serif", Font.BOLD, 30));
		btnDeposit.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-deposit-50.png"));
		deposit.add(btnDeposit);
		
		JLabel lblName_1 = new JLabel("NAME:");
		sl_deposit.putConstraint(SpringLayout.EAST, lblName_1, -809, SpringLayout.EAST, deposit);
		sl_deposit.putConstraint(SpringLayout.WEST, Userlabel, 55, SpringLayout.EAST, lblName_1);
		sl_deposit.putConstraint(SpringLayout.NORTH, lblName_1, 11, SpringLayout.NORTH, Userlabel);
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		deposit.add(lblName_1);
		
		JLabel lblAccountNo_1 = new JLabel("ACCOUNT NO:");
		sl_deposit.putConstraint(SpringLayout.NORTH, lblAccountNo_1, 11, SpringLayout.NORTH, Accountlabel);
		sl_deposit.putConstraint(SpringLayout.EAST, lblAccountNo_1, 0, SpringLayout.EAST, lblName_1);
		lblAccountNo_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		deposit.add(lblAccountNo_1);
		
		JPanel transfer = new JPanel();
		tabbedPane.addTab("Transfer", null, transfer, null);
		SpringLayout sl_transfer = new SpringLayout();
		transfer.setLayout(sl_transfer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sl_transfer.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, transfer);
		sl_transfer.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, transfer);
		sl_transfer.putConstraint(SpringLayout.SOUTH, panel_2, 310, SpringLayout.NORTH, transfer);
		sl_transfer.putConstraint(SpringLayout.EAST, panel_2, 515, SpringLayout.WEST, transfer);
		transfer.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		sl_transfer.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, transfer);
		sl_transfer.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel_11 = new JLabel("Balance:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 69, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_11, 10, SpringLayout.WEST, panel_2);
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-money-60.png"));
		lblNewLabel_11.setFont(new Font("Verdana", Font.BOLD, 30));
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Name");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 6, SpringLayout.SOUTH, lblNewLabel_11);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_12, 32, SpringLayout.WEST, lblNewLabel_11);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_12);
		
		 lblNewLabel_13 = new JLabel("00");
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_12, 0, SpringLayout.EAST, lblNewLabel_13);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 8, SpringLayout.NORTH, lblNewLabel_11);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_13, 6, SpringLayout.EAST, lblNewLabel_11);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_13, -7, SpringLayout.SOUTH, lblNewLabel_11);
		lblNewLabel_13.setFont(new Font("Verdana", Font.BOLD, 30));
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Account No");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_14, 20, SpringLayout.SOUTH, lblNewLabel_12);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_14, 40, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, -99, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_14, 4, SpringLayout.EAST, lblNewLabel_12);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_14);
		
		JLabel lblFrom = new JLabel("Transferring from");
		lblFrom.setForeground(new Color(255, 140, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblFrom, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblFrom, 140, SpringLayout.WEST, panel_2);
		lblFrom.setFont(new Font("Verdana", Font.BOLD, 20));
		panel_2.add(lblFrom);
		sl_transfer.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, transfer);
		sl_transfer.putConstraint(SpringLayout.EAST, panel_1, 1, SpringLayout.EAST, transfer);
		transfer.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblTransferringTo = new JLabel("Transferring to");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblTransferringTo, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblTransferringTo, 147, SpringLayout.WEST, panel_1);
		lblTransferringTo.setForeground(new Color(255, 140, 0));
		lblTransferringTo.setFont(new Font("Verdana", Font.BOLD, 20));
		panel_1.add(lblTransferringTo);
		
		textField_1 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_1, 189, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_1, -207, SpringLayout.SOUTH, panel_1);
		textField_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCheckAvailability = new JLabel("Check Availability:");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblCheckAvailability, 20, SpringLayout.WEST, panel_1);
		lblCheckAvailability.setFont(new Font("Verdana", Font.PLAIN, 16));
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblCheckAvailability, 0, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblCheckAvailability, -17, SpringLayout.WEST, textField_1);
		panel_1.add(lblCheckAvailability);
		
		JButton btnNewButton_3 = new JButton("");
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, textField_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_3, -45, SpringLayout.EAST, panel_1);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-search-24.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField_1.getText().matches("[a-zA-Z_]+")) {
					JOptionPane.showMessageDialog(null, "Please enter user account number!");
				}
				else {
				String sql = "select * from account where acc=?";
				try {
					ps= conn.prepareStatement(sql);
					ps.setString(1, textField_1.getText());
					rs = ps.executeQuery();
					if(rs.next()) {	
						String val = rs.getString("acc");
						textField_2.setText(val);
							JOptionPane.showMessageDialog(null, "User found!");													
						}
					else {
						JOptionPane.showMessageDialog(null, "User not found!");
					}
						
					}
				 catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);												
			}
		}
	}
});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, textField_1);
		panel_1.add(btnNewButton_3);
		
		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_2, 31, SpringLayout.SOUTH, textField_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_2, -45, SpringLayout.EAST, panel_1);
		textField_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAccountNo_2 = new JLabel("Account No:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblAccountNo_2, 30, SpringLayout.SOUTH, lblCheckAvailability);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, 17, SpringLayout.EAST, lblAccountNo_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblAccountNo_2, 73, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblAccountNo_2, 0, SpringLayout.EAST, lblCheckAvailability);
		lblAccountNo_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel_1.add(lblAccountNo_2);
		
		textField_4 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_2, -17, SpringLayout.NORTH, textField_4);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_4, 188, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_4, -45, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_4, -94, SpringLayout.SOUTH, panel_1);
		textField_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblAccountNo_2, -33, SpringLayout.NORTH, lblAmount);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_4, 17, SpringLayout.EAST, lblAmount);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblAmount, -1, SpringLayout.NORTH, textField_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblAmount, 102, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblAmount, -102, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblAmount, 0, SpringLayout.EAST, lblCheckAvailability);
		lblAmount.setFont(new Font("Verdana", Font.PLAIN, 16));
		panel_1.add(lblAmount);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-data-transfer-24.png"));
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().isEmpty() || textField_2.getText().matches("[a-zA-Z_]+")) {
					JOptionPane.showMessageDialog(null, "Please enter account number to transfer");
				}
				else {
					if(textField_4.getText().isEmpty() || textField_4.getText().matches("[a-zA-Z_]+")) {
						JOptionPane.showMessageDialog(null, "Please enter amount to transfer");
					}
			else {			
				int choise = JOptionPane.showConfirmDialog(null, "Do you want to transfer money?","Transfer",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_OPTION) {
				try {
					getSubtractionUpdate();
					getBalanceUpdate();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to add amount");							
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Transfer cancelled!");
				 }
				}
			}
		}		
	});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnTransfer, 15, SpringLayout.SOUTH, textField_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTransfer, 189, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnTransfer, -44, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnTransfer, -45, SpringLayout.EAST, panel_1);
		panel_1.add(btnTransfer);
		
		JPanel withdraw = new JPanel();
		tabbedPane.addTab("Withdraw", null, withdraw, null);
		SpringLayout sl_withdraw = new SpringLayout();
		withdraw.setLayout(sl_withdraw);
		
		JLabel lblAvailableBalance_1 = new JLabel("Balance:");
		sl_withdraw.putConstraint(SpringLayout.NORTH, lblAvailableBalance_1, 14, SpringLayout.NORTH, withdraw);
		sl_withdraw.putConstraint(SpringLayout.EAST, lblAvailableBalance_1, -738, SpringLayout.EAST, withdraw);
		lblAvailableBalance_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-money-60.png"));
		lblAvailableBalance_1.setFont(new Font("Verdana", Font.BOLD, 30));
		withdraw.add(lblAvailableBalance_1);
		
		 labelBalance_1 = new JLabel("00");
		sl_withdraw.putConstraint(SpringLayout.NORTH, labelBalance_1, 11, SpringLayout.NORTH, lblAvailableBalance_1);
		sl_withdraw.putConstraint(SpringLayout.WEST, labelBalance_1, 6, SpringLayout.EAST, lblAvailableBalance_1);
		labelBalance_1.setFont(new Font("Verdana", Font.BOLD, 30));
		withdraw.add(labelBalance_1);
		
		withdrawText = new JTextField();
		sl_withdraw.putConstraint(SpringLayout.NORTH, withdrawText, 90, SpringLayout.NORTH, withdraw);
		sl_withdraw.putConstraint(SpringLayout.SOUTH, withdrawText, -155, SpringLayout.SOUTH, withdraw);
		sl_withdraw.putConstraint(SpringLayout.EAST, withdrawText, -123, SpringLayout.EAST, withdraw);
		withdrawText.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawText.setFont(new Font("Verdana", Font.BOLD, 30));
		withdrawText.setColumns(10);
		withdraw.add(withdrawText);
		
		JButton btnDeposit_1 = new JButton("Withdraw");
		sl_withdraw.putConstraint(SpringLayout.NORTH, btnDeposit_1, 33, SpringLayout.SOUTH, withdrawText);
		btnDeposit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(withdrawText.getText().isEmpty() || withdrawText.getText().matches("[a-zA-Z_]+")) {
					JOptionPane.showMessageDialog(null, "Please enter valid operation!");
				}
			else {
				int choise = JOptionPane.showConfirmDialog(null, "Do you want to withdraw money?","Withdraw",JOptionPane.YES_NO_OPTION);				
				int DBalance = Integer.parseInt(getBalance());
				int UBalance = Integer.parseInt(getUserBalance());
				int Balance = DBalance-UBalance;				
				if(choise == JOptionPane.YES_OPTION) {
				String finalBalance = String.valueOf(Balance); 
				String sql = "update account set balance=? where name=?";
				try {
					if(DBalance>=UBalance) {					
					ps = conn.prepareStatement(sql);
					ps.setString(2, searchUser.getText());
					ps.setString(1, finalBalance);
					ps.executeUpdate();					
					JOptionPane.showMessageDialog(null, "Balance Withdrawn!");
					setWithdraw();
					getBalanceUpdate();
					}
					else {
						JOptionPane.showMessageDialog(null, "Balance Exceeded!");
					}
				} catch (SQLException e1) {					
					JOptionPane.showMessageDialog(null, "Balance failed to Withdraw!");
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Withdraw Cancelled!");
				}
			}			
		}
	});
				
		LocalDate date = java.time.LocalDate.now();
		String finalDate = date.toString();
		allTimeDate.setText(finalDate);
		btnDeposit_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-atm-50.png"));
		sl_withdraw.putConstraint(SpringLayout.WEST, btnDeposit_1, 0, SpringLayout.WEST, withdrawText);
		sl_withdraw.putConstraint(SpringLayout.SOUTH, btnDeposit_1, -63, SpringLayout.SOUTH, withdraw);
		sl_withdraw.putConstraint(SpringLayout.EAST, btnDeposit_1, 0, SpringLayout.EAST, withdrawText);
		btnDeposit_1.setFont(new Font("Serif", Font.BOLD, 30));
		withdraw.add(btnDeposit_1);
		
		JLabel lblName_1_1 = new JLabel("NAME:");
		sl_withdraw.putConstraint(SpringLayout.WEST, lblName_1_1, 124, SpringLayout.WEST, withdraw);
		sl_withdraw.putConstraint(SpringLayout.WEST, withdrawText, 439, SpringLayout.EAST, lblName_1_1);
		sl_withdraw.putConstraint(SpringLayout.NORTH, lblName_1_1, 26, SpringLayout.NORTH, withdrawText);
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		withdraw.add(lblName_1_1);
		
		JLabel lblAccountNo_1_1 = new JLabel("ACCOUNT NO:");
		sl_withdraw.putConstraint(SpringLayout.NORTH, lblAccountNo_1_1, 44, SpringLayout.SOUTH, lblName_1_1);
		sl_withdraw.putConstraint(SpringLayout.EAST, lblAccountNo_1_1, 0, SpringLayout.EAST, lblName_1_1);
		lblAccountNo_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		withdraw.add(lblAccountNo_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		sl_withdraw.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 42, SpringLayout.SOUTH, lblAvailableBalance_1);
		sl_withdraw.putConstraint(SpringLayout.WEST, lblNewLabel_2, 21, SpringLayout.EAST, lblName_1_1);
		sl_withdraw.putConstraint(SpringLayout.EAST, lblNewLabel_2, -202, SpringLayout.WEST, withdrawText);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		withdraw.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		sl_withdraw.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 40, SpringLayout.SOUTH, lblNewLabel_2);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		sl_withdraw.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		withdraw.add(lblNewLabel_3);
		
		JPanel transaction = new JPanel();
		tabbedPane.addTab("Transaction", null, transaction, null);
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_transaction = new GroupLayout(transaction);
		gl_transaction.setHorizontalGroup(
			gl_transaction.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
		);
		gl_transaction.setVerticalGroup(
			gl_transaction.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
		);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		
		transTable = new JTable();
		transTable.setRowSelectionAllowed(false);
		transTable.setRowMargin(10);
		transTable.setRowHeight(35);
		transTable.setIntercellSpacing(new Dimension(5, 0));
		transTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		transTable.setEnabled(false);
		transTable.setAutoCreateRowSorter(true);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_7 = new JLabel("USER NAME");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("DATE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_9 = new JLabel("DEPOSIT");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_10 = new JLabel("WITHDRAW");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(74)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(134)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(164)
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(118)
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addComponent(transTable, GroupLayout.PREFERRED_SIZE, 990, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(146, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(transTable, GroupLayout.PREFERRED_SIZE, 1391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(gl_panel_3);
		transaction.setLayout(gl_transaction);
		
		JPanel changepin = new JPanel();
		tabbedPane.addTab("Change Pin", null, changepin, null);
		SpringLayout sl_changepin = new SpringLayout();
		changepin.setLayout(sl_changepin);
		
		JLabel lblChangePin = new JLabel("Change Pin");
		sl_changepin.putConstraint(SpringLayout.NORTH, lblChangePin, 35, SpringLayout.NORTH, changepin);
		sl_changepin.putConstraint(SpringLayout.WEST, lblChangePin, 78, SpringLayout.WEST, changepin);
		lblChangePin.setFont(new Font("Verdana", Font.BOLD, 30));
		changepin.add(lblChangePin);
		
		JButton btnNewButton_2 = new JButton("Change Pin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null, "Are you sure?","Change pin",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_OPTION) {
				String oldPin = getPin();				
				String sql = "update account set pin=? where name=?";
				try {
					if(textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter old pin!");
					}
					else {
					if(!(oldPin.equals(textField_3.getText()))) {
						JOptionPane.showMessageDialog(null, "Enter correct pin!");
				}else {
					if(textField_5.getText().equals("")||textField_6.getText().equals("") ) {
						JOptionPane.showMessageDialog(null, "new pin can't left empty!");
					}
					else {
						if((textField_5.getText().length() <=4) || (textField_5.getText().length() >=8)) {
							JOptionPane.showMessageDialog(null, "4-8 character!");
						}
							else {
								if(!(textField_6.getText().equals(textField_5.getText()))) {
									JOptionPane.showMessageDialog(null, "Pin didn't match!");
								}
								else {
								ps = conn.prepareStatement(sql);
								ps.setString(2, searchUser.getText());
								ps.setString(1,textField_5.getText());
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "Pin Changed!");
								}
							}
							
						}
						
					
					}
				}
			}
			 
				
				
				catch (SQLException e1) {					
					JOptionPane.showMessageDialog(null, "Pin failed to retreive!");
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
				else {
					JOptionPane.showMessageDialog(null, "Cancelled!");
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_changepin.putConstraint(SpringLayout.NORTH, btnNewButton_2, -63, SpringLayout.SOUTH, changepin);
		sl_changepin.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -25, SpringLayout.SOUTH, changepin);
		sl_changepin.putConstraint(SpringLayout.EAST, btnNewButton_2, -301, SpringLayout.EAST, changepin);
		changepin.add(btnNewButton_2);
		
		textField_3 = new JTextField();
		sl_changepin.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, textField_3);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		changepin.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		sl_changepin.putConstraint(SpringLayout.SOUTH, textField_5, -139, SpringLayout.SOUTH, changepin);
		sl_changepin.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField_5);
		sl_changepin.putConstraint(SpringLayout.SOUTH, textField_3, -16, SpringLayout.NORTH, textField_5);
		sl_changepin.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField_5);
		sl_changepin.putConstraint(SpringLayout.EAST, textField_5, -301, SpringLayout.EAST, changepin);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		changepin.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		sl_changepin.putConstraint(SpringLayout.NORTH, textField_6, 19, SpringLayout.SOUTH, textField_5);
		sl_changepin.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField_3);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		changepin.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Old pin:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_changepin.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, textField_3);
		sl_changepin.putConstraint(SpringLayout.EAST, lblNewLabel_4, -29, SpringLayout.WEST, textField_3);
		changepin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New pin:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_changepin.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, textField_5);
		sl_changepin.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_4);
		changepin.add(lblNewLabel_5);
		
		JLabel lblConfirmPin = new JLabel("Confirm pin:");
		lblConfirmPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_changepin.putConstraint(SpringLayout.NORTH, lblConfirmPin, 30, SpringLayout.SOUTH, lblNewLabel_5);
		sl_changepin.putConstraint(SpringLayout.EAST, lblConfirmPin, 0, SpringLayout.EAST, lblNewLabel_4);
		changepin.add(lblConfirmPin);
		
		JPanel about = new JPanel();
		tabbedPane.addTab("About", null, about, null);
		
		JLabel lblDeveloperInfo = new JLabel("Developer Info");
		lblDeveloperInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNameAbdullaAl = new JLabel("Name: Abdulla al jaber");
		lblNameAbdullaAl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUniversityNanjingUniversity = new JLabel("University: Nanjing university of information science and technology");
		lblUniversityNanjingUniversity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_15 = new JLabel("Country: Bangladesh");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblEducationbscInSoftware = new JLabel("Education:B.Sc in Software Engineering (Continue..)");
		lblEducationbscInSoftware.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-developer-mode-100.png"));
		GroupLayout gl_about = new GroupLayout(about);
		gl_about.setHorizontalGroup(
			gl_about.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_about.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_about.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_about.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNameAbdullaAl)
							.addGroup(gl_about.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDeveloperInfo)
								.addComponent(lblNewLabel_15)))
						.addGroup(gl_about.createParallelGroup(Alignment.LEADING)
							.addComponent(lblEducationbscInSoftware)
							.addComponent(lblUniversityNanjingUniversity)))
					.addPreferredGap(ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
					.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		gl_about.setVerticalGroup(
			gl_about.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_about.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_about.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_about.createSequentialGroup()
							.addComponent(lblDeveloperInfo)
							.addGap(26)
							.addComponent(lblNameAbdullaAl)
							.addGap(11)
							.addComponent(lblNewLabel_15)
							.addGap(13)
							.addComponent(lblEducationbscInSoftware)
							.addGap(13)
							.addComponent(lblUniversityNanjingUniversity))))
		);
		about.setLayout(gl_about);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(searchUser.getText().isEmpty() || searchUser.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Enter your user name!");
				}
				else {
				loadTransaction();
				try {
					getBalanceUpdate();
				} catch (SQLException e2) {				
					JOptionPane.showMessageDialog(null, e2);					
				}
				String sql = "select * from account where name=?";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1,searchUser.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						String one = rs.getString("name");
						name.setText(one);
						lblNewLabel_12.setText(one);
						Userlabel.setText(one);
						lblNewLabel_2.setText(one);
						String two = rs.getString("dob");
						dob.setText(two);					
						String three = rs.getString("acc");
						accountno.setText(three);
						lblNewLabel_14.setText(three);
						Accountlabel.setText(three);
						lblNewLabel_3.setText(three);
						String four = rs.getString("acc_type");
						accounttype.setText(four);						
   					   	String five = rs.getString("nationality");
						nationality.setText(five);						
						String six = rs.getString("balance");
						
						amount.setText(six);
						labelBalance.setText(six);
						labelBalance_1.setText(six);
						lblNewLabel_13.setText(six);
						String seven = rs.getString("gender");
						gender.setText(seven);						
						String eight = rs.getString("mobile");
						mobile.setText(eight);						
						String nine = rs.getString("address");
						address.setText(nine);						
						String ten = rs.getString("sec_q");
						secq.setText(ten);
						updateUserInfo();					
					}
					else {
						JOptionPane.showMessageDialog(null, "User doesn't exists!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		}
	});
}	
	//------------------------------------------------------Get Balance-------------------------------------------------------
	public String getBalance() {
		String balance = null;
		String sql = "select * from account where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, searchUser.getText());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				balance = rs.getString("balance");
			}
			else {
				JOptionPane.showMessageDialog(null, "Failed to deposit");
			}							
		} catch (SQLException e1) {					
			JOptionPane.showMessageDialog(null, e1);
		}
		return balance;

	}
	//-----------------------------------------------------------GetPin
	public String getPin() {
		String pin = null;
		String sql = "select * from account where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, searchUser.getText());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				pin = rs.getString("pin");
			}
			else {
				JOptionPane.showMessageDialog(null, "Failed to retrieve");
			}							
		} catch (SQLException e1) {					
			JOptionPane.showMessageDialog(null, e1);
		}
		return pin;

	}
	
	public String getUserBalance() {
		return withdrawText.getText();
	}
	public void setDeposit() throws SQLException {
		String sqlDepo="insert into trans(acc,date,deposit) values(?,?,?)";		
		ps = conn.prepareStatement(sqlDepo);
		ps.setString(1, searchUser.getText());
		ps.setString(2, String.valueOf(new java.util.Date()));
		ps.setString(3, "+"+depositText.getText());
		ps.execute();
		loadTransaction();
		
	}
//	public void refreshTable() throws SQLException {
//		//String getDepositCell = transTable.getModel().getValueAt(arg0, arg1)
//		String sqlDepo="select * from trans where searchUser=?";		
//		ps = conn.prepareStatement(sqlDepo);
//		ps.setString(1, searchUser.getText());
//		rs = ps.executeQuery();
//		transTable.getModel().getValueAt(rs);
//		ps.execute();
//		
//	}
	public void setWithdraw() throws SQLException {
		String sqlDepo="insert into trans(acc,date,withdraw) values(?,?,?)";
		ps = conn.prepareStatement(sqlDepo);
		ps.setString(1, searchUser.getText());
		ps.setString(2, String.valueOf(new java.util.Date()));
		ps.setString(3, "-"+withdrawText.getText());
		//ps.setString(4, withdrawText.getText());
		ps.execute();
		loadTransaction();
		
	}
	public String getCurrentDate(){
		LocalDate date = java.time.LocalDate.now();
		String finalDate = date.toString();
		System.out.println(finalDate);
		return null;
	}
	//getTransferAmount
	public String getTransferAmount() {
		String amount = textField_4.getText();
		return amount;
	}
	public int getSubtract() {
		int myBalance = Integer.parseInt(getBalance());
		int userBalance = Integer.parseInt(getTransferAmount());
		int subtractedAmount = myBalance - userBalance;
		return subtractedAmount;
	}
	public String getToAmount() {
		
			String balance = null;
			String sql = "select * from account where acc=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, textField_2.getText());
				rs = ps.executeQuery();
				
				if(rs.next()) {
					balance = rs.getString("balance");
				}
				else {
					JOptionPane.showMessageDialog(null, "Failed to retreive money");
				}							
			} catch (SQLException e1) {					
				JOptionPane.showMessageDialog(null, e1);
			}
			return balance;

		}
	public int getAdded() {
		int getTransferAmount = Integer.parseInt(getTransferAmount());
		int getToAmount = Integer.parseInt(getToAmount());		
		int addAmount = getToAmount + getTransferAmount;
		return addAmount;
	}
	public void getAdditionUpdate() throws SQLException {
		int add =  getAdded();
		String sql = "update account set balance=? where acc=?";
		ps = conn.prepareStatement(sql);
		ps.setString(2, textField_1.getText());		
		ps.setString(1, String.valueOf(add));
		ps.executeUpdate();
		
	}
	public void getSubtractionUpdate() throws SQLException {
		int sub = getSubtract();	
		String val = String.valueOf(sub);
		String sql2 = "update account set balance=? where name=?";
		ps = conn.prepareStatement(sql2);
		ps.setString(2, searchUser.getText());	
		ps.setString(1, String.valueOf(val));		
		ps.executeUpdate();	
		JOptionPane.showMessageDialog(null,"Balance Transferred!");
		getAdditionUpdate();
	}
	public void updateUserInfo() {
		String sql = "select * from account where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,searchUser.getText());
			rs = ps.executeQuery();
			if(rs.next()) {
				String one = rs.getString("name");
				name.setText(one);				
				String two = rs.getString("dob");
				dob.setText(two);					
				String three = rs.getString("acc");
				accountno.setText(three);				
				String four = rs.getString("acc_type");
				accounttype.setText(four);						
				   	String five = rs.getString("nationality");
				nationality.setText(five);						
				String six = rs.getString("balance");
				amount.setText(six);
				String seven = rs.getString("gender");
				gender.setText(seven);						
				String eight = rs.getString("mobile");
				mobile.setText(eight);						
				String nine = rs.getString("address");
				address.setText(nine);						
				String ten = rs.getString("sec_q");
				secq.setText(ten);
			}
			else {
				//JOptionPane.showMessageDialog(null, "User doesn't exists!");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}

	public void  getBalanceUpdate() throws SQLException {
		String sql = "select balance from account where name=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, searchUser.getText());
		rs = ps.executeQuery();
		while(rs.next()) {
			labelBalance_1.setText(rs.getString("balance"));
			labelBalance.setText(rs.getString("balance"));
			lblNewLabel_13.setText(rs.getString("balance"));
		}
		
	}
	public void loadTransaction() {	
			String sql = "select * from trans where acc=? order by id desc";			
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,searchUser.getText());
				rs = ps.executeQuery();
				while(rs.next()) {
					transTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
			} catch (SQLException e1) {
	
				JOptionPane.showMessageDialog(null, "Failed to retrieve transaction!");
				JOptionPane.showMessageDialog(null, e1);
				
			}
		
	}
}
	

