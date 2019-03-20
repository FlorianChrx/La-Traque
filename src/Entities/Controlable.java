package Entities;

import java.util.ArrayList;

public interface Controlable {
	public ArrayList<Lieu> lieuAccessible();
	public void  goTo(Lieu lieu);
}
