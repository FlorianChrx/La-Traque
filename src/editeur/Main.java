package editeur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import Structures.Maison;
import Structures.Village;
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
		
	Village maisonList;
	Rectangle rectangle = new Rectangle();
	Maison current;
	boolean maisonSelected = false;
	boolean lastStep = false;
	private ObjectOutputStream oos;
	
	
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
				m.getRectangle().setStroke(Paint.valueOf("808000"));
			} else {
				current.addVoisin(m);
				pane.getChildren().add(new Line(current.getSurface().getOrigine().getX(),
												current.getSurface().getOrigine().getY(),
												m.getSurface().getOrigine().getX(),
												m.getSurface().getOrigine().getY()));
				current.getRectangle().setStroke(Paint.valueOf("5c5c3d"));
				current = null;
				maisonSelected = false;
			}
		}
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException, IOException {
		maisonList = new Village();
		oos = new ObjectOutputStream(new FileOutputStream("DATA/test.txt"));
		ImageView img = new ImageView(new Image(new FileInputStream("DATA/village.jpg")));
		
		
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
				try {
					oos.writeObject(maisonList);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				lb.setText("Sauvegarde Validé");
				pane.getChildren().remove(2, pane.getChildren().size());
			} else {
				lastStep = true;	
				lb.setText("Selectionnez les connections");
			}
		});
		
		
		img.setOnMousePressed(e -> {
			if(!lastStep) {
				rectangle.setLayoutX(e.getSceneX());
				rectangle.setLayoutY(e.getSceneY());
				rectangle.setWidth(0);
				rectangle.setHeight(0);
			}
		});
		
		img.setOnMouseDragged(e -> {
			if(!lastStep) {
				rectangle.setWidth(e.getSceneX()-rectangle.getLayoutX());
				rectangle.setHeight(e.getSceneY()-rectangle.getLayoutY());
			}
		});
		
		Scene scene = new Scene(vBox);
		scene.setOnKeyPressed(e -> {
			if(!lastStep && e.getCode().equals(KeyCode.ENTER)) {
				Rectangle c = new Rectangle(rectangle.getLayoutX(), rectangle.getLayoutY(), rectangle.getWidth(),rectangle.getHeight());
				c.setStroke(Paint.valueOf("000000"));
				c.setFill(Paint.valueOf("5c5c3d"));
				c.setOpacity(0.5);
				Maison m = new Maison((int)c.getX(), (int)c.getY(), (int)c.getHeight(), (int)c.getWidth());
				c.setOnMouseClicked(new CircleSelectionHandler(m, pane));
				pane.getChildren().add(c);
				maisonList.add(m);
				rectangle.setWidth(0);
				rectangle.setHeight(0);
			}
		});
		
		
		primaryStage.setHeight(800);
		primaryStage.setWidth(1200);
		
		primaryStage.setOnCloseRequest(e -> {
			try {
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
