/**
 * 
 */
package chess.util;

/**
 * Class ChessMoveException.java
 */
public class ChessMoveException extends java.lang.Exception {

	/**
	 * Constructeur
	 * 
	 * @param message          - détails de l'exception
	 * @param startingPosition - position de la case de départ du déplacement
	 * @param destination      - position de la case de destination du déplacement
	 */
	public ChessMoveException(String message, Position startingPosition, Position destination) {
		super(" ‼ " + message + " ( " + startingPosition + " → " + destination + " )");
	}

	private static final long serialVersionUID = 1L;

}
