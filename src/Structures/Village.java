package Structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Entities.Updatable;
import util.Position;

public class Village implements Updatable, Iterable<Lieu>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4072332616589070044L;
	/**
	 * Liste de tous les lieux du village
	 */
	private Map<String, Lieu> lieux;
	public Village() {
		lieux = new HashMap<String, Lieu>();
	}
	
	/**
	 * Permet d'obtenir la liste de voisins d'un lieu
	 * @param lieu le lieu dont on cherche les voisins
	 * @return Une liste de lieux
	 */
	public List<Lieu> getVoisins(Lieu lieu) {
		return lieu.getVoisins();
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

	public Lieu getLieu(String string) {
		if (lieux.containsKey(string)) return lieux.get(string);
		return null;
	}
	public boolean allDeads() {
		for (Lieu lieu : lieux.values()) {
			if (((Maison) lieu).isAlive()) return false;
		}
		return true;
	}
	public void update() {
		for (Lieu lieu : lieux.values()) {
			lieu.update();
		}
	}
	@Override
	public Iterator<Lieu> iterator() {
		return getLieux().iterator();
	}
	public void add(Lieu lieu) {
		lieux.put(lieu.getNom(), lieu);
	}
}
