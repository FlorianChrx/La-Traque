package classes;

import java.util.List;

import Entities.Enqueteur;
import Entities.Personnage;
import Structures.Lieu;
import Structures.Village;

/**
 * Classe du rôle Fauconnier (Enquêteur) [Deux actions]
 * @author calamar
 *
 */
public class EFauconnier extends Enqueteur {
	//Attributs
	private Faucon faucon;
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 */
	public EFauconnier(Village village) {
		super(village, 1);
		this.faucon = new Faucon(lieu);
	}
	
	/**
	 * Constructeur avec le lieu de départ du Fauconnier
	 * @param lieu de départ
	 */
	public EFauconnier(Lieu lieu) {
		super(lieu, 1);
		this.faucon = new Faucon(lieu);
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
	public boolean hasHelper() {
		return true;
	}

	@Override
	public Personnage getHelper() {
		return faucon;
	}
	
	
}
