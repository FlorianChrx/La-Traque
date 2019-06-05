package application;

public enum Interface {
	MAINMENU("interface_first.fxml"), PERSOMENU(""), MONMENU("");
	private String link;
	Interface(String link){
		this.link = link;
	}
	public String getLink() {
		return link;
	}
}
