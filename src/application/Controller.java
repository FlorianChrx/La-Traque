package application;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import Entities.Enqueteur;
import Entities.Personnage;
import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;
import classes.EEnqueteur;
import classes.TTueur;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import util.Game;

public class Controller {
	@FXML
	private VBox vBox;
	@FXML
	private MenuBar menu;
	@FXML
	private Menu file;
	@FXML
	private Menu help;
	@FXML
	private Menu edit;
	@FXML
	private ImageView image;
	@FXML
	private HBox hBox;
	@FXML
	private Button enquettez;
	@FXML
	private Button capacite;
	@FXML
	private Label label;
	@FXML
	private Pane pane;
	private ObjectInputStream ois;
	private Village vil;
	private boolean waitForAction;
	private Enqueteur enqueteur;
	private Tueur tueur;
	private Personnage playingPerso;
	private List<Lieu> voisin;
	private List<Rectangle> rectVoisin;
	private Rectangle tueurRectangle;
	private Game game;

	
	public void initialize() throws IOException, ClassNotFoundException{
		image = new ImageView(new Image(new FileInputStream("DATA/village.jpg"))); //instanciation de l'image
		vBox.getChildren().clear();										//reinitialisation de la vBox car sinon image invisible
		vBox.getChildren().addAll(menu,image,hBox);
		
		tueurRectangle = new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE);
		tueurRectangle.setOpacity(0.5);
		tueurRectangle.setFill(Color.valueOf("000000"));
		
		ois = new ObjectInputStream(new FileInputStream("DATA/test.txt"));  //chargement du village
		vil = (Village) ois.readObject();
		ois.close();
		
		
		
		enqueteur = new EEnqueteur(vil.getLieu("Z"));   //instanciation des personnage
		tueur = new TTueur(vil.getLieu("B"));
		
		game = new Game(vil, tueur, enqueteur, -1);
		
		rectVoisin = new ArrayList<>();
		voisin = new ArrayList<Lieu>();
		
		tour(enqueteur);
	}
	
	
	
	public void doEnquettez() {
		label.setText(game.resultatEvenement(game.getActualPlayer().getLieu()));
		clearVoisin();
		montrerLieux(game.getActualPlayer());
	}
	
	public void doCapacite() {
		
	}
	
	public void imageClicked(MouseEvent e) {
		
	}
	
	public void tour(Personnage p) {
		playingPerso = p;
		montrerLieux(p);
		if(p.canDoAction()) {
			waitForAction = true;
		}
	}
	
	public Rectangle montrerLieu(Lieu l, Paint fill, Paint stroke) {
		Rectangle r = new Rectangle(l.getSurface().getOrigine().getX(),l.getSurface().getOrigine().getY()+30,l.getSurface().getWidth(),l.getSurface().getHeight());
		r.setFill(fill);
		r.setStroke(stroke);
		r.setOpacity(0.25);
		pane.getChildren().add(r);
		r.setOnMouseClicked(new RectangleHandler());
		return r;
	}
	
	public void montrerVoisinPlayer(Personnage p) {
		Lieu l = p.getLieu();
		for(Lieu lieu : l.getVoisins()) {
			rectVoisin.add(montrerLieu(lieu, Color.valueOf("ffffff"), Color.valueOf("ffffff")));
			voisin.add(lieu);
		}
	}
	
	public void montrerLieux(Personnage p) {
		montrerLieu(p.getLieu(), Color.valueOf("ffffff"), Color.valueOf("000000"));
		montrerVoisinPlayer(p);
	}
	
	public void clearVoisin() {
		pane.getChildren().removeAll(rectVoisin);
		pane.getChildren().remove(pane.getChildren().size()-1);
		rectVoisin.clear();
		voisin.clear();
	}
	
	public class RectangleHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent e) {
			if(rectVoisin.contains((Rectangle) e.getSource())) {
				label.setText(game.resultatEvenement(voisin.get(rectVoisin.indexOf((Rectangle) e.getSource()))));
				clearVoisin();
				montrerLieux(game.getActualPlayer());
			}
			//endOfTurn();
			clearVoisin();
			montrerLieux(game.getActualPlayer());
		}
	}
	
	public void endOfTurn() {
		if(playingPerso == enqueteur) {
			playingPerso = tueur;
			System.out.println("Tueur joue");
			tueurRectangle.setOpacity(0.5);
		}else if(playingPerso == tueur) {
			playingPerso = enqueteur;
			System.out.println("Enquetteur joue");
			Game.updateAll(vil, tueur, enqueteur);
		}
		label.setText(label.getText()+"\n"+playingPerso.getName() + " c'est à toi de jouer");
		clearVoisin();
		tour(playingPerso);
	}
	
	public void checkWin(Personnage p) {
		label.setText(label.getText()+"\n"+p.getName() + " Vous avez gagnez");
		System.out.println(p.getName() + " Vous avez gagnez");
	}
}
