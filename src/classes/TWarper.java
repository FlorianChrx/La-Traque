package classes;

import java.util.ArrayList;
import java.util.List;

import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Warper (Tueur) [NbActions pas encore défini]
 * @author calamar
 *
 */
public class TWarper extends Tueur {
	//Attributs
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public TWarper(Village village) {
		super(village, 1);
	}
	
	/**
	 * Constructeur avec le lieu de départ du Warper 
	 * @param lieu de départ
	 */
	public TWarper(Lieu lieu) {
		super(lieu, 1);
	}
	
	//Méthodes	
	
	/**
	 * Retourne les voisins (du lieu) ainsi que leur voisins.
	 */
	@Override
	public List<Lieu> lieuxAccessibles() {
		List<Lieu> liste = new ArrayList<Lieu>();
		for(Lieu lieu : lieu.getVoisins()) {
			liste.addAll(lieu.getVoisins());
		}
		return liste;	
	}
	
	@Override
	public void nextDay() {
		goTo(lieu);		
	}
	
	@Override
	public void update() {
		nextDay();		
	}
	
	/**
	 * Le Warper se déplace d'une ou de deux maisons en fonction du lieu choisit.
	 */
	@Override
	public void action(Lieu lieu) {
		if(canDoAction()) {
			goTo(lieu);
		} else {
			System.out.println("Le Warper n'a plus d'actions.");
		}
		actionsDone++;
	}

	@Override
	public boolean hasHelper() {
		return false;
	}

}
