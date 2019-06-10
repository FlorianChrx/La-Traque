package classes;

import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Brute (Tueur) [NbActions pas encore défini]
 * @author calamar
 *
 */
@SuppressWarnings("serial")
public class TBrute extends Tueur {
	//Attributs
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7387215184195661317L;

	//Constructeurs	
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public TBrute(Village village) {
		super(village, 1);
	}
	
	/**
	 * Constructeur avec le lieu de départ de la Brute
	 * @param lieu de départ
	 */
	public TBrute(Lieu lieu) {
		super(lieu, 1);
	}

	//Méthodes 

	@Override
	public boolean hasHelper() {
		return false;
	}
}
