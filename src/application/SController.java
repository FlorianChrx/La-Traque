package application;

import java.io.IOException;

import javafx.scene.Node;
import javafx.stage.Stage;

public class SController {
	public void changeScene(Node n, Interface i) throws IOException {
		setScene(i, (Stage) n.getScene().getWindow());
	}
	
	private void setScene(Interface i, Stage stage) throws IOException{
		stage.setScene(i.newScene());
	}
}
