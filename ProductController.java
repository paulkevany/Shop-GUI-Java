package databaseController;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import application.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductController {
	
	Order o = new Order();
	
	public ObservableList<String> getProducts() {

	ObservableList <String> products = FXCollections.observableArrayList();
	

	//Get products from db
	
	 Connection conn = null;
	   Statement stmt = null;
	   
	      //STEP 2: Register JDBC driver
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ProductDB","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String sql;
	      sql = "select Model from Phone";
	      
	      ResultSet rs = null;
	      
		try {
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      //STEP 5: Extract data from result set
	      try {
			while(rs.next()){
			     //Retrieve by column name
			
				products.addAll(rs.getString(1));
				
				
				
			  }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //try {
			//stmt.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	    //  try {
			//conn.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	   
	

	
	
			
		return products;
	}
	
	
	
	public void addToOrder(String name) {
		
	
		
		Order order = new Order(name);
		
		o.add(order);
		
		
		
	}
	

}
