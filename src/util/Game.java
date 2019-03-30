package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;
import classes.MaitreChien;

public class Game {
	
	static Village villageActuel;
	static Tueur tueur;
	static Enqueteur enqueteur;
	static Scanner clavier = new Scanner(System.in);
	
	/**
	 * Fonction principale, lancée au lancement du jeu
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre jeu appuies sur entrée pour jouer !");
		clavier.nextLine();
		villageActuel = new Village("");
		tueur = null;
		enqueteur = new MaitreChien(villageActuel);
	}
	
	/**
	 * Permet d'obtenir le lieu actuel du tueur
	 * @return le lieu actuel du tueur
	 */
	public static Lieu getTueurLocation() {
		return tueur.getLieu();
	}
	
	/**
	 * Permet d'obtenir le lieu actuel de l'enqueteur
	 * @return le lieu actuel de l'enqueteur
	 */
	public static Lieu getEnqueteurLocation() {
		return enqueteur.getLieu();
	}
	/**
	 * Permet d'obtenir le tueur
	 * @return le tueur de la partie
	 */
	public static Tueur getTueur() {
		return tueur;
	}
	/**
	 * Permet d'obtenir l'enqueteur
	 * @return l'enqueteur de la partie
	 */
	public static Enqueteur getEnqueteur() {
		return enqueteur;
	}
	
}
