package Banking_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Reset extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int account;
	private forgot f;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset frame = new Reset();
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
	public Reset() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblResetYourPassword = new JLabel("Reset your password");
		lblResetYourPassword.setFont(new Font("Verdana", Font.BOLD, 30));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter your account");
				}
				else {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter your pin");
				}
				else {
					if(textField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Confirm your pin");
					}
					else {
						if(textField.getText().length()<4 || textField.getText().length()>8) {
							JOptionPane.showMessageDialog(null, "4-8 digits");
						}
						else {
							if(!(textField.getText().equals(textField_1.getText()))) {
								JOptionPane.showMessageDialog(null, "pin didn't match");
							}
							else {
								Connection conn = ConnectionDB.connect();
								PreparedStatement ps = null;				
								String sql = "update account set pin =? where acc=?";
								try {
									ps = conn.prepareStatement(sql);
									ps.setString(2, textField_2.getText());
									ps.setString(1,textField_1.getText());
									ps.executeUpdate();
									JOptionPane.showMessageDialog(null, "Pin has been reset!");
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							
						}
					}
				}
			}
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewPin = new JLabel("New pin:");
		lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblConfirmPin = new JLabel("Confirm pin:");
		lblConfirmPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(81)
							.addComponent(lblResetYourPassword))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(353)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewPin)
								.addComponent(lblConfirmPin)
								.addComponent(lblAccount))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
					.addGap(326))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(67)
					.addComponent(lblResetYourPassword)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAccount))
							.addGap(37)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewPin))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPin))
					.addGap(18)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
