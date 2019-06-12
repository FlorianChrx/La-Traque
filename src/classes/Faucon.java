package classes;

import java.util.List;
import Entities.Personnage;
import Entities.Tueur;
import Structures.Lieu;

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
	
	@Override
	public String action(List<Personnage> personnages) {
		actionsDone++;
		for (Personnage perso : personnages) {
			if (perso instanceof Tueur && perso.getLieu().equals(getLieu())) {
				return "Le Faucon semble intrigué";
			}
		}
		return "Le faucon recherche sa proie...";
	}
	
	@Override
	public boolean hasHelper() {
		return false;
	}
	
	@Override
	public void goTo(Lieu lieu) {
		actionsDone++;
		this.lieu = lieu;
	}

	@Override
	public String getName() {
		return "Faucon";
	}

}
