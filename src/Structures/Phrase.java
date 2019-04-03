package Structures;

import java.util.List;
import util.CSVReader;
import java.util.Random;

public class Phrase {
	private static List<String> courts;
	private static List<String> moyens; 
	private static List<String> longs; 
	private static List<String> noms;
	private static Random alea;
	
	public Phrase() {
		CSVReader court = new CSVReader("DATA/court.csv");
		CSVReader moyen = new CSVReader("DATA/moyen.csv");
		CSVReader longss = new CSVReader("DATA/long.csv");
		CSVReader nomss = new CSVReader("DATA/noms.csv");
		courts = court.getList();
		moyens = moyen.getList();
		longs = longss.getList();
		noms = nomss.getList();
		alea = new Random();
	}
	
	public static String nomMaison() {
		int i = alea.nextInt(noms.size());
		String nom = noms.get(i);
		noms.remove(i);
		return nom;
	}
	
	public static String nextPhrase(int nbJours) {
		if (nbJours < 3) {
			return nextPhraseShort();
		}
		else if (nbJours < 8) {
			return nextPhraseMedium();
		}
		return nextPhraseLong();
	}
	
	public static String nextPhraseShort() {
		return courts.get(alea.nextInt(40));
	}
	
	public static String nextPhraseMedium() {
		return moyens.get(alea.nextInt(40));
	}
	public static String nextPhraseLong() {
		return longs.get(alea.nextInt(40));
	}
}
