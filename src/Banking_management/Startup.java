package Banking_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Startup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startup frame = new Startup();
					frame.setTitle("Welcome!");
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
	public Startup() {
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
		
		JLabel lblVeryNiceTo = new JLabel("VERY NICE TO SEE YOU HERE!");
		lblVeryNiceTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeryNiceTo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		panel.add(lblVeryNiceTo);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		sl_panel.putConstraint(SpringLayout.NORTH, lblVeryNiceTo, 59, SpringLayout.SOUTH, lblWelcome);
		sl_panel.putConstraint(SpringLayout.NORTH, lblWelcome, 107, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblWelcome, -311, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblWelcome, 398, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblWelcome, -385, SpringLayout.EAST, panel);
		lblWelcome.setBackground(Color.LIGHT_GRAY);
		lblWelcome.setForeground(new Color(255, 140, 0));
		lblWelcome.setFont(new Font("Monotype Corsiva", Font.BOLD, 50));
		panel.add(lblWelcome);
		
		JButton btnAdmin = new JButton("ADMIN");
		sl_panel.putConstraint(SpringLayout.NORTH, btnAdmin, 61, SpringLayout.SOUTH, lblVeryNiceTo);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAdmin, -97, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblVeryNiceTo, 0, SpringLayout.WEST, btnAdmin);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin_authentication admin = new admin_authentication();
				admin.setVisible(true);
			}
		});
		btnAdmin.setBackground(new Color(205, 133, 63));
		btnAdmin.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-admin-settings-male-60.png"));
		sl_panel.putConstraint(SpringLayout.EAST, btnAdmin, 509, SpringLayout.WEST, panel);
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sl_panel.putConstraint(SpringLayout.WEST, btnAdmin, 211, SpringLayout.WEST, panel);
		panel.add(btnAdmin);
		
		JButton btnUser = new JButton("USER");
		sl_panel.putConstraint(SpringLayout.NORTH, btnUser, 61, SpringLayout.SOUTH, lblVeryNiceTo);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnUser, -97, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblVeryNiceTo, 0, SpringLayout.EAST, btnUser);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentication auth = new authentication();
				auth.setVisible(true);
			}
		});
		btnUser.setBackground(new Color(205, 133, 63));
		sl_panel.putConstraint(SpringLayout.WEST, btnUser, 6, SpringLayout.EAST, btnAdmin);
		sl_panel.putConstraint(SpringLayout.EAST, btnUser, -185, SpringLayout.EAST, panel);
		btnUser.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-user-60.png"));
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnUser);
	}
}
