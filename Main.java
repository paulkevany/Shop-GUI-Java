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
			Scene scene = new Scene(root,650,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			//Create tabs 
			
			Tab TV = new Tab();
			Tab Phone = new Tab();
			Tab Orders = new Tab();
			
			//Tab settings
			
			TV.setText("Buy TV's");
			Phone.setText("Buy Phone's");
			Orders.setText("View Orders");
			
			//Tab setContent methods
			
			//TV.setContent();
			//Phone.setContent();
			
			
			//Add tabs to tabPane
			root.getTabs().addAll(Phone, TV, Orders);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
