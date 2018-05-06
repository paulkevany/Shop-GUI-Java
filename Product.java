package application;

import java.util.ArrayList;

import databaseController.ProductController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Product {

	static ProductController pc = new ProductController();
	
	ArrayList <String> productsInDB = new ArrayList<String>();
	
	public static Node setGuiElements() {
		
		VBox vb = new VBox(30);
		
		Label title = new Label("Products for Sale");
		
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		
		ComboBox <String> products = new ComboBox <String>();
		
		products.getItems().addAll(pc.getProducts());
		
		Button buy = new Button("Buy");

		vb.getChildren().addAll(title, products, buy);
		
		vb.setAlignment(Pos.CENTER);
		
		buy.setOnAction(e->{
			
			pc.addToOrder(products.getSelectionModel().getSelectedItem());
			
			buy.setDisable(true);
			
			
		});
		
				
		
		return vb;
		
		
	}
	
	
	
	
}
