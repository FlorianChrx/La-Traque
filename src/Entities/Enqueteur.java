package Entities;

import Structures.Lieu;
import Structures.Village;

public abstract class Enqueteur extends Personnage{
	//Attributs
	
	//Constructeurs	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut faire le personnage
	 */
	public Enqueteur(Village village, int nbActions) {
		super(village, nbActions);
		this.lieu.setInvestigate();
	}	
	/**
	 * Constructeur avec le lieu de départ de l'Enquêteur
	 * @param lieu de départ
	 * @param nbActions que peut faire le personnage
	 */
	public Enqueteur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
		this.lieu.setInvestigate();
	}
	
	/**
	 * Permet de déplacer l'enqueteur
	 */
	public void goTo(Lieu lieu) {
		if(lieu.isInvestigate()) {
			this.lieu.setEmpty();
		}
		this.lieu = lieu;
		if(this.lieu.isEmpty()) {
			this.lieu.setInvestigate();
		}
	}
	@Override
	public boolean hasHelper() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getName() {
		return ("Enquêteur");
	}
}

