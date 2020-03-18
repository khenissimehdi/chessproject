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

		if (getPosition().isOnSameColumnAs(destination)) {
			res = true;
		}

		return res;
	}

}