package classes;

import java.util.ArrayList;

import Entities.Enqueteur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Fauconnier (Enquêteur) [NbActions pas encore défini]
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
	public ArrayList<Lieu> lieuxAccessibles() {
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

	@Override
	public void action(Lieu lieu) {
		//  A voir avec l'équipe pour définir	
		// Voit autour de lui
		// Proposition : Choix entre -> Faucon qui tourne autour : le joueur voit autour de lui
		//							 -> Envoyer son faucon voir un endroit en particulier
	}

}
