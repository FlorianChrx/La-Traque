package Entities;

import Structures.Lieu;
import Structures.Village;

public abstract class Enqueteur extends Personnage {
	//Attributs
	
	//Constructeurs	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut faire le personnage
	 */
	public Enqueteur(Village village, int nbActions) {
		super(village, nbActions);
	}	
	/**
	 * Constructeur avec le lieu de départ de l'Enquêteur
	 * @param lieu de départ
	 * @param nbActions que peut faire le personnage
	 */
	public Enqueteur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	
	//Méthodes	
	/**
	 * Pour l'instant ne fait que print une phrase
	 */
	public void enquete() {
		System.out.println(lieu.getPhrase());
	}
	public void goTo(Lieu lieu) {
		this.lieu.setEmpty();
		this.lieu = lieu;
		this.lieu.setInvestigate();
	}
}

