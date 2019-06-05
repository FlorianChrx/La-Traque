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
	public void start(Stage stage) throws IOException, ClassNotFoundException{
		loader = new FXMLLoader();
		
		setScene(Interface.MAINMENU, stage);
        
        stage.setWidth(Double.MAX_VALUE);
        stage.setHeight(Double.MAX_VALUE);
        
        stage.setTitle("Chasse au Monstre");
        stage.show();
	}
	
	public static Controller getController() {
		return loader.getController();
	}
	
	private void setScene(Interface i, Stage stage) throws IOException{
		loader.setLocation(getClass().getResource(i.getLink()));
		stage.setScene(new Scene(loader.load()));
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
}
