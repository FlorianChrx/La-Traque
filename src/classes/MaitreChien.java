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

	@Override
	public boolean hasHelper() {
		return true;
	}

	@Override
	public Personnage getHelper() {
		return chien;
	}
	
	
}

