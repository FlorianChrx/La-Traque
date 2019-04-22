package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entities.Personnage;
import Structures.Lieu;
import Structures.Maison;

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
	
	/**
	 * Le Faucon prend le lieu du Fauconnier et affiche le statut d'une maison voisine aléatoire.
	 */
	@Override
	public void action(Lieu lieu) {
		if(lieu instanceof Maison) {
			if(canDoAction()) {
				List<Lieu> voisins = new ArrayList<Lieu>();
				voisins.addAll(lieu.getVoisins());
				Collections.shuffle(voisins);
				lieu = voisins.get(0);
				lieu.getStatutLieu();
			}
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
