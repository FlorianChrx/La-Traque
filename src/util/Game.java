package util;

import java.util.List;

import Entities.Enqueteur;
import Entities.Personnage;
import Entities.Tueur;
import Entities.Updatable;
import Structures.Lieu;
import Structures.Maison;
import Structures.Village;
import classes.EEnqueteur;
import classes.TTueur;

public class Game {
	
	/**
	 * Village actuel présent dans le jeu
	 */
	private final Village VILLAGE;
	/**
	 * Tueur actuel présent dans le jeu
	 */
	private final Tueur TUEUR;
	/**
	 * Enqueteur actuel présent dans le jeu
	 */
	private final Enqueteur ENQUETEUR;
	private Personnage[] persos;
	private int tours = 0;
	boolean endTurn = false;
	
	public Game(Village village, Tueur TUEUR, Enqueteur ENQUETEUR) {
		int nb = 2;
		if(TUEUR.hasHelper()) nb++;
		if(ENQUETEUR.hasHelper()) nb++;
		this.VILLAGE = village;
		this.TUEUR = TUEUR;
		this.ENQUETEUR = ENQUETEUR;
		persos = new Personnage[nb];
		nb = 1;
		try {
			persos[0] = ENQUETEUR;
			if(ENQUETEUR.hasHelper()) {
				persos[nb] = ENQUETEUR.getHelper();
				nb++;
			}
			if(TUEUR.hasHelper()) {
				persos[nb] = TUEUR.getHelper();
				nb++;
			}
			persos[nb] = TUEUR;
		} catch (Exception e) {
			System.out.println("Erreur création des personnages");
			persos = new Personnage[] {new EEnqueteur(village), new TTueur(village)};
		}
	}
	
	public String resultatEvenement(Lieu lieu) {
		String res ="";
		if(getEnqueteurLocation().equals(getTueurLocation())) return "L'enquêteur à arrêté le TUEUR !";
		if(persos[tours%persos.length].getLieu().equals(lieu)) {
			res = persos[tours%persos.length].action(lieu);
		} else {
			persos[tours%persos.length].goTo(lieu);
		}
		if(!persos[tours%persos.length].canDoAction()) {
			tours++;
			if(tours%persos.length == 0) {
				updateAll(persos);
				VILLAGE.update();
			}
		}
		if(getEnqueteurLocation().equals(getTueurLocation())) return "L'enquêteur à arrêté le TUEUR !"; 
		if (((Maison) lieu).isDead()) return lieu.getPhrase();
		return res;
	}
	
	/**
	 * Permet d'obtenir le lieu actuel du TUEUR
	 * @return le lieu ou se situe le TUEUR
	 */
	public Lieu getTueurLocation() {
		return TUEUR.getLieu();
	}
	/**
	 * Permet d'obtenir le lieu actuel de l'ENQUETEUR
	 * @return le lieu ou se situe l'ENQUETEUR
	 */
	public Lieu getEnqueteurLocation() {
		return ENQUETEUR.getLieu();
	}
	/**
	 * Permet d'obtenir l'instance du TUEUR actuel du jeu
	 * @return le TUEUR actuel
	 */
	public Tueur getTueur() {
		return TUEUR;
	}
	/**
	 * Permet d'obtenir l'instance de l'ENQUETEUR actuel du jeu
	 * @return l'ENQUETEUR actuel
	 */
	public Enqueteur getEnqueteur() {
		return ENQUETEUR;
	}
	/**
	 * Permet d'obtenir l'instance du village actuel du jeu
	 * @return le village actuel ou se déroule l'action
	 */
	public Village getVillageActuel() {
		return VILLAGE;
	}
	
	public List<Lieu> getLieuxAccessibles() {
		return persos[tours%persos.length].lieuxAccessibles();
	}
	
	public static void updateAll(Updatable... entities) {
		for (Updatable entity : entities) {
			entity.update();
		}
	}
	
	public Personnage getActualPlayer() {
		return persos[tours%persos.length];
	}
}
