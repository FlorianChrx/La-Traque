package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Personnage;
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
			do {
				 tourEnqueteur();
			 } while(enqueteur.canDoAction());
			 /*
			 do {
				 System.out.println("-- Tour du tueur --");
				 System.out.println("Votre Choix :");
				 choix = clavier.nextLine();
				 // - 1 pour avoir l'indice de la maison choisie (car le chiffre visible
				 // est le numéro de la maison et non son indice)
				 choixInt = Integer.parseInt(choix);
			 } while ((choixInt > villageActuel.getLieux().size() && choixInt < villageActuel.getLieux().size() || !tueur.canGoTo(villageActuel.getLieux().get(choixInt-1))) && tueur.canDoAction());
			 tueur.action(villageActuel.getLieux().get(choixInt-1));
			 */
			 System.out.println("Jour suivant !");
			 clavier.nextLine();
			 enqueteur.update();
		}
	}
	
	public static void afficherVillagePour(Personnage p) {
		System.out.println(villageActuel.toString());
		System.out.println(villageActuel.getVoisinsString(p.getLieu()));
	}
	
	public static void tourEnqueteur() {
		afficherVillagePour(enqueteur);
		int choix;
		System.out.println("-- Tour de l'enqueteur --");
		System.out.println(enqueteur.getActionsDone());
		System.out.println(enqueteur.getNbActions());

		System.out.println("Votre Choix :");
		choix = choix(1, villageActuel.getLieux().size()+1);
		if (choix != -1 && (enqueteur.canGoTo(villageActuel.getLieux().get(choix-1)) || enqueteur.getLieu().equals(villageActuel.getLieux().get(choix-1)))) {
			enqueteur.action(villageActuel.getLieux().get(choix-1));
		}
	}
	
	public static int choix(int min, int max) {
		String choix;
		do {
			choix = clavier.nextLine();
		} while(!isNumeric(choix));
		int res = Integer.parseInt(choix);
		if(res >= max || res < min) return -1;
		return res;
	}
	
	public static boolean isNumeric(String choix) {
		try {
            Integer.parseInt(choix);
            return true;
        } catch (NumberFormatException e) {
            return false;
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