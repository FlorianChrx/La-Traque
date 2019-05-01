package util;

import java.util.Scanner;

import Entities.Enqueteur;
import Entities.Updatable;
import Entities.Personnage;
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
	/**
	 * Booléen déterminant si l'un des deux joueurs à gagné
	 */
	private static boolean win = false;
	/**
	 * Booléen déterminant si la partie viens d'être lancée
	 */
	private static boolean start = true;
	/**
	 * Tableau des différents tueurs jouables tels qu'affichés dans les menus
	 */
	private final static String[] TUEURS = {"Warper", "Brute"};
	/**
	 * Tableau des différents tueurs jouables tels qu'affichés dans les menus
	 */
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
			if (!start) {
				changementJoueur();
			}
			tour(enqueteur);
			if (enqueteur.hasHelper()) {
				tour(enqueteur.getHelper());
			}
			changementJoueur();
			tour(tueur);
			if (tueur.hasHelper()) {
				tour(tueur.getHelper());
			}
			if(villageActuel.allDeads()) lose();
			enqueteur.update();
			tueur.update();
			updateAll(villageActuel, enqueteur, tueur);
			start = false;
		}
	}
	
	private static void changementJoueur() {
		clearScreen();
		System.out.println("CHANGEMENT DE JOUEUR !");
		clavier.nextLine();
	}
  /**
	 * Méthode déclenchée lorsque le tueur a gagné
	 * Elle affiche le gagnant et met le booléen de victoire à vrai
	 */
    
	private static void lose() {
		System.out.println("Le tueur a gagné !");
		win = true;
	}
    
	/**
	 * Méthode permettant d'afficher toutes les chaînes de caractères d'un tableau
	 * @param tab représentant un tableau de chaînes de caractères 
	 */
	private static void afficher(String[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.println((i+1)+". "+tab[i]);
		}
	}
    
	/**
	 * Méthode permettant de déclencher la séquence de choix des personnages
	 */
	private static void choixPersos() {
		int choixE = 0;
		System.out.println(" -- CHOIX DE L'ENQÊTEUR --");
		afficher(ENQUETEURS);
		choixE = SaisieNombre(1, ENQUETEURS.length + 1);
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
		choixE = SaisieNombre(1, TUEURS.length + 1);
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
	/**
	 * Méthode permettant de vider l'écran de tout affichage
	 */
	private static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}
	/**
	 * Méthode permettant la saisie d'un nombre entier inférieur à une borne maximum
	 * @param max, un entier représentant l'entier maximum saisie (exclu)
	 * @return le premier entier valide saisie
	 */
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
	/**
	 * Méthode permettant la saisie d'un nombre entier inférieur à une borne maximum
	 * @param min, un entier représentant la valeur minimum saisie (incluse)
	 * @param max, un entier représentant la valeur maximum saisie (exclue)
	 * @return le premier entier valide saisie
	 */
	private static int SaisieNombre(int min, int max) {
		int res = SaisieNombre(max);
		if (res < min) {
			res = SaisieNombre(min, max);
		}
		return res;
	}
    
	public static void tour(Personnage p) {
		do {
			if (win) {
				break;
			}
			clearScreen();
			System.out.println(villageActuel.toString());
			System.out.println(p.getName());
			System.out.println("Vous êtes dans la maison " + p.getLieu().getNom());
			System.out.println("Maisons accessibles: " + villageActuel.getVoisins(p.getLieu()));
			System.out.println("\nPour vous rendre dans une des maisons accessibles, rentrez la lettre correspondante.\nVous pouvez aussi intéragir avec la maison sur laquelle vous vous trouvez de la même façon.");
			String choix;
			char name;
			do {
				do {
					choix = clavier.nextLine();
				} while (choix.length() != 1);
				name = choix.charAt(0);
			} while (villageActuel.getLieu(name) == null);
			p.action(villageActuel.getLieu(name));
			clavier.nextLine();
		} while (p.canDoAction());
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
	/**
	 * Méthode déclenchée lorsque l'enquêteur a gagné
	 * Elle affiche le gagnant et met le booléen de victoire à vrai
	 */
	public static void win() {
		System.out.println("L'Enqueteur a gagné !");
		win = true;
	}
	public static void updateAll(Updatable... entities) {
		for (Updatable entity : entities) {
			entity.update();
		}
	}
}
