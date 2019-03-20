package Structures;

import java.util.ArrayList;

import util.Position;
import util.Surface;

public interface Lieu {
	public Position getPosition();
	public void setPosition(Position s);
	public void setPosition(int x, int y);
	public ArrayList<Lieu> getVoisins();
	public Surface getSurface();
	public void setSurface(Surface s);
	public void setSurface(Position s, int height, int width);
	public void setSurface(int x, int y, int height, int width);
}
