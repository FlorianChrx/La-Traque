package util;

import java.util.List;

import Entities.Enqueteur;
import Entities.Personnage;
import Entities.Tueur;
import Entities.Updatable;
import Structures.Lieu;
import Structures.Maison;
import Structures.Village;

public class Game {
	
	/**
	 * Village actuel présent dans le jeu
	 */
	private Village villageActuel;
	/**
	 * Tueur actuel présent dans le jeu
	 */
	private Tueur tueur;
	/**
	 * Enqueteur actuel présent dans le jeu
	 */
	private Enqueteur enqueteur;
	private Personnage[] persos;
	private int tours = 0;
	boolean endTurn = false;
	
	public Game(Village village, Tueur tueur, Enqueteur enqueteur) {
		this.villageActuel = village;
		this.tueur = tueur;
		this.enqueteur = enqueteur;
		persos = new Personnage[] {enqueteur, tueur};
	}
	
	public String resultatEvenement(Lieu lieu) {
		if(getEnqueteurLocation().equals(getTueurLocation())) return "L'enquêteur à arrêté le tueur !";
		persos[tours%2].action(lieu);
		if(!persos[tours%2].canDoAction()) {
			tours++;
			if(tours%2 == 0) {
				updateAll(villageActuel, enqueteur, tueur);
			}
		}
		if(getEnqueteurLocation().equals(getTueurLocation())) return "L'enquêteur à arrêté le tueur !"; 
		if (((Maison) lieu).isDead()) return lieu.getPhrase();
		return "Au tour de " + persos[tours%2].getName();
	}
	
	/**
	 * Permet d'obtenir le lieu actuel du tueur
	 * @return le lieu ou se situe le tueur
	 */
	public Lieu getTueurLocation() {
		return tueur.getLieu();
	}
	/**
	 * Permet d'obtenir le lieu actuel de l'enqueteur
	 * @return le lieu ou se situe l'enqueteur
	 */
	public Lieu getEnqueteurLocation() {
		return enqueteur.getLieu();
	}
	/**
	 * Permet d'obtenir l'instance du tueur actuel du jeu
	 * @return le tueur actuel
	 */
	public Tueur getTueur() {
		return tueur;
	}
	/**
	 * Permet d'obtenir l'instance de l'enqueteur actuel du jeu
	 * @return l'enqueteur actuel
	 */
	public Enqueteur getEnqueteur() {
		return enqueteur;
	}
	/**
	 * Permet d'obtenir l'instance du village actuel du jeu
	 * @return le village actuel ou se déroule l'action
	 */
	public Village getVillageActuel() {
		return villageActuel;
	}
	
	public List<Lieu> getLieuxAccessibles() {
		return persos[tours%2].lieuxAccessibles();
	}
	
	public static void updateAll(Updatable... entities) {
		for (Updatable entity : entities) {
			entity.update();
		}
	}
	
	public Personnage getActualPlayer() {
		return persos[tours%2];
	}
}
