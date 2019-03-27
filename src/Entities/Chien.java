package Entities;

import java.util.ArrayList;

import Structures.Lieu;

public class Chien extends Personnage {
	//Attributs
	
	//Constructeurs	
	
	/**
	 * Constructeur le lieu de départ du Chien
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Chien(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}

	//Méthodes
	
	/**
	 * Permet au chien de mordre le tueur si celui-ci se trouve dans la même maison
	 */
	public void action() { // Chaque action nbActions - 1
		
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
