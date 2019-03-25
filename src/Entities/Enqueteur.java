package Entities;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;

/**
 * 
 * Classe abstraite représentant un tueur générique
 * @author florianchiraux
 *
 */
public abstract class Enqueteur extends Personnage {
	
	/**
	 * Permet de construire un Enquêteur
	 * @param village dans lequel se trouve le tueur
	 * @param nbActions le nombre d'actions que peut effectuer l'enqueteur par tour
	 */
	public Enqueteur(Village village, int nbActions) {
		super(village, nbActions);
	}
	/**
	 * Permet de construire un Enquêteur
	 * @param lieu ou sera crée l'Enqueteur
	 * @param nbActions le nombre d'actions que peut effectuer l'enqueteur par tour
	 */
	public Enqueteur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
	}
	/**
	 * Méthode permettant de faire l'enquête dans un lieu
	 */
	public void enquete() {
		if (lieu instanceof Maison) {
			System.out.println(lieu.getPhrase());
			((Maison) lieu).setInvestigate();
		}
	}

}

