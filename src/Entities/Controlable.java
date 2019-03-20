package Entities;

import java.util.ArrayList;

import Structures.Lieu;

public interface Controlable {
	public ArrayList<Lieu> lieuAccessible();
	public void  goTo(Lieu lieu);
}
