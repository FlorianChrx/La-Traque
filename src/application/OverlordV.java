package application;

import java.io.IOException;

import classes.EFauconnier;
import classes.MaitreChien;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class OverlordV extends SController {
	@FXML
	ImageView imageChien;
	@FXML
	ImageView imageFaucon;
	@FXML
	Text titleChien;
	@FXML
	Text titleFaucon;
	@FXML
	Text textChien;
	@FXML
	Text textFaucon;
	
	public void initialize() {
		
		imageChien.setOpacity(0.8);
		imageFaucon.setOpacity(0.8);
		titleChien.setOpacity(0.3);
		titleFaucon.setOpacity(0.3);
		textChien.setOpacity(0.3);
		textFaucon.setOpacity(0.3);		
	}
	
	public void imageOpacityOverChien(MouseEvent event) {
		imageChien.setOpacity(1);
		titleChien.setOpacity(1);
		textChien.setOpacity(1);
	}
	
	public void imageOpacityOverFaucon(MouseEvent event) {
		imageFaucon.setOpacity(1);
		titleFaucon.setOpacity(1);
		textFaucon.setOpacity(1);	
	}
	
	public void imageOpacityQuitChien(MouseEvent event) {
		imageChien.setOpacity(0.8);
		titleChien.setOpacity(0.3);
		textChien.setOpacity(0.3);
	}
	
	public void imageOpacityQuitFaucon(MouseEvent event) {
		imageFaucon.setOpacity(0.8);
		titleFaucon.setOpacity(0.3);
		textFaucon.setOpacity(0.3);	
	}
	
	public void choixChien() throws IOException {
		Main.enqueteur = new MaitreChien(Main.village);
		changeScene(imageChien, Interface.TUEURMENU);
	}
	
	public void choixFaucon() throws IOException {
		Main.enqueteur = new EFauconnier(Main.village);
		changeScene(imageChien, Interface.TUEURMENU);
	}
}