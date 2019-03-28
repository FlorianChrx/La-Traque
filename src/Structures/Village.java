package Structures;

import java.util.ArrayList;
import Entities.Enqueteur;
import Entities.Tueur;

public class Village {
	private ArrayList<Lieu> lieux;
	private Routes routes;
	private Tueur tueur;
	private Enqueteur enqueteur;
	
	public Village(Tueur tueur, Enqueteur enqueteur, String lienCSV) {
		init(lienCSV);
		this.tueur = tueur;
		this.enqueteur = enqueteur;
	}

	private void init(String lienCSV) {
		this.lieux = new ArrayList<Lieu>();
		// à développer
		this.routes = new Routes(lieux);
		// à développer
	}

	public ArrayList<Lieu> getVoisins(Lieu lieu) {
		return routes.getVoisins(lieu);
	}

	public ArrayList<Lieu> getLieux() {
		return lieux;
	}

	public Lieu getTueurLocation() {
		return tueur.getLieu();
	}
	
	public Lieu getEnqueteurLocation() {
		return enqueteur.getLieu();
	}

	public Tueur getTueur() {
		return tueur;
	}

	public Enqueteur getEnqueteur() {
		return enqueteur;
	}
}
