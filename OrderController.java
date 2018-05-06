package databaseController;

import java.util.ArrayList;

import application.Order;

public class OrderController {
	
	
	ArrayList <Order> orders = new ArrayList <Order>();
	



public Order getProductsInOrder() {
	
	Order p = null;
	
	
	for(int i = 0; i<orders.size(); i++) {
	
		 p = orders.get(i);
}
	
	return p;


}

























}