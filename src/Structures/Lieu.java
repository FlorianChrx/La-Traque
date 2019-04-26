package Structures;

import java.util.ArrayList;
import java.util.List;

import Entities.Updatable;
import util.Phrase;
import util.Position;
import util.Surface;

/**
 * 
 * Classe représentant un lieu
 * @author florianchiraux
 *
 */

public abstract class Lieu implements Updatable {
	/**
	 * Surface de la maison et implicitement sa position
	 */
	protected Surface surface;
	/**
	 * Statut du lieu s'il contient l'enqueteur ou le tueur 
	 */
	protected Statut statutLieu;
	protected static Phrase phrase = new Phrase();
	protected List<Lieu> voisins;	
	
	
	public Lieu(Surface surface, Statut statut, List<Lieu> voisins) {
		this.surface = surface;
		this.statutLieu = statut;
		this.voisins = voisins;
	}
	/**
	 * Permet de construire un lieu
	 * @param statut correspondant au statut du lieu
	 * @param surface correspondant à la surface du lieu
	 */
	public Lieu(Surface surface, Statut statut) {
		this(surface, statut, new ArrayList<Lieu>());
	}
	public Lieu(Surface surface) {
		this(surface, Statut.EMPTY);
	}
	
	/**
	 * Définie le lieu comme acceuillant le tueur
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
	 * Définie le lieu comme vide
	 */
	public void setEmpty() {
		this.setStatutLieu(Statut.EMPTY);
	}
	/**
	 * Vérifie si le lieu est occupé par le tueur
	 * @return Vrai ou faux selon l'etat du lieu
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
	public List<Lieu> getVoisins() {
		return voisins;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statutLieu == null) ? 0 : statutLieu.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Lieu))
			return false;
		Lieu other = (Lieu) obj;
		if (statutLieu != other.statutLieu)
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}
	/**
	 * Permet d'obtenir le statut actuel du lieu
	 * @return le statut actuel du lieu
	 */
	public Statut getStatutLieu() {
		return this.statutLieu;
	}
	/**
	 * Permet de redéfinir le statut du lieu avec un statut donné
	 * @param statut : le statut à attribuer au lieu
	 */
	public void setStatutLieu(Statut statut) {
		this.statutLieu = statut;
	}
	public abstract char getNom();
	public void addVoisin(Lieu lieu) {
		if(!voisins.contains(lieu)) {
			voisins.add(lieu);
			lieu.addVoisin(this);
		}
	}
	public void addVoisins(List<Lieu> lieus) {
		for (Lieu lieu : lieus) {
			addVoisin(lieu);
		}
	}
	public boolean isEmpty() {
		return this.statutLieu.equals(Statut.EMPTY);
	}
}
