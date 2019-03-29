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
	/**
	 * Méthode permettant de transformer le village en tableau de booleen (les cases avec la valeur vrai étant 
	 * des cases avec une maison à cette position)
	 * /!\ la map doit etre inferieure ou égale à 30*30 pour appeler cette méthode sous peine de faire 
	 * planter le jeu
	 */
	public boolean[][] toBooleanTab(){
		boolean[][] tab = new boolean[30][30];
		for (Lieu lieu : lieux) {
			tab[lieu.getPosition().getX()][lieu.getPosition().getY()] = true;
		}
		return tab;
	}
	/**
	 * Méthode permettant de représenter le village par une chaine de caractères à partir d'un tableau booléen
	 * généré à l'appel de cette méthode via la méthode {@link toBooleanTab()}
	 */
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
