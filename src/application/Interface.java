package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public enum Interface {
	MAINMENU("interface_first.fxml"), MODEMENU("interface_nbJoueur.fxml"), CHOIXMENU("interface.fxml"), ENQUETEURMENU("interfaceChoixEnqueteur.fxml"), TUEURMENU("interfaceChoixTueur.fxml");
	private String link;
	Interface(String link){
		this.link = link;
	}
	public String getLink() {
		return link;
	}
	public Scene newScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(getLink()));
		return new Scene(loader.load());
	}
}
