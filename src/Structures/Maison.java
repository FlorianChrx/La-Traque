package Structures;

import java.util.ArrayList;

import util.Entity;
import util.Position;
import util.Surface;

/**
 * 
 * Classe représentant une maison avec surface, statut, le village dans laquelle 
 * elle se situe et le nombre de jours depuis le meutre lorsqu'il a eu lieu (vaut 0 sinon)
 * @author florianchiraux
 *
 */
public class Maison implements Lieu, Entity {
	//Attributs
	/**
	 * Village dans lequel se situe la maison
	 */
	private Village village;
	/**
	 * Statut de son habitant et de son potentiel visiteur (tueur/enqueteur)
	 */
	private Statut statut;
	/**
	 * Surface de la maison et implicitement sa position
	 */
	private Surface surface;
	/**
	 * Nombre de jours depuis la mort de l'habitant
	 */
	private int days;
	
	
	//Constructeurs
	
	/**
	 * Permet de construire une maison
	 * @param village correspondant au village dans laquelle se situe la maison
	 * @param statut correspondant au statut de l'habitant
	 * @param surface correspondant à la surface de la maison 
	 */
	public Maison(Village village, Statut statut, Surface surface) {
		this.setVillage(village);
		this.setStatut(statut);
		this.surface = surface;
	}
	/**
	 * Permet de construire une maison
	 * @param village correspondant au village dans laquelle se situe la maison
	 * @param statut correspondant au statut de l'habitant
	 * @param origine correspondant au point d'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(Village village, Statut statut, Position origine, int height, int width) {
		this(village, statut, new Surface(origine, height, width));
	}
	/**
	 * 
	 * @param village correspondant au village dans laquelle se situe la maison
	 * @param origine correspondant au point d'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(Village village, Position origine, int height, int width) {
		this(village, Statut.ALIVE, new Surface(origine, height, width));
	}
	/**
	 * 
	 * @param village correspondant au village dans laquelle se situe la maison
	 * @param x	correspondant à l'abscisse de l'origine de la surface de la maison
	 * @param y correspondant à l'ordonnée de l'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(Village village, int x, int y, int height, int width) {
		this(village, Statut.ALIVE, new Surface(new Position(x,y), height, width));
	}
	
	
	//Méthodes
	
	
	@Override
	public Position getPosition() {
		return surface.getOrigine();
	}
	@Override
	public ArrayList<Lieu> getVoisins() {
		return getVillage().getVoisins(this);
	}
	@Override
	public Surface getSurface() {
		return surface;
	}
	@Override
	public void setPosition(Position s) {
		surface.setOrigine(s);	
	}
	@Override
	public void setPosition(int x, int y) {
		setPosition(new Position(x, y));
	}
	@Override
	public void setSurface(Surface s) {
		surface = s;
	}
	@Override
	public void setSurface(Position s, int height, int width) {
		setSurface(new Surface(s, height, width));
	}
	@Override
	public void setSurface(int x, int y, int height, int width) {
		setSurface(new Position(x, y), height, width);
	}
	/**
	 * Permet de passer au jour suivant, soit d'incrémenter le nombre de jours depuis le meurtre de 1
	 */
	public void nextDay() {
		days++;
	}
	/**
	 * Définie comme mort l'habitant
	 */
	public void setDead() {
		this.setStatut(Statut.DEAD);
	}
	/**
	 * Définie comme vivant l'habitant
	 */
	public void setAlive() {
		this.setStatut(Statut.ALIVE);
	}
	/**
	 * Définie la maison comme acceuillant le tueur
	 */
	public void setMurder() {
		this.setStatut(Statut.MURDER);
	}
	/**
	 * Définie la maison comme acceuillant l'enquêteur
	 */
	public void setInvestigate() {
		this.setStatut(Statut.INVESTIGATE);
	}
	/**
	 * Permet d'obtenir le statut actuel de la maison et de son habitant
	 * @return Retourne un statut
	 */
	public Statut getStatut() {
		return statut;
	}
	/**
	 * Définie le statut de la maison avec le statut passé en paramètre
	 * @param statut le statut a attribuer à la maison
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getDays();
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		result = prime * result + ((getVillage() == null) ? 0 : getVillage().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maison other = (Maison) obj;
		if (getDays() != other.getDays())
			return false;
		if (statut != other.statut)
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		if (getVillage() == null) {
			if (other.getVillage() != null)
				return false;
		} else if (!getVillage().equals(other.getVillage()))
			return false;
		return true;
	}
	/**
	 * Permet d'obtenir le village dans lequel se trouve la maison 
	 * @return Retourne le village contennant la maison
	 */
	public Village getVillage() {
		return village;
	}
	/**
	 * Permet de changer la maison de village
	 * @param village représentant le village dans lequel la maison se trouve
	 */
	public void setVillage(Village village) {
		this.village = village;
	}
	/**
	 * Permet de savoir le nombre de jours depuis le meurtre
	 * @return Retourne le nombre de jours depuis le meurtre
	 */
	public int getDays() {
		return days;
	}
	public String getPhrase() {
		return Phrase.nextPhrase(days);
	}
	/**
	 * Permet de remettre à 0 le nombre de jours depuis le meurtre
	 */
	public void resetDays() {
		this.days = 0;
	}
	@Override
	public void update() {
		this.nextDay();
	}
}
