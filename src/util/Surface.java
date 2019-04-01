package util;

public class Surface implements Comparable<Surface>{
	private Position origine;
	private int width;
	private int height;
	private int superficie;
	
	
	/**
	 * 
	 * @param origine Correspond au point d'origine de la surface <b>en haut à gauche</b>
	 * @param width
	 * @param height
	 */
	public Surface(Position origine, int width, int height) {
		this.origine = origine;
		this.width = width;
		this.height = height;
		calculSuperficie();
	}
	
	public Surface(int x, int y, int width, int height) {
		this(new Position(x, y), width, height);
	}
	
	public Position getorigine() {
		return origine;
	}
	public void setorigine(Position origine) {
		this.origine = origine;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
		calculSuperficie();
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
		calculSuperficie();
	}
	
	private void calculSuperficie() {
		this.superficie = this.width*this.height;
	}

	@Override
	public String toString() {
		return "Surface [origine=" + origine + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		result = prime * result + superficie;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Surface))
			return false;
		Surface other = (Surface) obj;
		if (height != other.height)
			return false;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (superficie != other.superficie)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	/**
	 * Permet de savoir si deux surface sont en contact
	 * @param surface
	 * @return <b>vrai</b> ou <b>faux</b> si la surface fournie en paramètre est en
	 * contact avec celle de l'instance appellée
	 */
	public boolean inContact(Surface surface) {
		return this.origine.getX() <= surface.origine.getX()+surface.width &&
			   this.origine.getX()+this.width >= surface.origine.getX() &&
			   this.origine.getY() <= surface.origine.getY()+surface.height &&
			   this.origine.getY()+this.height >= surface.origine.getY();
	}
	
	
	/**
	 * Permet de savoir si une position se situe dans la surface
	 * @param surface
	 * @return <b>vrai</b> ou <b>faux</b> si la position fournie en paramètre est en
	 * contact avec la surface
	 */
	public boolean inContact(Position position) {
		return inContact(new Surface(position, 0, 0));
	}

	@Override
	public int compareTo(Surface surface) {
		if(this.superficie > surface.superficie) return 1;
		if(this.superficie < surface.superficie) return -1;
		return 0;
	}

	public Position getOrigine() {
		return origine;
	}

	public void setOrigine(Position origine) {
		this.origine = origine;
	}
	
}
