package classes;

import java.util.List;

import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Brute (Tueur) [NbActions pas encore défini]
 * @author calamar
 *
 */
public class TBrute extends Tueur {
	//Attributs
	
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
	 * @param lieu de départd
	 */
	public TBrute(Lieu lieu) {
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

	@Override
	public void action(Lieu lieu) {
		// A voir avec l'équipe pour définir
		
	}

	@Override
	public boolean hasHelper() {
		// TODO Auto-generated method stub
		return false;
	}

}