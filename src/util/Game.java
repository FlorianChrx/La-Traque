package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;
import classes.MaitreChien;

public class Game {
	
	/**
	 * Village actuel présent dans le jeu
	 */
	private static Village villageActuel;
	/**
	 * Tueur actuel présent dans le jeu
	 */
	private static Tueur tueur;
	/**
	 * Enqueteur actuel présent dans le jeu
	 */
	private static Enqueteur enqueteur;
	/**
	 * Scanner permettant les saisies clavier
	 */
	private static Scanner clavier = new Scanner(System.in);
	private static boolean win = false;
	
	/**
	 * Méthode principale du jeu
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre jeu appuies sur entrée pour jouer !");
		clavier.nextLine();
		villageActuel = new Village("");
		tueur = null;
		enqueteur = new MaitreChien(villageActuel);
		while (!win) {
			do {
				System.out.println(villageActuel.toString());
				System.out.println(villageActuel.getVoisinsString(getEnqueteurLocation()));
				char choix;
				do {
					choix = clavier.nextLine().charAt(0);
				} while (villageActuel.getLieu(choix) == null || villageActuel.getLieu(choix).isInvestigate() || (villageActuel.getVoisins(getEnqueteurLocation()).contains(villageActuel.getLieu(choix))));
				enqueteur.action(villageActuel.getLieu(choix));
			} while (enqueteur.canDoAction());
		}
	}
	/**
	 * Permet d'obtenir le lieu actuel du tueur
	 * @return le lieu ou se situe le tueur
	 */
	public static Lieu getTueurLocation() {
		return tueur.getLieu();
	}
	/**
	 * Permet d'obtenir le lieu actuel de l'enqueteur
	 * @return le lieu ou se situe l'enqueteur
	 */
	public static Lieu getEnqueteurLocation() {
		return enqueteur.getLieu();
	}
	/**
	 * Permet d'obtenir l'instance du tueur actuel du jeu
	 * @return le tueur actuel
	 */
	public static Tueur getTueur() {
		return tueur;
	}
	/**
	 * Permet d'obtenir l'instance de l'enqueteur actuel du jeu
	 * @return l'enqueteur actuel
	 */
	public static Enqueteur getEnqueteur() {
		return enqueteur;
	}
	/**
	 * Permet d'obtenir l'instance du village actuel du jeu
	 * @return le village actuel ou se déroule l'action
	 */
	public static Village getVillageActuel() {
		return villageActuel;
	}

	public static void win() {
		win = true;
	}
}
