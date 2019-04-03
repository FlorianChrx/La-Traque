package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		super(lieu, 2);
	}
	
	//Méthodes
	
	@Override
	public void action(Lieu lieu) {
		if(canDoAction()) {
			List<Lieu> voisins = new ArrayList<Lieu>();
			voisins.addAll(lieu.getVoisins());
			Collections.shuffle(voisins);
			goTo(voisins.get(0));
		}
	}

	@Override
	public void goTo(Lieu lieu) {
		this.lieu = lieu;
	}
	
	@Override
	public boolean hasHelper() {
		return false;
	}

}
