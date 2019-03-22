package Entities;

import java.util.ArrayList;

import Structures.Lieu;

public interface Controlable {
	public ArrayList<Lieu> lieuxAccessibles();
	public void  goTo(Lieu lieu);
}
