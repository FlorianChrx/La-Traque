package Structures;

import java.util.ArrayList;
import util.CSVReader;
import java.util.Random;

public class Phrase {
	private static ArrayList<String> courts;
	private static ArrayList<String> moyens; 
	private static ArrayList<String> longs; 
	private static Random alea;
	
	public Phrase() {
		CSVReader court = new CSVReader("court.csv");
		CSVReader moyen = new CSVReader("moyen.csv");
		CSVReader longss = new CSVReader("long.csv");
		courts = court.getList();
		moyens = moyen.getList();
		longs = longss.getList();
		alea = new Random();
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
