package entities;

import structures.Lieu;
import structures.Maison;
import structures.Village;

/**
 * Class abstraite correspondant aux Tueurs
 * @author geoffrey
 *
 */
public abstract class Tueur extends Personnage {
	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Village village, int nbActions) {
		super(village, nbActions);
	}
	
	/**
	 * Construteur avec le lieu de départ du tueur
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	
	/**
	 * Permet de tuer le résident d'une maison
	 */
	public void tue() {
		if(lieu instanceof Maison) {
			((Maison) lieu).setDead();
		}
	}
}
