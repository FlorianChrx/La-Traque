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
	
	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre jeu appuies sur entrée pour jouer !");
		clavier.nextLine();
		villageActuel = new Village("");
		tueur = null;
		enqueteur = new MaitreChien(villageActuel);
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

	public static void setVillageActuel(Village villageActuel) {
		Game.villageActuel = villageActuel;
	}
}
