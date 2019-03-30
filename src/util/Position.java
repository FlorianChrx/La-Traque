package util;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Definit les valeurs <b>x</b> et <b>y</b> égalent à celle
	 * fournit en paramètre.
	 * @param pos
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Definit les valeurs <b>x</b> et <b>y</b> égalent à celle de la position
	 * fournit en paramètre.
	 * @param pos
	 */
	public void setPosition(Position pos) {
		this.setPosition(pos.getX(), pos.getY());
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
		return this.y - pos.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
