package entities;

import structures.Lieu;
import structures.Village;

public abstract class Enqueteur extends Personnage {
	//Attributs
	
	//Constructeurs
	public Enqueteur(Village village, int nbActions) {
		super(village, nbActions);
	}
	public Enqueteur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	
	//Méthodes
	public void enquete() {
		System.out.println(lieu.getPhrase());
	}

}

