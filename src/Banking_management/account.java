package Banking_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.SpringLayout;


public class account extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JTextField micr;
	private JTextField userName;
	private JTextField amount;
	private JTextField address;
	private JTextField mobile;
	private JTextField caste;
	private JTextField pin;
	private JTextField sec_a;
	private JDateChooser dob;
	private JComboBox<String> acc_type;
	private JComboBox <String>nationality;
	private JComboBox<String> sec_q;
	private ButtonGroup bg;
	private String gender;
	Connection conn;
	ResultSet rs;
	PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account frame = new account();
					frame.setTitle("Create an user account");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public account() throws SQLException {
		super("Create Account");
		conn = (Connection) ConnectionDB.connect();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Account no: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Secret code: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Account type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		account = new JTextField();
		account.setFont(new Font("Tahoma", Font.PLAIN, 18));
		account.setColumns(10);
		account.setText(RandomAccount());
		
		micr = new JTextField();
		micr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		micr.setColumns(10);
		micr.setText( RandomMicr());
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		address.setColumns(10);
					
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Nationality:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_7 = new JLabel("ID/Passport:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("Mobile:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		userName = new JTextField();
		userName.setToolTipText("");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userName.setColumns(10);
		
		mobile = new JTextField();
		mobile.setToolTipText("10");
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mobile.setColumns(10);
		
		caste = new JTextField();
		caste.setToolTipText("10");
		caste.setFont(new Font("Tahoma", Font.PLAIN, 18));
		caste.setColumns(10);
		
		bg = new ButtonGroup();
		
		JRadioButton male = new JRadioButton("Male");
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setSelected(true);
		JRadioButton female = new JRadioButton("Female");
		female.setHorizontalAlignment(SwingConstants.CENTER);
		bg.add(male);
		bg.add(female);
		if(female.isSelected()) {
			gender ="Female";
		}
		else {
			gender ="Male";
		}
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				int choise = JOptionPane.showConfirmDialog(null, "Create a new account?","Create account",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_OPTION) {												
				String sql ="insert into account(acc,name,dob,pin,acc_type,nationality,caste,micr_no,gender,mobile,address,sec_q,sec_a,balance) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//				if (!number.matches("[0-9]+")) {
//				    System.out.println("Invalid number");
//				}
//				
				try {
					if(account.getText().isEmpty() || !(account.getText().matches("[0-9]+"))) {
						JOptionPane.showMessageDialog(null, "Account is empty or remove chararcters");	
					}
					else {
						if(userName.getText().isEmpty() || !(userName.getText().matches("[a-zA-Z_]+"))) {
							JOptionPane.showMessageDialog(null, "name is empty  or remove numbers");
						}
						else {
							if(pin.getText().isEmpty() || !(pin.getText().matches("[0-9]+"))) {
								JOptionPane.showMessageDialog(null, "pin is empty or remove chararcters");
							}
							else {
								if(pin.getText().length()<4 || pin.getText().length()>10) {
									JOptionPane.showMessageDialog(null, "pin in between 4 to 8 digits");
								}
								else {
									if(acc_type.getSelectedItem().equals("Select")) {
										JOptionPane.showMessageDialog(null, "Select your account type!");
									}
									else {
										if(nationality.getSelectedItem().equals("Select")) {
											JOptionPane.showMessageDialog(null, "Select your country!");
										}
										else {
											if(caste.getText().isEmpty()) {
												JOptionPane.showMessageDialog(null, "Enter your NationalID/Passport no!");												
											}
											else {
												if(micr.getText().isEmpty() || !(micr.getText().matches("[0-9]+"))) {
													JOptionPane.showMessageDialog(null, "Enter any secret number  or remove characters!");
												}
												else {
													if(mobile.getText().isEmpty() || !(amount.getText().matches("[0-9]+"))) {
														JOptionPane.showMessageDialog(null, "Enter your phone number or remove characters!");
														
													}
													else {
														if(address.getText().isEmpty()) {
															JOptionPane.showMessageDialog(null, "Enter your address!");
														}
														else {
															if(sec_q.getSelectedItem().equals("Select")) {
																JOptionPane.showMessageDialog(null, "Select your security question!");
															}
															else {
																if(sec_a.getText().isEmpty()) {
																	JOptionPane.showMessageDialog(null, "Enter your security answer!");
																}
																else {
																	if(amount.getText().isEmpty() || !(amount.getText().matches("[0-9]+"))) {
																		JOptionPane.showMessageDialog(null, "Amount can't be null");
																		
																	}
																	else {
																									
																		ps = conn.prepareStatement(sql);
																		ps.setString(1, account.getText());
																		ps.setString(2, userName.getText());
																		DateFormat df = new SimpleDateFormat("yyyy-mm-d");																		
																		ps.setString(3, df.format(dob.getDate()));//dob
																		ps.setString(4, pin.getText());
																		ps.setString(5, (String)acc_type.getSelectedItem());//acc_type
																		ps.setString(6, (String)nationality.getSelectedItem());//nationality
																		ps.setString(7, caste.getText());
																		ps.setString(8, micr.getText());
																		ps.setString(9, gender);//gender
																		ps.setString(10, mobile.getText());
																		ps.setString(11, address.getText());
																		ps.setString(12, (String) sec_q.getSelectedItem());
																		ps.setString(13, sec_a.getText());
																		ps.setString(14, amount.getText());
																		ps.execute();
																		JOptionPane.showMessageDialog(null, "      Congratulations \n your id has been created");
																		
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
			
					//AccountBalance();
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, e);
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Account creating cancelled!");
				}
				
			}
		});

		btnCreateAccount.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-add-30.png"));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setText("");
				micr.setText("");
				userName.setText("");
				amount.setText("");
				address.setText("");
				mobile.setText("");
				caste.setText("");
				pin.setText("");
				sec_a.setText("");
			}
		});
		btnClear.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-clear-symbol-30.png"));
		
		JLabel lblNewLabel_9 = new JLabel("Pin:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		pin = new JTextField();
		pin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pin.setColumns(10);
		pin.setText( RandomPin());
		
		JLabel lblNewLabel_10 = new JLabel("Security Q:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				authentication auth = new authentication();
				auth.setVisible(true);
			}
		});
		btnBack_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\Back-24-20px\\icons8-back-20.png"));
		
		JLabel lblSecurityA = new JLabel("Security A:");
		lblSecurityA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		sec_a = new JTextField();
		sec_a.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sec_a.setColumns(10);
		
		 nationality = new JComboBox<String>();
		 nationality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nationality.setToolTipText("10");
		nationality.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "Bangladesh", "India", "Sri-lanka", "Canada", "USA", "China"}));
		nationality.setSelectedIndex(1);
		
		 acc_type = new JComboBox<String>();
		 acc_type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acc_type.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "Current", "Saving"}));
		
		JLabel lblRegisterAccount = new JLabel("Register Account");
		lblRegisterAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		dob = new JDateChooser();
		dob.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		

		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.GREEN);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		amount = new JTextField();
		amount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amount.setColumns(10);
		
		 sec_q = new JComboBox<>();
		 sec_q.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sec_q.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "Where were your father born?", "Who's your first school friend?", "What's your favorite food?", "What's your favorite game?", "What's your your mother name?"}));
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, lblSecurityA, 16, SpringLayout.SOUTH, lblNewLabel_10);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSecurityA, 339, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblSecurityA, -22, SpringLayout.WEST, sec_a);
		sl_panel.putConstraint(SpringLayout.WEST, caste, 23, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, caste, -11, SpringLayout.NORTH, sec_q);
		sl_panel.putConstraint(SpringLayout.EAST, caste, 888, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, mobile, 14, SpringLayout.SOUTH, nationality);
		sl_panel.putConstraint(SpringLayout.WEST, mobile, 23, SpringLayout.EAST, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, mobile, 886, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_10, -23, SpringLayout.WEST, sec_q);
		sl_panel.putConstraint(SpringLayout.EAST, sec_q, -118, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, userName, 19, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, userName, -19, SpringLayout.NORTH, dob);
		sl_panel.putConstraint(SpringLayout.EAST, userName, 884, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, sec_q, 721, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 21, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.NORTH, sec_q, 275, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, sec_q, -15, SpringLayout.NORTH, sec_a);
		sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 386, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnClear, 247, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnClear, 422, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnClear, 403, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnCreateAccount, 364, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnCreateAccount, 723, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCreateAccount, 890, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, sec_a, 319, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, sec_a, 721, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, sec_a, 888, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, amount, 334, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, amount, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, amount, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 192, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 644, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, acc_type, 195, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, acc_type, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, acc_type, 226, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, acc_type, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 231, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 609, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 259, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, address, 287, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, address, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, address, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, female, 244, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, female, 414, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, female, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, male, 244, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, male, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, male, 410, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblAmount, 340, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblAmount, 239, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblAddress, 292, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblAddress, 238, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 245, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 244, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 200, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 203, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, nationality, 143, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, nationality, 719, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, nationality, 173, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, nationality, 886, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 155, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 617, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, pin, 149, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pin, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pin, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 150, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_9, 273, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, dob, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, dob, 717, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, dob, 125, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, dob, 884, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 98, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 602, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 123, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, micr, 103, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, micr, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, micr, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 108, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 215, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 650, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 75, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, account, 57, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, account, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, account, 499, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblRegisterAccount, 25, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRegisterAccount, 319, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblRegisterAccount, 50, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRegisterAccount, 520, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 216, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnBack_1, 8, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnBack_1, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnBack_1, 41, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnBack_1, 187, SpringLayout.WEST, panel);
		panel.setLayout(sl_panel);
		panel.add(btnBack_1);
		panel.add(lblNewLabel);
		panel.add(lblRegisterAccount);
		panel.add(account);
		panel.add(lblNewLabel_4);
		panel.add(userName);
		panel.add(lblNewLabel_2);
		panel.add(micr);
		panel.add(lblNewLabel_5);
		panel.add(dob);
		panel.add(lblNewLabel_9);
		panel.add(pin);
		panel.add(lblNewLabel_6);
		panel.add(nationality);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_3);
		panel.add(lblAddress);
		panel.add(lblAmount);
		panel.add(male);
		panel.add(female);
		panel.add(address);
		panel.add(lblNewLabel_7);
		panel.add(lblNewLabel_10);
		panel.add(acc_type);
		panel.add(lblNewLabel_8);
		panel.add(amount);
		panel.add(lblSecurityA);
		panel.add(sec_a);
		panel.add(caste);
		panel.add(sec_q);
		panel.add(btnCreateAccount);
		panel.add(mobile);
		panel.add(btnClear);
		
	}
	public String RandomAccount() {
		Random rd = new Random();
		int random = rd.nextInt(1000000+1);
		String str = String.valueOf(random);
		return str;
	}
	public String RandomMicr() {
		Random rd = new Random();
		int random = rd.nextInt(10000+1);
		String str = String.valueOf(random);
		return str;
	}
	public String RandomPin() {
		Random rd = new Random();
		int random = rd.nextInt(1000000+1);
		String str = String.valueOf(random);
		return str;
	}	
}
