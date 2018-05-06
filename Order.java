package application;

import java.util.ArrayList;

import javafx.scene.Node;

public class Order {

	String productName;
	ArrayList<Order> orders = new ArrayList<Order>();

	public Order(String name) {

		this.productName = name;

	}

	public Order() {

	}

	public String getProductsInOrder() {

		return this.productName;
	}

	public void add(Order o) {

		orders.add(o);
		getOrders();

	}
	
	public void getOrders() {
		
		System.out.println("Your order contains:");
		
		for(int i=0; i<orders.size(); i++) {
		
		String a = orders.get(i).productName;
		
		System.out.println(a);
		
		
		
	
		}
	}

}
