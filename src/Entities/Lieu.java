package Entities;

import java.util.ArrayList;

import util.Position;
import util.Surface;

public interface Lieu {
	public Position getPosition();
	public ArrayList<Lieu> getVoisins();
	public Surface getSurface();
}
