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
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
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
	private boolean win = false;
	private Village vil;
	private boolean waitForAction;
	private Lieu lieuChoisi = null;
	private Enqueteur enqueteur;
	private Tueur tueur;
	private Personnage playingPerso = enqueteur;
	private List<Lieu> voisin;
	private List<Rectangle> rectVoisin;
	
	public void initialize() throws IOException, ClassNotFoundException{
		ois = new ObjectInputStream(new FileInputStream("DATA/test.txt"));  //chargement du village
		vil = (Village) ois.readObject();
		ois.close();
		
		enqueteur = new EEnqueteur(vil);   //instanciation des personnage
		tueur = new TTueur(vil);
		label.setText(enqueteur.canDoAction()+"");
		
		rectVoisin = new ArrayList<>();
		voisin = new ArrayList<Lieu>();
		
		
		
		image = new ImageView(new Image(new FileInputStream("DATA/village.jpg"))); //instanciation de l'image
		vBox.getChildren().clear();										//reinitialisation de la vBox car sinon image invisible
		vBox.getChildren().addAll(menu,image,hBox);
		
		tour(enqueteur);
		
	}
	
	public void tour(Personnage p) {
		do {
			if (win) {
				break;
			}
			waitForAction = true;
			montrerLieux(p);
		} while (p.canDoAction());
	}
	
	public Rectangle montrerLieu(Lieu l, Paint fill, Paint stroke) {
		Rectangle r = new Rectangle(l.getSurface().getOrigine().getX(),l.getSurface().getOrigine().getY()+30,l.getSurface().getWidth(),l.getSurface().getHeight());
		r.setFill(fill);
		r.setStroke(stroke);
		r.setOpacity(0.25);
		pane.getChildren().add(r);
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
		rectVoisin.clear();
		voisin.clear();
	}
	
	public void doEnquettez() {
		
	}
	
	public void doCapacite() {
		
	}
	
	public void imageClicked(MouseEvent e) {
		if(waitForAction)
			for(Rectangle r : rectVoisin)
				if(r.contains(new Point2D(e.getSceneX(), e.getSceneY()))) {
					playingPerso.action(voisin.get(rectVoisin.indexOf(r)));
					clearVoisin();
					montrerLieux(playingPerso);
				}
		waitForAction = false;
	}
}
