package Entities;

import java.io.Serializable;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;
import util.Phrase;

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
	
	/**
	 * Représente le gestionnaire de textes affichables
	 */
	private Phrase phrase;
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Village village, int nbActions) {
		super(village, nbActions);
		this.lieu.setMurder();
		this.phrase = new Phrase();
	}	
	/**
	 * Construteur avec le lieu de départ du Tueur
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
		this.lieu.setMurder();
		this.phrase = new Phrase();
	}
	
	//Méthodes	
	/**
	 * Permet de tuer le résident d'une maison
	 */
	public String action() {
		if(lieu instanceof Maison) {
			((Maison) lieu).setDead();
		}
		actionsDone++;
		return phrase.phraseMeurtre();
	}
	
	public void goTo(Lieu lieu) {
		if(!this.lieu.isEmpty()) {
			this.lieu.setEmpty();
		}
		this.lieu = lieu;
		this.lieu.setMurder();
		actionsDone++;
	}
	@Override
	public String getName() {
		return ("Tueur");
	}
}
