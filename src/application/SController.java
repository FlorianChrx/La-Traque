package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SController {
	public void changeScene(Node n, Interface i) throws IOException {
		Stage s = (Stage) n.getScene().getWindow();
		setScene(i, s);
	}
	
	private void setScene(Interface i, Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(i.getLink()));
		stage.setScene(new Scene(loader.load()));
	}
}
