package Entities;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;

public abstract class Enqueteur extends Personnage {

	public Enqueteur(Village village, int nbActions) {
		super(village, nbActions);
	}
	public Enqueteur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	
	public void enquete() {
		if (lieu instanceof Maison) {
			System.out.println(lieu.getPhrase());
			((Maison) lieu).setInvestigate();
		}
	}

}

