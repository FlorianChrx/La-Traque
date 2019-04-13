package Structures;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Position;

public class Village {
	/**
	 * Liste de tous les lieux du village
	 */
	private Map<Character, Lieu> lieux;
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
   /**
	 * Permet d'obtenir la liste de tous les lieux du village
	 * @return La liste de tous les lieux du village
	 */
	public Collection<Lieu> getLieux() {
		return lieux.values();
	}
  
	/**
	 * Méthode permettant de transformer le village en tableau de booleen (les cases avec la valeur vrai étant 
	 * des cases avec une maison à cette position)
	 * /!\ la map doit etre inferieure ou égale à 30*30 pour appeler cette méthode sous peine de faire 
	 * planter le jeu
	 */
	public boolean[][] toBooleanTab(){
		boolean[][] tab = new boolean[30][30];
		for (Lieu lieu : getLieux()) {
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
					for (Lieu lieu : getLieux()) {
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
		this.lieux = new HashMap<Character, Lieu>();
		Maison m1 = new Maison(2, 2, 0, 0);
		Maison m2 = new Maison(5, 5, 0, 0);
		Maison m3 = new Maison(10, 10, 0, 0);	
		Maison m4 = new Maison(20, 20, 0, 0);
		Maison m5 = new Maison(25, 25, 0, 0);
		lieux.put(m1.getNom(), m1);
		lieux.put(m2.getNom(), m2);
		lieux.put(m3.getNom(), m3);
		lieux.put(m4.getNom(), m4);
		lieux.put(m5.getNom(), m5);
		this.routes = new Routes(lieux.values());
		routes.addConnexion(m1, m2);
		routes.addConnexion(m2, m3);
		routes.addConnexion(m3, m4);
		routes.addConnexion(m3, m5);
	}
	public Lieu getLieu(char c) {
		if (lieux.containsKey(Character.toUpperCase(c))) return lieux.get(Character.toUpperCase(c));
		return null;
	}
}
