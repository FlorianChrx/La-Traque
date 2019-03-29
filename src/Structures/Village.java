package Structures;

import java.util.ArrayList;

public class Village {
	private ArrayList<Lieu> lieux;
	private Routes routes;
	
	public Village(String lienCSV) {
		init(lienCSV);
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
}
