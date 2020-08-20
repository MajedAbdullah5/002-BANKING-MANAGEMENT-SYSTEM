package Banking_management;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
	ResultSet rs;
	PreparedStatement ps;
	int s = 0;
	Thread th;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            //here you can put the selected theme class name in JTattoo
			 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setTitle("Loading....");
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
	public Loading() {
		super("Loading");
		//conn = (Connection) ConnectionDB.connect();
		th = new Thread((Runnable)this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Majed Abdullah\\Downloads\\icons8-loading-100.png"));
		
		JLabel lblLoading = new JLabel("Redirecting.....");
		lblLoading.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblThisSoftwareIs = new JLabel("This software is redirecting to the tursted site");
		lblThisSoftwareIs.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addGap(338))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(163)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(173, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(466, Short.MAX_VALUE)
					.addComponent(lblLoading, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(387))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(406, Short.MAX_VALUE)
					.addComponent(lblThisSoftwareIs)
					.addGap(349))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblLoading, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(lblThisSoftwareIs)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void setUploading() {
		setVisible(false);
		th.start();
		
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i<=200;i++) {
				s=s+1;
				int m = progressBar.getMaximum();
				int v = progressBar.getValue();
				if(v<m) {
					progressBar.setValue(progressBar.getValue()+1);
				}
				else {
					i = 201;
					setVisible(false);
					Home home = new Home();
					home.setVisible(true);
				}
				Thread.sleep(50);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
}
