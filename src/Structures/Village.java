package Structures;

import java.util.ArrayList;

import util.Position;

public class Village {
	private ArrayList<Lieu> lieux;
	private Routes routes;
	
	public Village(String lienCSV) {
		init(lienCSV);
	}

	private void init(String lienCSV) {
		villageTest();
	}

	public ArrayList<Lieu> getVoisins(Lieu lieu) {
		return routes.getVoisins(lieu);
	}
	
	public String getVoisinsString(Lieu lieuActuel) {
		String res = "Lieux accessibles: ";
		for (Lieu lieu : lieux) {
			if(routes.isConnected(lieu, lieuActuel)) {
				res += lieux.indexOf(lieu) + ", ";
			}
		}
		return res;
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
					for (Lieu lieu : lieux) {
						if(lieu.getPosition().equals(new Position(i,j))) {
							// + 1 pour avoir le numéro de la maison
							res += (lieux.indexOf(lieu)+1);
							break;
						}
					}
				} else {
					res += ".";
				}
			}
			res += "\n";
		}
		return res;
	}
	/**
	 * Permet de générer un village test
	 */
	private void villageTest() {
		this.lieux = new ArrayList<Lieu>();
		lieux.add(new Maison(this, 2, 2, 0, 0));
		lieux.add(new Maison(this, 5, 5, 0, 0));
		lieux.add(new Maison(this, 10, 10, 0, 0));
		lieux.add(new Maison(this, 20, 20, 0, 0));
		lieux.add(new Maison(this, 25, 25, 0, 0));
		this.routes = new Routes(lieux);
		routes.addConnexion(lieux.get(0), lieux.get(1));
		routes.addConnexion(lieux.get(1), lieux.get(2));
		routes.addConnexion(lieux.get(2), lieux.get(3));
		routes.addConnexion(lieux.get(3), lieux.get(4));
	}
}
