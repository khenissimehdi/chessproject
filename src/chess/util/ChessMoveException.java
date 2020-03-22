package chess.util;

/**
 * Classe ChessMoveException
 * Lancée lorsqu'un déplacement est invalide.
 */
public class ChessMoveException extends java.lang.Exception {

	/**
	 * Constructeur de l'exception
	 * 
	 * @param message Détails de l'exception
	 * @param startingPosition Position de la case de départ du déplacement
	 * @param destination Position de la case de destination du déplacement
	 */
	public ChessMoveException(String message, Position startingPosition, Position destination) {
		super(" ‼ " + message + " ( " + startingPosition + " → " + destination + " )");
	}

	private static final long serialVersionUID = 1L;

}
