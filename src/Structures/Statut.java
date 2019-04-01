package Structures;
/**
 * 
 * Classe énumérants les statuts caractérisant un lieu (si un personnage important s'y trouve)
 * @author florianchiraux
 *
 */
public enum Statut {
	/**
	 * MURDER: le tueur est présent dans le lieu
	 * INVESTIGATE: l'enqueteur est présent dans le lie
	 * EMPTY: le lieu ne contient ni le tueur ni l'enqueteur
	 */
	 MURDER, INVESTIGATE, EMPTY;
}
