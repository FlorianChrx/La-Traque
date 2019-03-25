package Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Structures.Lieu;
import Structures.Village;

/**
 * 
 * Classe abstraite definissant un personnage
 * @author florianchiraux
 *
 */

public abstract class Personnage implements Controlable {
	
	
	//Attributs
	
	/**
	 * Répresente le lieu où se situe le personnage
	 */
	protected Lieu lieu;
	/**
	 * Représente le nombre d'actions que peut effectuer le personnage en une journée
	 */
	protected int nbActions;
	/**
	 * Représentant le nombre d'action effectués ce jour;
	 */
	protected int actionsDone;
	
	
	//Constructeurs

	/**
	 * Permet la création d'un personnage dans un lieu donné et avec un nombre d'actions donné
	 * @param lieu représentant le lieu actuel du personnage
	 * @param nbActions représentant le nombre d'actions possible par tour
	 */
	public Personnage(Lieu lieu, int nbActions) {
		this.setLieu(lieu);
		setNbActions(nbActions);
	}
	
	/**
	 * Permet la création d'un personnage dans un lieu tiré aléatoirement et un nombre d'actions donné
	 * @param village représentant le village dans lequel doit se trouver le personnage
	 * @param nbActions représentant le nombre d'actions possible par tour
	 */
	public Personnage(Village village, int nbActions) {
		ArrayList<Lieu> lieux = village.getLieux();
		Collections.shuffle(lieux);
		this.setLieu(lieux.get(1));
		this.setNbActions(nbActions);
	}

	
	//Méthodes
	

	@Override
	public void goTo(Lieu lieu) {
		setLieu(lieu);
	}

	@Override
	public abstract ArrayList<Lieu> lieuxAccessibles();
	/**
	 * Permet d'obtenir le lieu dans lequel se trouve le personnage
	 * @return
	 */
	public Lieu getLieu() {
		return lieu;
	}
	/**
	 * Permet de redéfinir le lieu actuel du personnage
	 * @param lieu représentant un lieu dans lequel le personnage doit être
	 */
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	/**
	 * Permet d'obtenir le nombre d'actions disponible par jour pour le personnage
	 * @return Retourne un entier le nombre d'actions disponible ce jour pour le personnage
	 */
	public int getNbActions() {
		return nbActions;
	}
	/**
	 * Permet d'obtenir le nombre d'action effectué ce jour
	 * @return Retourne un entier représentant le nombre d'action effectué ce jour
	 */
	public int getActionsDone() {
		return actionsDone;
	}
	/**
	 * Permet de redéfinir le nombre d'actions effectuées ce jour
	 * @param actionsDone
	 */
	public void setActionsDone(int actionsDone) {
		this.actionsDone = actionsDone;
	}
	/**
	 * Permet de redéfinir le nombre d'actions disponible par jour pour le personnage
	 * @param nbActions représentant le nombre d'actions disponible par jour pour le personnage
	 */
	public void setNbActions(int nbActions) {
		this.nbActions = nbActions;
	} 
	/**
	 * Permet de savoir si le personnage peut encore effectuer une action
	 * @return un booléen représentant si oui ou non le personnage peut effectuer une action aujourd'hui
	 */
	public boolean canDoAction() {
		return this.actionsDone < this.nbActions;
	}
	/**
	 * Defini comme bloqué aujourd'hui le pseronnage et donc ne peut plue effectuer d'action
	 */
	public void setBlocked() {
		setActionsDone(getNbActions());
	}
	/**
	 * Permet de remettre a 0 le nombre d'action effectués à ce tour
	 */
	public void resetActionsDone() {
		setActionsDone(0);
	}
	/**
	 * Permet d'effectuer certaines actions au changement de journée
	 */
	public abstract void nextDay();
	public boolean canGoTo(Lieu lieu) {
		return lieuxAccessibles().contains(lieu);
	}
	public boolean canGoToAll(Collection<Lieu> lieux) {
		return lieuxAccessibles().containsAll(lieux);
	}
}
