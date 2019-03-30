package classes;

import java.util.ArrayList;

import Entities.Personnage;
import Structures.Lieu;
import Structures.Maison;
import util.Game;

/**
 * Classe du Chien appartenant au MaitreChien [Deux actions]
 * @author calamar
 *
 */
public class Chien extends Personnage {
	//Attributs
	
	//Constructeurs	
	/**
	 * Constructeur le lieu de départ du Chien
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Chien(Lieu lieu) {
		super(lieu, 2);
	}

	//Méthodes	
	/**
	 *  Le chien avance. Si le tueur se situe dans la maison et que le chien a des
	 *  points d'actions, le chien bloque le tueur. Si le tueur se situe dans la
	 *  maison mais que le chien n'a plus de d'actions le tueur le bloque. Si il n'y
	 *  a personne, le chien avance une nouvelle fois.
	 */
	public void action(Lieu lieu) { 
		if(lieu instanceof Maison) {
			goTo(lieu);
			actionsDone ++;
			if(canDoAction() && lieu.isMurder()) {
				Game.getTueur().setBlocked();
				actionsDone ++;
			} else if ((!canDoAction()) && lieu.isMurder()) {
				setBlocked();
			}
		}
	}
	
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
