package Structures;

import java.util.List;
import util.CSVReader;
import java.util.Random;

public class Phrase {
	private static List<String> courts;
	private static List<String> moyens; 
	private static List<String> longs; 
	private static List<String> noms;
	private static List<String> tueur;
	private static Random alea;
	
	public Phrase() {
		CSVReader court = new CSVReader("DATA/court.csv");
		CSVReader moyen = new CSVReader("DATA/moyen.csv");
		CSVReader longss = new CSVReader("DATA/long.csv");
		CSVReader nomss = new CSVReader("DATA/noms.csv");
		CSVReader tueurs = new CSVReader("DATA/tueur.csv");
		courts = court.getList();
		moyens = moyen.getList();
		longs = longss.getList();
		noms = nomss.getList();
		tueur = tueurs.getList();
		alea = new Random();
	}
	
	public char nomMaison() {
		int i = alea.nextInt(noms.size());
		String nom = noms.get(i);
		noms.remove(i);
		return nom.charAt(0);
	}
	
	public String phraseMeurtre() {
		return tueur.get(alea.nextInt(tueur.size()));
	}
	
	public String nextPhrase(int nbJours) {
		if (nbJours == 0) {
			return "Les habitants sont encore en vie, mais pour combien de temps encore ?";
		}
		else if (nbJours < 3) {
			return nextPhraseShort();
		}
		else if (nbJours < 8) {
			return nextPhraseMedium();
		}
		return nextPhraseLong();
	}

	public String nextPhraseShort() {
		return courts.get(alea.nextInt(courts.size()));
	}
	
	public String nextPhraseMedium() {
		return moyens.get(alea.nextInt(moyens.size()));
	}
	public String nextPhraseLong() {
		return longs.get(alea.nextInt(longs.size()));
	}
}
