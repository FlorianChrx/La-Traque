package Structures;

import java.util.ArrayList;

import util.Position;
import util.Surface;

public interface Lieu {
	/*
	 * Permet d'obtenir la position de l'origine du lieu
	 */
	public Position getPosition();
	/*
	 * Permet de redefinir la position de l'origine d'un lieu avec une nouvelle position
	 */
	public void setPosition(Position s);
	/*
	 * Permet de redefinir la position de l'origine d'un lieu avec des coordonnnées
	 */
	public void setPosition(int x, int y);
	/*
	 * Permet d'obtenir la liste des voisins de ce lieu
	 */
	public ArrayList<Lieu> getVoisins();
	/*
	 * Permet d'obtenir la surface du lieu
	 */
	public Surface getSurface();
	/*
	 * Permet de redéfinir la surface du lieu avec une surface
	 */
	public void setSurface(Surface s);
	/*
	 * Permet de redéfinir la surface du lieu avec une origine et des dimensions
	 */
	public void setSurface(Position s, int height, int width);
	/*
	 * Permet de redéfinir la surface du lieu avec des coordonnées et des dimensions
	 */
	public void setSurface(int x, int y, int height, int width);
}
