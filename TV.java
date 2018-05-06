package application;

import databaseController.TVController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TV {
	
	static TVController TVC = new TVController();

	static String TVMake;
	static int TVSize;
	static String TVType;
	static String TV3DCapable;

	public TV(String Make, String Type, int ScreenSize,  String capable3D) {

		TV.TVMake = Make;
		TV.TVSize = ScreenSize;
		TV.TVType = Type;
		TV.TV3DCapable = capable3D;

	}

	public static Node setGuiElements() {

		VBox vb = new VBox(30);

		vb.setAlignment(Pos.TOP_CENTER);

		Label title = new Label("Add TV");
		title.setPadding(new Insets(15));
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));

		Label MakeL = new Label("Make: ");
		Label TypeL = new Label("Type: ");
		Label SizeL = new Label("Size: ");
		Label ThreeDL = new Label("3D:  ");

		TextField MakeTF = new TextField();
		TextField TypeTF = new TextField();
		TextField SizeTF = new TextField();
		ChoiceBox<String> ThreeDCB = new ChoiceBox<String>();
		
		ThreeDCB.getItems().addAll("Yes", "No");
		

		MakeL.setLabelFor(MakeTF);
		TypeL.setLabelFor(TypeTF);
		SizeL.setLabelFor(SizeTF);
		ThreeDL.setLabelFor(ThreeDCB);

		MakeTF.setMaxWidth(175);
		TypeTF.setMaxWidth(175);
		SizeTF.setMaxWidth(60);
		ThreeDCB.setMaxWidth(50);

		// Button to add TV
		Button addTV = new Button("Add TV");

		// Set button handler

		addTV.setOnAction(e -> {

			// TV -> addTV method
			try {

				
				TVMake = MakeTF.getText();
				TVType = TypeTF.getText();
				TVSize = Integer.parseInt(SizeTF.getText());
				TV3DCapable = ThreeDCB.getSelectionModel().getSelectedItem();
					
				createTV(TVMake, TVType, TVSize, TV3DCapable);
				
				
				

			} catch (Exception q) {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Error Occured");
				alert.setContentText("Unable to create TV");
				alert.showAndWait();

			}

		});

		HBox hb = new HBox(10);
		HBox hb1 = new HBox(10);
		HBox hb2 = new HBox(10);
		HBox hb3 = new HBox(10);

		// HBox's for displaying label next to textfield

		hb.getChildren().addAll(MakeL, MakeTF);
		hb1.getChildren().addAll(TypeL, TypeTF);
		hb2.getChildren().addAll(SizeL, SizeTF);
		hb3.getChildren().addAll(ThreeDL, ThreeDCB);

		// Set Alignment
		hb.setAlignment(Pos.CENTER);
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);

		vb.getChildren().addAll(title, hb, hb1, hb2, hb3, addTV);
		return vb;

	}

	public static void createTV(String TVModel, String TVType , int TVSize, String ThreeD) {

		if (TVModel.isEmpty() || TVType.isEmpty() || TVSize == 0) {

			// If textFields are empty

			try {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Data Error");
				alert.setContentText("Please fill in all fields");
				alert.showAndWait();

			} catch (Exception e) {

				System.out.println("Unable to show alert");
			}

		} else {

			TV tv = new TV(TVMake, TVType, TVSize, TV3DCapable);

			//Save TV 
			
			TVC.saveTV(tv);

		}
	}
	
	
	public static String getMake() {
		
		return TVMake;
		
	}
	
public static String getType() {
		
		return TVType;
		
	}

public static int getSize() {
	
	return TVSize;
	
}

public static String getThreeDCapable() {
	
	return TV3DCapable;
	
}
	

}