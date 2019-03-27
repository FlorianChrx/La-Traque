package Entities;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;

/**
 * Class abstraite correspondant aux Tueurs
 * @author geoffrey
 *
 */
public abstract class Tueur extends Personnage {
	//Attributs
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Village village, int nbActions) {
		super(village, nbActions);
	}	
	/**
	 * Construteur avec le lieu de départ du Tueur
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	
	//Méthodes	
	/**
	 * Permet de tuer le résident d'une maison
	 */
	public void tue() {
		if(lieu instanceof Maison) {
			((Maison) lieu).setDead();
		}
	}
}
