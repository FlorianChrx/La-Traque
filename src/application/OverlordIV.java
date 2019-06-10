package application;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class OverlordIV {
	@FXML
	ImageView imageWarper;
	@FXML
	ImageView imageBrute;
	@FXML
	Text titleWarper;
	@FXML
	Text titleBrute;
	@FXML
	Text textWarper;
	@FXML
	Text textBrute;
	
	public void initialize() {
		
		imageWarper.setOpacity(0.8);
		imageBrute.setOpacity(0.8);
		titleWarper.setOpacity(0.3);
		titleBrute.setOpacity(0.3);
		textWarper.setOpacity(0.3);
		textBrute.setOpacity(0.3);		
	}
	
	public void imageOpacityOverWarper(MouseEvent event) {
		imageWarper.setOpacity(1);
		titleWarper.setOpacity(1);
		textWarper.setOpacity(1);
	}
	
	public void imageOpacityOverBrute(MouseEvent event) {
		imageBrute.setOpacity(1);
		titleBrute.setOpacity(1);
		textBrute.setOpacity(1);	
	}
	
	public void imageOpacityQuitWarper(MouseEvent event) {
		imageWarper.setOpacity(0.8);
		titleWarper.setOpacity(0.3);
		textWarper.setOpacity(0.3);
	}
	
	public void imageOpacityQuitBrute(MouseEvent event) {
		imageBrute.setOpacity(0.8);
		titleBrute.setOpacity(0.3);
		textBrute.setOpacity(0.3);	
	}
}
