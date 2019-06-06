package application;

public enum Interface {
	MAINMENU("interface_first.fxml"), MODEMENU("interface_nbJoueur.fxml"), CHOIXMENU("interface.fxml"), ENQUETEURMENU("interfaceChoixEnqueteur.fxml"), TUEURMENU("interfaceChoixTueur.fxml");
	private String link;
	Interface(String link){
		this.link = link;
	}
	public String getLink() {
		return link;
	}
}
