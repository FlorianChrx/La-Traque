package Structures;

import java.util.ArrayList;

import util.Position;
import util.Surface;

/**
 * 
 * Interface enumérant les méthodes accessibles depuis chaque classe représentant un lieu
 * @author florianchiraux
 *
 */

public interface Lieu {
	/**
	 * Permet d'obtenir la Position du lieu
	 * @return Retourne la position du lieu
	 */
	public Position getPosition();
	/**
	 * Permet de redéfinir la position du lieu
	 * @param s correspondant à une position
	 */
	public void setPosition(Position s);
	/**
	 * Permet de redéfinir la position du lieu
	 * @param x correspondant à une abscisse
	 * @param y correspondant à une ordonnée
	 */
	public void setPosition(int x, int y);
	/**
	 * Permet d'obtenir les lieux voisins accessibles
	 * @return Retourne liste de lieus
	 */
	public ArrayList<Lieu> getVoisins();
	/**
	 * Permet d'obtenir la surface du lieu
	 * @return Retourne une surface
	 */
	public Surface getSurface();
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param s correspondant à une surface
	 */
	public void setSurface(Surface s);
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param p correspondant à une position d'origine
	 * @param height correspondant à une hauteur
	 * @param width correspondant à une largeur
	 */
	public void setSurface(Position p, int height, int width);
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param x correspondant à l'abscisse de l'origine
	 * @param y correspondant à l'ordonnée de l'origine
	 * @param height correspondant à une hauteur
	 * @param width correspondant à une largeur
	 */
	public void setSurface(int x, int y, int height, int width);
}
