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
		CSVReader court = new CSVReader("court.csv");
		CSVReader moyen = new CSVReader("moyen.csv");
		CSVReader longss = new CSVReader("long.csv");
		CSVReader nomss = new CSVReader("noms.csv");
		courts = court.getList();
		moyens = moyen.getList();
		longs = longss.getList();
		noms = nomss.getList();
		alea = new Random();
	}
	
	public String nomMaison() {
		int i = alea.nextInt(noms.size());
		String nom = noms.get(i);
		noms.remove(i);
		return nom;
	}
	
	public String nextPhrase(int nbJours) {
		if (nbJours < 3) {
			return nextPhraseShort();
		}
		else if (nbJours < 8) {
			return nextPhraseMedium();
		}
		return nextPhraseLong();
	}
	
	public String nextPhraseShort() {
		return courts.get(alea.nextInt(40));
	}
	
	public String nextPhraseMedium() {
		return moyens.get(alea.nextInt(40));
	}
	public String nextPhraseLong() {
		return longs.get(alea.nextInt(40));
	}
}
