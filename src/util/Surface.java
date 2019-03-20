package util;

public class Surface implements Comparable<Surface>{
	private Position pos1;
	private float width;
	private float height;
	private float superficie;
	
	
	/**
	 * 
	 * @param pos1 Correspond au point d'origine de la surface <b>en haut à gauche</b>
	 * @param width
	 * @param height
	 */
	public Surface(Position pos1, float width, float height) {
		this.pos1 = pos1;
		this.width = width;
		this.height = height;
		calculSuperficie();
	}
	public Position getPos1() {
		return pos1;
	}
	public void setPos1(Position pos1) {
		this.pos1 = pos1;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
		calculSuperficie();
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
		calculSuperficie();
	}
	
	private void calculSuperficie() {
		this.superficie = this.width*this.height;
	}

	@Override
	public String toString() {
		return "Surface [pos1=" + pos1 + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Surface other = (Surface) obj;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (pos1 == null) {
			if (other.pos1 != null)
				return false;
		} else if (!pos1.equals(other.pos1))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
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
		return this.pos1.getX() <= surface.pos1.getX()+surface.width &&
			   this.pos1.getX()+this.width >= surface.pos1.getX() &&
			   this.pos1.getY() <= surface.pos1.getY()+surface.height &&
			   this.pos1.getY()+this.height >= surface.pos1.getY();
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

	
}
