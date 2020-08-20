package Banking_management;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Banking_management.ConnectionDB;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Admin extends JFrame {

	private JPanel contentPane;	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private JPanel panel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setTitle("Admin panel");
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
	public Admin() {	
		conn = null;
		ps = null;
		rs = null;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -401, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -838, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 842, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setRowMargin(10);
		table.setRowHeight(40);
		table.setMinimumSize(new Dimension(150, 150));
		table.setIntercellSpacing(new Dimension(5, 0));
		table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		table.setBackground(new Color(245, 245, 220));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(1)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 849, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(2821, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(2)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1702, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		JButton btnListUser = new JButton("List User");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnListUser, 75, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnListUser, 1, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnListUser, 130, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnListUser, -5, SpringLayout.WEST, panel);
		btnListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn = ConnectionDB.connect();
				String sql = "select name,acc,acc_type,nationality,mobile,balance from account order by id desc";
				try {
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnListUser.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-list-40.png"));
		contentPane.add(btnListUser);
		btnListUser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton = new JButton("Specific ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 22, SpringLayout.SOUTH, btnListUser);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 1, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -267, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.WEST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specific_user usr = new specific_user();
				usr.setVisible(true);	
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-user-male-50.png"));
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnNewButton_1 = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 33, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnListUser);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -179, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, panel);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise = JOptionPane.showConfirmDialog(null, "Are you sure?","Delete user",JOptionPane.YES_NO_OPTION);
				if(choise == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				String cell = table.getModel().getValueAt(row, 1).toString();
				String sql = "delete from account where acc=?";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, cell);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Account has been deleted!");
					updateTable();
				} catch (SQLException f) {				
					f.printStackTrace();
				}
}
	else {
		JOptionPane.showMessageDialog(null, "Cancelled deletion!");
	}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-delete-bin-40.png"));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 327, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 1, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 87, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -6, SpringLayout.WEST, panel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_authentication at = new admin_authentication();
				at.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\eclipse-workspace\\Banking_management_system\\src\\Banking_management\\icons\\icons8-back-20.png"));
		contentPane.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAccountNo, -3, SpringLayout.NORTH, panel);
		contentPane.add(lblAccountNo);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("NAME");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblName, -4, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblName, -70, SpringLayout.WEST, lblAccountNo);
		contentPane.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblAccountType = new JLabel("ACCOUNT TYPE");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAccountType, -4, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAccountType, -419, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAccountNo, -25, SpringLayout.WEST, lblAccountType);
		contentPane.add(lblAccountType);
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblMobile = new JLabel("MOBILE");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMobile, -5, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMobile, -181, SpringLayout.EAST, contentPane);
		contentPane.add(lblMobile);
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblBalance = new JLabel("BALANCE");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBalance, -5, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBalance, -36, SpringLayout.EAST, contentPane);
		contentPane.add(lblBalance);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNationality = new JLabel("NATIONALITY");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNationality, -4, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNationality, -289, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMobile, 45, SpringLayout.EAST, lblNationality);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNationality, 14, SpringLayout.EAST, lblAccountType);
		contentPane.add(lblNationality);
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
	}
	public void updateTable() throws SQLException {
		String sql = "select name,acc,acc_type,nationality,mobile,balance from account";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	
	}
	
}


