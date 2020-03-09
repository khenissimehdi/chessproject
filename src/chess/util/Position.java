/**
 * 
 */
package chess.util;

/**
 * Class Position.java
 */

public class Position {
	
	private int x,y;
	
	/**
	 * Constructeur par défaut classe position
	 */
	public Position() {
		this.x=0;
		this.y=0;
	}
	
	
	/**
	 * Constructeur de la clase position
	 * @param x Axe X
	 * @param y Axe Y
	 * @throws IllegalArgumentException
	 */
	public Position(int x , int y ) throws IllegalArgumentException
	{
		if (x<0 || x>7 || y<0 || y>7)
		{
			throw new IllegalArgumentException("Position invalide : " + x + "," + y);
		}
		this.x=x;
		this.y=y;
	}
	
	public Position(String algebraicNotation) {
		
		if (algebraicNotation.length() != 2)
		{
			throw new IllegalArgumentException("La chaine de caractères ne possèdent pas deux caractères");
		}
		
		char pos1 = algebraicNotation.charAt(0);
	    char pos2 = algebraicNotation.charAt(1);
		
		if (pos1 < 'A' || pos1 > 'H')
		{
			throw new IllegalArgumentException("Le premier caractère (" + algebraicNotation.charAt(0) + ") n'est pas comprit entre A et H");
		}
		
		if (pos2 < '1')
		{
			throw new IllegalArgumentException("Le deuxième caractère (" + algebraicNotation.charAt(1) + ") est inférieur à 1");
		}
		if (pos2 > '8')
		{
			throw new IllegalArgumentException("Le deuxième caractère (" + algebraicNotation.charAt(1) + ") est supérieur à 8");
		}
		
		this.x = pos1 - 'A';
		this.y = pos2 - '1';
	}
	
	/**
	 * Accesseur attribut X
	 * @return
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Accesseur attribut Y
	 * @return
	 */
	public int getY(){
		return this.y;
	}
	
	

	/**
	 * Méthode modifiant l'affichage d'un objet de la classe
	 */
	@Override
	public String toString() {
		return "   "; 
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

	/**
	 * Méthode de comparaison avec un abjet
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public String toAlgebraicNotation() {
		StringBuilder res = new StringBuilder(2);
		char valueX = (char)(this.x + 'A');
		res.append(Character.toString(valueX));
		res.append(Integer.toString(this.y + 1));
		return res.toString();
	}
	
	public boolean isOnSameLineAs(Position pos) {
		return (pos.getY() == this.getY()) ? true : false;
	}
	
	public boolean isOnSameColumnAs(Position pos) {
		return (pos.getX() == this.getX()) ? true : false;
	}
	
	public boolean isOnSameDiagonalAs(Position pos) {
		int pos1 = Math.abs(pos.getX() - this.getY());
		int pos2 = Math.abs(this.getX() - pos.getY());
		return pos1 == pos2;
	}
	
	public int getManhattanDistance(Position pos) {
		return Math.abs(pos.getX() - this.getX()) + Math.abs(pos.getY() - this.getY());
	}
	

}
