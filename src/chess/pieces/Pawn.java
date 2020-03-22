/**
 * 
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * @author khen0002
 *
 */
public final class Pawn extends Piece {

	/**
	 * 
	 */
	public Pawn(Chessboard board, Position position, Color color) {
		super(board, position, color, color + " PAWN", (color == Color.WHITE) ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().getManhattanDistance(destination) == 1 && destination.getY() > getPosition().getY()) {
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

		return res;
	}

}