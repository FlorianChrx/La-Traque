package Structures;

import util.Position;
import util.Surface;

/**
 * 
 * Classe représentant une maison avec surface, statut, le village dans laquelle 
 * elle se situe et le nombre de jours depuis le meutre lorsqu'il a eu lieu (vaut 0 sinon)
 * @author florianchiraux
 *
 */
public class Maison extends Lieu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4168050509765971796L;
	
	//Attributs
	/**
	 * Statut de son habitant 
	 */
	private StatutMaison statutMaison;
	private int days;
	private String nom;
	
	//Constructeurs
	
	/**
	 * Permet de construire une maison
	 * @param statut correspondant au statut de l'habitant
	 * @param surface correspondant à la surface de la maison 
	 */
	public Maison(StatutMaison statut, Surface surface) {
		super(surface);
		this.statutMaison = statut;
		this.nom = phrase.nomMaison();
	}
	/**
	 * Permet de construire une maison
	 * @param statut correspondant au statut de l'habitant
	 * @param origine correspondant au point d'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(StatutMaison statut, Position origine, int height, int width) {
		this(statut, new Surface(origine, width, height));
	}
	/**
	 * @param origine correspondant au point d'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(Position origine, int height, int width) {
		this(StatutMaison.ALIVE, new Surface(origine, width, height));
	}
	/**
	 * @param x	correspondant à l'abscisse de l'origine de la surface de la maison
	 * @param y correspondant à l'ordonnée de l'origine de la surface de la maison
	 * @param height correspondant à la hauteur de la représentation de la maison
	 * @param width correspondant à la largeur de la représentation de la maison
	 */
	public Maison(int x, int y, int height, int width) {
		this(StatutMaison.ALIVE, new Surface(new Position(x,y), width, height));
	}
	
	
	//Méthodes
	
	
	/**
	 * Permet de passer au jour suivant, soit d'incrémenter le nombre de jours depuis le meurtre de 1
	 */
	private void nextDay() {
		if (isDead()) {
			this.days = days + 1;
		}
	}
	/**
	 * Définie comme mort l'habitant
	 */
	public void setDead() {
		this.setStatutMaison(StatutMaison.DEAD);
	}
	/**
	 * Définie comme vivant l'habitant
	 */
	public void setAlive() {
		this.setStatutMaison(StatutMaison.ALIVE);
	}
	/**
	 * Vérifie si l'habitant est mort
	 * @return Vrai ou faux selon l'etat de la maison
	 */
	public boolean isDead() {
		return statutMaison.equals(StatutMaison.DEAD);
	}
	/**
	 * Vérifie si l'habitant est en vie
	 * @return Vrai ou faux selon l'etat de la maison
	 */
	public boolean isAlive() {
		return statutMaison.equals(StatutMaison.ALIVE);
	}
	/**
	 * Permet d'obtenir le statut actuel de la maison et de son habitant
	 * @return Retourne un statut
	 */
	public StatutMaison getStatutMaison() {
		return statutMaison;
	}
	/**
	 * Définie le statut de la maison avec le statut passé en paramètre
	 * @param statut le statut a attribuer à la maison
	 */
	private void setStatutMaison(StatutMaison statutMaison) {
		this.statutMaison = statutMaison;
	}
	/**
	 * Permet de savoir le nombre de jours depuis le meurtre
	 * @return Retourne le nombre de jours depuis le meurtre
	 */
	public int getDays() {
		return days;
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
	@Override
	public String getPhrase() {
		return phrase.nextPhrase(this.days);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + days;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((statutMaison == null) ? 0 : statutMaison.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Maison))
			return false;
		Maison other = (Maison) obj;
		if (days != other.days)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (statutMaison != other.statutMaison)
			return false;
		return true;
	}
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return ""+nom;
	}
	
}
