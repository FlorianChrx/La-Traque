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
	
	public boolean[][] toBooleanTab(){
		boolean[][] tab = new boolean[30][30];
		for (Lieu lieu : lieux) {
			tab[lieu.getPosition().getX()][lieu.getPosition().getY()] = true;
		}
		return tab;
	}
	
	public String toString() {
		boolean[][] tab = toBooleanTab();
		String res = "";
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (tab[i][j]) {
					res += "#";
				} else {
					res += ".";
				}
			}
		}
		return res;
	}
}
