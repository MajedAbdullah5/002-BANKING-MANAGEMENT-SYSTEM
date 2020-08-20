package Banking_management;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;

public class ConnectionDB {
	 private static java.sql.Connection conn = null;
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bank_management?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");			
			}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		return (Connection)conn;
	}
	
	

}
