package chess.util;

/**
 * Classe Piece
 * Représente la position d'une pièce lors d'une partie d'échecs
 */
public class Position {

	// Abscisse de la case représentée par cette position (0 = colonne de gauche, 7 = colonne de droite)
	private int x;
	// Ordonnée de la case représentée par cette position (0 = ligne du bas, 7 = ligne du haut)
	private int y;

	/**
	 * Constructeur de la classe position (avec entier)
	 * 
	 * @param x Abscisse (comprise entre 0 et 7)
	 * @param y Ordonnée (comprise entre 0 et 7)
	 * @throws IllegalArgumentException Si l'une des coordonnées est invalide
	 */
	public Position(int x, int y) throws IllegalArgumentException {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			throw new IllegalArgumentException(" ‼ Position invalide : " + x + "," + y);
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructeur de la classe position (avec chaîne de caractères)
	 *
	 * @param algebraicNotation Chaîne de 2 caractères représentant une case de l'échiquier en notation algébrique
	 * @throws IllegalArgumentException Si la position représentée est invalide
	 */
	public Position(String algebraicNotation) throws IllegalArgumentException {

		if (algebraicNotation.length() != 2) {
			throw new IllegalArgumentException(" ‼ Position invalide : la chaine de caractères ne possède pas deux caractères.");
		}

		char pos1 = algebraicNotation.charAt(0);
		char pos2 = algebraicNotation.charAt(1);

		if (pos1 < 'A' || pos1 > 'H') {
			throw new IllegalArgumentException(
					" ‼ Position invalide : le premier caractère (" + algebraicNotation.charAt(0) + ") n'est pas comprit entre A et H.");
		}

		if (pos2 < '1') {
			throw new IllegalArgumentException(
					" ‼ Position invalide : le deuxième caractère (" + algebraicNotation.charAt(1) + ") est inférieur à 1.");
		}
		if (pos2 > '8') {
			throw new IllegalArgumentException(
					" ‼ Position invalide : le deuxième caractère (" + algebraicNotation.charAt(1) + ") est supérieur à 8.");
		}

		this.x = pos1 - 'A';
		this.y = pos2 - '1';
	}

	/**
	 * Accesseur attribut X
	 * 
	 * @return int Entier en paramètre X de l'objet
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Accesseur attribut Y
	 * 
	 * @return int Entier en paramètre Y de l'objet
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Méthode générant le HashCode en fonction de la méthode equals() ci-dessous
	 * 
	 * @return int HashCode de l'objet
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	/**
	 * Méthode de comparaison entre deux positions
	 * 
	 * @param obj La position avec laquelle on compare l'objet
	 * @return boolean Résultat de la comparaison (True : identique / False : différent)
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

	/**
	 * Méthode qui retourne la distance de Manhattan entre la position courante et une autre position.
	 * 
	 * @param pos Position
	 * @return int Distance d'après la formule de Manhattan sous form d'entier
	 */
	public int getManhattanDistance(Position pos) {
		return Math.abs(pos.getX() - this.getX()) + Math.abs(pos.getY() - this.getY());
	}

	
	/**
	 * Teste si la position courante est sur la même colonne qu'une autre position
	 * 
	 * @param pos Position
	 * @return boolean Résulat du test (True : sur la même colonne / False : sur une autre colonne)
	 */
	public boolean isOnSameColumnAs(Position pos) {
		return (pos.getX() == this.getX()) ? true : false;
	}

	/**
	 * Teste si la position courante est sur la même diagonale qu'une autre position
	 * 
	 * @param pos Position
	 * @return boolean Résulat du test (True : sur la même diagonale / False : pas sur le même diagonale)
	 */
	public boolean isOnSameDiagonalAs(Position pos) {
		int posX = Math.abs(pos.getX() - this.getX());
		int posY = Math.abs(this.getY() - pos.getY());
		return posX == posY;
	}

	/**
	 * Teste si la position courante est sur la même ligne qu'une autre position
	 * 
	 * @param pos Position
	 * @return boolean Résulat du test (True : sur la même ligne / False : sur une autre ligne)
	 */
	public boolean isOnSameLineAs(Position pos) {
		return (pos.getY() == this.getY()) ? true : false;
	}

	/**
	 * Méthode qui transforme la position courante en notation algébrique
	 * 
	 * @return String Représentation de la position courante en notation algébrique (exemple : A1)
	 */
	public String toAlgebraicNotation() {
		StringBuilder res = new StringBuilder(2);
		char valueX = (char) (this.x + 'A');
		int valueY = this.y + 1;
		res.append(Character.toString(valueX));
		res.append(Integer.toString(valueY));
		return res.toString();
	}

	/**
	 * Méthode modifiant l'affichage d'un objet de la classe lorsqu'il est considéré comme une chaîne de caractères
	 */
	@Override
	public String toString() {
		return toAlgebraicNotation();
	}

}
