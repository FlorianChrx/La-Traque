package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private static FXMLLoader loader;
	

	@Override
	public void start(Stage stage) throws IOException, ClassNotFoundException {
		loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("interfaceProjet.fxml"));
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
		stage.setScene(scene);
        
        stage.setWidth(Double.MAX_VALUE);
        stage.setHeight(Double.MAX_VALUE);
        
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
