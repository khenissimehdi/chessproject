package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe King
 * Classe représentant le roi
 */
public final class King extends Piece {

	/**
	 * Constructeur d'une pièce (ROI)
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 */
	public King(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " KING", (color == Color.WHITE) ? Symbol.WHITE_KING : Symbol.BLACK_KING);
	}
	
	/**
	 * Méthode qui teste la validité d'un déplacement pour le roi
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().getManhattanDistance(destination) == 1)
		{
			if (getPosition().isOnSameColumnAs(destination) || getPosition().isOnSameLineAs(destination))
				res = true;
		}
		else if (getPosition().getManhattanDistance(destination) == 2)
		{
			if (getPosition().isOnSameDiagonalAs(destination))
				res = true;
		}
		return res;
	}

}
