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
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import util.Game;

public class Controller {
	@FXML
	private VBox vBox;
	@FXML
	private ImageView image;
	@FXML
	private HBox hBox;
	@FXML
	private Button enquettez;
	@FXML
	private Button capacite;
	@FXML
	private Text label;
	@FXML
	private Pane pane;
	@FXML
	private Label nbAction;
	
	private ObjectInputStream ois;
	private Village vil;
	private Enqueteur enqueteur;
	private Tueur tueur;
	private List<Lieu> voisin;
	private List<Rectangle> rectVoisin;
	private Rectangle tueurRectangle;
	private Game game;
	private double rectOpacity;

	
	public void initialize() throws IOException, ClassNotFoundException{
		
		image = new ImageView(new Image(new FileInputStream("DATA/village2.png"))); //instanciation de l'image
		vBox.getChildren().clear();										//reinitialisation de la vBox car sinon image invisible
		vBox.getChildren().addAll(image,hBox);
		
		tueurRectangle = new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE);
		tueurRectangle.setOpacity(0.5);
		tueurRectangle.setFill(Color.valueOf("000000"));
		
		ois = new ObjectInputStream(new FileInputStream("DATA/test2.txt"));  //chargement du village
		vil = (Village) ois.readObject();
		ois.close();
		
		rectOpacity = 0.3;
		
		enqueteur = new EEnqueteur(vil.getLieu("Z"));   //instanciation des personnage
		tueur = new TTueur(vil.getLieu("C"));
		
		game = new Game(vil, tueur, enqueteur);

		nbAction.setText("Action possible : "+game.getActualPlayer().getNbActions());
		
		rectVoisin = new ArrayList<>();
		voisin = new ArrayList<Lieu>();
		
		montrerLieux(enqueteur);
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
	
	public Rectangle montrerLieu(Lieu l, Paint fill, Paint stroke) {
		Rectangle r = new Rectangle(l.getSurface().getOrigine().getX(),l.getSurface().getOrigine().getY(),l.getSurface().getWidth(),l.getSurface().getHeight());
		r.setFill(fill);
		r.setStroke(stroke);
		r.setOpacity(rectOpacity);
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
		Rectangle r = montrerLieu(p.getLieu(), Color.valueOf("6062b2"), Color.valueOf("000000"));
		r.setOpacity(0.5);
		rectVoisin.add(r);
		voisin.add(p.getLieu());
		montrerVoisinPlayer(p);
	}
	
	public void clearVoisin() {
		pane.getChildren().removeAll(rectVoisin);
		rectVoisin.clear();
		voisin.clear();
	}
	
	public class RectangleHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent e) {
			nbAction.setText("Action possible : "+game.getActualPlayer().getNbActions());
			if(rectVoisin.contains((Rectangle) e.getSource())) {
				label.setText(game.resultatEvenement(voisin.get(rectVoisin.indexOf((Rectangle) e.getSource()))));
			}
			clearVoisin();
			montrerLieux(game.getActualPlayer());
			if(game.getActualPlayer() instanceof Tueur) {
				image.setEffect(new ColorAdjust(0,0,-0.6,0));
				setRanctangleOpacity(0.1);
			} else {
				image.setEffect(new ColorAdjust(0,0,0,0));
				setRanctangleOpacity(0.3);
			}
		}
	}
	
	public void setRanctangleOpacity(double value) {
		rectOpacity = value;
		clearVoisin();
		montrerLieux(game.getActualPlayer());
	}
}
