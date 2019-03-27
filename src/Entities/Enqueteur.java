package Entities;

import Structures.Lieu;
import Structures.Village;

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

