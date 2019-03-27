package classes;

import java.util.ArrayList;

import Entities.Chien;
import Entities.Enqueteur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Maître-Chien (Enquêteur)
 * @author calamar
 *
 */
public class MaitreChien extends Enqueteur {
	//Attributs
	private Chien chien;
	
	//Constructeurs
	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public MaitreChien(Village village) {
		super(village, 1);
	}
	
	/**
	 * Construteur avec le lieu de départ du MaitreChien
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public MaitreChien(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
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
}