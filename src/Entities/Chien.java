package Entities;

import java.util.ArrayList;

import Structures.Lieu;
import Structures.Maison;

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
	 * Permet au chien de mordre le tueur si celui-ci se trouve dans la même maison
	 * et d'avancer (De 1 ou de 2 en fonction de si il a mordu le tueur ce tour-ci
	 */
	public void action(Lieu lieu) { 
		// Chaque action nbActions - 1
		if(lieu instanceof Maison) {
			goTo(lieu);
			actionsDone ++;
			if(((Maison) lieu).isMurder()) {
				if(canDoAction()) {
					lieu.getVillage().getTueur().setBlocked();
					actionsDone ++;
				} else {
					setBlocked();
				}
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
