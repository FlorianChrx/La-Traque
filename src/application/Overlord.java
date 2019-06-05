package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Overlord {
	@FXML
	ImageView imageHunt;
	@FXML
	ImageView imagePrey;
	@FXML
	Text textHunt;
	@FXML
	Text textPrey;
	
	public void initialize() {
		
		imageHunt.setOpacity(0.8);
		imagePrey.setOpacity(0.8);
		textHunt.setOpacity(0.3);
		textPrey.setOpacity(0.3);
		
	}
	
	public void imageOpacityOverHunt(MouseEvent event) {
		imageHunt.setOpacity(1);
		textHunt.setOpacity(1);
	}
	
	public void imageOpacityOverPrey(MouseEvent event) {
		imagePrey.setOpacity(1);
		textPrey.setOpacity(1);
	}
	
	public void imageOpacityQuitHunt(MouseEvent event) {
		imageHunt.setOpacity(0.8);
		textHunt.setOpacity(0.3);
	}
	
	public void imageOpacityQuitPrey(MouseEvent event) {
		imagePrey.setOpacity(0.8);
		textPrey.setOpacity(0.3);
	}
}
