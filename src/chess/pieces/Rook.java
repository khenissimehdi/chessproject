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
public final class Rook extends Piece {

	/**
	 * 
	 */
	public Rook(Chessboard board, Position position, Color color) {
		super(board, position, color, color + "_ROOK", (color == Color.WHITE) ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;

		if (getPosition().isOnSameColumnAs(destination) || getPosition().isOnSameLineAs(destination)) {
			res = true;
		}

		return res;
	}

}