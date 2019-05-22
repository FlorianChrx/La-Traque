package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Structures.Maison;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
		
	List<Maison> maisonList;
	Rectangle rectangle = new Rectangle();
	Maison current;
	boolean maisonSelected = false;
	boolean lastStep = false;
	
	
	public class CircleSelectionHandler implements javafx.event.EventHandler<javafx.scene.input.MouseEvent>{
		
		private Maison m;
		private Pane pane;
		
		public CircleSelectionHandler(Maison m, Pane pane) {
			this.m = m;
			this.pane = pane;
		}
			
		@Override
		public void handle(javafx.scene.input.MouseEvent arg0) {
			if(!maisonSelected) {
				current = m;
				maisonSelected = true;
				m.getRectangle().setFill(Paint.valueOf("808000"));
			} else {
				current.addVoisin(m);
				pane.getChildren().add(new Line(current.getRectangle().getX(),
												current.getRectangle().getY(),
												m.getRectangle().getX(),
												m.getRectangle().getY()));
				current.getRectangle().setFill(Paint.valueOf("5c5c3d"));
				current = null;
				maisonSelected = false;
			}
		}
	}
	
	public void start(Stage primaryStage) {
		maisonList = new ArrayList<Maison>();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ressource/test.txt"));
		Image img = new Image(new ImageView("ressource/village.png"));
		
		
		rectangle.setWidth(10);
		rectangle.setHeight(10);
		rectangle.setStroke(Paint.valueOf("000000"));
		rectangle.setFill(Paint.valueOf("0000ff"));
		rectangle.setOpacity(0.5);
		
		
		Label lb = new Label("Selectionnez les maisons");
		Button bt = new Button("Fin");
		
		HBox hBox = new HBox(bt, lb);
		Pane pane = new Pane(img);
		pane.getChildren().add(rectangle);
		VBox vBox = new VBox(pane, hBox);
		
		bt.setOnAction(e -> {
			if(lastStep) {
				os.setObject(maisonList);
				lb.setText("Sauvegarde Validé");
				pane.getChildren().remove(2, pane.getChildren().size());
			} else {
				lastStep = true;	
				lb.setText("Selectionnez les connections");
			}
		});
		
		
		img.getImageView().setOnMousePressed(e -> {
			if(!lastStep) {
				rectangle.setLayoutX(e.getSceneX());
				rectangle.setLayoutY(e.getSceneY());
				rectangle.setRadius(0);
			}
		});
		
		img.getImageView().setOnMouseDragged(e -> {
			if(!lastStep) rectangle.setRadius(Math.hypot(e.getSceneX()-rectangle.getLayoutX(),
										e.getSceneY()-rectangle.getLayoutY()));
		});
		
		Scene scene = new Scene(vBox);
		scene.setOnKeyPressed(e -> {
			if(!lastStep && e.getCode() == KeyCode.ENTER) {
				Circle c = new Circle(rectangle.getLayoutX(), rectangle.getLayoutY(), rectangle.getRadius());
				c.setStroke(Paint.valueOf("000000"));
				c.setFill(Paint.valueOf("5c5c3d"));
				c.setOpacity(0.5);
				Maison m = new Maison(c);
				c.setOnMouseClicked(new CircleSelectionHandler(m, pane));
				pane.getChildren().add(c);
				maisonList.add(m);
				rectangle.setRadius(0);
			}
		});
		
		
		primaryStage.setHeight(500);
		primaryStage.setWidth(700);
		
		img.resize(primaryStage);
		img.setHeight(img.getHeight()-20);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
