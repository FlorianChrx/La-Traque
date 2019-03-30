package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;
import classes.MaitreChien;

public class Game {
	
	private static Village villageActuel;
	private static Tueur tueur;
	private static Enqueteur enqueteur;
	private static Scanner clavier = new Scanner(System.in);
	private static boolean win = false;
	
	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre jeu appuies sur entrée pour jouer !");
		clavier.nextLine();
		villageActuel = new Village("../../ressources/empty.csv");
		tueur = null;
		enqueteur = new MaitreChien(villageActuel);
		while (!win) {
			 String choix;
			 int choixInt;
			 System.out.println(villageActuel.toString());
			 System.out.println(villageActuel.getVoisinsString(getEnqueteurLocation()));
			 System.out.println("Votre Choix :");;
			 do {
				 choix = clavier.nextLine();
				 // - 1 pour avoir l'indice de la maison choisie (car le chiffre visible
				 // est le numéro de la maison et non son indice)
				 choixInt = Integer.parseInt(choix);
			 } while (choixInt > villageActuel.getLieux().size() && choixInt < villageActuel.getLieux().size() || ! enqueteur.canGoTo(villageActuel.getLieux().get(choixInt-1)));
			 enqueteur.goTo(villageActuel.getLieux().get(choixInt-1));
		}
	}
	
	public static Lieu getTueurLocation() {
		return tueur.getLieu();
	}
	
	public static Lieu getEnqueteurLocation() {
		return enqueteur.getLieu();
	}

	public static Tueur getTueur() {
		return tueur;
	}

	public static Enqueteur getEnqueteur() {
		return enqueteur;
	}
	
	public static Village getVillageActuel() {
		return villageActuel;
	}

	public static void win() {
		win = true;
	}
	
}