package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe Knight
 * Classe représentant le cavalier
 */
public final class Knight extends Piece {

	/**
	 * Constructeur d'une pièce (CAVALIER)
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 */
	public Knight(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " KNIGHT",
				(color == Color.WHITE) ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT);
	}

	/**
	 * Méthode qui teste la validité d'un déplacement pour un cavalier
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().getManhattanDistance(destination) == 3) {
			if (!getPosition().isOnSameColumnAs(destination) && !getPosition().isOnSameLineAs(destination)
					&& !getPosition().isOnSameDiagonalAs(destination))
				res = true;
		}
		return res;
	}

}