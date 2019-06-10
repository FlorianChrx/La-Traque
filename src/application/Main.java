package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static FXMLLoader loader;
	
	@Override
	public void start(Stage stage) throws IOException, ClassNotFoundException {
		loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("interfaceProjet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
		stage.setScene(scene);

        
        stage.setTitle("Chasse au Monstre");
        stage.show();
	}
	
	public static Controller getController() {
		return loader.getController();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
}
