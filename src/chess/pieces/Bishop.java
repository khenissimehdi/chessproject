package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe Bishop
 * Classe représentant le fou
 */
public final class Bishop extends Piece {

	/**
	 * Constructeur d'une pièce (FOU)
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 */
	public Bishop(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " BISHOP",
				(color == Color.WHITE) ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP);
	}

	/**
	 * Méthode qui teste la validité d'un déplacement pour un fou
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().isOnSameDiagonalAs(destination))
			if (!board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination))
				res = true;

		return res;
	}

}