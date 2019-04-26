package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Updatable;
import Entities.Tueur;
import Structures.Lieu;
import Structures.Village;
import classes.EFauconnier;
import classes.MaitreChien;
import classes.TBrute;
import classes.TWarper;

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
	private static boolean start = true;
	private final static String[] TUEURS = {"Warper", "Brute"};
	private final static String[] ENQUETEURS = {"Maître Chien", "Fauconnier"};
	
	/**
	 * Méthode principale du jeu
	 */
	public static void main(String[] args) {
		villageActuel = new Village("");
		choixPersos();
		System.out.println("Bienvenue dans notre jeu appuies sur entrée pour jouer !");
		clavier.nextLine();
		
		while (!win) {
			//affiche qu'il y a un changement de joueur sauf si c'est le premier tour de boucle
			//dans ce cas le booléen start passe a faux car a la prochaine execution ça ne sera
			//plus la première éxecution de boucle
			if (! start) {
				System.out.println("Changement de Joueur !");
				clavier.nextLine();
			} else {
				start = false;
			}
			do {
				//si la partie est gagné on quitte directement la boucle
				if (win) break;
				clearScreen();
				tourEnqueteur();
			} while (enqueteur.canDoAction());
			if (!win) {
				System.out.println("Changement de Joueur !");
				clavier.nextLine();
			}
			do {
				//si la partie est gagné on quitte directement la boucle
				if (win) break;
				clearScreen();
				tourTueur();
			} while (tueur.canDoAction());
			//si tous les habitants sont morts l'enqueteur à perdu
			if(villageActuel.allDeads()) lose();
			villageActuel.update();
			enqueteur.update();
			tueur.update();
			updateAll(villageActuel, enqueteur, tueur);
		}
	}
	private static void lose() {
		System.out.println("L'Enqueteur à gagné !");
		win = true;
	}
	private static void afficher(String[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.println((i+1)+". "+tab[i]);
		}
	}
	private static void choixPersos() {
		int choixE = 0;
		System.out.println(" -- CHOIX DE L'ENQÊTEUR --");
		afficher(ENQUETEURS);
		choixE = SaisieNombre(ENQUETEURS.length + 1);
		switch (choixE) {
		case 1:
			enqueteur = new MaitreChien(villageActuel);
			break;
			
		case 2:
			enqueteur = new EFauconnier(villageActuel);
			break;

		default:
			enqueteur = new MaitreChien(villageActuel);
			break;
		}
		int choixT = 0;
		System.out.println(" -- CHOIX DU TUEUR -- ");
		afficher(TUEURS);
		choixE = SaisieNombre(TUEURS.length + 1);
		switch (choixT) {
		case 1:
			tueur = new TWarper(villageActuel);
			break;
			
		case 2:
			tueur = new TBrute(villageActuel);
			break;

		default:
			tueur = new TWarper(villageActuel);
			break;
		}
	}
	private static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}
	private static int SaisieNombre(int max) {
		int res = 0;
		String choix = clavier.nextLine();
		try {
			Integer.parseInt(choix);
		} catch (Exception e) {
			res = SaisieNombre(max);
		}
		if (res >= max) {
			res = SaisieNombre(max);
		}
		return res;
	}
	public static void tourEnqueteur() {
		System.out.println(villageActuel.toString());
		System.out.println(" -- ENQUETEUR -- ");
		System.out.println("Vous êtes dans la maison " + getEnqueteurLocation().getNom());
		System.out.println("Maisons accessibles: " + villageActuel.getVoisins(getEnqueteurLocation()));
		System.out.println("\nPour vous rendre dans une des maisons accessibles, rentrez la lettre correspondante.\nVous pouvez aussi inspecter la maison sur laquelle vous vous trouvez de la même façon.");
		String choix;
		char name;
		do {
			do {
				choix = clavier.nextLine();
			} while (choix.length() != 1);
			name = choix.charAt(0);
		} while (villageActuel.getLieu(name) == null);
		enqueteur.action(villageActuel.getLieu(name));
	}
	public static void tourTueur() {
		System.out.println(villageActuel.toString());
		System.out.println(" -- TUEUR -- ");
		System.out.println("Vous êtes dans la maison " + getTueurLocation().getNom());
		System.out.println("Maisons accessibles: " + villageActuel.getVoisins(getTueurLocation()));
		System.out.println("\nPour vous rendre dans une des maisons accessibles, rentrez la lettre correspondante.\nVous pouvez aussi massacrer les habitants de la maison sur laquelle vous vous trouvez de la même façon.");
		String choix;
		char name;
		do {
			do {
				choix = clavier.nextLine();
			} while (choix.length() != 1);
			name = choix.charAt(0);
		} while (villageActuel.getLieu(name) == null);
		tueur.action(villageActuel.getLieu(name));
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
		System.out.println("L'Enqueteur à gagné !");
		win = true;
	}
	public static void updateAll(Updatable... entities) {
		for (Updatable entity : entities) {
			entity.update();
		}
	}
}
