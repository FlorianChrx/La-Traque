package classes;

import java.util.List;

import Entities.Personnage;
import Entities.Tueur;
import Structures.Lieu;

/**
 * Classe du Chien appartenant au MaitreChien [Deux actions]
 * @author calamar
 *
 */
public class Chien extends Personnage {
	//Attributs
	
	//Constructeurs	
	/**
	 * Constructeur avec le lieu de départ du Chien
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Chien(Lieu lieu) {
		super(lieu, 2);
	}

	//Méthodes	

	@Override
	public String action(List<Personnage> personnages) { 
		actionsDone++;
		for (Personnage perso : personnages) {
			if (perso instanceof Tueur && perso.getLieu().equals(getLieu())) {
				perso.setBlocked();
				return "Le chien aboie !";
			}
		}
		return "Le chien cherche une piste";
	}
	
	@Override
	public void goTo(Lieu lieu) {
		actionsDone++;
		this.lieu = lieu;
	}

	@Override
	public boolean hasHelper() {
		return false;
	}

	@Override
	public String getName() {
		return "Chien";
	}	
}
