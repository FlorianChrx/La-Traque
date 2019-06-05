package classes;

import Entities.Enqueteur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Enquêteur de base [Deux actions]
 * @author calamar
 *
 */
public class EEnqueteur extends Enqueteur {
	//Attributs
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public EEnqueteur(Village village) {
		super(village, 2);
	}
	
	/**
	 * Construteur avec le lieu de départ de l'enquêteur
	 * @param lieu de départ
	 */
	public EEnqueteur(Lieu lieu) {
		super(lieu, 2);
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
				enquete();
			} else if (canGoTo(lieu)){
				goTo(lieu);
			} else {
				System.out.println("Je ne peux pas aller si loin...");
			}
		}
		actionsDone++;
	}

	@Override
	public boolean hasHelper() {
		return false;
	}
	
	/*@Override
	public boolean canDoAction() {
		return actionsDone >= nbActions;
	}*/
}
