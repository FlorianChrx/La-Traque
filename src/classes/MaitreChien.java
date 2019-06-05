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
	public void action(Lieu lieu) { // -> lieu paramètre = lieu cliqué par joueur
		System.out.println(lieu.getNom());
		if(canDoAction()) {
			if(this.lieu.equals(lieu)) {
				actionsDone++;
			} else if (canGoTo(lieu)){
				goTo(lieu);
				actionsDone++;
			} else {
				System.out.println("Je ne peux pas aller si loin...");
			}
		} else {
			System.out.println("Le Maitre Chien n'a plus d'actions.");
			chien.action(lieu);
		}
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

