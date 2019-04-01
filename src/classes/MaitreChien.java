package classes;

import java.util.List;

import Entities.Enqueteur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle MaitreChien (Enquêteur) [Deux actions]
 * @author calamar
 *
 */
public class MaitreChien extends Enqueteur {
	//Attributs
	private Chien chien; // -> Vraiment ?
	
	//Constructeurs
	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public MaitreChien(Village village) {
		super(village, 2);
	}
	
	/**
	 * Construteur avec le lieu de départ du MaitreChien
	 * @param lieu de départ
	 */
	public MaitreChien(Lieu lieu) {
		super(lieu, 2);
	}
	
	//Méthodes
	@Override
	public List<Lieu> lieuxAccessibles() {
		return lieu.getVoisins();
	}
	@Override
	public void nextDay() {
		actionsDone = 0;	
	}
	@Override
	public void update() {
		nextDay();
	}
	@Override
	public void action(Lieu lieu) { // -> lieu paramètre = lieu cliqué par joueur
		if(canDoAction()) {
			if(this.lieu.equals(lieu)) {
				enquete();
			} else {
				goTo(lieu);
			}
		} else {
			// g plu d'action frr
		}
    actionsDone++;
	}

	@Override
	public boolean hasHelper() {
		return true;
	}	
}

