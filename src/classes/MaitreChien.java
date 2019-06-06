package classes;

import Entities.Enqueteur;
import Entities.Personnage;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle MaitreChien (Enquêteur) [Deux actions]
 * @author calamar
 *
 */
public class MaitreChien extends Enqueteur {
	//Attributs
	/**
	 * Bon toutou
	 */
	private Chien chien;
	
	//Constructeurs
	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public MaitreChien(Village village) {
		super(village, 2);
		chien = new Chien(this.getLieu());
	}
	
	/**
	 * Construteur avec le lieu de départ du MaitreChien
	 * @param lieu de départ
	 */
	public MaitreChien(Lieu lieu) {
		super(lieu, 2);
		chien = new Chien(lieu);
	}
	
	//Méthodes
	
	/**
	 * L'enquêteur enquête si le lieu cliqué est sa maison actuelle sinon il se déplace à la maison selectionnée.
	 * Lorsqu'il a fini, le chien joue.
	 */
	@Override
	public String action() { // -> lieu paramètre = lieu cliqué par joueur
		actionsDone++;
		return getLieu().getPhrase();
	}

	@Override
	public boolean hasHelper() {
		return true;
	}

	@Override
	public Personnage getHelper() {
		return chien;
	}
	
	
}

