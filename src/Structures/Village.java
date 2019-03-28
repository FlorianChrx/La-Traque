package Structures;

import java.util.ArrayList;
import Entities.Enqueteur;
import Entities.Tueur;

public class Village {
	private ArrayList<Lieu> lieux;
	private Routes routes;
	private Tueur tueur;
	private Enqueteur enqueteur;
	
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
	
}
