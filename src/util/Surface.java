package util;

public class Surface {
	private Position origine;
	private int height;
	private int width;
	
	public Surface(Position origine, int height, int width) {
		this.origine = origine;
		this.height = height;
		this.width = width;
	}

	public Position getOrigine() {
		return origine;
	}

	public void setOrigine(Position origine) {
		this.origine = origine;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getOx() {
		return origine.getX();
	}
	
	public int getOy() {
		return origine.getY();
	}
	
	
	
}
