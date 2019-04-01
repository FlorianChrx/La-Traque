package Entities;

import java.util.ArrayList;
import java.util.Collection;

import Structures.Lieu;


/**
 * 
 * Interface énumérant les fonctions de chaque entité contrôlable
 * @author florianchiraux
 *
 */
public interface Controlable {
	/**
	 * Permet de lister les lieux accessible à l'entité
	 * @return une liste de lieu où peut se rendre l'entité
	 */
	public ArrayList<Lieu> lieuxAccessibles();
	/**
	 * Permet de déplacer l'entité
	 * @param lieu représentant le lieu où doit se rendre l'entité
	 */
	public void  goTo(Lieu lieu);
	/**
	 * Permet de determiner si le personnage peu se déplacer vers un lieu donné
	 * @param lieu qui représente le lieu testé
	 * @return vrai ou faux selon si le personnage peu se rendre au lieu visé 
	 */
	public boolean canGoTo(Lieu lieu);
	/**
	 * Permet de determiner si le personnage peu se déplacer vers un ensemble de lieux donné
	 * @param lieux une collection de lieux testés
	 * @return vrai ou faux selon si le personnage peu se rendre aux lieus visés
	 */
	public boolean canGoToAll(Collection<Lieu> lieux);
}
