package util;

import java.util.List;

import Entities.Enqueteur;
import Entities.Personnage;
import Entities.Tueur;
import Entities.Updatable;
import Structures.Lieu;
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
		String res = null;
		if(sameLieu()) return "L'enquêteur à arrêté le tueur !";
		if(needMove(lieu)) {
			persos[tours%2].goTo(lieu);
		} else {
			res = persos[tours%2].action();
		}
		if(!persos[tours%2].canDoAction()) {
			tours++;
			if(tours%2 == 0) {
				updateAll(villageActuel, enqueteur, tueur);
			}
		}
		if(sameLieu()) return "L'enquêteur à arrêté le tueur !"; 
		return res;
	}

	/**
	 * Verifie si les deux personnages sont dans le même lieu
	 * @return un boolean révélant si les personnages se sont rencontrés
	 */
	private boolean sameLieu() {
		return getEnqueteurLocation().equals(getTueurLocation());
	}
	/**
	 * determine si le personnage actuel doit effectuer un déplacement vers un lieu donné
	 */
	private boolean needMove(Lieu lieu) {
		return persos[tours%2].getLieu().equals(lieu);
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
