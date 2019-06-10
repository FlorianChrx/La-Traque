package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class OverlordII extends SController {
	@FXML
	Text jouer;
	@FXML
	Text quitter;
	@FXML
	ImageView rune;
	
	public void initialize() {
		jouer.setOpacity(0);
		quitter.setOpacity(0);
		rune.setOpacity(0);
	}
	public void overJouer(MouseEvent event) {
		jouer.setOpacity(1);
	}
	public void exitJouer(MouseEvent event) {
		jouer.setOpacity(0);
	}
	
	public void overQuitter(MouseEvent event) {
		quitter.setOpacity(1);
		rune.setOpacity(0.4);
	}
	public void exitQuitter(MouseEvent event) {
		quitter.setOpacity(0);
		rune.setOpacity(0);
	}
	
	public void clicJouer(MouseEvent event) throws IOException {
		changeScene(jouer, Interface.MODEMENU);
	}
}
