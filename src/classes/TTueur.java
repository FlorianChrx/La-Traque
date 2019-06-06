package classes;

import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Tueur de base [NbActions pas encore défini]
 * @author calamar
 *
 */
public class TTueur extends Tueur {
	//Attributs
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7860707379882673629L;

	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public TTueur(Village village) {
		super(village, 1);
	}
	
	/**
	 * Constructeur avec le lieu de départ du Tueur
	 * @param lieu de départ
	 */
	public TTueur(Lieu lieu) {
		super(lieu, 1);
	}
	
	//Méthodes

	@Override
	public boolean hasHelper() {
		return false;
	}
}
