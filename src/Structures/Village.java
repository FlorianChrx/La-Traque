package Structures;

import java.util.ArrayList;
import java.util.List;

import util.Position;

public class Village {
	/**
	 * Liste de tous les lieux du village
	 */
	private List<Lieu> lieux;
	/**
	 * Gestionnaire des routes (connexions) entre les lieux
	 */
	private Routes routes;
	/**
	 * Permet de construire un village selon une carte prédefinie 
	 * dont le lien et donné en paramètre
	 * @param lienCSV un String représentant le lien vers le fichier de configuration du village
	 */
	public Village(String lienCSV) {
		villageTest();
	}
	
	/**
	 * Permet d'obtenir la liste de voisins d'un lieu
	 * @param lieu le lieu dont on cherche les voisins
	 * @return Une liste de lieux
	 */
	public List<Lieu> getVoisins(Lieu lieu) {
		return routes.getVoisins(lieu);
	}
	public String getVoisinsString(Lieu lieuActuel) {
		String res = "Lieux accessibles: ";
		for (Lieu lieu : getVoisins(lieuActuel)) {
			res += lieux.indexOf(lieu);
		}
		return res;
	}
   /**
	 * Permet d'obtenir la liste de tous les lieux du village
	 * @return La liste de tous les lieux du village
	 */
	public List<Lieu> getLieux() {
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
							res += lieu.getNom();
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
		lieux.add(new Maison(2, 2, 0, 0));
		lieux.add(new Maison(5, 5, 0, 0));
		lieux.add(new Maison(10, 10, 0, 0));
		lieux.add(new Maison(20, 20, 0, 0));
		lieux.add(new Maison(25, 25, 0, 0));
		this.routes = new Routes(lieux);
		routes.addConnexion(lieux.get(0), lieux.get(1));
		routes.addConnexion(lieux.get(1), lieux.get(2));
		routes.addConnexion(lieux.get(2), lieux.get(3));
		routes.addConnexion(lieux.get(3), lieux.get(4));
	}
	public Lieu getLieu(char c) {
		for (Lieu lieu : lieux) {
			if (lieu.getNom() == c) {
				return lieu;
			}
		}
		return null;
	}
}
