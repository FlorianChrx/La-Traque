package classes;

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
	@Override
	public List<Lieu> lieuxAccessibles() {
		return lieu.getVoisins(); // Il faudrait aussi les voisins des voisins : au cas où il voudrait sauter
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
		// A le choix entre faire une petit (avancer de une case) ou un grand un bond (avancer de deux cases)
		// Du coup, une seule action ?
	}

	@Override
	public boolean hasHelper() {
		// TODO Auto-generated method stub
		return false;
	}

}
