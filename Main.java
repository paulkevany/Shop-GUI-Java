package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = new TabPane();
			Scene scene = new Scene(root,650,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			//Create tabs 
			
			Tab TVS = new Tab();
			Tab Phones = new Tab();
			Tab Products = new Tab();
			
			//Tab settings
			
			TVS.setText("Add TV's");
			Phones.setText("Add Phone's");
			Products.setText("View Products");
			
			//Tab setContent methods
			
			TVS.setContent(TV.setGuiElements());
			Phones.setContent(Phone.setGuiElements());
			Products.setContent(Product.setGuiElements());
			
			
			//Add tabs to tabPane
			root.getTabs().addAll(Phones, TVS, Products);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
