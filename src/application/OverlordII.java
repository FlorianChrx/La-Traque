package application;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class OverlordII {
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
	public void overJouer() {
		jouer.setOpacity(1);
	}
	public void exitJouer() {
		jouer.setOpacity(0);
	}
	
	public void overQuitter() {
		quitter.setOpacity(1);
		rune.setOpacity(0.4);
	}
	public void exitQuitter() {
		quitter.setOpacity(0);
		rune.setOpacity(0);
	}
}
