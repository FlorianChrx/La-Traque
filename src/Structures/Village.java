package Structures;

import java.util.ArrayList;
import java.util.List;

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
		init(lienCSV);
	}
	/**
	 * Initialise le village selon la configuration dont le lien est donné 
	 * @param lienCSV un String représentant le lien vers le fichier de configuration du village
	 */
	private void init(String lienCSV) {
		this.lieux = new ArrayList<Lieu>();
		// à développer
		this.routes = new Routes(lieux);
		// à développer
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
	public List<Lieu> getLieux() {
		return lieux;
	}
}
