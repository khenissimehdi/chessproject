package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe Pawn
 * Classe représentant le pion
 */
public final class Pawn extends Piece {

	/**
	 * Constructeur d'une pièce (PION)
	 * @param board Echiquier où se trouve la pièce
	 * @param position Position de la pièce
	 * @param color Couleur de la pièce
	 */
	public Pawn(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " PAWN", (color == Color.WHITE) ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN);
	}

	/**
	 * Méthode qui teste la validité d'un déplacement pour un pion
	 * @param destination Position de la case de destination du déplacement
	 * @return True si le mouvement est possible, false sinon
	 */
	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (this.isBlack()) {
			
			if (getPosition().getManhattanDistance(destination) == 1 && getPosition().getY() > destination.getY()) {
				if (getPosition().isOnSameColumnAs(destination)) {
					if (board.getPiece(destination) == null)
							res = true;
				}
			} else if (getPosition().getManhattanDistance(destination) == 2) {
				if (getPosition().isOnSameDiagonalAs(destination)) {
					if (board.getPiece(destination) != null) {
						if (board.getPiece(destination).getColor() != board.getPiece(this.getPosition()).getColor()) {
								res = true;
						}
					}
				}
			}
			
		} else if (this.isWhite()) {
		
			
			if (getPosition().getManhattanDistance(destination) == 1 && getPosition().getY() < destination.getY()) {
				if (getPosition().isOnSameColumnAs(destination)) {
					if (board.getPiece(destination) == null)
							res = true;
				}
			} else if (getPosition().getManhattanDistance(destination) == 2) {
				if (getPosition().isOnSameDiagonalAs(destination)) {
					if (board.getPiece(destination) != null) {
						if (board.getPiece(destination).getColor() != board.getPiece(this.getPosition()).getColor()) {
								res = true;
						}
					}
				}
			}
			
		}

		return res;
	}

}