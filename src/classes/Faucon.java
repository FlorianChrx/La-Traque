package classes;


import Entities.Personnage;
import Structures.Lieu;

/**
 * Classe du Faucon ~millenium~ appartenant au Fauconnier [Une action] 
 * @author calamar
 *
 */
public class Faucon extends Personnage {
	//Attributs
	
	//Constructeurs
	
	/**
	 * Constructeur avec le lieu de départ
	 * @param lieu de départ
	 */
	public Faucon(Lieu lieu) {
		super(lieu, 1);
	}
	
	//Méthodes
	
	@Override
	public String action(Lieu lieu) {
		return "";
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
		return "Faucon";
	}

}
