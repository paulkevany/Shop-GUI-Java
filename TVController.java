package databaseController;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import application.TV;

public class TVController {
	
	ArrayList <TV> TVList = new ArrayList <TV>();
	
	public void saveTV(TV tv){
		
		TVList.add(tv);
		
		//Add tv to database
		
		addTVToDB(tv);
		
		
	}
	
	
	public void addTVToDB(TV tv) {
		
		
		// JDBC driver name and database URL
				// String JDBC_DRIVER = "com.mysql.jdbc.Driver";
				final String DB_URL = "jdbc:mysql://localhost/ProductDB";

				// Database credentials
				final String USER = "root";
				final String PASS = "root";

				Connection conn = null;
				PreparedStatement stmt = null;
				try {
					// STEP 2: Register JDBC driver
					// try {

					// Class.forName("com.mysql.jdbc.Driver");

					// }catch(ClassNotFoundException e) {

					// System.out.println("Unable to find JDBC Class");
					// }

					// STEP 3: Open a connection
					System.out.println("Connecting to database...");
					conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

					System.out.println("Executing Query...");
					String sql = "insert into TV (Make, Type, Size, 3DCapable) VALUES (?, ?, ?, ?)";
					stmt = (PreparedStatement) conn.prepareStatement(sql);

					stmt.setString(1, TV.getMake());
					stmt.setString(2, TV.getType());
					stmt.setInt(3, TV.getSize());
					stmt.setString(4, TV.getThreeDCapable());

					int rows = stmt.executeUpdate();
					System.out.println(rows + " row updated!");

					sql = "SELECT * from Phone";
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {

						// Print data here

					}

					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Handle errors for JDBC

					System.out.println("Couldn't find JDBC Driver");

					se.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {

				}
				try {
					if (conn != null)

						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		
		
		
		
	}
	

