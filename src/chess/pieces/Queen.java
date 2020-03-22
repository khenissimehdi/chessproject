package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe Queen
 * Classe représentant la reine
 */
public final class Queen extends Piece {

	/**
	 * Constructeur d'une pièce (REINE)
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 */
	public Queen(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " QUEEN",
				(color == Color.WHITE) ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN);
	}

	/**
	 * Méthode qui teste la validité d'un déplacement pour la reine
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;
		if (getPosition().isOnSameColumnAs(destination)) {
			if (!board.isPiecePresentOnSameColumnBetween(getPosition(), destination))
				res = true;
		} else if (getPosition().isOnSameLineAs(destination)) {
			if (!board.isPiecePresentOnSameLineBetween(getPosition(), destination))
				res = true;
		} else if (getPosition().isOnSameDiagonalAs(destination)) {
			if (!board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination))
				res = true;
		}

		return res;
	}

}