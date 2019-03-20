package Structures;

import java.util.ArrayList;
import util.Position;
import util.Surface;

/**
 * Classe représentant une maison, elle posède une surface
 * @author florianchiraux
 *
 */
public class Maison implements Lieu {
	//Attributs
	/*
	 * Village dans lequel la maison se trouve
	 */
	private Village village;
	/*
	 * Statut de la maison qui defini si son occupant est vivant, mort, contient le tueur ou si une enquete est en cours
	 */
	private Statut statut;
	/*
	 * Surface permettant de localiser la maison par son origine et sa superficie
	 */
	private Surface surface;
	
	//Constructeurs
	
	
	/*
	 * Constructeur Standard
	 */
	public Maison(Village village, Statut statut, Surface surface) {
		this.village = village;
		this.setStatut(statut);
		this.surface = surface;
	}
	/*
	 * Constructeur à partir d'une origine, d'une hauteur, d'une largeur et du statut
	 */
	public Maison(Village village, Statut statut, Position origine, int height, int width) {
		this(village, statut, new Surface(origine, height, width));
	}
	/*
	 * Constructeur à partir d'une origine, d'une hauteur, d'une largeur et attribuant le statut par défaut
	 */
	public Maison(Village village, Position origine, int height, int width) {
		this(village, Statut.ALIVE, new Surface(origine, height, width));
	}
	/*
	 * Constructeur à partir de coordonnées, d'une hauteur, d'une largeur et attribuant le statut par défaut
	 */
	public Maison(Village village, int x, int y, int height, int width) {
		this(village, Statut.ALIVE, new Surface(new Position(x,y), height, width));
	}
	
	
	//Méthodes
	
	@Override
	public Position getPosition() {
		return surface.getOrigine();
	}
	@Override
	public ArrayList<Lieu> getVoisins() {
		return village.getVoisins(this);
	}
	@Override
	public Surface getSurface() {
		return surface;
	}
	@Override
	public void setPosition(Position s) {
		surface.setOrigine(s);	
	}
	@Override
	public void setPosition(int x, int y) {
		setPosition(new Position(x, y));
	}
	@Override
	public void setSurface(Surface s) {
		surface = s;
	}
	@Override
	public void setSurface(Position s, int height, int width) {
		setSurface(new Surface(s, height, width));
	}
	@Override
	public void setSurface(int x, int y, int height, int width) {
		setSurface(new Position(x, y), height, width);
	}
	/*
	 * Defini l'occupant comme mort
	 */
	public void setDead() {
		this.setStatut(Statut.DEAD);
	}
	/*
	 * Defini l'occupant comme vivant
	 */
	public void setAlive() {
		this.setStatut(Statut.ALIVE);
	}
	/*
	 * Defini la maison comme acceuillant le tueur
	 */
	public void setMurder() {
		this.setStatut(Statut.MURDER);
	}
	/*
	 * Defini la maison dans laquelle se déroule une enquête 
	 */
	public void setInvestigate() {
		this.setStatut(Statut.INVESTIGATE);
	}
	/*
	 * Permet d'obtenir le statut d'une maison
	 */
	public Statut getStatut() {
		return statut;
	}
	/*
	 * Permet de modifier l'etat d'une maison
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
}
