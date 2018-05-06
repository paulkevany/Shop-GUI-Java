package application;

import databaseController.PhoneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Phone {
	
	static PhoneController pc = new PhoneController(); //Controller method

	static String Make;
	static String Model;
	static int StorageSpace;

	public Phone(String make, String model, int storage) {

		// Constructor

		this.Make = make;
		this.Model = model;
		this.StorageSpace = storage;

	}

	public static Node setGuiElements() {

		VBox vb = new VBox(50);
		
		vb.setAlignment(Pos.TOP_CENTER);

		Label title = new Label("Add Phone");
		title.setPadding(new Insets(15));
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		
		Label makeL = new Label("Make: ");
		Label modelL = new Label("Model: ");
		Label storageL = new Label("Storage: ");
		
		TextField MakeTF = new TextField();
		TextField ModelTF = new TextField();
		TextField StorageTF = new TextField();
		
	
		
		makeL.setLabelFor(MakeTF);
		modelL.setLabelFor(ModelTF);
		
		MakeTF.setMaxWidth(175);
		ModelTF.setMaxWidth(175);
		StorageTF.setMaxWidth(60);
		
		//Button to add phone
		Button addPhone = new Button("Add Phone");
		
		//Set button handler
		
		addPhone.setOnAction(e->{
			
			//Phone -> addPhone method
			try {
				
			Make = MakeTF.getText();
			Model = ModelTF.getText();
			StorageSpace = Integer.parseInt(StorageTF.getText());
				
			createPhone(Make, Model, StorageSpace);
			
			}catch(Exception q) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Error Occured");
				alert.setContentText("Unable to create phone");
				alert.showAndWait();
				
				
				
			}
			
		});
		
		
		HBox hb = new HBox(10);
		HBox hb1 = new HBox(10);
		HBox hb2 = new HBox(10);
		
		//HBox's for displaying label next to textfield
		
		hb.getChildren().addAll(makeL, MakeTF);
		hb1.getChildren().addAll(modelL, ModelTF);
		hb2.getChildren().addAll(storageL, StorageTF);
		
		//Set Alignment
		hb.setAlignment(Pos.CENTER);
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		
		vb.getChildren().addAll(title, hb, hb1, hb2, addPhone);
		return vb;

	}
	
	public static void createPhone(String PhoneMake, String PhoneModel, int PhoneStorage) {
		
		if(PhoneMake.isEmpty()  || PhoneModel.isEmpty() || PhoneStorage == 0 ) {
			
			//If textFields are empty
			
			try {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Data Error");
			alert.setContentText("Please fill in all fields");
			alert.showAndWait();
			
			}catch(Exception e) {
				
				System.out.println("Unable to show alert");
			}
			
		}else {
			
			Phone phone = new Phone(PhoneMake, PhoneModel, PhoneStorage);
			
			//Phone is made, Add to arraylist
			
			pc.savePhone(phone);
			
			
			
			
			
			
			
			
		}
		
		
		
	}
	

}
