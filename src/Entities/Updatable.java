package Entities;
/**
 * 
 * Classe représentant un entité présente sur le plateau
 * @author florianchiraux
 *
 */
public interface Updatable {
	/**
	 * Permet de mettre à jour une entité (utile en fin de tour)
	 */
	public void update();
}
