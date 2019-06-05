package Entities;

import java.util.Collections;
import java.util.List;

import Structures.Lieu;

public class IA {
	public static void decision(Personnage p) {
		List<Lieu> l = p.getLieu().getVoisins();
		l.add(p.getLieu());
		Collections.shuffle(l);
		p.action(l.get(0));
	}
}
