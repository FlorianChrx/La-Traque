package classes;

import Entities.Personnage;
import Structures.Lieu;

/**
 * Classe du Chien appartenant au MaitreChien [Deux actions]
 * @author calamar
 *
 */
public class Chien extends Personnage {
	//Attributs
	
	//Constructeurs	
	/**
	 * Constructeur avec le lieu de départ du Chien
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Chien(Lieu lieu) {
		super(lieu, 2);
	}

	//Méthodes	

	@Override
	public String action() { 
		return null;
	}
	
	@Override
	public void goTo(Lieu lieu) {
		this.lieu = lieu;
	}

	@Override
	public boolean hasHelper() {
		return false;
	}

	@Override
	public String getName() {
		return "Chien";
	}	
}
