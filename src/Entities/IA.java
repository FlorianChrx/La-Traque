package Entities;

import java.util.Collections;
import java.util.List;

import Structures.Lieu;

public class IA {
	public static Lieu decision(Personnage p) {
		List<Lieu> list = p.getLieu().getVoisins();
		list.add(p.getLieu());
		Collections.shuffle(list);
		return list.get(0);
	}
}
