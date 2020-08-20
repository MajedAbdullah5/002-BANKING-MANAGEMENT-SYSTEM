package Banking_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

public class authentication extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JCheckBox chckbxAgreeOurTerms;
	private JButton btnLogin;
	public Connection conn;
	public ResultSet rs;
	PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		    try {
		            //here you can put the selected theme class name in JTattoo
		    	 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(authentication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					authentication frame = new authentication();
					frame.setTitle("User login");
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
	public authentication() {
		super("Login");
		conn = (Connection) ConnectionDB.connect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterAccoountNo = new JLabel("Enter accoount no: ");
		lblEnterAccoountNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterPin = new JLabel("Enter pin: ");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
				
		btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-enter-30.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "select * from account where acc=? and pin=?";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1,textField.getText());
					ps.setString(2, textField_1.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						setVisible(false);
						Loading lo = new Loading();
						lo.setUploading();
						lo.setVisible(true);
						rs.close();
						ps.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Credential");
					}					
				}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
				finally {
					try {
						rs.close();
						ps.close();						
					}catch(Exception e) {}
				}
				
				
			}
		});
		
		JButton btnNewButton = new JButton("Create account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				account auth = null;
				try {
					auth = new account();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				auth.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-add-30.png"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-security-lock-30.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-key-30.png"));
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Lucida Sans", Font.BOLD, 34));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Startup st = new Startup();
				st.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-back-20.png"));
		
		JLabel lblThisLoginIs = new JLabel("This login will verify you are a valid user");
		lblThisLoginIs.setForeground(Color.GREEN);
		lblThisLoginIs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblYouAreNot = new JLabel("You are not an attacker or Robot");
		lblYouAreNot.setForeground(Color.RED);
		
		chckbxAgreeOurTerms = new JCheckBox("Agree our terms and condition");
		chckbxAgreeOurTerms.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!chckbxAgreeOurTerms.isSelected()) {		
					btnLogin.setEnabled(false);				
				}
				else {
					btnLogin.setEnabled(true);
				}
				
			}
		});
         
		
		JButton btnForgotPassword = new JButton("forgot password?");
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				forgot f;
				try {
					f = new forgot();
					f.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(lblUserLogin, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(lblEnterAccoountNo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(lblEnterPin, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(chckbxAgreeOurTerms, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(107)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(232))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(298)
					.addComponent(lblThisLoginIs, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(442)
					.addComponent(lblYouAreNot))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(422, Short.MAX_VALUE)
					.addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(379))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addGap(45)
					.addComponent(lblUserLogin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterAccoountNo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterPin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addComponent(chckbxAgreeOurTerms)
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnForgotPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblThisLoginIs)
					.addGap(7)
					.addComponent(lblYouAreNot))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
