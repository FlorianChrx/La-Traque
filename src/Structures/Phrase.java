package Structures;

import java.util.List;
import java.util.Random;

import util.CSVReader;

public class Phrase {
	private List<String> courts;
	private List<String> moyens; 
	private List<String> longs; 
	private Random alea;
	
	public Phrase() {
		CSVReader court = new CSVReader("../../DATA/court.csv");
		CSVReader moyen = new CSVReader("../../DATA/moyen.csv");
		CSVReader longss = new CSVReader("../../DATA/long.csv");
		courts = court.getList();
		moyens = moyen.getList();
		longs = longss.getList();
		alea = new Random();
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
