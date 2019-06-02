package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("interfaceProjet.fxml"));
        Parent root = loader.load();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
        
        stage.setWidth(Double.MAX_VALUE);
        stage.setHeight(Double.MAX_VALUE);
        
        stage.setTitle("Chasse au Monstre");
        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
