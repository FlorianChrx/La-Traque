package Entities;

import java.util.ArrayList;
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
}
