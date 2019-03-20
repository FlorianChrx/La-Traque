package util;

public class Position {
	private float x;
	private float y;
	
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
	/**
	 * Definit les valeurs <b>x</b> et <b>y</b> égalent à celle
	 * fournit en paramètre.
	 * @param pos
	 */
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * Definit les valeurs <b>x</b> et <b>y</b> égalent à celle de la position
	 * fournit en paramètre.
	 * @param pos
	 */
	public void setPosition(Position pos) {
		this.x = pos.x;
		this.y = pos.y;
	}
	
	public String toString() {
		return "x : " + this.x + " y : " + this.y;
	}
	
	
	/**
	 * Permet de savoir si la valeur de <b>x</b> est <b>plus grande</b>
	 * que celle de la <b>position</b> fournie en parametre
	 * @param pos
	 * @return Retourne un int <b>superieur, inférieur ou égal à 0</b>
	 * si la valeur de <b>x</b> de <b>cette position</b> est <b>superieur, inférieur ou égal à celle
	 * fournie en parametre</b>.
	 */
	public int xGreaterThan(Position pos) {
		if(this.x > pos.x) return 1;
		if(this.x < pos.x) return -1;
		return 0;
	}
	
	/**
	 * Permet de savoir si la valeur de <b>y</b> est <b>plus grande</b>
	 * que celle de la <b>position</b> fournie en parametre
	 * @param pos
	 * @return Retourne un int <b>superieur, inférieur ou égal à 0</b>
	 * si la valeur de <b>y</b> de <b>cette position</b> est <b>superieur, inférieur ou égal à celle
	 * fournie en parametre</b>.
	 */
	public int yGreaterThan(Position pos) {
		if(this.y > pos.y) return 1;
		if(this.y < pos.y) return -1;
		return 0;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
	
	
	
}
