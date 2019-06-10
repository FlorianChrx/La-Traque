package application;

import java.io.IOException;

import Entities.Enqueteur;
import Entities.Tueur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private static FXMLLoader loader;
	public boolean ia;
	public static Tueur tueur;
	public static Enqueteur enqueteur;
	
	
	
	@Override
	public void start(Stage stage) throws IOException, ClassNotFoundException{
		loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("interface_first.fxml"));
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
