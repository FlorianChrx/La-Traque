package Structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Class permettant de representer les connexions entres les Lieus
 * @author geoffrey
 *
 */
public class Routes {
	
	/**
	 * Map associant un Lieu avec un ArrayList de Lieu
	 */
	private Map<Lieu, ArrayList<Lieu>> connexion;
	
	/**
	 * On fournit un ArrayList qui correspond à la liste des clés, c'est à dire toutes les maisons
	 * @param lieus
	 */
	public Routes(Collection<Lieu> lieus) {
		this.connexion = new LinkedHashMap<Lieu, ArrayList<Lieu>>(lieus.size());
		for (Lieu lieu : lieus) {
			connexion.put(lieu, new ArrayList<Lieu>());
		}
	}
	/**
	 * Getter de la Map
	 * @return la Map<Lieu, ArrayList<Lieu>>
	 */
	public Map<Lieu, ArrayList<Lieu>> getConnexion() {
		return this.connexion;
	}
	
	/**
	 * Permet de modifier tous les lieus et connexions.
	 * @param connexion : Map<Lieu, ArrayList<Lieu>> associant les Lieus et leurs voisins
	 */
	public void setConnexion(Map<Lieu, ArrayList<Lieu>> connexion) {
		this.connexion = connexion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Routes other = (Routes) obj;
		if (connexion == null) {
			if (other.connexion != null)
				return false;
		} else if (!connexion.equals(other.connexion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Routes [connexion=" + connexion + "]";
	}
	
	
	/**
	 * Permet d'ajouter <b>un</b> élément dans la liste des voisins d'un lieu
	 * @param lieu auquel vous voulez <b>ajouter</b> un voisin
	 * @param <b>voisin</b> que vous voulez ajouter à l'ArrayList
	 * @return <b>vrai</b> ou <b>faux</b> si l'ajout à reussi ou pas (c'est à dire
	 * si la clé de la HashMap existe)
	 */
	public boolean addConnexion(Lieu lieu, Lieu voisin) {
		System.out.println(connexion.size());
		boolean b1 = this.connexion.get(lieu).add(voisin);
		boolean b2 = this.connexion.get(voisin).add(lieu);
		return b1 && b2;
	}
	
	/**
	 * Permet d'ajouter <b>plusieurs</b> éléments dans la liste des voisins d'un lieu
	 * <b>sans supprimer</b> les voisins existant.
	 * @param lieu auquel vous voulez <b>ajouter</b> des voisins
	 * @param <b>voisins</b> que vous voulez ajouter à l'ArrayList
	 * @return <b>vrai</b> ou <b>faux</b> si l'ajout à reussi ou pas (c'est à dire
	 * si la clé de la HashMap existe)
	 */
	public void addConnexion(Lieu lieu, Collection<Lieu> voisins) {
		this.connexion.get(lieu).addAll(voisins);
		for(Lieu voisin : voisins) {
			this.connexion.get(voisin).add(lieu);
		}
			
	}
	
	/**
	 * Permet de savoir si un lieu possède un voisin <b>fournit en paramètre</b>
	 * @param lieu
	 * @param voisin
	 * @return <b>vrai</b> ou <b>faux</b> si le lieu possède le voisin ou pas.
	 */
	public boolean isConnected(Lieu lieu, Lieu voisin) {
		return this.connexion.get(lieu).contains(voisin);
	}
	
	/**
	 * Permet de savoir si un lieu possède un ou plusieurs voisin(s)
	 * @param lieu
	 * @return retourne <b>vrai</b> si le lieu possède au moins un voisin;
	 */
	public boolean haveVoisin(Lieu lieu) {
		return !this.connexion.get(lieu).isEmpty();
	}
	
	/**
	 * <b>Supprime</b> le voisin d'un lieu fournit en paramètre
	 * @param lieu pour lequel on veut ajouter un voisin
	 * @param voisin que l'on veut ajouter
	 * @return <b>vrai</b> si le voisin a pu être retiré (c'est à dire, si le voisin
	 * fournit en paramètre est vraiment voisin avec le lieu
	 */
	public boolean removeVoisin(Lieu lieu, Lieu voisin) {
		return this.connexion.get(lieu).remove(voisin);
	}
	
	/**
	 * Retire tous les éléments de l'ArrayList du lieu
	 * @param lieu
	 */
	public void removeAllVoisin(Lieu lieu) {
		this.connexion.get(lieu).clear();
	}
	
	/**
	 * Permet d'obtenir la list de tous les voisins d'un lieu
	 * @param lieu
	 * @return une ArrayList de Lieu
	 */
	public ArrayList<Lieu> getVoisins(Lieu lieu){
		return this.connexion.get(lieu);
	}	
}
