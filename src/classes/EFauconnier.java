package classes;

import java.util.List;

import Entities.Enqueteur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Fauconnier (Enquêteur) [Deux actions]
 * @author calamar
 *
 */
public class EFauconnier extends Enqueteur {
	//Attributs
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public EFauconnier(Village village) {
		super(village, 1);
	}
	
	/**
	 * Constructeur avec le lieu de départ du Fauconnier
	 * @param lieu de départ
	 */
	public EFauconnier(Lieu lieu) {
		super(lieu, 1);
	}

	//Méthodes
	@Override
	public List<Lieu> lieuxAccessibles() {
		return lieu.getVoisins();
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
	 * 
	 */
	@Override
	public void action(Lieu lieu) {
		if(canDoAction()) {
			if(this.lieu.equals(lieu)) {
				enquete();
			} else {
				goTo(lieu);
			}
		} else {
			// g plu d'action frr
			System.out.println("Le Maitre Chien n'a plus d'actions.");
			//chien.action(lieu);
			System.out.println("Le Chien n'a plus d'actions.");
		}
		actionsDone++;
		//  A voir avec l'équipe pour définir	
		// Voit autour de lui
		// Proposition : Choix entre -> Faucon qui tourne autour : le joueur voit autour de lui
		//							 -> Envoyer son faucon voir un endroit en particulier
	}

	@Override
	public boolean hasHelper() {
		return true;
	}

}
