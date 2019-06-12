package Entities;

import java.io.Serializable;
import java.util.List;

import Structures.Lieu;
import Structures.Maison;
import Structures.Village;
import util.Phrase;

/**
 * Class abstraite correspondant aux Tueurs
 * @author geoffrey
 *
 */
@SuppressWarnings("serial")
public abstract class Tueur extends Personnage implements Serializable{
	//Attributs
	
	Phrase phrase = new Phrase();
	
	//Constructeurs
	/**
	 * Constructeur avec un village en prenant une maison aléatoirement comme lieu de départ
	 * @param village
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Village village, int nbActions) {
		super(village, nbActions);
		this.lieu.setMurder();
	}	
	/**
	 * Construteur avec le lieu de départ du Tueur
	 * @param lieu de départ
	 * @param nbActions que peut effectuer le personnage
	 */
	public Tueur(Lieu lieu, int nbActions) {
		super(lieu, nbActions);
		this.lieu.setMurder();
	}
	
	//Méthodes	
	/**
	 * Permet de tuer le résident d'une maison
	 */
	public void tue() {
		if(lieu instanceof Maison) {
			((Maison) lieu).setDead();
		}
	}
	
	@Override
	public String action(List<Personnage> personnages) { 
		actionsDone++;
		tue();
		return phrase.phraseMeurtre();
	}
	
	public void goTo(Lieu lieu) {
		if(!this.lieu.isEmpty()) {
			this.lieu.setEmpty();
		}
		this.lieu = lieu;
		this.lieu.setMurder();
		actionsDone++;
	}
	@Override
	public String getName() {
		return ("Tueur");
	}
}
