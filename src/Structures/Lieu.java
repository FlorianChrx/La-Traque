package Structures;

import java.util.ArrayList;

import util.Position;
import util.Surface;

/**
 * 
 * Classe représentant un lieu
 * @author florianchiraux
 *
 */

public abstract class Lieu {
	/**
	 * Surface de la maison et implicitement sa position
	 */
	protected Surface surface;
	/**
	 * Village dans lequel se situe le lieu
	 */
	protected Village village;
	/**
	 * Statut du lieu s'il contient l'enqueteur ou le tueur 
	 */
	protected Statut statutLieu;
	
	public Lieu(Surface surface, Village village) {
		this.surface = surface;
		this.village = village;
	}
	
	
	/**
	 * Définie la maison comme acceuillant le tueur
	 */
	public void setMurder() {
		this.setStatutLieu(Statut.MURDER);
	}
	/**
	 * Définie le lieu comme acceuillant l'enquêteur
	 */
	public void setInvestigate() {
		this.setStatutLieu(Statut.INVESTIGATE);
	}
	/**
	 * Vérifie si la maison est occupée par le tueur
	 * @return Vrai ou faux selon l'etat de la maison
	 */
	public boolean isMurder() {
		return statutLieu.equals(Statut.MURDER);
	}
	/**
	 * Vérifie si le lieu subit une enquête
	 * @return Vrai ou faux selon l'etat du lieu
	 */
	public boolean isInvestigate() {
		return statutLieu.equals(Statut.INVESTIGATE);
	}
	
	/**
	 * Permet d'obtenir la Position du lieu
	 * @return Retourne la position du lieu
	 */
	public Position getPosition() {
		return surface.getOrigine();
	}
	/**
	 * Permet de redéfinir la position du lieu
	 * @param s correspondant à une position
	 */
	public void setPosition(Position s) {
		surface.setOrigine(s);	
	}
	/**
	 * Permet de redéfinir la position du lieu
	 * @param x correspondant à une abscisse
	 * @param y correspondant à une ordonnée
	 */
	public void setPosition(int x, int y) {
		setPosition(new Position(x, y));
	}
	/**
	 * Permet d'obtenir les lieux voisins accessibles
	 * @return Retourne liste de lieus
	 */
	public ArrayList<Lieu> getVoisins() {
		return getVillage().getVoisins(this);
	}
	/**
	 * Permet d'obtenir la surface du lieu
	 * @return Retourne une surface
	 */
	public Surface getSurface() {
		return surface;
	}
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param s correspondant à une surface
	 */
	public void setSurface(Surface s) {
		surface = s;
	}
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param p correspondant à une position d'origine
	 * @param height correspondant à une hauteur
	 * @param width correspondant à une largeur
	 */
	public void setSurface(Position s, int height, int width) {
		setSurface(new Surface(s, height, width));
	}
	/**
	 * Permet de redéfinir la surface du lieu
	 * @param x correspondant à l'abscisse de l'origine
	 * @param y correspondant à l'ordonnée de l'origine
	 * @param height correspondant à une hauteur
	 * @param width correspondant à une largeur
	 */
	public void setSurface(int x, int y, int height, int width) {
		setSurface(new Position(x, y), height, width);
	}
	/**
	 * Permet d'obtenir une phrase à afficher en fonction du nombre de jours depuis le meurtre
	 * @return Retourne une chaine de caractère 
	 */
	public abstract String getPhrase();
	/**
	 * Test si ce lieu est le même que celui passé en paramètre
	 * @param o un autre lieu
	 * @return Vrai ou faux si les lieux sont identiques
	 */
	public abstract boolean equals(Object o);
	/**
	 * Permet d'obtenir le village dans lequel se trouve le lieu
	 * @return le village dans lequel se trouve le lieu
	 */
	public Village getVillage() {
		return this.village;
	}
	
	public Statut getStatutLieu() {
		return this.statutLieu;
	}
	public void setStatutLieu(Statut statut) {
		this.statutLieu = statut;
	}
}
