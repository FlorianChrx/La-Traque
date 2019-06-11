package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Entities.Enqueteur;
import Entities.Tueur;
import Structures.Village;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static FXMLLoader loader;
	public static boolean ia;
	public static Tueur tueur;
	public static Enqueteur enqueteur;
	public static Village village;
	
	@Override
	public void start(Stage stage) throws IOException, ClassNotFoundException {
		loader = new FXMLLoader();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA/test.txt"));  //chargement du village
		village = (Village) ois.readObject();
		ois.close();
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
	
	public static void end() {
		
	}
	
}
