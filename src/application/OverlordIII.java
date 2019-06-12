package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class OverlordIII extends SController{
	@FXML
	ImageView iA;
	@FXML
	ImageView jcJ;
	@FXML
	Text iAText;
	@FXML
	Text jcJText;
	
	public void initialize() {
		
		iA.setOpacity(0.8);
		jcJ.setOpacity(0.8);
		iAText.setOpacity(0.3);
		jcJText.setOpacity(0.3);		
	}
	
	public void imageOpacityOverIA(MouseEvent event) {
		iA.setOpacity(1);
		iAText.setOpacity(1);
	}
	
	public void imageOpacityOverJcJ(MouseEvent event) {
		jcJ.setOpacity(1);
		jcJText.setOpacity(1);
	}
	
	public void imageOpacityQuitIA(MouseEvent event) {
		iA.setOpacity(0.8);
		iAText.setOpacity(0.3);
	}
	
	public void imageOpacityQuitJcJ(MouseEvent event) {
		jcJ.setOpacity(0.8);
		jcJText.setOpacity(0.3);
	}
	
	public void changementUn() throws IOException {
		changeScene(iA, Interface.CHOIXMENU);
		Main.ia = true;
	}
	
	public void changementDeux() throws IOException {
		changeScene(iA, Interface.CHOIXMENU);
		Main.ia = false;
	}
}
