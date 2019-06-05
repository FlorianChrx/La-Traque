package Structures;

import java.io.Serializable;

/**
 * 
 * Classe énumérant les status possibles d'une maison (à ne pas confondre avec le statut d'un lieu)
 * @author florianchiraux
 *
 */
public enum StatutMaison implements Serializable{
	/**
	 * Statut disponibles pour une maison
	 * ALIVE: l'habitant est vivant
	 * DEAD: l'habitant est mort
	 */
	ALIVE, DEAD;
}
