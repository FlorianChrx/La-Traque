package Entities;

import java.io.Serializable;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;

/**
 * Class abstraite correspondant aux Tueurs
 * @author geoffrey
 *
 */
public abstract class Tueur extends Personnage implements Serializable{
	//Attributs
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4124489599918258283L;
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Village village, int nbActions) {
		super(village, nbActions);
		this.lieu.setMurder();
	}	
	/**
	 * Construteur avec le lieu de départ du Tueur
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
		this.lieu.setMurder();
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
	public void goTo(Lieu lieu) {
		if(!this.lieu.isEmpty()) {
			this.lieu.setEmpty();
		}
		this.lieu = lieu;
		this.lieu.setMurder();
	}
	@Override
	public String getName() {
		return ("Tueur");
	}
}
