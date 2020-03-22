/**
 * 
 */
package chess.util;

/**
 * Class Position.java
 */

public class Position {

	private int x, y;

	/**
	 * Constructeur par défaut classe position
	 */
	public Position() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Constructeur de la classe position
	 * 
	 * @param x Axe X
	 * @param y Axe Y
	 * @throws IllegalArgumentException
	 */
	public Position(int x, int y) throws IllegalArgumentException {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			throw new IllegalArgumentException("Position invalide : " + x + "," + y);
		}
		this.x = x;
		this.y = y;
	}

	public Position(String algebraicNotation) {

		if (algebraicNotation.length() != 2) {
			throw new IllegalArgumentException("La chaine de caractères ne possèdent pas deux caractères");
		}

		char pos1 = algebraicNotation.charAt(0);
		char pos2 = algebraicNotation.charAt(1);

		if (pos1 < 'A' || pos1 > 'H') {
			throw new IllegalArgumentException(
					"Le premier caractère (" + algebraicNotation.charAt(0) + ") n'est pas comprit entre A et H");
		}

		if (pos2 < '1') {
			throw new IllegalArgumentException(
					"Le deuxième caractère (" + algebraicNotation.charAt(1) + ") est inférieur à 1");
		}
		if (pos2 > '8') {
			throw new IllegalArgumentException(
					"Le deuxième caractère (" + algebraicNotation.charAt(1) + ") est supérieur à 8");
		}

		this.x = pos1 - 'A';
		this.y = pos2 - '1';
	}

	/**
	 * Méthode de comparaison avec un objet
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		Position pos = (Position) obj;
		if ((getX() == pos.getX()) && (getY() == pos.getY())) {
			res = true;
		}
		return res;
	}

	public int getManhattanDistance(Position pos) {
		return Math.abs(pos.getX() - this.getX()) + Math.abs(pos.getY() - this.getY());
	}

	/**
	 * Accesseur attribut X
	 * 
	 * @return
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Accesseur attribut Y
	 * 
	 * @return
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Méthode générant le HashCode en fonction de la méthode equals() ci-dessous
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	public boolean isOnSameColumnAs(Position pos) {
		return (pos.getX() == this.getX()) ? true : false;
	}

	public boolean isOnSameDiagonalAs(Position pos) {
		int posX = Math.abs(pos.getX() - this.getX());
		int posY = Math.abs(this.getY() - pos.getY());
		return posX == posY;
	}

	public boolean isOnSameLineAs(Position pos) {
		return (pos.getY() == this.getY()) ? true : false;
	}

	public String toAlgebraicNotation() {
		StringBuilder res = new StringBuilder(2);
		char valueX = (char) (this.x + 'A');
		int valueY = this.y + 1;
		res.append(Character.toString(valueX));
		res.append(Integer.toString(valueY));
		return res.toString();
	}

	/**
	 * Méthode modifiant l'affichage d'un objet de la classe
	 */
	@Override
	public String toString() {
		return toAlgebraicNotation();
	}

}
