package databaseController;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import application.Phone;

public class PhoneController {

	ArrayList<Phone> PhoneList = new ArrayList<Phone>();

	public void savePhone(Phone phone) {

		PhoneList.add(phone); // Phone saved locally

		System.out.println(getPhonesList());

		// Add to database

		addPhoneToDb(phone);

		// TODO Auto-generated catch block

	}

	public String getPhonesList() {

		String make = "";
		String model = "";

		for (int i = 0; i < PhoneList.size(); i++) {

			make = PhoneList.get(i).getMake();
			model = PhoneList.get(i).getModel();

		}
		System.out.println(make);
		return model;

	}

	public void addPhoneToDb(Phone phone) {

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
			String sql = "insert into Phone (Make, Model, Storage) VALUES (?, ?, ?)";
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			stmt.setString(1, phone.getMake());
			stmt.setString(2, phone.getModel());
			stmt.setInt(3, phone.getStorage());

			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);

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
