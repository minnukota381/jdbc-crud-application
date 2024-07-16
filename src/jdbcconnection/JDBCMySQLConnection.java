package jdbcconnection;

import java.sql.*;

public class JDBCMySQLConnection {

	public static void main(String[] args) {		
		String url = "jdbc:mysql://localhost:3306/minnudb";
		String username = "root";
		String password = "12345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection established");
			
		} catch(Exception e) {
			System.out.println("Error Message :"+e.getMessage());
		}
	}

}
